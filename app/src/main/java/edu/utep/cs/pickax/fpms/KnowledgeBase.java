package edu.utep.cs.pickax.fpms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jacob on 4/26/15.
 */
public final class KnowledgeBase {

    private KBHelper dbHelper;

    private SQLiteDatabase database;

    public static final String AC_TABLE = "Aircraft";
    public static final String AC_ID = "ac_id";
    public static final String AC_NAME = "ac_name";
    public static final String AC_MODEL = "ac_model";
    public static final String AC_COLOR = "ac_color";
    public static final String AC_MIN_CRUISE_SPD = "ac_min_cruise_spd";
    public static final String AC_NORM_CRUISE_SPD = "ac_norm_cruise_spd";
    public static final String AC_MAX_CRUISE_SPD = "ac_max_cruise_spd";
    public static final String AC_MIN_CRUISE_ALT = "ac_min_cruise_alt";
    public static final String AC_NORM_CRUISE_ALT = "ac_min_cruise_alt";
    public static final String AC_MAX_CRUISE_ALT = "ac_min_cruise_alt";
    public static final String AC_FUEL_CAP = "ac_fuel_cap";
    public static final String AC_FUEL_CON_RATE = "ac_fuel_con_rate";

    public KnowledgeBase(Context context){
        dbHelper = new KBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long createRecords(String id, String name, String model, String color, Integer mincs, Integer normcs, Integer maxcs,
                              Integer minca, Integer normca, Integer maxca, Integer fuelcap, Integer fuelrate ){

        ContentValues values = new ContentValues();
        values.put(AC_ID, id);
        values.put(AC_NAME, name);
        values.put(AC_MODEL, model);
        values.put(AC_COLOR, color);
        values.put(AC_MIN_CRUISE_SPD, mincs);
        values.put(AC_NORM_CRUISE_SPD, normcs);
        values.put(AC_MAX_CRUISE_SPD, maxcs);
        values.put(AC_MIN_CRUISE_ALT, minca);
        values.put(AC_NORM_CRUISE_ALT, normca);
        values.put(AC_MAX_CRUISE_ALT, maxca);
        values.put(AC_FUEL_CAP, fuelcap);
        values.put(AC_FUEL_CON_RATE, fuelrate);


        return database.insert(AC_TABLE, null, values);
    }

    public Cursor selectRecords() {
        String[] cols = new String[] {AC_ID, AC_NAME, AC_MODEL, AC_COLOR, AC_MIN_CRUISE_SPD, AC_NORM_CRUISE_SPD,
        AC_MAX_CRUISE_SPD, AC_MIN_CRUISE_ALT, AC_NORM_CRUISE_ALT, AC_MAX_CRUISE_ALT, AC_FUEL_CAP, AC_FUEL_CON_RATE};

        Cursor mCursor = database.query(true, AC_TABLE,cols,null
                , null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }

        return mCursor; // iterate to get each value.
    }

}
