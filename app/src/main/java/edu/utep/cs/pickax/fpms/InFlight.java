/*
InFlght handles realtime data display and the Google Glass
 */
package edu.utep.cs.pickax.fpms;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class InFlight extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_flight);

        final TextView speed = (TextView)findViewById(R.id.tv_current_speed);
        final TextView altitude = (TextView)findViewById(R.id.tv_current_altitude);
        final TextView remainingFuel = (TextView)findViewById(R.id.tv_remaining_fuel);
        final TextView heading = (TextView)findViewById(R.id.tv_current_heading);

        Intent mServiceIntent = new Intent(this, CoordinateProvider.class);
        mServiceIntent.setData(null);
        this.startService(mServiceIntent);

        Thread updater = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep((long)1000);
                } catch (InterruptedException e) {
                    Log.d("SLEEP", "exception in sleep");
                }
                heading.setText(""+CoordinateProvider.getCurrentHeading());
                speed.setText(""+CoordinateProvider.getCurrentSpeed());
                altitude.setText(""+CoordinateProvider.getCurrentAltitude());
                heading.setText(""+CoordinateProvider.getCurrentHeading());
                remainingFuel.setText("...");
            }
        };

        updater.start();


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