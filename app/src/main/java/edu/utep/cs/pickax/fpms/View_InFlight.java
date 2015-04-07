/*
InFlght handles realtime data display and the Google Glass
 */
package edu.utep.cs.pickax.fpms;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

//TODO: Stop timers when leaving activity
public class View_InFlight extends ActionBarActivity {
    private final String TAG = "INFLIGHT";
    private static TextView speed;
    private static TextView altitude;
    private static TextView remainingFuel;
    private static TextView heading;
    private static TextView coordinatesLat;
    private static TextView coordinatesLon;
    private static TextView coordinatesLat2;
    private static TextView coordinatesLon2;
    private static TextView eta;
    private static TextView rta;
    private static TextView speedAlert;

    private static Random r = new Random(System.currentTimeMillis());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_flight);
        initializeViews();

        //Create instance of Model_CoordinateProvider to start coordinate generation
        Model_CoordinateProvider c = new Model_CoordinateProvider();

        //Use a CountDownTimer to constantly update labels
        new CountDownTimer(Long.MAX_VALUE, 1000) {
            public void onTick(long millisUntilFinished) {
                updateLabels();
            }
            public void onFinish() {
                Log.d(TAG, "countdown done?");
            }
        }.start();

    }

    private void initializeViews() {
        speed = (TextView)findViewById(R.id.tv_current_speed);
        altitude = (TextView)findViewById(R.id.tv_current_altitude);
        remainingFuel = (TextView)findViewById(R.id.tv_remaining_fuel);
        heading = (TextView)findViewById(R.id.tv_current_heading);
        coordinatesLat = (TextView)findViewById(R.id.tv_current_coordinates_lat);
        coordinatesLon = (TextView)findViewById(R.id.tv_current_coordinates_lon);
        //Redundant coordinate textviews for weather map card
        coordinatesLat2 = (TextView)findViewById(R.id.tv_current_coordinates_lat2);
        coordinatesLon2 = (TextView)findViewById(R.id.tv_current_coordinates_lon2);
        eta = (TextView)findViewById(R.id.ETA);
        rta = (TextView)findViewById(R.id.RTA);
        speedAlert = (TextView) findViewById(R.id.speed_alert);
    }

    /**
     * Labels are on "cards" that contain same info as Google Glass cards
     * This method updates the values on the labels using the Model_CoordinateProvider
     */
    private static void updateLabels() {
        heading.setText("" + Model_CoordinateProvider.getCurrentHeading());
        speed.setText(""+ Model_CoordinateProvider.getCurrentSpeed());
        altitude.setText(""+ Model_CoordinateProvider.getCurrentAltitude());
        heading.setText(""+ Model_CoordinateProvider.getCurrentHeading());
        remainingFuel.setText("?");

        double[] coordPair = Model_CoordinateProvider.getCurrentCoordinates();
        coordinatesLat.setText("Latitude: "+coordPair[0]);
        coordinatesLon.setText("Longitude: "+coordPair[1]);
        coordinatesLat2.setText("Latitude: "+coordPair[0]);
        coordinatesLon2.setText("Longitude: "+coordPair[1]);

        eta.setText("ETA: ?");
        rta.setText("RTA: ?");
        updateSpeedAlert();
    }

    //TODO: get the ETA and RTA from the appropriate provider
    //TODO: See if there is an acceptable range to be within the RTA
    private static void updateSpeedAlert() {
        //temporary test values
        int ETA = r.nextInt();
        int RTA = r.nextInt();

        if (ETA > RTA) { //compare ETA > RTA. Temp fake values are used just for now
            speedAlert.setText(R.string.speed_speed_up);
            speedAlert.setTextColor(Color.RED);
        } else if (ETA < RTA) { //compare ETA < RTA. Temp fake values are used just for now
            speedAlert.setText(R.string.speed_slow_down);
            speedAlert.setTextColor(Color.RED);
        } else {
            speedAlert.setText(R.string.speed_on_schedule);
            speedAlert.setTextColor(Color.GREEN);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_in_flight, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
