package com.uniquindio.edu.co.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.uniquindio.edu.co.application.models.Car;
import com.uniquindio.edu.co.application.models.User;
import com.uniquindio.edu.co.application.models.Vehicle;
import com.uniquindio.edu.co.application.models.enums.UserRole;

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
public class UserTest {
    private static final Logger LOG = Logger.getLogger(UserTest.class.getName());

    /**
     * Prueba para verificar la creacio'n correcta de un usuario 
     */
    @Test
    public void fullData() {
        LOG.info("Inicio de datos completos");
        User user;
        try {
            user = new  User("pablo", "1101199", "password",
                             "pablo@gmail.com",null, UserRole.CLIENT);
            assertEquals(user.getUserRole(), UserRole.CLIENT);
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
        assertThrows(Throwable.class, () -> new User(null, null,null,null,null,null));
        LOG.info("Finalización de datos nulos");
    }
    /**
     * Prueba para verificar la agregaci'on correcta de un carro a un usuario 
     */
    @Test
    public void testAddNewVehicle() {
        LOG.info("Inicio de testAddNewVehicle");
        User user;
        try {
            user = new  User("pablo", "1101199", "password",
                             "pablo@gmail.com",null, UserRole.CLIENT);
            Car car = new Car("modelo 1000", "2df2j");
            user.addNewVehicle(car);
            assertTrue(user.getTotalVehicles() ==1 );
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testAddNewVehicle");
    }
    /**
     * Prueba para verificar la comparacio'n de las credenciales 
     */
    @Test
    public void isMatchCredentials() {
        LOG.info("Inicio de isMatchCredentials");
        User user;
        try {
            user = new  User("pablo", "1101199", "password",
                             "pablo@gmail.com",null, UserRole.CLIENT);
            assertTrue(user.isMatchCredentials("pablo@gmail.com","password") );
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de isMatchCredentials");
    }
    /**
     * Prueba para verificar la obtencio'n de las placas y modelo de los
     * vehiculos que pertenecen al usuario en formato
     * placa-modelo ej: "sun24-modelo 233" 
     */
    @Test
    public void testVehiclesLicensePlateAndModel() {
        LOG.info("Inicio de testVehiclesLicensePlateAndModel");
        User user;
        try {
            user = new  User("pablo", "1101199", "password",
                             "pablo@gmail.com",null, UserRole.CLIENT);

            Car car = new Car("modelo 1000", "2df2j");
            user.addNewVehicle(car);
            ArrayList<String> listVehicles = user.getVehiclesLicensePlateAndModel();
            assertTrue(listVehicles.contains("2df2j-modelo 1000") );
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testVehiclesLicensePlateAndModel");
    }
    /**
     * Prueba para verificar la obtencio'n de un vehiculo por medio de
     * su placa
     */
    @Test
    public void testHasVehicleMatchLicensePlate() {
        LOG.info("Inicio de testVehicleByLicensePlate");
        User user;
        try {
            user = new  User("pablo", "1101199", "password",
                             "pablo@gmail.com",null, UserRole.CLIENT);

            Car car = new Car("modelo 1000", "2df2j");
            user.addNewVehicle(car);
            assertTrue(user.hasVehicleMatchLicensePlate("2df2j") );
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testVehicleByLicensePlate");
    }
}
