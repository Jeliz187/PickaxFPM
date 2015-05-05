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

    public Airport(){
        //empty constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Waypoint getAssociatedWaypoint() {
        return associatedWaypoint;
    }

    public void setAssociatedWaypoint(Waypoint associatedWaypoint) {
        this.associatedWaypoint = associatedWaypoint;
    }

    public int getOpHoursClose() {
        return opHoursClose;
    }

    public void setOpHoursClose(int opHoursClose) {
        this.opHoursClose = opHoursClose;
    }

    public int getOpHoursOpen() {
        return opHoursOpen;
    }

    public void setOpHoursOpen(int opHoursOpen) {
        this.opHoursOpen = opHoursOpen;
    }

    public String getRunwayClosures() {
        return runwayClosures;
    }

    public void setRunwayClosures(String runwayClosures) {
        this.runwayClosures = runwayClosures;
    }

    //returns true if the given time falls within operation hours for the airport
    public boolean isInOperationHours(int time) {
        return time >= opHoursOpen && time <= opHoursClose;
    }

}
