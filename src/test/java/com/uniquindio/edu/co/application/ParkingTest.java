package com.uniquindio.edu.co.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.uniquindio.edu.co.application.models.Parking;
import com.uniquindio.edu.co.application.models.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Clase para probar el funcionamiento del código de la clase de un carro
 * 
 * @author shrdaos 
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class ParkingTest {
    private static final Logger LOG = Logger.getLogger(ParkingTest.class.getName());

    /**
     * Prueba para verificar la creacio'n correcta de un parqueadero 
     */
    @Test
    public void fullData() {
        LOG.info("Inicio de datos completos");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            assertEquals(parking.getName(), "parqueadero prueba");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de datos completos");
    }
    /**
     * Prueba para verificar  el fallo en caso de datos nulos 
     */
    @Test
    public void nullData() {
        LOG.info("Inicio de datos nulos");
        assertThrows(Throwable.class, () -> new Parking(null,-1,-1,-1,null, null,null));
        LOG.info("Finalización de datos nulos");
    }
    /**
     * Prueba para verificar la obtencion de un usuario por medio de sus credenciales  
     */
    @Test
    public void testUserByCredentials() {
        LOG.info("Inicio de testUserByCredentials");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            User user = parking.getUserByCredentials("sharon@gmail.com","asdf");
            assertEquals(user.getName(), "sharon");

            assertTrue(user != null);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testUserByCredentials");
    }
    /**
     * Prueba para verificar la obtencion de un usuario por medio de su identificacio'n  
     */
    @Test
    public void testUserById() {
        LOG.info("Inicio de testUserById");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            User user = parking.getUserById("1193391919");
            assertEquals(user.getName(), "sharon");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testUserById");
    }
    /**
     * Prueba para verificar la obtencion de los nombres e identificaciones
     * de los clientes en formato nombre-identificacion  
     */
    @Test
    public void testUserClientNamesAndIdentification() {
        LOG.info("Inicio de testUserById");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            ArrayList<String> list = parking.getUserClientNamesAndIdentification();
            assertTrue(list.contains("sharon-1193391919"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testUserById");
    }
    /**
     * Prueba para verificar la obtencion de las  placas y modelos 
     * de los vehiculos basandose en la identificacion de un usuario y en formato placa-modelo  
     */
    @Test
    public void testVehiclesLicensePlateAndModelByUserId() {
        LOG.info("Inicio de testVehiclesLicensePlateAndModelByUserId");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            ArrayList<String> list = parking.getVehiclesLicensePlateAndModelByUserId("2298891919");
            for (String string : list) {
                System.out.println(string);
            }
            assertTrue(list.contains("sun24-eco deluxe 2019"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        LOG.info("Finalización de testVehiclesLicensePlateAndModelByUserId");
    }
    /**
     * Prueba para verificar  si un espacio esta' libre, basandose en la coordenada i , j,
     * al ejecutar burnData todos los espacios quedan libres por defecto
     */
    @Test
    public void testIsFreeSpace() {
        LOG.info("Inicio de testIsFreeSpace");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            assertTrue(parking.isFreeSpace(1,1));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        LOG.info("Finalización de testIsFreeSpace");
    }
    /**
     * Prueba para verificar  el proceso de reservar un espacio
     */
    @Test
    public void testReserveSpace() {
        LOG.info("Inicio de testReserveSpace");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            assertTrue(parking.reserveSpace("2298891919","sun24",LocalDateTime.now(), 1,1));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        LOG.info("Finalización de testReserveSpace");
    }
    /**
     * Prueba para verificar  el proceso de reservar un espacio
     */
    @Test
    public void testSpaceUsingPosition() {
        LOG.info("Inicio de testSpaceUsingPosition");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            assertTrue(parking.getSpaceUsingPosition(1, 1) != null);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        LOG.info("Finalización de testSpaceUsingPosition");
    }
    /**
     * Prueba para verificar si el vehiculo ya esta' en un espacio 
     */
    @Test
    public void testVehicleAlreadyOnSpace() {
        LOG.info("Inicio de testVehicleAlreadyOnSpace");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();

           parking.reserveSpace("2298891919","sun24",LocalDateTime.now(), 1,1);
           assertTrue(parking.vehicleAlreadyOnSpace("sun24"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        LOG.info("Finalización de testVehicleAlreadyOnSpace");
    }
    /**
     * Prueba para verificar la obtencio'n de un propietario por medio de la placa del vehiculo 
     */
    @Test
    public void testPropietaryByLicensePlate() {
        LOG.info("Inicio de testPropietaryByLicensePlate");
        try {
            Parking parking = new Parking("parqueadero prueba",1000,1000,1000,null,null,null);
            parking.burnData();
            User user = parking.getPropietaryByLicensePlate("sun24");
            assertEquals(user.getName(), "juan");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

        LOG.info("Finalización de testPropietaryByLicensePlate");
    }
    
}
