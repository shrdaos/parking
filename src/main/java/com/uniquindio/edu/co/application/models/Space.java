package com.uniquindio.edu.co.application.models;

import java.time.LocalDateTime;

public class Space {

    private int positionI;
    private int positionJ;
    private LocalDateTime startTime;
    private Vehicle vehicle;
    
    public Space(int positionI, int positionJ, LocalDateTime startTime, Vehicle vehicle) {
        this.positionI = positionI;
        this.positionJ = positionJ;
        this.startTime = startTime;
        this.vehicle = vehicle;
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
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
 

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Space [positionI=" + positionI + ", positionJ=" + positionJ + ", startTime=" + startTime + ", vehicle="
                + vehicle + "]";
    }
    
}
