/*
A simple mock GPS coordinate provider from El Paso to Albuquerque
Provides:
coordinates
speed
altitude
heading
 */
package edu.utep.cs.pickax.fpms;

import android.os.CountDownTimer;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class TestLocationProvider extends AbstractLocationProvider {
    private final String TAG = "TEST COORD PROVIDER";
    private final Random r = new Random(System.currentTimeMillis());

    private final int LATITUDE = 0, LONGITUDE = 1; //Indices in the coordinates array
    public final double[] elpasoCoordinates = {31.7975656, -106.3876102};
    public final double[] albuquerqueCoordinates = {35.043036, -106.616076};
    private double[] currentCoordinates = {elpasoCoordinates[LATITUDE], elpasoCoordinates[LONGITUDE]};

    private Calendar cal;

    public TestLocationProvider() {
        cal = Calendar.getInstance();
        //Use a CountDownTimer to constantly update the coordinates
        new CountDownTimer(Long.MAX_VALUE, 1000) {
            public void onTick(long millisUntilFinished) {
                generateCoordinates();
            }
            public void onFinish() {
                Log.d(TAG, "countdown done?");
            }
        }.start();
    }

    @Override
    double[] CurrentCoordinates() {
        return currentCoordinates;
    }

    //Random speed within 100 to 500
    @Override
    double CurrentSpeed() {
        return RandomDouble(100.0, 500.0);
    }

    //Random altitude within 100 to 500
    @Override
    double CurrentAltitude() {
        return RandomDouble(100.0, 500.0);
    }

    //Random heading within 0 to 360
    @Override
    double CurrentHeading() {
        return RandomDouble(0.0, 360.0);
    }

    @Override
    int currentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("kkmm", Locale.US);
        return Integer.parseInt(sdf.format(cal.getTime()));
    }

    @Override
    int distanceToDestination() {
        return 0;
    }

    //Random generator to produce mock values
    double RandomDouble(double min, double max) {
        return min + (max - min) * r.nextDouble();
    }

    /**
     * Starting at El Paso coordinates, generateCoordinates() slowly updates latitude and longitude
     * to approach Albuquerque
     */
    public void generateCoordinates() {
        if (currentCoordinates[LATITUDE] < albuquerqueCoordinates[LATITUDE]) {
            currentCoordinates[LATITUDE] += 0.005;
        }
        if (currentCoordinates[LONGITUDE] > albuquerqueCoordinates[LONGITUDE]) {
            currentCoordinates[LONGITUDE] -= 0.0001;
        }
    }
}
