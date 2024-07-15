/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.projekat;

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

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)
public class SOUcitajListuProjektaTest {

    @Mock
    private DBBroker dbBroker;
    private SOUcitajListuProjekta so;
    private Projekat projekat;

    
    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        so = new SOUcitajListuProjekta();
        projekat = new Projekat(1, "BDW", "dizajn", LocalDate.of(2024, 7, 15), LocalDate.of(2024, 9, 15));

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
    }

    

    @Test
    public void testValidateProjekatWithValidData() throws Exception {
        Projekat validProjekat = new Projekat();
        assertDoesNotThrow(() -> {
            so.validate(validProjekat);
        });
    }

    @Test
    public void testValidateProjekatWithInvalidData() {
        assertThrows(Exception.class, () -> {
            so.validate(new Tim());
        });
    }

    @Test
    public void testExecute() throws Exception {
        List<AbstractDomainObject> projekti = Arrays.asList(projekat);
        when(dbBroker.select(projekat)).thenReturn(new ArrayList<>(projekti));

        so.execute(projekat);

        List<Projekat> rezultat = so.getLista();
        assertNotNull(rezultat);
        assertEquals(1, rezultat.size());
        assertTrue(rezultat.contains(projekat));

        verify(dbBroker, times(1)).select(projekat);
    }

    @Test
    public void testExecuteNeuspesno() throws Exception {
        when(dbBroker.select(projekat)).thenThrow(new RuntimeException("Greška prilikom selektovanja projekata"));

        assertThrows(Exception.class, () -> {
            so.execute(projekat);
        });

        
    }

}