/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak.SOKreirajZadatak;

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)

public class SONadjiTimoveTest {

    public SONadjiTimoveTest() {
    }

    @Mock
    private DBBroker dbBroker;
    SONadjiTimove so;
    Tim t;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        so = new SONadjiTimove();
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        t = new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ));

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
    }

    /**
     * Test of validate method, of class SONadjiTimove.
     */
   
    @Test
    public void testExecute() throws Exception {

        List<AbstractDomainObject> timovi = Arrays.asList(t);
        when(dbBroker.select(t)).thenReturn(new ArrayList<>(timovi));

        so.execute(t);

        List<Tim> rezultat = so.getLista();
        assertNotNull(rezultat);
        assertEquals(1, rezultat.size());
        assertTrue(rezultat.contains(t));

        verify(dbBroker, times(1)).select(t);

    }

  @Test
    public void testValidateTimWithValidData() throws Exception {
        Tim validTim = new Tim();
      
        assertDoesNotThrow(() -> {
            so.validate(validTim);
        });
    }

    @Test
    public void testValidateTimWithInvalidData() {
    
    assertThrows(Exception.class, () -> {
        so.validate(new Zadatak());
    });

}
  @Test
    public void testExecuteNeuspesno() throws Exception {

         when(dbBroker.select(t)).thenThrow(new RuntimeException("Greska prilikom pronalaska"));

         assertThrows(Exception.class, () -> {
            so.execute(t);
        });


    }

}
