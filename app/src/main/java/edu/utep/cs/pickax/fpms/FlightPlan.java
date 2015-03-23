package edu.utep.cs.pickax.fpms;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by ruben on 3/17/15.
 */
public class FlightPlan {
    //Fields needed for the flight plan
    private String flightPlanName;
    private final String type = "IFR";
    private char aircraftID;
    private String acTypeAndSpecialEquipment;
    private int airspeed;
    private String departurePoint;
    private String destination;
    private Date flightDate;
    private int departureTime;
    private int cruisingAlt;
    //private Route route; //Make a Route Class
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

    public FlightPlan(String flightPlanName1, char aircraftID1, String acTypeAndSpecialEquipment1,
                      int airspeed1, String departurePoint1, String destination1, Date flightDate1,
                      int departureTime1, int cruisingAlt1, int estTimeEnroute1, int fuelOnBoard1,
                      String pilotName1, String contactInfo1, int passengersOnBoard1, int aircraftColor1,
                      String destContactInfo1, String remarks1){
        flightPlanName = flightPlanName1;
        aircraftID = aircraftID1;
        acTypeAndSpecialEquipment = acTypeAndSpecialEquipment1;
        airspeed = airspeed1;
        departurePoint = departurePoint1;
        destination = destination1;
        flightDate = flightDate1;
        departureTime = departureTime1;
        cruisingAlt = cruisingAlt1;
        estTimeEnroute = estTimeEnroute1;
        fuelOnBoard = fuelOnBoard1;
        pilotName = pilotName1;
        contactInfo = contactInfo1;
        passengersOnBoard = passengersOnBoard1;
        aircraftColor = aircraftColor1;
        destContactInfo = destContactInfo1;
        remarks = remarks1;
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

    //Setter methods
    public void setFlightPlanName(String flightPlanName2) {
        flightPlanName = flightPlanName2;
    }

    public void setAircraftID(char aircraftID2){
        aircraftID = aircraftID2;
    }

    public void setAcTypeAndSpecialEquipment(String acTypeAndSpecialEquipment2){
        acTypeAndSpecialEquipment = acTypeAndSpecialEquipment2;
    }

    public void setAirspeed(int airspeed2){
        airspeed = airspeed2;
    }

    public void setDeparturePoint(String departurePoint2){
        departurePoint = departurePoint2;
    }

    public void setDestination(String destination2){
        destination = destination2;
    }

    public void setFlightDate(Date flightDate2){
        flightDate = flightDate2;
    }

    public void setDepartureTime(int departureTime2){
        departureTime = departureTime2;
    }

    public void setCruisingAlt(int cruisingAlt2){
        cruisingAlt = cruisingAlt2;
    }

    public void setEstTimeEnroute(int estTimeEnroute2){
        estTimeEnroute = estTimeEnroute2;
    }

    public void setFuelOnBoard(int fuelOnBoard2){
        fuelOnBoard = fuelOnBoard2;
    }

    public void setPilotName(String pilotName2){
        pilotName = pilotName2;
    }

    public void setContactInfo(String contactInfo2){
        contactInfo = contactInfo2;
    }

    public void setPassengersOnBoard(int passengersOnBoard2){
        passengersOnBoard = passengersOnBoard2;
    }

    public void setAircraftColor(int aircraftColor2){
        aircraftColor = aircraftColor2;
    }

    public void setDestContactInfo(String destContactInfo2){
        destContactInfo = destContactInfo2;
    }

    public void setRemarks(String remarks2){
        remarks = remarks2;
    }
}
