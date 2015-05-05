/*
Abstract class to allow implementations of a coordinate provider, be it a standalone GP or
phone/tablet GPS
 */
package edu.utep.cs.pickax.fpms;

/**
 * Concrete subclasses of AbstractLocationProvider are used to implement the methods to
 * provide realtime updates. Can be used to read from device GPS, external GPS, etc...
 */
public abstract class AbstractLocationProvider {

    abstract double[] CurrentCoordinates();

    abstract double CurrentSpeed();

    abstract double CurrentAltitude();

    abstract double CurrentHeading();

    abstract int currentTime();

    abstract int distanceToDestination();
}
