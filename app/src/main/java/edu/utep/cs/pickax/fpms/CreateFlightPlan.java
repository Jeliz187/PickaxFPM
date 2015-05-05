package edu.utep.cs.pickax.fpms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
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
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class CreateFlightPlan extends ActionBarActivity {

    private EditText et_name;
    private EditText et_flightType;
    private Spinner sp_aircraftID;
    private EditText et_ATandSE; //Aircraft Type & Special Equipment
    private EditText et_airspeed;
    private DatePicker datepick;
    private TimePicker timepick;

    private EditText et_dateOfFlight;
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

    private Spinner ac_id; //TODO actionlistener that populates fields for a given aircraft
    private Spinner sp_destination;
    private Spinner sp_departure;
    private Spinner sp_timeZone;
    private Spinner sp_altAirport1;
    private Spinner sp_altAirport2;
    private Spinner sp_altAirport3;

    private Button btnHome;
    private Button btnSave;
    private Button btnSubmit;

    private static FlightPlan myModelFlightPlan;
    private static LinkedList<Waypoint> myRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_flight_plan);
        initializeViews(); //Create references to views
        initializeSpinners(); //Set the adapters for the spinners
        loadSpinnerData();

        //Set shortest route as default option
        //rb_shortest.setSelected(true);
        rg_routeOptions.check(rg_routeOptions.getChildAt(0).getId());

        //Listeners for route options selection
        rb_archived.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CreateFlightPlan.this, ArchivedRoutes.class);
                startActivity(myIntent);
            }
        });

        rb_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CreateFlightPlan.this, CustomRoutes.class);
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
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setRouteType();
                    setFields();
                    //Save serialized FlightPlan object to KB
                    writeFPToKB(serializeFlightPlan());
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Context context = getApplicationContext();
                    CharSequence text = getResources().getString(R.string.missing_field);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });

        ac_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position == parent.getCount()) {
//                    Intent i = new Intent();
//                    i.setClass(CreateFlightPlan.this, CreateAircraft.class);
//                    startActivity(i);
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    //Sets all the relevant (need to finish) fields that make up the FlightPlan object
    private void setFields() throws Exception {
        //TODO better exception handling
        //TODO get Aircraft information
        myModelFlightPlan = new FlightPlan();
        if(et_name.getText().toString().trim().equals("")){
            throw new Exception(); //Exception if no flight plan name
        }
        myModelFlightPlan.setFlightPlanName(et_name.getText().toString());
        //myModelFlightPlan.setAircraftID();
        //myModelFlightPlan.setAcTypeAndSpecialEquipment();
        //myModelFlightPlan.setAirspeed(Integer.parseInt(et_airspeed.getText().toString()));
        myModelFlightPlan.setDeparturePoint(sp_departure.getSelectedItem().toString());
        myModelFlightPlan.setDestination(sp_destination.getSelectedItem().toString());
        myModelFlightPlan.setFlightDate(getSpecifiedDate());
        myModelFlightPlan.setDepartureTime(getSpecifiedTime());
        //myModelFlightPlan.setCruisingAlt(Integer.parseInt(et_cruisingAltitude.getText().toString()));
        myModelFlightPlan.setEstTimeEnroute(calculateEstTimeEnroute());
        //myModelFlightPlan.setFuelOnBoard();
        myModelFlightPlan.setAltAirports(altAirportsAsList());
        myModelFlightPlan.setPilotName(et_pilotName.getText().toString());
        myModelFlightPlan.setContactInfo(et_contactInfo.getText().toString());
        myModelFlightPlan.setPassengersOnBoard(Integer.parseInt(sp_numberOnboard.getSelectedItem().toString()));
        //myModelFlightPlan.setAircraftColor();
        myModelFlightPlan.setDestContactInfo(et_destContactInfo.getText().toString());
        myModelFlightPlan.setRemarks(et_remarks.getText().toString());
        myModelFlightPlan.setRoute(myRoute);
    }

    private void setRouteType() throws Exception {
        int selection = rg_routeOptions.getCheckedRadioButtonId();

        if(sp_departure.getSelectedItem().toString().equals(sp_destination.getSelectedItem().toString())) {
            throw new Exception(); //exception if departure == destination
        }

        Waypoint departure = Waypoint.getWaypointByName(Start.waypointList, "VP"+sp_departure.getSelectedItem().toString());
        Waypoint destination = Waypoint.getWaypointByName(Start.waypointList, "VP"+sp_destination.getSelectedItem().toString());

        switch (selection){
            case R.id.rb_shortest:
                //Shortest
                Log.d("Create Flight Plan", "SELECTED shortest");
                myRoute = Route.computeShortestRoute(Start.waypointList, departure, destination);
                break;
            case R.id.rb_fastest:
                //Fastest
                Log.d("Create Flight Plan", "SELECTED fastest (not implemented yet)");
                throw new Exception(); //Not implemented yet
            case R.id.rb_archived:
                //Archived
                Log.d("Create Flight Plan", "SELECTED archived (not implemented yet)");
                throw new Exception(); //Not implemented yet
            case R.id.rb_custom:
                //Custom
                Log.d("Create Flight Plan", "SELECTED custom (not implemented yet)");
                throw new Exception(); //Not implemented yet
            default:
                Log.d("Create Flight Plan", "oooops no route option selected");
                throw new Exception();
        }
    }

    private void writeFPToKB(String encoded) {
        KnowledgeBase kb = new KnowledgeBase(this);
        long r = kb.createFlightPlanRecord(encoded);
        Log.d("CREATE", "Saved fp tp db: " + r);
    }

    private String serializeFlightPlan() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( myModelFlightPlan );
        oos.close();
        return new String( Base64.encode(baos.toByteArray(), Base64.DEFAULT) );
    }

    public static FlightPlan getFlightPlan() {
        return myModelFlightPlan;
    }

    private int calculateEstTimeEnroute(){
        //TODO calculations
        return 310;
    }

    private LinkedList<String> altAirportsAsList(){
        LinkedList<String> list = new LinkedList<>();
        list.add(sp_altAirport1.getSelectedItem().toString());
        list.add(sp_altAirport2.getSelectedItem().toString());
        list.add(sp_altAirport3.getSelectedItem().toString());
        return list;
    }

    private void loadSpinnerData() {
        // database handler
        AC_KBHelper db = new AC_KBHelper(getApplicationContext());

        // Spinner Drop down elements
        List<String> labels = db.getAircrafts();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        ac_id.setAdapter(dataAdapter);
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
    private Date getSpecifiedDate() {
        int day = datepick.getDayOfMonth();
        int month = datepick.getMonth();
        int year =  datepick.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }

    //Returns the time as an int that is represented by the time picker
    private int getSpecifiedTime() {
        String hr = "" + timepick.getCurrentHour();
        String min = "" + timepick.getCurrentMinute();
        //TODO represent times when minutes > 10
        return Integer.parseInt(hr+min);
    }

    /**
     * Creates references to all the relevant views
     */
    private void initializeViews() {
        et_name= (EditText) findViewById(R.id.et_name);
        rg_routeOptions = (RadioGroup) findViewById(R.id.rg_route_options);
        rb_archived = (RadioButton) findViewById(R.id.rb_archived);
        rb_custom = (RadioButton) findViewById(R.id.rb_custom);
        rb_shortest = (RadioButton) findViewById(R.id.rb_shortest);
        rb_fastest = (RadioButton) findViewById(R.id.rb_fastest);
        btnHome = (Button) findViewById(R.id.btn_home);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        datepick = (DatePicker) findViewById(R.id.datePicker);
        timepick = (TimePicker) findViewById(R.id.timePicker);
        et_estTimeEnroute = (EditText) findViewById(R.id.et_estimated_time);
        et_pilotName = (EditText) findViewById(R.id.et_pilot_name);
        et_contactInfo = (EditText) findViewById(R.id.et_contact_info);
        et_destContactInfo = (EditText) findViewById(R.id.et_dest_contact_info);
        et_remarks = (EditText) findViewById(R.id.et_remarks);

        ac_id = (Spinner) findViewById(R.id.sp_aircraft_id);
        sp_destination = (Spinner) findViewById(R.id.sp_dest);
        sp_departure = (Spinner) findViewById(R.id.sp_departure);
        sp_timeZone = (Spinner) findViewById(R.id.sp_time_zone);
        sp_altAirport1 = (Spinner) findViewById(R.id.sp_alt_airport1);
        sp_altAirport2 = (Spinner) findViewById(R.id.sp_alt_airport2);
        sp_altAirport3 = (Spinner) findViewById(R.id.sp_alt_airport3);
        sp_numberOnboard = (Spinner) findViewById(R.id.sp_number_onboard);

        timepick.setIs24HourView(true);
        timepick.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
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
