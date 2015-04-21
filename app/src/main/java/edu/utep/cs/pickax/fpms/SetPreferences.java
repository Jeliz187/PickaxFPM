package edu.utep.cs.pickax.fpms;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static edu.utep.cs.pickax.fpms.R.id.sp_aircraft_id;


public class SetPreferences extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__set_preferences);

        Spinner ac_id = (Spinner) findViewById(sp_aircraft_id);
        ArrayAdapter<CharSequence> ac_id_adapter = ArrayAdapter.createFromResource(this, R.array.array_aircraft_id, android.R.layout.simple_spinner_dropdown_item);
        ac_id.setAdapter(ac_id_adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view__set_preferences, menu);
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
