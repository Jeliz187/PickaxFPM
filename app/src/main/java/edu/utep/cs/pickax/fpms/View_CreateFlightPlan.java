package edu.utep.cs.pickax.fpms;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;


public class View_CreateFlightPlan extends ActionBarActivity {

    private EditText et_name;
    private EditText et_flightType;
    private Spinner sp_aircraftID;
    private EditText et_ATandSE; //Aircraft Type & Special Equipment
    private EditText et_airspeed;
    private DatePicker datepick;

    private EditText et_dateOfFlight;
    private EditText et_departTime;
    private EditText et_cruisingAltitude;
    private RadioGroup rg_routeOptions;
    private RadioButton rb_shortest;
    private RadioButton rb_fastest;
    private RadioButton rb_archived;
    private RadioButton rb_custom;
    private EditText et_estTimeEnroute;
    private EditText et_fuelOnboard;
    private EditText et_pilotName;
    private EditText et_contactInfo;
    private Spinner sp_numberOnboard;
    private EditText et_aircraftColor;
    private EditText et_destContactInfo;
    private EditText et_remarks;
    private Spinner ac_id;
    private Spinner sp_destination;
    private Spinner sp_departure;
    private Spinner sp_timeZone;
    private Spinner sp_altAirport1;
    private Spinner sp_altAirport2;
    private Spinner sp_altAirport3;

    private Button btnHome;
    private Button btnSave;
    private Button btnSubmit;

    private Model_FlightPlan myModelFlightPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flight_plan);
        initializeViews(); //Create references to views
        initializeSpinners(); //Set the adapters for the spinners

        rb_archived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(View_CreateFlightPlan.this, View_ArchivedRoutes.class);
                startActivity(myIntent);
            }
        });

        rb_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(View_CreateFlightPlan.this, View_CustomRoutes.class);
                startActivity(myIntent);
            }
        });

        btnHome.setOnClickListener(Control_Buttons.btnListenerHome(this));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Using the info on the Create Flight Plan screen, create a new FlightPlan object
        //TODO: error checking
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myModelFlightPlan = new Model_FlightPlan(et_name.getText().toString(), 'I', et_ATandSE.getText().toString(), Integer.parseInt(et_airspeed.getText().toString()),
                        sp_departure.getSelectedItem().toString(), sp_destination.getSelectedItem().toString(), getDate(), Integer.parseInt(et_departTime.getText().toString()),
                        Integer.parseInt(et_cruisingAltitude.getText().toString()), Integer.parseInt(et_estTimeEnroute.getText().toString()),
                        Integer.parseInt(et_fuelOnboard.getText().toString()), et_pilotName.getText().toString(), et_contactInfo.getText().toString(),
                        Integer.parseInt(sp_numberOnboard.getSelectedItem().toString()), Integer.parseInt(et_aircraftColor.getText().toString()),
                        et_destContactInfo.getText().toString(), et_remarks.getText().toString());
                finish();
            }
        });


        ac_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == parent.getCount()-1) {
                    Intent i = new Intent();
                    i.setClass(View_CreateFlightPlan.this, View_CreateAircraft.class);
                    startActivity(i);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    /**
     * Sets the adapters for each of the spinners
     */
    private void initializeSpinners() {
        ac_id.setAdapter(makeAdapter(R.array.array_aircraft_id));

        sp_destination.setAdapter(makeAdapter(R.array.array_dept_dest));

        sp_departure.setAdapter(makeAdapter(R.array.array_dept_dest));

        sp_timeZone.setAdapter(makeAdapter(R.array.array_time_zone));

        sp_altAirport1.setAdapter(makeAdapter(R.array.array_airport_code));

        sp_altAirport2.setAdapter(makeAdapter(R.array.array_airport_code));

        sp_altAirport3.setAdapter(makeAdapter(R.array.array_airport_code));
    }

    /**
     * Sets the adapter using the given array resource
     * @param arrayResID ID of the array resource to use
     * @return the correct array adapter
     */
    private ArrayAdapter<CharSequence> makeAdapter(int arrayResID) {
        return ArrayAdapter.createFromResource(this, arrayResID, android.R.layout.simple_spinner_dropdown_item);
    }

    /**
     * Computes the Date from the DatePicker
     * @return the Date object specified by the DatePicker 'datepick'
     */
    private Date getDate() {
        int day = datepick.getDayOfMonth();
        int month = datepick.getMonth();
        int year =  datepick.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    /**
     * Creates references to all the relevant views
     */
    private void initializeViews() {
        et_name= (EditText) findViewById(R.id.et_name);
        et_ATandSE = (EditText) findViewById(R.id.et_at_and_se);
        et_airspeed = (EditText) findViewById(R.id.et_airspeed);
        rb_archived = (RadioButton) findViewById(R.id.rb_archived);
        rb_custom = (RadioButton) findViewById(R.id.rb_custom);
        btnHome = (Button) findViewById(R.id.btn_home);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        datepick = (DatePicker) findViewById(R.id.datePicker);
        et_departTime = (EditText) findViewById(R.id.et_depart_time);
        et_cruisingAltitude = (EditText) findViewById(R.id.et_cruising_altitude);
        et_estTimeEnroute = (EditText) findViewById(R.id.et_estimated_time);
        et_fuelOnboard = (EditText) findViewById(R.id.et_fuel_onboard);
        et_pilotName = (EditText) findViewById(R.id.et_pilot_name);
        et_contactInfo = (EditText) findViewById(R.id.et_contact_info);
        et_aircraftColor = (EditText) findViewById(R.id.et_aircraft_color);
        et_destContactInfo = (EditText) findViewById(R.id.et_dest_contact_info);
        et_remarks = (EditText) findViewById(R.id.et_remarks);

        ac_id = (Spinner) findViewById(R.id.sp_aircraft_id);
        sp_destination = (Spinner) findViewById(R.id.sp_dest);
        sp_departure = (Spinner) findViewById(R.id.sp_departure);
        sp_timeZone = (Spinner) findViewById(R.id.sp_time_zone);
        sp_altAirport1 = (Spinner) findViewById(R.id.sp_alt_airport1);
        sp_altAirport2 = (Spinner) findViewById(R.id.sp_alt_airport2);
        sp_altAirport3 = (Spinner) findViewById(R.id.sp_alt_airport3);
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
