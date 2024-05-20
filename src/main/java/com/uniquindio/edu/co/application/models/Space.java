package com.uniquindio.edu.co.application.models;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Space {

    private int positionI;
    private int positionJ;
    private LocalDateTime startTime;
    private Vehicle vehicle;
    
    public Space(int positionI, int positionJ, LocalDateTime startTime, Vehicle vehicle)throws Exception {
        if( positionI <0)
            throw new Exception("la posicion I no puede ser menor que cero");
        if( positionJ <0)
            throw new Exception("la posicion J no puede ser menor que cero");

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

    public boolean matchPosition(int i, int j) {
        if(this.positionI == i && this.positionJ ==j)
            return true;
        return false;
    }

    public boolean isFree() {
        if(this.vehicle == null && this.startTime == null)
            return true;
        return false;
    }

    //verifica si el vehiculo en el espacio contiene la misma placa que la 
    //placa que llega por parametro
    public boolean matchVehicleLicensePlate(String vehicleLicensePlate) {
        if(this.vehicle != null && vehicle.getLicensePlate().equals(vehicleLicensePlate))
            return true;
        return false;
    }

    public Double calculateReservationAmmount(LocalDateTime endDate, double totalPerHour) throws Exception {
        if(startTime.compareTo(endDate) <= 0){
            long totalMinutes = ChronoUnit.MINUTES.between(startTime, endDate);
            long totalHours = totalMinutes / 60;
            long extraMinutes = totalMinutes % 60;
    
            double costoHorasCompletas = totalHours * totalPerHour;
            double costoMinutosExtras = extraMinutes * (totalPerHour / 60.0);
            double totalCost =costoHorasCompletas + costoMinutosExtras; 
            //allows to format as 1.22, using two decimals
            String totalCostOnlyTwoDecimals = String.format("%.2f", (totalCost) ).replace(',', '.'); 
    
            return Double.parseDouble(totalCostOnlyTwoDecimals);
        }
        throw new Exception("La fecha de inicio es menor a la fecha de finalizacion,");
    }

    //elimina el vehiculo y el tiempo de inicio de reservacion para dejar 
    //el espacio libre
    public void clearSpace() {
        this.startTime = null;
        this.vehicle = null;
    }
    
}
