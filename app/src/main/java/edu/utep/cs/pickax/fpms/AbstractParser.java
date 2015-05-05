package edu.utep.cs.pickax.fpms;

import java.util.LinkedList;

/**
 * Concrete subclasses of AbstractParser are used to implement the methods to parse specific XML formats
 */
public abstract class AbstractParser {
    public abstract LinkedList<Aircraft> getAllAircraft();
    public abstract LinkedList<Airport> getAllAirports();
    public abstract LinkedList<Waypoint> getAllWaypoints();
}
