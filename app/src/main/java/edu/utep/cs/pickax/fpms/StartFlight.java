package edu.utep.cs.pickax.fpms;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class StartFlight extends ActionBarActivity {
    private Button btnHome;
    private Button btnStartFlight;
    private TableLayout flightsTable;
    private int selectionCount;
    private FlightPlan selectedPlan = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_flight);
        initializeViews();

        addFlight();
        btnHome.setOnClickListener(Control_Buttons.btnListenerHome(this));

        btnStartFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                Context context = getApplicationContext();
                Toast toast;

                if (mBluetoothAdapter == null) {
                    // Device does not support Bluetooth
                    toast = Toast.makeText(context, "No bluetooth available", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    if (!mBluetoothAdapter.isEnabled()) {
                        // Bluetooth is not enabled)
                        toast = Toast.makeText(context, "Enable bluetooth before continuing", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                }

                //TODO restore if to selectionCount == 1
                if(selectionCount == 1) {
                    Intent myIntent = new Intent(StartFlight.this, InFlight.class);
                    myIntent.putExtra("flight_plan", selectedPlan);
                    startActivity(myIntent);
                } else if(selectionCount > 1) {
                    toast = Toast.makeText(context, getResources().getString(R.string.multiple_selections), Toast.LENGTH_SHORT);
                    toast.show();
                } else if(selectionCount < 1) {
                    toast = Toast.makeText(context, getResources().getString(R.string.no_selections), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    private void addFlight() {
        //TODO read all plans for the current day and add here
        FlightPlan plan = CreateFlightPlan.getFlightPlan();

        if(plan == null){
            return;
        }

        TableRow row = new TableRow(this);
        TextView name = new TextView(this);
        TextView date = new TextView(this);
        TextView departDest = new TextView(this);
        TextView time = new TextView(this);
        CheckBox selector =  new CheckBox(this);
        setUpCheckBox(selector, plan);

        TableRow.LayoutParams trParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        row.setLayoutParams(trParams);

        name.setText(plan.getFlightPlanName());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(plan.getFlightDate());

        date.setText(new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(calendar.getTime()));

        departDest.setText(plan.getDeparturePoint()+"-"+plan.getDestination());
        time.setText(plan.getDepartureTime()+"");

        row.addView(selector);
        row.addView(name);
        row.addView(date);
        row.addView(departDest);
        row.addView(time);

        flightsTable.addView(row);
    }

    private void setUpCheckBox(CheckBox selector, final FlightPlan plan) {
        selector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox thisThing = (CheckBox)v;
                if (thisThing.isChecked()) {
                    selectionCount++;
                    selectedPlan = plan;
                } else {
                    selectionCount--;
                }
            }
        });
    }

    private void initializeViews() {
        btnHome = (Button) findViewById(R.id.btn_home);
        btnStartFlight = (Button) findViewById(R.id.btn_start_flight);
        flightsTable = (TableLayout) findViewById(R.id.flights_table);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_flight, menu);
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
