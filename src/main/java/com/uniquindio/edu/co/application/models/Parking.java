package com.uniquindio.edu.co.application.models;
import java.util.*;
import java.util.function.Predicate;

import com.uniquindio.edu.co.application.models.enums.UserRole;

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

    public void burnData() {
        //se queman los espacios
    spaceList.add(new Space(1,1,null,null));
    spaceList.add(new Space(1,2,null,null));
    spaceList.add(new Space(1,3,null,null));
    spaceList.add(new Space(1,4,null,null));
    spaceList.add(new Space(1,5,null,null));
    spaceList.add(new Space(1,6,null,null));
    spaceList.add(new Space(2,1,null,null));

    //se quema la lista de usuarios
    userList.add(new User("sharon", "1193391919","asdf", "sharon@gmail.com", null, UserRole.ADMIN));

    Car  clientCar = new Car("2019","sun24");
    Car  clientCar2 = new Car("2022","lpy24");
    User client1 =new User("juan", "2298891919","asdf", "juan@gmail.com", null, UserRole.CLIENT); 
    User client2 =new User("pablito", "2298803919","asdf", "pablo@gmail.com", null, UserRole.CLIENT); 
    try {
        client1.addNewVehicle(clientCar);
        client2.addNewVehicle(clientCar2);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    userList.add(client1);
    userList.add(client2);

    //
    }

    public User  getUserByCredentials(String email,String password) throws Exception{
        Predicate<User> matchCredentials = j -> (j.isMatchCredentials(email,password));
        Optional<User> user = userList.stream().filter(matchCredentials).findFirst();
        if(user.isPresent())
            return user.get();
		throw new Exception("Revise las credenciales e intente nuevamente");
    }
    




}
