package com.uniquindio.edu.co.application.models;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.uniquindio.edu.co.application.models.enums.UserRole;

public class User {

    private String name;
    private String identification;
    private String password;
    private String email;
    private List<Vehicle> vehicleList;
    private UserRole userRole;
    public User(String name, String identification, String password, String email, List<Vehicle> vehicleList,
            UserRole userRole) throws Exception {
            
        if(name ==null || name.isBlank())
                throw new Exception("El nombre de usuario no puede ser nulo");
        if(identification ==null || identification.isBlank())
                throw new Exception("La identificacio'n del usuario no puede ser nulo");
        if(password ==null || password.isBlank())
                throw new Exception("La clave del usuario no puede ser nulo");
        if(email ==null || email.isBlank())
                throw new Exception("El email del usuario no puede ser nulo");
        this.name = name;
        this.identification = identification;
        this.password = password;
        this.email = email;
        //si la lista de vehiculos del usuario es nula se crea una nueva lista vacia,
        //esto con el fin de evitar NullPointerException

        if(vehicleList == null){
            this.vehicleList = new ArrayList<>();
        }else{
            this.vehicleList = vehicleList;
        }

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
    public void addNewVehicle(Vehicle vehicle) throws Exception{

        if(!vehicleList.contains(vehicle)){
            vehicleList.add(vehicle);
        }else{
            throw new Exception("No se puede agregar dos veces el mismo vehiculo a un usuario.");
        }

    }
    @Override
    public String toString() {
        return "User [name=" + name + ", identification=" + identification + ", password=" + password + ", email="
                + email + ", vehicleList=" + vehicleList + ", userRole=" + userRole + "]";
    }
    
    public boolean isMatchCredentials(String email, String password) {
        if(this.email.equals(email) && this.password.equals(password))
            return true;
        return false;
    }
    public ArrayList<String> getVehiclesLicensePlateAndModel() {
          return vehicleList.stream()
                .map(vehicle -> vehicle.getLicensePlate()+"-"+vehicle.getModel())
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public Vehicle getVehicleByLicensePlate(String vehicleLicensePlate) throws Exception {
        Predicate<Vehicle>matchLicensePlate = vehicle -> (vehicle.getLicensePlate().equals(vehicleLicensePlate));
        Optional<Vehicle> vehicle = vehicleList.stream().filter(matchLicensePlate).findFirst();
        if(vehicle.isPresent())
            return vehicle.get();
		throw new Exception("El vehiculo no existe");
    }
    public boolean hasVehicleMatchLicensePlate(String licensePlate) {
        Predicate<Vehicle>matchLicensePlate = vehicle -> (vehicle.getLicensePlate().equals(licensePlate));
        Optional<Vehicle> vehicle = vehicleList.stream().filter(matchLicensePlate).findFirst();
        return vehicle.isPresent();
    }
    public int getTotalVehicles() {
        return vehicleList.size();
    }
    
}
