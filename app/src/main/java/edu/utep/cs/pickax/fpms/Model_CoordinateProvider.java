/*
A simple mock GPS coordinate provider from El Paso to Albuquerque
coordinates
speed
altitude
heading
 */
package edu.utep.cs.pickax.fpms;

import android.os.CountDownTimer;
import android.util.Log;

import java.util.Random;

public class Model_CoordinateProvider {
    private static final String TAG = "COORD_PROVIDER";
    private static final Random r = new Random(System.currentTimeMillis());
    private static final int LATITUDE = 0, LONGITUDE = 1;
    static private double[] elpasoCoordinates = {31.7975656, -106.3876102};
    static private double[] albuquerqueCoordinates = {35.043036, -106.616076};
    static private double[] currentCoordinates = elpasoCoordinates;

    public Model_CoordinateProvider() {
        new CountDownTimer(Long.MAX_VALUE, 1000) {
            public void onTick(long millisUntilFinished) {
                generateCoordinates();
            }
            public void onFinish() {
                Log.d(TAG, "countdown done?");
            }
        }.start();
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
        if (currentCoordinates[LATITUDE] < albuquerqueCoordinates[LATITUDE]) {
            currentCoordinates[LATITUDE] += 0.005;
        }
        if (currentCoordinates[LONGITUDE] > albuquerqueCoordinates[LONGITUDE]) {
            currentCoordinates[LONGITUDE] -= 0.0001;
        }
    }
}
