package edu.utep.cs.pickax.fpms;

import android.text.format.Time;

/**
 * Created by Jacob on 4/29/2015.
 */
public class Display {

    private Time currentTime;
    private float distanceTraveled;
    private float distanceRemaining;
    private int eta;
    private int rta;
    private float speed;
    private float windSpeed; //Provided by Weather Information
    private float windDirection; //Provided by Weather Information


    public Display (Time currentTime, int distanceTraveled, int distanceRemaining, int eta, int rta){
        this.currentTime = currentTime;
        this.distanceTraveled = distanceTraveled;
        this.distanceRemaining = distanceRemaining;
        this.eta = eta;
        this.rta = rta;
    }

    public Display(){
        //empty constructor used for adding fields one at a time
    }

    public Time getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime() {
        currentTime.setToNow();
    }

    public float getSpeed(){
        return speed;
    }

    public void setSpeed(float speed){
        this.speed = speed;
    }


    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(float distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public float getDistanceRemaining() {
        return distanceRemaining;
    }

    public void setDistanceRemaining(float distanceRemaining) {
        this.distanceRemaining = distanceRemaining;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getRta() {
        return rta;
    }

    public void setRta(int rta) {
        this.rta = rta;
    }

    public float calcDistanceRemaining(float tripDistance){
        return tripDistance - this.getDistanceTraveled();
    }

    public float calcDistanceTraveled(float originLat, float originLng, float currentLat, float currentLng) {
        double earthRadius = 3958.75;
        double dLat = Math.toRadians(currentLat-originLat);
        double dLng = Math.toRadians(currentLng-originLng);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(originLat)) * Math.cos(Math.toRadians(currentLat)) * Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;
        int meterConversion = 1609;
        return new Float(dist * meterConversion);
    }

    public float clacRTA(float lat1, float lon1, float lat2, float lon2 ){
        float trueCourse = new Float(Math.atan2(Math.sin(lon1 - lon2) * Math.cos(lat2), (Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2))) % 2 * Math.PI);
        float windTrackAngle = trueCourse - windDirection;
        float windCorrectionAngle = new Float(windSpeed * Math.sin(windTrackAngle) / speed);
        float groundSpeed = new Float(speed * Math.cos(windCorrectionAngle) + windSpeed * Math.cos(windTrackAngle));

        return distanceTraveled/groundSpeed;
    }

    public float calcETA(int departureTime){
        return this.getRta()- departureTime;
    }
}
