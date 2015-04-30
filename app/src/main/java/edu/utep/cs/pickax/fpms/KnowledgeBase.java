package edu.utep.cs.pickax.fpms;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jacob on 4/26/15.
 */
public final class KnowledgeBase {

    private AC_KBHelper dbHelper;
    private SQLiteDatabase database;

    //Aircraft KnowledgeBase Variables
    public static final String AC_TABLE = "AIRCRAFT";
    public static final String AC_NAME = "ac_name"; //Names of the columns in the Database
    public static final String AC_ID = "ac_id";
    public static final String AC_MODEL = "ac_model";
    public static final String AC_COLOR = "ac_color";
    public static final String AC_MIN_CRUISE_SPD = "ac_min_cruise_spd";
    public static final String AC_NORM_CRUISE_SPD = "ac_norm_cruise_spd";
    public static final String AC_MAX_CRUISE_SPD = "ac_max_cruise_spd";
    public static final String AC_MIN_CRUISE_ALT = "ac_min_cruise_alt";
    public static final String AC_NORM_CRUISE_ALT = "ac_norm_cruise_alt";
    public static final String AC_MAX_CRUISE_ALT = "ac_max_cruise_alt";
    public static final String AC_FUEL_CAP = "ac_fuel_cap";
    public static final String AC_FUEL_CON_RATE = "ac_fuel_con_rate";

    //Route KnowledgeBase Variables
    public static final String RT_TABLE = "ROUTE";
    public static final String RT_NAME = "rt_name";
    public static final String RT_ID = "rt_id";

    //Waypoint KnowledgeBase Variables
    public static final String WP_TABLE = "WAYPOINT";
    public static final String WP_NAME =  "wp_name";
    public static final String WP_LAT = "wp_lat";
    public static final String WP_LONG = "wp_long";
    public static final String WP_ALT = "wp_alt";

    //Airport KnowledgeBase Variables
    public static final String AP_NAME = "ap_name";
    public static final String AP_WP = "ap_wp";

    public KnowledgeBase(Context context){
        dbHelper = new AC_KBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long createAircraftRecords(
            String name, String id, String model, String color, Integer mincs,
            Integer normcs, Integer maxcs, Integer minca, Integer normca,
            Integer maxca, Integer fuelcap, Integer fuelrate ){

        ContentValues ap_values = new ContentValues();
        ap_values.put(AC_NAME, name);
        ap_values.put(AC_ID, id);
        ap_values.put(AC_MODEL, model);
        ap_values.put(AC_COLOR, color);
        ap_values.put(AC_MIN_CRUISE_SPD, mincs);
        ap_values.put(AC_NORM_CRUISE_SPD, normcs);
        ap_values.put(AC_MAX_CRUISE_SPD, maxcs);
        ap_values.put(AC_MIN_CRUISE_ALT, minca);
        ap_values.put(AC_NORM_CRUISE_ALT, normca);
        ap_values.put(AC_MAX_CRUISE_ALT, maxca);
        ap_values.put(AC_FUEL_CAP, fuelcap);
        ap_values.put(AC_FUEL_CON_RATE, fuelrate);

        return database.insert(AC_TABLE, null, ap_values);
    }

    public long createAircraftRecords(Aircraft a) {
        ContentValues ap_values = new ContentValues();
        ap_values.put(AC_NAME, a.getName());
        ap_values.put(AC_ID, a.getId());
        ap_values.put(AC_MODEL, a.getModel());
        ap_values.put(AC_COLOR, a.getColor());
        ap_values.put(AC_MIN_CRUISE_SPD, a.getMinCruiseSpeed());
        ap_values.put(AC_NORM_CRUISE_SPD, a.getNormalCruiseSpeed());
        ap_values.put(AC_MAX_CRUISE_SPD, a.getMaxCruiseSpeed());
        ap_values.put(AC_MIN_CRUISE_ALT, a.getMinCruiseAltitude());
        ap_values.put(AC_NORM_CRUISE_ALT, a.getNormalCruiseAltitude());
        ap_values.put(AC_MAX_CRUISE_ALT, a.getMaxCruiseAltitude());
        ap_values.put(AC_FUEL_CAP, a.getFuelConsumption()); //TODO make sure these are correct
        ap_values.put(AC_FUEL_CON_RATE, a.getConsumptionRate());

        return database.insert(AC_TABLE, null, ap_values);
    }

    public long createWaypointRecords(
            String wp_name, Integer wp_lat, Integer wp_long, Integer wp_alt ){

        ContentValues wp_values = new ContentValues();
        wp_values.put(WP_NAME, wp_name);
        wp_values.put(WP_LAT, wp_lat);
        wp_values.put(WP_LONG, wp_long);
        wp_values.put(WP_ALT, wp_alt);
        return database.insert(WP_TABLE, null, wp_values);
    }
}
