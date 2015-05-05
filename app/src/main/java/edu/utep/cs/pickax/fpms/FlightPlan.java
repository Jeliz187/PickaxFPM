package edu.utep.cs.pickax.fpms;

import android.text.format.Time;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by ruben on 3/17/15.
 */
public class FlightPlan implements Serializable {
    //Fields needed for the flight plan
    private String flightPlanName;
    private final String type = "IFR";
    private char aircraftID;
    private String acTypeAndSpecialEquipment;
    private int airspeed;
    private String departurePoint;
    private String destination;
    private Date flightDate;
    private int departureTime; //24 time as int
    private int cruisingAlt;
    private LinkedList<Waypoint> route;
    private int estTimeEnroute;
    private int fuelOnBoard;
    private LinkedList<String> altAirports;
    private String pilotName;
    private String contactInfo;
    private int passengersOnBoard;
    private int aircraftColor;
    private String destContactInfo;
    private String remarks;
    private boolean TGFApproval = false;

    //
    public FlightPlan() {
        //Empty constructor, fields are added one at a time
    }

    //Getter methods
    public String getFlightPlanName() {
        return flightPlanName;
    }

    public char getAircraftID(){
        return aircraftID;
    }

    public String getAcTypeAndSpecialEquipment(){
        return acTypeAndSpecialEquipment;
    }

    public int getAirspeed(){
        return airspeed;
    }

    public String getDeparturePoint(){
        return departurePoint;
    }

    public String getDestination(){
        return destination;
    }

    public Date getFlightDate(){
        return flightDate;
    }

    public int getDepartureTime(){
        return departureTime;
    }

    public int getCruisingAlt(){
        return cruisingAlt;
    }

    public int getEstTimeEnroute(){
        return estTimeEnroute;
    }

    public int getFuelOnBoard(){
        return fuelOnBoard;
    }

    public LinkedList<String> getAltAirports(){
        return altAirports;
    }

    public String getPilotName(){
        return pilotName;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public int getPassengersOnBoard(){
        return passengersOnBoard;
    }

    public int getAircraftColor(){
        return aircraftColor;
    }

    public String getDestContactInfo(){
        return destContactInfo;
    }

    public String getRemarks(){
        return remarks;
    }

    public LinkedList<Waypoint> getRoute() {
        return route;
    }


    //Setter methods
    public void setFlightPlanName(String flightPlanName) {
        this.flightPlanName = flightPlanName;
    }

    public void setAircraftID(char aircraftID){
        this.aircraftID = aircraftID;
    }

    public void setAcTypeAndSpecialEquipment(String acTypeAndSpecialEquipment){
        this.acTypeAndSpecialEquipment = acTypeAndSpecialEquipment;
    }

    public void setAirspeed(int airspeed){
        this.airspeed = airspeed;
    }

    public void setDeparturePoint(String departurePoint2){
        departurePoint = departurePoint2;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public void setFlightDate(Date flightDate){
        this.flightDate = flightDate;
    }

    public void setDepartureTime(int departureTime){
        this.departureTime = departureTime;
    }

    public void setCruisingAlt(int cruisingAlt){
        this.cruisingAlt = cruisingAlt;
    }

    public void setEstTimeEnroute(int estTimeEnroute){
        this.estTimeEnroute = estTimeEnroute;
    }

    public void setFuelOnBoard(int fuelOnBoard){
        this.fuelOnBoard = fuelOnBoard;
    }

    public void setAltAirports(LinkedList<String> altAirports){
        this.altAirports = altAirports;
    }

    public void setPilotName(String pilotName){
        this.pilotName = pilotName;
    }

    public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
    }

    public void setPassengersOnBoard(int passengersOnBoard){
        this.passengersOnBoard = passengersOnBoard;
    }

    public void setAircraftColor(int aircraftColor){
        this.aircraftColor = aircraftColor;
    }

    public void setDestContactInfo(String destContactInfo){
        this.destContactInfo = destContactInfo;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    public void setRoute(LinkedList<Waypoint> route) {
        this.route = route;
    }
}
