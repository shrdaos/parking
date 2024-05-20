package com.uniquindio.edu.co.application;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.uniquindio.edu.co.application.models.Car;
import com.uniquindio.edu.co.application.models.SpaceRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * Clase para probar el funcionamiento del código de la clase de un registro de espacio 
 * 
 * @author shrdaos 
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class SpaceRecordTest {
    private static final Logger LOG = Logger.getLogger(SpaceRecordTest.class.getName());

    /**
     * Prueba para verificar la creacio'n correcta de un carro 
     */
    @Test
    public void fullData() {
        LOG.info("Inicio de datos completos");
        SpaceRecord spaceRecord;
        try {
            spaceRecord = new SpaceRecord(LocalDateTime.now(),LocalDateTime.now(),"2012 kia", 
                                "2da23","119118118",1, 1, 1200.0) ;
            assertEquals(spaceRecord.getAmountPaid(), 1200.0);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de datos completos");
    }
    /**
     * Prueba para verificar si funciona correctamente el metodo que retorna si 
     * la fecha del registro de espacio esta' entre dos fechas enviadas por parametro 
     */
    @Test
    public void testIsBetweenDates() {
        LOG.info("Inicio de testIsBetweenDates");
        SpaceRecord spaceRecord;
        try {
            spaceRecord = new SpaceRecord(LocalDateTime.of(2010, 1, 18, 3, 33, 33),
                                          LocalDateTime.of(2010, 1, 20, 3, 33, 33),
                                          "2012 kia","2da23","119118118",1, 1, 1200.0) ;
            assertTrue(spaceRecord.isBetweenDates(LocalDateTime.of(2010, 1, 15, 3, 33, 33),
                                                   LocalDateTime.of(2010, 1, 25, 3, 33, 33)));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
        LOG.info("Finalización de testIsBetweenDates");
    }
}
