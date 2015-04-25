package edu.utep.cs.pickax.fpms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherCard extends Fragment {

    private static View rootview = null;

    public WeatherCard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(rootview==null) {
            //only inflate if it hasn't already been done
            rootview = inflater.inflate(R.layout.fragment_weather_card, container, false);
        }

        //TODO refactor update labels to Display Class
        TextView speed = (TextView) rootview.findViewById(R.id.in_flight_speed);
        speed.setText(Math.random()+"");
        return rootview;
    }

    public static View getRootview() {
        return rootview==null ? null : rootview;
    }
}
