package com.uniquindio.edu.co.application.models;

import java.time.LocalDateTime;

public class SpaceRecord {
    private LocalDateTime starTime;
    private LocalDateTime endTime;
    private String        model;
    private String        licensePlate;
    private String        userIdentification;
    private int           positionI;       
    private int           positionJ;       
    private double        amountPaid;
    private String        vehicleType;
    public SpaceRecord(LocalDateTime starTime, LocalDateTime endTime, String model, String licensePlate,
            String userIdentification, int positionI, int positionJ,String vehicleType, double ammount) {
        this.starTime = starTime;
        this.endTime = endTime;
        this.model = model;
        this.licensePlate = licensePlate;
        this.userIdentification = userIdentification;
        this.positionI = positionI;
        this.positionJ = positionJ;
        this.amountPaid = ammount;
        this.vehicleType = vehicleType;
    }
    
    public LocalDateTime getStarTime() {
        return starTime;
    }
    public void setStarTime(LocalDateTime starTime) {
        this.starTime = starTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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
    public String getUserIdentification() {
        return userIdentification;
    }
    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }
    public int getPositionI() {
        return positionI;
    }
    public void setPositionI(int positionI) {
        this.positionI = positionI;
    }
    public int getPositionJ() {
        return positionJ;
    }
    public void setPositionJ(int positionJ) {
        this.positionJ = positionJ;
    }
    

    public double getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    @Override
    public String toString() {
        return "SpaceRecord [starTime=" + starTime + ", endTime=" + endTime + ", model=" + model + ", licensePlate="
                + licensePlate + ", userIdentification=" + userIdentification + ", positionI=" + positionI
                + ", positionJ=" + positionJ + ", amountPaid=" + amountPaid + "]";
    }
    public boolean isBetweenDates(LocalDateTime startTime, LocalDateTime endTime) {
        try {
            if(this.starTime.compareTo(startTime) >= 0 && this.endTime.compareTo(endTime) <=0)
                return true;
            return false;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    

    
}
