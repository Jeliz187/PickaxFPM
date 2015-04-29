package edu.utep.cs.pickax.fpms;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 4/26/15.
 */
public class AC_KBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AIRCRAFT.db";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "create table AIRCRAFT (" +
                    " ac_name text not null," +
                    " ac_id text primary key," +
                    " ac_model text not null," +
                    " ac_color text not null," +
                    " ac_min_cruise_spd integer not null," +
                    " ac_norm_cruise_spd integer not null, " +
                    " ac_max_cruise_spd integer not null, " +
                    " ac_min_cruise_alt integer not null," +
                    " ac_norm_cruise_alt integer not null," +
                    " ac_max_cruise_alt integer not null," +
                    " ac_fuel_cap integer not null," +
                    " ac_fuel_con_rate integer not null);";

    public AC_KBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(AC_KBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS AIRCRAFT");
        onCreate(database);
    }
    public List<String> getAircrafts(){
        List<String> Aircrafts = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT * FROM AIRCRAFT";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Aircrafts.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return Aircrafts;
    }
}
