/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
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
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SONadjiTimove;

/**
 *
 * @author Ivana
 */
@ExtendWith(MockitoExtension.class)
public class SONadjiZadatkeTest {

    @Mock
    private DBBroker dbBroker;
    private SONadjiZadatke so;
    private Zadatak zadatak;

    @BeforeEach
    public void setUp() throws  NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        so = new SONadjiZadatke();
        zadatak = new Zadatak(1, "kreiranje objava", new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
    }

    /**
     * Test of validate method, of class SONadjiZadatke.
     */
    @Test
    public void testValidateZadatakWithValidData() throws Exception {
        Zadatak validZadatak = new Zadatak();

        assertDoesNotThrow(() -> {
            so.validate(validZadatak);
        });
    }

    @Test
    public void testValidateZadatakWithInvalidData() {
        assertThrows(Exception.class, () -> {
            so.validate(new Tim());
        });
    }

    /**
     * Test of execute method, of class SONadjiZadatke.
     */
    @Test
    public void testExecute() throws Exception {
        List<AbstractDomainObject> zadaci = Arrays.asList(zadatak);
        when(dbBroker.select(zadatak)).thenReturn(new ArrayList<>(zadaci));

        so.execute(zadatak);

        List<Zadatak> rezultat = so.getLista();
        assertNotNull(rezultat);
        assertEquals(1, rezultat.size());
        assertTrue(rezultat.contains(zadatak));

        verify(dbBroker, times(1)).select(zadatak);
    }

    @Test
    public void testExecuteNeuspesno() throws Exception {
        when(dbBroker.select(zadatak)).thenThrow(new RuntimeException("Greska prilikom pronalaska"));

        Exception exception = assertThrows(Exception.class, () -> {
            so.execute(zadatak);
        });

    }
    
}
