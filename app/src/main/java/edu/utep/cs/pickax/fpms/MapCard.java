package edu.utep.cs.pickax.fpms;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLngBounds;

import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapCard extends Fragment {

    private static View rootview = null;
    private GoogleMap g_map;

    public MapCard() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootview == null) {
            //only inflate if it hasn't already been done
            rootview = inflater.inflate(R.layout.fragment_map_card, container, false);
        }

        //TODO refactor update labels to Display Class
        TextView speed = (TextView) rootview.findViewById(R.id.in_flight_speed);
        speed.setText(Math.random() + "");

        return (rootview);
    }

    public static View getRootview() {
        return rootview == null ? null : rootview;
    }
}
