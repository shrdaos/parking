package com.uniquindio.edu.co.application.models;

public class Car extends Vehicle {

    public Car(String model, String licensePlate)throws Exception{
        super(model,licensePlate);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected String getVehicleType() {
        return "CAR";
    }
    
}
