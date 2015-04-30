package edu.utep.cs.pickax.fpms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by ruben on 4/30/15.
 */
public class FP_KBHelper extends Abstract_KBHelper {
    private static final String DATABASE_NAME = "FLIGHTPLAN.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table FLIGHTPLAN (" +
                    " fp_data text primary key,";

    public FP_KBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(AC_KBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS AIRCRAFT");
        onCreate(db);
    }
}
