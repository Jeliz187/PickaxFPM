package edu.utep.cs.pickax.fpms;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class StartFlight extends ActionBarActivity {
    private Button btnHome;
    private Button btnStartFlight;
    private TableLayout flightsTable;

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
                //TODO: add alert if there is no flight plan selected
                Intent myIntent = new Intent(StartFlight.this, InFlight.class);
                startActivity(myIntent);
            }
        });

    }

    private void addFlight() {
        edu.utep.cs.pickax.fpms.FlightPlan plan = CreateFlightPlan.getFlightPlan();

        if(plan == null){
            return;
        }

        TableRow row = new TableRow(this);
        TextView name = new TextView(this);
        TextView date = new TextView(this);
        TextView departDest = new TextView(this);
        TextView time = new TextView(this);

        TableRow.LayoutParams trParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        row.setLayoutParams(trParams);

        name.setText(plan.getFlightPlanName());
        date.setText(plan.getFlightDate().getMonth()+"/"+plan.getFlightDate().getDay()+"/"+(plan.getFlightDate().getYear()+1900));
        departDest.setText(plan.getDeparturePoint()+"-"+plan.getDestination());
        time.setText(plan.getDepartureTime()+"");

        row.addView(name);
        row.addView(date);
        row.addView(departDest);
        row.addView(time);

        flightsTable.addView(row);
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
