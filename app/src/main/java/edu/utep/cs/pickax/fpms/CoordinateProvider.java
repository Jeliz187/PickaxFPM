/*
A simple mock GPS coordinate provider from El Paso to Albuquerque
 */
package edu.utep.cs.pickax.fpms;

import android.os.AsyncTask;
import android.util.Log;

public class CoordinateProvider extends AsyncTask<Void, Void, Void>{
    final String TAG = "COORD_PROVIDER";
    final int LATITUDE = 0, LONGITUDE = 1;
    private double[] elpasoCoordinates = {31.7975656, -106.3876102};
    private double[] albuquerqueCoordinates = {35.043036, -106.616076};
    private double[] currentCoordinates = elpasoCoordinates;

    double[] getCurrentCoordinates() {
        return currentCoordinates;
    }

    @Override
    protected Void doInBackground(Void... params) {
        while (true) {
            try {
                Thread.sleep((long)1000);
            } catch (InterruptedException e) {
                Log.d(TAG, "exception in sleep");
            }
            if (currentCoordinates[LATITUDE] < albuquerqueCoordinates[LATITUDE]) {
                currentCoordinates[LATITUDE] += 0.005;
            }
            if (currentCoordinates[LONGITUDE] > albuquerqueCoordinates[LONGITUDE]) {
                currentCoordinates[LONGITUDE] -= 0.0001;
            }
        }
    }
}
