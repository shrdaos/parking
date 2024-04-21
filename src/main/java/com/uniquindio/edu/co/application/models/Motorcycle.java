package com.uniquindio.edu.co.application.models;

import com.uniquindio.edu.co.application.models.enums.MotorcycleType;

public class Motorcycle extends Vehicle {
    private double speedMax;
    private MotorcycleType motorcycleType;

    public Motorcycle(double speedMax, MotorcycleType motorcycleType, String model, String licensePlate) {
        super(model,licensePlate);
        this.speedMax = speedMax;
        this.motorcycleType = motorcycleType;
    }

    public double getSpeedMax() {
        return speedMax;
    }

    public void setSpeedMax(double speedMax) {
        this.speedMax = speedMax;
    }

 

    @Override
    public String toString() {
        return "Motorcycle [speedMax=" + speedMax + ", motorcycleType=" + motorcycleType + ", getModel()=" + getModel()
                + ", getLicensePlate()=" + getLicensePlate() + ", getSpeedMax()=" + getSpeedMax() + ", toString()="
                + super.toString() + ", getMotorcycleType()=" + getMotorcycleType() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + "]";
    }

    public MotorcycleType getMotorcycleType() {
        return motorcycleType;
    }

    public void setMotorcycleType(MotorcycleType motorcycleType) {
        this.motorcycleType = motorcycleType;
    }
    
}
