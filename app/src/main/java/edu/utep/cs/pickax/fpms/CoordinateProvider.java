/*
A simple mock GPS coordinate provider from El Paso to Albuquerque
coordinates
speed
altitude
heading
 */
package edu.utep.cs.pickax.fpms;

import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.util.Random;

public class CoordinateProvider {
    private static final String TAG = "COORD_PROVIDER";
    private static final Random r = new Random(System.currentTimeMillis());
    private static final int LATITUDE = 0, LONGITUDE = 1;
    static private double[] elpasoCoordinates = {31.7975656, -106.3876102};
    static private double[] albuquerqueCoordinates = {35.043036, -106.616076};
    static private double[] currentCoordinates = elpasoCoordinates;

    public CoordinateProvider() {
        Thread t = new Thread() {
            @Override
            public void run() {
                generateCoordinates();
            }
        };
        t.start();
    }

    static double[] getCurrentCoordinates() {
        return currentCoordinates;
    }

    static double getCurrentSpeed() {
        return getRandomDouble(100.0, 500.0);
    }

    static double getCurrentAltitude() {
        return getRandomDouble(100.0, 500.0);
    }

    static double getCurrentHeading() {
        return getRandomDouble(0.0, 360.0);
    }

    static double  getRandomDouble(double min, double max) {
        return min + (max - min) * r.nextDouble();
    }

    public void generateCoordinates() {
        Log.d(TAG, "In loop");
        while (true) {
            boolean limitLat = true;
            boolean limitLon = true;
            try {
                Thread.sleep((long)1000);
            } catch (InterruptedException e) {
                Log.d(TAG, "exception in sleep");
            }
            if (currentCoordinates[LATITUDE] < albuquerqueCoordinates[LATITUDE]) {
                currentCoordinates[LATITUDE] += 0.005;
                limitLat = false;
            }
            if (currentCoordinates[LONGITUDE] > albuquerqueCoordinates[LONGITUDE]) {
                currentCoordinates[LONGITUDE] -= 0.0001;
                limitLon = false;
            }

            if(limitLat & limitLon) {
                Log.d(TAG, "Done looping");
                return;
            }
        }
    }
}