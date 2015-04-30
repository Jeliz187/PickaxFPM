package edu.utep.cs.pickax.fpms;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.util.LinkedList;

/**
 * Created by ruben on 4/30/15.
 */
public class Route {



    //TODO fix so that route is actually the shortest
    public static LinkedList<Waypoint> computeShortestRoute(LinkedList<Waypoint> allWaypoints, Waypoint departure, Waypoint destination) {

        LinkedList<Waypoint> route = new LinkedList<>();
        route.add(departure);

        allWaypoints.remove(departure); //We don't need to compare to the departure

        Waypoint current = route.get(0);
        Waypoint nextCandidate = null;
        double distance;
        double distanceToDest;
        double shortestDistance = Double.MAX_VALUE;
        double shortestDistanceToDest = Double.MAX_VALUE;
        boolean keepAdding = true;

        while(keepAdding) {
            Log.d("ROUTE", "IN LOOP, route length is " + route.size());
            for (Waypoint w : allWaypoints) {
                distance = current.getDistanceTo(w); //Possible waypoint has to be close
                distanceToDest = w.getDistanceTo(destination); //Possible waypoint has to be close to destination

                if (distance < shortestDistance && distanceToDest < shortestDistanceToDest) {
                    shortestDistance = distance;
                    shortestDistanceToDest = distanceToDest;
                    nextCandidate = w;
                }
            }

            //reset values
            shortestDistance = Double.MAX_VALUE;
            shortestDistanceToDest = Double.MAX_VALUE;

            if(nextCandidate == null){
                keepAdding = false;
            }
            else if(nextCandidate.getName().equalsIgnoreCase(destination.getName())) {
                route.add(nextCandidate);
                keepAdding = false; //Reached the destination, we are done
            } else {
                route.add(nextCandidate);
                current = route.getLast(); //We will find the shortest distance waypoint from this waypoint
                allWaypoints.remove(nextCandidate); //We don't need to compare to the current
            }
        }

        return route;
    }
}
