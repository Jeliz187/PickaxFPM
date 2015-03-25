package edu.utep.cs.pickax.fpms;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class CreateFlightPlan extends ActionBarActivity {

    private EditText et_name;
    private EditText et_flightType;
    private Spinner sp_aircraftID;
    private EditText et_ATandSE; //Aircraft Type & Special Equipment
    private EditText et_airspeed;
    private Spinner sp_departure;
    private Spinner sp_destination;
    private EditText et_dateOfFlight;
    private ImageView iv_calendar;
    private EditText et_departTime;
    private Spinner sp_timeZone;
    private EditText et_cruisingAltitude;
    private RadioGroup rg_routeOptions;
    private RadioButton rb_shortest;
    private RadioButton rb_fastest;
    private RadioButton rb_archived;
    private RadioButton rb_custom;
    private EditText et_estTimeEnroute;
    private EditText et_fuelOnboard;
    private Spinner sp_altAirport1;
    private Spinner sp_altAirport2;
    private Spinner sp_altAirport3;
    private EditText et_pilotName;
    private EditText et_contactInfo;
    private Spinner sp_numberOnboard;
    private EditText et_aircraftColor;
    private EditText et_destContactInfo;
    private EditText et_remarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flight_plan);

        et_name= (EditText)findViewById(R.id.et_name);

        rb_archived = (RadioButton)findViewById(R.id.rb_archived);
        rb_archived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CreateFlightPlan.this, ArchivedRoutes.class);
                startActivity(myIntent);
            }
        });

        Button btnHome = (Button)findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnSave = (Button)findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("Name", et_name.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        //boolean myBoolean = savedInstanceState.getBoolean("MyBoolean");
        et_name.setText(savedInstanceState.getString("Name"));
        Log.d("COOL", "Restored a field - on restore");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_flight_plan, menu);
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
