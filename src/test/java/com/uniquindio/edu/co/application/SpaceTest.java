package com.uniquindio.edu.co.application;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.uniquindio.edu.co.application.models.Car;
import com.uniquindio.edu.co.application.models.Space;

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
public class SpaceTest {
    private static final Logger LOG = Logger.getLogger(SpaceTest.class.getName());

    /**
     * Prueba para verificar la creacio'n correcta de un  espacio 
     */
    @Test
    public void fullData() {
        LOG.info("Inicio de datos completos");
        Space space;
        try {
            space = new Space(1,1,null,null);
            assertTrue(space != null);
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
        assertThrows(Throwable.class, () -> new Space(-1, -1,null,null));
        LOG.info("Finalización de datos nulos");
    }
    /**
     * Prueba para verificar la validacion de posicion i , j  
     */
    @Test
    public void testMatchPosition() {
        LOG.info("Inicio de testMatchPosition");
        Space space;
        try {
            space = new Space(1,1,null,null);
            assertTrue(space.matchPosition(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testMatchPosition");
    }
    /**
     * Prueba para verificar si un espacio es libre cuando se crea  
     */
    @Test
    public void testIsFree() {
        LOG.info("Inicio de testIsFree");
        Space space;
        try {
            space = new Space(1,1,null,null);
            assertTrue(space.isFree());
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testIsFree");
    }
    /**
     * Prueba para verificar que un espacio valide correctamente
     * la placa del vehiculo que lo esta' ocupando  
     */
    @Test
    public void testMatchVehicleLicensePlate() {
        LOG.info("Inicio de testMatchVehicleLicensePlate");
        Space space;
        try {
            Car car = new Car("kia 2033", "sun33");
            space = new Space(1,1,null,null);

            space.setVehicle(car);

            assertTrue(space.matchVehicleLicensePlate("sun33"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testMatchVehicleLicensePlate");
    }
    

    
}