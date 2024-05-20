package com.uniquindio.edu.co.application;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.uniquindio.edu.co.application.models.Car;

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
public class CarTest {
    private static final Logger LOG = Logger.getLogger(CarTest.class.getName());

    /**
     * Prueba para verificar la creacio'n correcta de un carro 
     */
    @Test
    public void fullData() {
        LOG.info("Inicio de datos completos");
        Car car;
        try {
            car = new Car("modelo 2014","Sun34");
            assertEquals(car.getModel(), "modelo 2014");
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
        assertThrows(Throwable.class, () -> new Car(null, null));
        LOG.info("Finalización de datos nulos");
    }
}
