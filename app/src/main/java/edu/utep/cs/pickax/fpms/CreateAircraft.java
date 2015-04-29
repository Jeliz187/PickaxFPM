package edu.utep.cs.pickax.fpms;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateAircraft extends ActionBarActivity{

    private Button btnHome;
    private Button btnSave;
    private Button btnSubmit;

    private Aircraft myAC;

    private EditText ac_name;
    private EditText ac_id;
    private EditText ac_model;
    private EditText ac_color;
    private EditText ac_min_speed;
    private EditText ac_norm_speed;
    private EditText ac_max_speed;
    private EditText ac_min_alt;
    private EditText ac_norm_alt;
    private EditText ac_max_alt;
    private EditText ac_fuel_con;
    private EditText ac_con_rate;
    private Context context = this;
    private KnowledgeBase ACKB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_aircraft);
        initializeViews();

        btnHome.setOnClickListener(Control_Buttons.btnListenerHome(this));

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    setFields();
                    setAIRCRAFTKnowledgeBase();
                } catch (Exception e) {
                    Context context = getApplicationContext();
                    CharSequence text = getResources().getString(R.string.missing_field);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

    private void setFields() {
        myAC = new Aircraft();
        myAC.setName(ac_name.getText().toString());
        myAC.setId(ac_id.getText().toString());
        myAC.setModel(ac_model.getText().toString());
        myAC.setColor(ac_color.getText().toString());
        myAC.setMinCruiseSpeed(Integer.parseInt(ac_min_speed.getText().toString()));
        myAC.setNormalCruiseSpeed(Integer.parseInt(ac_norm_speed.getText().toString()));
        myAC.setMaxCruiseSpeed(Integer.parseInt(ac_max_speed.getText().toString()));
        myAC.setMinCruiseAltitude(Integer.parseInt(ac_min_alt.getText().toString()));
        myAC.setNormalCruiseAltitude(Integer.parseInt(ac_norm_alt.getText().toString()));
        myAC.setMaxCruiseAltitude(Integer.parseInt(ac_max_alt.getText().toString()));
        myAC.setFuelConsumption(Integer.parseInt(ac_fuel_con.getText().toString()));
        myAC.setConsumptionRate(Integer.parseInt(ac_con_rate.getText().toString()));

//        finish();
    }

    public void setAIRCRAFTKnowledgeBase() {
        ACKB = new KnowledgeBase(context);

        String name = myAC.getName();
        String id = myAC.getId();
        String model = myAC.getModel();
        String color = myAC.getColor();
        int mins = myAC.getMinCruiseSpeed();
        int norms = myAC.getNormalCruiseSpeed();
        int maxs = myAC.getMaxCruiseSpeed();
        int mina = myAC.getMinCruiseAltitude();
        int norma = myAC.getNormalCruiseAltitude();
        int maxa = myAC.getMaxCruiseAltitude();
        int fc = myAC.getFuelConsumption();
        int cr = myAC.getConsumptionRate();

//        CharSequence text = name;
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();

        ACKB.createAircraftRecords(name, id, model, color, mins, norms, maxs, mina, norma, maxa, fc, cr);
        finish();
    }

    private void initializeViews() {
        ac_name = (EditText) findViewById(R.id.create_ac_name);
        ac_id = (EditText) findViewById(R.id.create_ac_id);
        ac_model = (EditText) findViewById(R.id.create_ac_model);
        ac_color = (EditText) findViewById(R.id.create_ac_color);
        ac_min_speed = (EditText) findViewById(R.id.create_ac_min_crusing_speed);
        ac_norm_speed = (EditText) findViewById(R.id.create_ac_norm_crusing_speed);
        ac_max_speed = (EditText) findViewById(R.id.create_ac_max_crusing_speed);
        ac_min_alt = (EditText) findViewById(R.id.create_ac_min_crusing_altitude);
        ac_norm_alt = (EditText) findViewById(R.id.create_ac_norm_crusing_altitude);
        ac_max_alt = (EditText) findViewById(R.id.create_ac_max_crusing_altitude);
        ac_fuel_con = (EditText) findViewById(R.id.create_ac_fuel_consumption);
        ac_con_rate = (EditText) findViewById(R.id.create_ac_fuel_consumption_rate);


        btnHome = (Button) findViewById(R.id.btn_home);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_aircraft, menu);
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
