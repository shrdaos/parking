package com.uniquindio.edu.co.application;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.uniquindio.edu.co.application.models.Motorcycle;
import com.uniquindio.edu.co.application.models.enums.MotorcycleType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Clase para probar el funcionamiento del código de la clase de una motocicleta 
 * 
 * @author shrdaos 
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class MotorcycleTest {
    private static final Logger LOG = Logger.getLogger(MotorcycleTest.class.getName());

    /**
     * Prueba para verificar la creacio'n correcta de una moto clasica 
     */
    @Test
    public void fullData() {
        LOG.info("Inicio de datos completos");
        try {
            Motorcycle motorcycle = new Motorcycle(233.5,MotorcycleType.CLASSIC,"Rx 150", "knd24f");
            assertEquals(motorcycle.getModel(), "Rx 150");
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
        assertThrows(Throwable.class, () -> new Motorcycle(233.5,MotorcycleType.CLASSIC,null, null));
        LOG.info("Finalización de datos nulos");
    }
    /**
     * Prueba para verificar la obtenci'n correcta del tipo de motocicleta 
     */
    @Test
    public void testType() {
        LOG.info("Inicio de tipo de motocicleta");
        try {
            Motorcycle motorcycle = new Motorcycle(233.5,MotorcycleType.CLASSIC,"Rx 150", "knd24f");
            assertEquals(motorcycle.getMotorcycleType(), MotorcycleType.CLASSIC);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de datos completos");
    }
}
