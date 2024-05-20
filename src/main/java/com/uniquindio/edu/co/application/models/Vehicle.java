package com.uniquindio.edu.co.application.models;

public abstract class Vehicle {
    private String model;
    private String licensePlate;
    public Vehicle(String model, String licensePlate) throws Exception {
        if( model == null || model.isBlank())
            throw new Exception("El modelo debe ser diferente de null");
        if( licensePlate == null || licensePlate.isBlank())
            throw new Exception("La placa debe ser diferente de null");
        this.model = model;
        this.licensePlate = licensePlate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    @Override
    public String toString() {
        return "Vehicle [model=" + model + ", licensePlate=" + licensePlate + "]";
    }
    protected abstract String getVehicleType();
    
    
}
