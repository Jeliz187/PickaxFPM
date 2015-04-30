package edu.utep.cs.pickax.fpms;

import java.util.LinkedList;

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


    //Calculates the distance to a given waypoint in nautical miles
    public double getDistanceTo(Waypoint nextWP) {
        //SRS was wrong, look here: http://www.movable-type.co.uk/scripts/latlong.html
        double earthRadius = 3443.89849; //in nautical miles

        double lat1 = this.latitude;
        double lon1 = this.longitude;

        double lat2 = nextWP.getLatitude();
        double lon2 = nextWP.getLongitude();

        double φ1 = Math.toRadians(lat1);
        double φ2 = Math.toRadians(lat2);

        double Δφ = Math.toRadians(lat2 - lat1);
        double Δλ = Math.toRadians(lon2 - lon1);

        double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) + Math.cos(φ1) * Math.cos(φ2) * Math.sin(Δλ/2) * Math.sin(Δλ/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return earthRadius * c;
    }

    public double getTimeTo(Waypoint nextWp, double currentGroundSpeed) {
        //Formula from SRS
        return getDistanceTo(nextWp) / currentGroundSpeed;
    }

    public static Waypoint getWaypointByName(LinkedList<Waypoint> all, String name) {
        for( Waypoint w : all) {
            if(w.getName().equalsIgnoreCase(name)){
                return w;
            }
        }
        return null;
    }
}
