package edu.utep.cs.pickax.fpms;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;


public class Start extends ActionBarActivity {
    //accessible lists for any class that needs to use them.
    public static LinkedList<Aircraft> aircraftList;
    public static LinkedList<Airport> airportList;
    public static LinkedList<Waypoint> waypointList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            System.exit(0);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        loadResouces();

        Button flightPlan = (Button)findViewById(R.id.btn_create_fp);
        flightPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Start.this, CreateFlightPlan.class);
                startActivity(myIntent);
            }
        });

        Button mng_flight_plan = (Button)findViewById(R.id.btn_manage_fp);
        mng_flight_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Start.this, ManageFlightPlans.class);
                startActivity(myIntent);
            }
        });

        Button mng_resources = (Button)findViewById(R.id.btn_manage_res);
        mng_resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Start.this, ManageResources.class);
                startActivity(myIntent);
            }
        });

        Button usr_pref = (Button)findViewById(R.id.btn_set_prefs);
        usr_pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Start.this, SetPreferences.class);
                startActivity(myIntent);
            }
        });

        Button start_flight = (Button)findViewById(R.id.btn_start_flight);
        start_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Start.this, StartFlight.class);
                startActivity(myIntent);
            }
        });
    }

    //Parse resources and save to database
    private void loadResouces() {
        KnowledgeBase kb = new KnowledgeBase(this);
        InputStream aircraftFile = null;
        InputStream airportsFile = null;
        InputStream waypointsFile = null;

        aircraftFile = getResources().openRawResource(R.raw.aircraftcharacteristic);
        airportsFile = getResources().openRawResource(R.raw.airport);
        waypointsFile = getResources().openRawResource(R.raw.waypoint);

        XMLParser myParser = new XMLParser(aircraftFile, airportsFile, waypointsFile);
        aircraftList = myParser.getAllAircraft();
        airportList = myParser.getAllAirports();
        waypointList = myParser.getAllWaypoints();

        //TODO only add if not already present

        for(Aircraft a : aircraftList) {
            kb.createAircraftRecords(a);
        }

        for(Airport a : airportList) {
            //TODO add airport record
        }

        for(Waypoint a : waypointList) {
            //TODO add waypoint record
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
