package edu.utep.cs.pickax.fpms;

import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by ruben on 4/25/15.
 */
public class MapInfoWindow implements GoogleMap.InfoWindowAdapter {
    private View infoWindow;
    private LayoutInflater inflater;

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        if (infoWindow == null) {
            infoWindow = inflater.inflate(R.layout.map_info_window, null);
        }
        return infoWindow;
    }
}
