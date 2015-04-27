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

    public Waypoint() {
        //Empty constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
