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

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getMinCruiseSpeed() {
        return minCruiseSpeed;
    }

    public int getNormalCruiseSpeed() {
        return normalCruiseSpeed;
    }

    public int getMaxCruiseSpeed() {
        return maxCruiseSpeed;
    }

    public int getMinCruiseAltitude() {
        return minCruiseAltitude;
    }

    public int getNormalCruiseAltitude() {
        return normalCruiseAltitude;
    }

    public int getMaxCruiseAltitude() {
        return maxCruiseAltitude;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getConsumptionRate() {
        return consumptionRate;
    }


    public boolean isSafeSpeed(int speed) {
        return speed>=minCruiseSpeed && speed<=maxCruiseSpeed;
    }

    public boolean isSafeAltitude(int altitude) {
        return altitude>=minCruiseAltitude && altitude<=maxCruiseAltitude;
    }
}
