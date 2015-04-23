package edu.utep.cs.pickax.fpms;

public class Waypoint {
    private String name;
    private double latitude;
    private double longitude;

    public Waypoint(String name, double latitude, double longitude) {
        if(!name.startsWith("VP") || name.length() != 5){
            return;
        }
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
