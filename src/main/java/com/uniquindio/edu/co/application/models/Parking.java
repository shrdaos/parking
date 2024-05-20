package com.uniquindio.edu.co.application.models;

import java.io.EOFException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.uniquindio.edu.co.application.models.enums.MotorcycleType;
import com.uniquindio.edu.co.application.models.enums.UserRole;

public class Parking {

   private String name;
   private double classicMotorcicleFee;
   private double hybridMotorcicleFee;
   private double carFee;

   private List<Space> spaceList;
   private List<User> userList;
   private List<SpaceRecord> recordList;

    public Parking(String name, double classicMotorcicleFee, double hybridMotorcicleFee, double carFee,
        List<Space> spaceList, List<User> userList, List<SpaceRecord> recordList) throws Exception {

        if (name == null || name.isBlank())
            throw new Exception("El nombre del parqueadero no puede estar vacio");
        if (classicMotorcicleFee < 0)
            throw new Exception("La tarifa por hora de motos clasicas no puede ser menor que cero");
        if (hybridMotorcicleFee < 0)
            throw new Exception("La tarifa por hora de motos hibridas no puede ser menor que cero");
        if (carFee < 0)
            throw new Exception("La tarifa por hora de carros no puede ser menor que cero");

        this.name = name;
        this.classicMotorcicleFee = classicMotorcicleFee;
        this.hybridMotorcicleFee = hybridMotorcicleFee;
        this.carFee = carFee;
        //para las listas en caso de que sean nulas se crea una lista vacia []
        this.spaceList = (spaceList != null)? spaceList : new ArrayList<>();
        this.userList = (userList != null)? userList : new ArrayList<>();
        this.recordList = (recordList != null)? recordList : new ArrayList<>() ;
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

    public List<SpaceRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<SpaceRecord> recordList) {
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
    try {
        spaceList.add(new Space(1,1,null,null));
        spaceList.add(new Space(1,2,null,null));
        spaceList.add(new Space(1,3,null,null));
        spaceList.add(new Space(1,4,null,null));
        spaceList.add(new Space(1,5,null,null));
        spaceList.add(new Space(1,6,null,null));
        spaceList.add(new Space(2,1,null,null));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    //se quema la lista de usuarios
    try {
        userList.add(new User("sharon", "1193391919","asdf", "sharon@gmail.com", null, UserRole.ADMIN));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    Motorcycle clientCar2 = null;
    Motorcycle  clientCar = null;
    try {
        clientCar = new Motorcycle(2000.0,MotorcycleType.CLASSIC,"eco deluxe 2019","sun24");
        clientCar2 = new Motorcycle(150.0,MotorcycleType.HYBRID,"victory bomber 2022","lpy24");
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    User client1 = null;
    try {
        client1 = new User("juan", "2298891919","asdf", "juan@gmail.com", null, UserRole.CLIENT);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    User client2 = null;
    try {
        client2 = new User("pablito", "2298803919","asdf", "pablo@gmail.com", null, UserRole.CLIENT);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    try {
        client1.addNewVehicle(clientCar);
        client2.addNewVehicle(clientCar2);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    userList.add(client1);
    userList.add(client2);

    }

    public User  getUserByCredentials(String email,String password) throws Exception{
        Predicate<User> matchCredentials = j -> (j.isMatchCredentials(email,password));
        Optional<User> user = userList.stream().filter(matchCredentials).findFirst();
        if(user.isPresent())
            return user.get();
		throw new Exception("Revise las credenciales e intente nuevamente");
    }
    public User  getUserById(String id) throws Exception{
        Predicate<User> matchId = j -> (j.getIdentification().equals(id));
        Optional<User> user = userList.stream().filter(matchId).findFirst();
        if(user.isPresent())
            return user.get();
		throw new Exception("El número de identificación no existe");
    }

    public ArrayList<String> getUserClientNamesAndIdentification() {
        return userList.stream()
                .map(user -> user.getName() + "-" + user.getIdentification())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getVehiclesLicensePlateAndModelByUserId(String userId) throws Exception {
        User user = getUserById(userId);
        return user.getVehiclesLicensePlateAndModel();
    }

    public boolean isFreeSpace(int i, int j) {
        Predicate<Space> matchSpace = space -> (space.matchPosition(i,j) && space.isFree());
        Optional<Space> space = spaceList.stream().filter(matchSpace).findFirst();
        if(space.isPresent())
            return true;
        return false;
    }

    public boolean reserveSpace(String userIdentification, String vehicleLicensePlate, LocalDateTime selectedDateTime,
            int i, int j) throws Exception {
            
        if(!isFreeSpace(i, j))
                throw new Exception("El espacio ya fue reservado");
        if(vehicleAlreadyOnSpace(vehicleLicensePlate))
                throw new Exception("El vehiculo ya se encuentra en un espacio, debe retirarlo primero.");

        //obtenemos la informacio'n necesaria para la reserva
        Space space = getSpaceUsingPosition(i,j);
        User user = getUserById(userIdentification);
        Vehicle vehicle = user.getVehicleByLicensePlate(vehicleLicensePlate);
        //guardamos la informacion del vehiculo y la hora de reserva
        space.setVehicle(vehicle);
        space.setStartTime(selectedDateTime);
        return true;

    }
    //permite obtener un espacio usando su posicion i j
    public Space getSpaceUsingPosition(int i, int j) throws Exception {
        Predicate<Space>matchPosition = space -> (space.matchPosition(i, j));
        Optional<Space> space = spaceList.stream().filter(matchPosition).findFirst();
        if(space.isPresent())
            return space.get();
		throw new Exception("El espacio i:"+i+" j:"+j+" no existe");


    }

    //metodo que verifica si un vehiculo ya esta' en algu'n espacio por medio de la placa (para evitar reservar dos
    //espacios con el mismo vehiculo)
    public boolean vehicleAlreadyOnSpace(String vehicleLicensePlate) {
       Predicate<Space> matchVehicleLicensePlate = space -> (space.matchVehicleLicensePlate(vehicleLicensePlate));
        Optional<Space> space = spaceList.stream().filter(matchVehicleLicensePlate).findFirst();
        if(space.isPresent())
            return true;
        return false;
    }

    //permite obtener un usuario por medio de la placa del vehiculo
    public User getPropietaryByLicensePlate(String licensePlate) throws Exception {
        Predicate<User>matchLicensePlate = user -> (user.hasVehicleMatchLicensePlate(licensePlate));
        Optional<User> user = userList.stream().filter(matchLicensePlate).findFirst();
        if(user.isPresent())
            return user.get();
		throw new Exception("No hay ningun usuario con un vehiculo cuya placa sea "+licensePlate);
    }

    public Double getReservationAmmount(LocalDateTime endDate, int positionI, int positionJ) throws Exception {
        //se obtiene el espacio usando las posiciones i, j
        Space space = getSpaceUsingPosition(positionI, positionJ);
        //se valida que el espacio no este' libre
        if(space.isFree())
            throw new Exception("El espacio esta' libre, por tanto no se le puede obtener el monto de reservacio'n");

        double totalPerHour  = getTotalPerHour(space.getVehicle().getVehicleType());
        return space.calculateReservationAmmount(endDate,totalPerHour);
    }

    //metodo que permite obtener el valor por hora segun el tipo de vehiculo
    private double getTotalPerHour(String vehicleType) throws Exception {
        //se definen hybrid y classic como string para mejor legibilidad
        String hybrid = MotorcycleType.HYBRID.name();
        String classic = MotorcycleType.CLASSIC.name();
        //se obtiene el monto usando una estructura if else
        if(vehicleType.equalsIgnoreCase("car")){
            return carFee;
        } else if (vehicleType.equalsIgnoreCase(hybrid)){
            return hybridMotorcicleFee;
        } else if (vehicleType.equalsIgnoreCase(classic)){
            return classicMotorcicleFee;
        }
        throw new Exception("Error, no se pudo determinar el tipo de vehiculo");
    }

    public Double endReservation(LocalDateTime endTime, int positionI, int positionJ) throws Exception {
        Space space = getSpaceUsingPosition(positionI, positionJ);
        double ammount = getReservationAmmount(endTime, positionI, positionJ);
        Vehicle spaceVehicle = space.getVehicle();
        User user = getPropietaryByLicensePlate(spaceVehicle.getLicensePlate()); 
        SpaceRecord spaceRecord = new SpaceRecord(space.getStartTime(), endTime,spaceVehicle.getModel() ,spaceVehicle.getLicensePlate(),
                                                  user.getIdentification(), positionI, positionJ,ammount);
        recordList.add(spaceRecord);
        space.clearSpace();
        return ammount;
    }

    public List<SpaceRecord> getRecordsBetween(LocalDateTime startTime, LocalDateTime endTime) {
        Predicate<SpaceRecord>matchDates = spaceRecord -> (spaceRecord.isBetweenDates(startTime, endTime));
        List<SpaceRecord> spaceRecordList = recordList.stream().filter(matchDates).collect(Collectors.toList());
        return spaceRecordList;
    }

    public Double getMoneyEarned() {
        return   recordList.stream()
                        .mapToDouble(SpaceRecord::getAmountPaid)
                        .sum();
    }

    public int countSpaceRecords() {
        return this.recordList.size();
    }

}
