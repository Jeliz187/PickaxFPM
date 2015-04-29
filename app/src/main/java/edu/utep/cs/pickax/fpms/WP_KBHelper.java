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
public class WP_KBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "WAYPOINT";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "create table WAYPOINT (" +
                    " wp_name text primary key," +
                    " wp_lat text not null," +
                    " wp_long text not null," +
                    " wp_alt text not null);";

    public WP_KBHelper(Context context) {
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
        database.execSQL("DROP TABLE IF EXISTS WAYPOINT");
        onCreate(database);
    }
    public List<String> getWaypoints(){
        List<String> Waypoints = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT * FROM WAYPOINT";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Waypoints.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return Waypoints;
    }
}
