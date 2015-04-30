package edu.utep.cs.pickax.fpms;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;



import java.io.InputStream;
import java.util.LinkedList;

/**
 * Implements the ability to parse our example XML files
 */
public class XMLParser extends Parser{
    private InputStream aircraftXML = null;
    private InputStream airportXML = null;
    private InputStream waypointXML = null;

    public XMLParser(InputStream aircraftXML, InputStream airportXML, InputStream waypointXML) {
        this.aircraftXML = aircraftXML;
        this.airportXML = airportXML;
        this.waypointXML = waypointXML;
    }

    public XMLParser(InputStream waypointXML) {
        this.waypointXML = waypointXML;
    }

    @Override
    public LinkedList<Aircraft> getAllAircraft() {
        LinkedList<Aircraft> list = new LinkedList<>();
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        Aircraft aircraft = null;
        String text = "";

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(aircraftXML, null);

            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if(tagname.equalsIgnoreCase("aircraft")) {
                            aircraft = new Aircraft();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        //TODO try/catch blocks
                        if(tagname.equalsIgnoreCase("aircraft")) {
                            list.add(aircraft);
                        } else if(tagname.equalsIgnoreCase("name")) {
                            aircraft.setName(text);
                        } else if(tagname.equalsIgnoreCase("id")) {
                            aircraft.setId(text);
                        } else if(tagname.equalsIgnoreCase("model")) {
                            aircraft.setModel(text);
                        } else if(tagname.equalsIgnoreCase("color")) {
                            aircraft.setColor(text);
                        } else if(tagname.equalsIgnoreCase("cruise_speed_min")) {
                            aircraft.setMinCruiseSpeed(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("cruise_speed_normal")) {
                            aircraft.setNormalCruiseSpeed(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("cruise_speed_max")) {
                            aircraft.setMaxCruiseSpeed(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("cruise_altitude_min")) {
                            aircraft.setMinCruiseAltitude(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("cruise_altitude_normal")) {
                            aircraft.setNormalCruiseAltitude(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("cruise_altitude_max")) {
                            aircraft.setMaxCruiseAltitude(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("fuel_consumption")) {
                            aircraft.setFuelConsumption(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("consumption_rate")) {
                            aircraft.setConsumptionRate(Integer.parseInt(text));
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            //Some kind of alert
        }

        return list;
    }

    @Override
    public LinkedList<Airport> getAllAirports() {
        LinkedList<Airport> list = new LinkedList<>();
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        Airport airport = null;
        String text = "";

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(airportXML, null);

            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if(tagname.equalsIgnoreCase("airport")) {
                            airport = new Airport();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        //TODO try/catch blocks
                        if(tagname.equalsIgnoreCase("airport")) {
                            list.add(airport);
                        } else if(tagname.equalsIgnoreCase("name")) {
                            airport.setName(text);
                        } else if(tagname.equalsIgnoreCase("waypoint")) {
                            //airport.setAssociatedWaypoint(text); //TODO parse individual waypoint
                        } else if(tagname.equalsIgnoreCase("runway_closures")) {
                            airport.setRunwayClosures(text);
                        } else if(tagname.equalsIgnoreCase("op_open")) {
                            airport.setOpHoursOpen(Integer.parseInt(text));
                        } else if(tagname.equalsIgnoreCase("op_close")) {
                            airport.setOpHoursClose(Integer.parseInt(text));
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            //Some kind of alert
        }

        return list;
    }

    @Override
    public LinkedList<Waypoint> getAllWaypoints() {
        LinkedList<Waypoint> list = new LinkedList<>();
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        Waypoint waypoint = null;
        String text = "";

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(waypointXML, null);

            int eventType = parser.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if(tagname.equalsIgnoreCase("waypoint")) {
                            waypoint = new Waypoint();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        //TODO try/catch blocks
                        if(tagname.equalsIgnoreCase("waypoint")) {
                            list.add(waypoint);
                        } else if(tagname.equalsIgnoreCase("name")) {
                            waypoint.setName(text);
                        } else if(tagname.equalsIgnoreCase("lat")) {
                            waypoint.setLatitude(Double.parseDouble(text));
                        } else if(tagname.equalsIgnoreCase("long")) {
                            waypoint.setLongitude(Double.parseDouble(text));
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            //Some kind of alert
        }

        return list;
    }

}
