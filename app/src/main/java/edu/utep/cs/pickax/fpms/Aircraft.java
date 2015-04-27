package edu.utep.cs.pickax.fpms;

public class Aircraft {
    private String name;
    private String id;
    private String model;
    private String color;
    private int minCruiseSpeed;
    private int normalCruiseSpeed;
    private int maxCruiseSpeed;
    private int minCruiseAltitude;
    private int normalCruiseAltitude;
    private int maxCruiseAltitude;
    private int fuelConsumption;
    private int consumptionRate;

    public Aircraft(String name, String id, String model, String color, int minCruiseSpeed, int normalCruiseSpeed,
                    int maxCruiseSpeed, int minCruiseAltitude, int normalCruiseAltitude,
                    int maxCruiseAltitude, int fuelConsumption, int consumptionRate){
        this.name = name;
        this.id = id;
        this.model = model;
        this.color = color;
        this.minCruiseSpeed = minCruiseSpeed;
        this.normalCruiseSpeed = normalCruiseSpeed;
        this.maxCruiseSpeed = maxCruiseSpeed;
        this.minCruiseAltitude = minCruiseAltitude;
        this.normalCruiseAltitude = normalCruiseAltitude;
        this.maxCruiseAltitude = maxCruiseAltitude;
        this.fuelConsumption = fuelConsumption;
        this.consumptionRate = consumptionRate;

    }

    public Aircraft(){
        //empty constructor used for adding fields one at a time
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNormalCruiseAltitude() {
        return normalCruiseAltitude;
    }

    public void setNormalCruiseAltitude(int normalCruiseAltitude) {
        this.normalCruiseAltitude = normalCruiseAltitude;
    }

    public int getMaxCruiseSpeed() {
        return maxCruiseSpeed;
    }

    public void setMaxCruiseSpeed(int maxCruiseSpeed) {
        this.maxCruiseSpeed = maxCruiseSpeed;
    }

    public int getMinCruiseAltitude() {
        return minCruiseAltitude;
    }

    public void setMinCruiseAltitude(int minCruiseAltitude) {
        this.minCruiseAltitude = minCruiseAltitude;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMinCruiseSpeed() {
        return minCruiseSpeed;
    }

    public void setMinCruiseSpeed(int minCruiseSpeed) {
        this.minCruiseSpeed = minCruiseSpeed;
    }

    public int getNormalCruiseSpeed() {
        return normalCruiseSpeed;
    }

    public void setNormalCruiseSpeed(int normalCruiseSpeed) {
        this.normalCruiseSpeed = normalCruiseSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaxCruiseAltitude() {
        return maxCruiseAltitude;
    }

    public void setMaxCruiseAltitude(int maxCruiseAltitude) {
        this.maxCruiseAltitude = maxCruiseAltitude;
    }

    public int getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(int consumptionRate) {
        this.consumptionRate = consumptionRate;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public boolean isSafeSpeed(int speed) {
        return speed>=minCruiseSpeed && speed<=maxCruiseSpeed;
    }

    public boolean isSafeAltitude(int altitude) {
        return altitude>=minCruiseAltitude && altitude<=maxCruiseAltitude;
    }
}
