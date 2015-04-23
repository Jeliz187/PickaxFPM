package edu.utep.cs.pickax.fpms;

public class Airport {
    private String name;
    private String runwayClosures;
    private int opHoursOpen;
    private int opHoursClose;
    private Waypoint associatedWaypoint;

    public Airport(String name, String runwayClosures, int opHoursOpen, int opHoursClose, Waypoint associatedWaypoint) {
        this.name = name;
        this.runwayClosures = runwayClosures;
        this.opHoursOpen = opHoursOpen;
        this.opHoursClose = opHoursClose;
        this.associatedWaypoint = associatedWaypoint;
    }

    public String getName() {
        return name;
    }

    public String getRunwayClosures() {
        return runwayClosures;
    }

    public int getOpenTime() {
        return opHoursOpen;
    }

    public int getCloseTime() {
        return opHoursClose;
    }

    public double getLatitude() {
        return associatedWaypoint.getLatitude();
    }

    public double getLongitude() {
        return associatedWaypoint.getLongitude();
    }

    public Waypoint getAssociatedWaypoint() {
        return associatedWaypoint;
    }



    public boolean isInOperationHours(int time) {
        return time >= opHoursOpen && time <= opHoursClose;
    }

}
