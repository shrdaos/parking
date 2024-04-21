package com.uniquindio.edu.co.application.models;

import java.util.*;

import com.uniquindio.edu.co.application.models.enums.UserRole;

public class User {

    private String name;
    private String identification;
    private String password;
    private String email;
    private List<Vehicle> vehicleList;
    private UserRole userRole;
    public User(String name, String identification, String password, String email, List<Vehicle> vehicleList,
            UserRole userRole) {
        this.name = name;
        this.identification = identification;
        this.password = password;
        this.email = email;
        this.vehicleList = vehicleList;
        this.userRole = userRole;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }
    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
    public UserRole getUserRole() {
        return userRole;
    }
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", identification=" + identification + ", password=" + password + ", email="
                + email + ", vehicleList=" + vehicleList + ", userRole=" + userRole + "]";
    }

    
    
}
