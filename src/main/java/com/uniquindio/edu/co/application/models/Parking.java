package com.uniquindio.edu.co.application.models;
import java.util.*;

public class Parking {

   private String name;
   private double classicMotorcicleFee;
   private double hybridMotorcicleFee;
   private double carFee;

   private List<Space> spaceList;
   private List<User> userList;
   private List<Record> recordList;

    public Parking(String name, double classicMotorcicleFee, double hybridMotorcicleFee, double carFee,
        List<Space> spaceList, List<User> userList, List<Record> recordList) {
        this.name = name;
        this.classicMotorcicleFee = classicMotorcicleFee;
        this.hybridMotorcicleFee = hybridMotorcicleFee;
        this.carFee = carFee;
        this.spaceList = spaceList;
        this.userList = userList;
        this.recordList = recordList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getClassicMotorcicleFee() {
        return classicMotorcicleFee;
    }

    public void setClassicMotorcicleFee(double classicMotorcicleFee) {
        this.classicMotorcicleFee = classicMotorcicleFee;
    }

    public double getHybridMotorcicleFee() {
        return hybridMotorcicleFee;
    }

    public void setHybridMotorcicleFee(double hybridMotorcicleFee) {
        this.hybridMotorcicleFee = hybridMotorcicleFee;
    }

    public double getCarFee() {
        return carFee;
    }

    public void setCarFee(double carFee) {
        this.carFee = carFee;
    }

    public List<Space> getSpaceList() {
        return spaceList;
    }

    public void setSpaceList(List<Space> spaceList) {
        this.spaceList = spaceList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    @Override
    public String toString() {
        return "Parking [name=" + name + ", classicMotorcicleFee=" + classicMotorcicleFee + ", hybridMotorcicleFee="
                + hybridMotorcicleFee + ", carFee=" + carFee + ", spaceList=" + spaceList + ", userList=" + userList
                + ", recordList=" + recordList + "]";
    }

    




}
