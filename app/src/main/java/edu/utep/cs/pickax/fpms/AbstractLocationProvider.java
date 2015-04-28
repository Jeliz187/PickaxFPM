/*
Abstract class to allow implementations of a coordinate provider, be it a standalone GP or
phone/tablet GPS
 */
package edu.utep.cs.pickax.fpms;

import android.os.CountDownTimer;
import android.util.Log;

import java.util.Random;

public abstract class AbstractLocationProvider {

    abstract double[] CurrentCoordinates();

    abstract double CurrentSpeed();

    abstract double CurrentAltitude();

    abstract double CurrentHeading();

    abstract int currentTime();

    abstract int distanceToDestination();
}
