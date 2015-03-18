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

}
