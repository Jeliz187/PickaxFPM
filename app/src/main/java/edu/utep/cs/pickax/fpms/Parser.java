package edu.utep.cs.pickax.fpms;

/**
 * Concrete subclasses of Parser are used to implement the methods to parse specific XML formats
 */
public abstract class Parser {
    public abstract Aircraft getAircraft(String name);
    public abstract Airport getAirport(String name);
    public abstract Waypoint getWaypoint(String name);
}
