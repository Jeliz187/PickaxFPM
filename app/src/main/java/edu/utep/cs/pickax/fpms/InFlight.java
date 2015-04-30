/*
InFlght handles realtime data display and the Google Glass
 */
package edu.utep.cs.pickax.fpms;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

import static android.support.v4.app.Fragment.instantiate;

//TODO: Stop timers when leaving activity
public class InFlight extends ActionBarActivity{
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_flight);

        //Test data
        TestLocationProvider tcp = new TestLocationProvider();

        //
        Waypoint departure = Waypoint.getWaypointByName(Start.waypointList, "VPELP");
        Waypoint destination = Waypoint.getWaypointByName(Start.waypointList, "VPABQ");
        Waypoint next = null;

        Log.d("INFLIGHT", "ep to alb: " + departure.getDistanceTo(destination));
        Log.d("INFLIGHT", "ep to alb time : "+departure.getTimeTo(destination, 200));

        LinkedList<Waypoint> myRoute = Route.computeShortestRoute(Start.waypointList, departure, destination);
        for(Waypoint w : myRoute){
            Log.d("ROUTE", w.getName());
        }

        //TODO use Display class here to update labels
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

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
            .setTitle("Quit")
            .setMessage("Quitting will close the application and stop Google Glass tracking")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // continue with delete
                    Intent intent = new Intent(InFlight.this, Start.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("EXIT", true);
                    startActivity(intent);
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            })
            .show();
    }



}
