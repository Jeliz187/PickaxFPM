package edu.utep.cs.pickax.fpms;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Start extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

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
