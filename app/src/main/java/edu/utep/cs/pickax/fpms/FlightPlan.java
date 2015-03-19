package edu.utep.cs.pickax.fpms;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by ruben on 3/17/15.
 */
public class FlightPlan {

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
    //private LinkedList<Tuple> route; //We need to elaborate
    private int estTimeEnroute;
    private int fuelOnBoard;
    private LinkedList<String> altAirports;
    private String pilotName;
    private String contactInfo;
    private int passengersOnBoard;
    private int aircraftColor;
    private String destContactInfo;
    private String remarks;
    private boolean TGFApproval;

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
}
