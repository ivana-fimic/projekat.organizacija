/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.pozicije;

import java.lang.reflect.Field;
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
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;

/**
 *
 * @author Ivana Fimic
 */ 
@ExtendWith(MockitoExtension.class)
public class SOUcitajListuPozicijaTest {

    @Mock
    private DBBroker dbBroker;
    private SOUcitajListuPozicija so;
    private Pozicija pozicija;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        so = new SOUcitajListuPozicija();
        pozicija = new Pozicija(1, "Koodinator");

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
    }

    @Test
    public void testValidatePozicijaWithValidData() throws Exception {
        Pozicija validPozicija = new Pozicija();
        assertDoesNotThrow(() -> {
            so.validate(validPozicija);
        });
    }

    @Test
    public void testValidatePozicijaWithInvalidData() {
        assertThrows(Exception.class, () -> {
            so.validate(new Tim());
        });
    }

    @Test
    public void testExecute() throws Exception {
        List<AbstractDomainObject> pozicije = Arrays.asList(pozicija);
        when(dbBroker.select(pozicija)).thenReturn(new ArrayList<>(pozicije));

        so.execute(pozicija);

        List<Pozicija> rezultat = so.getLista();
        assertNotNull(rezultat);
        assertEquals(1, rezultat.size());
        assertTrue(rezultat.contains(pozicija));

        verify(dbBroker, times(1)).select(pozicija);
    }
    @Test
    public void testExecuteNeuspesno() throws Exception {
        when(dbBroker.select(pozicija)).thenThrow(new RuntimeException("Greska prilikom pronalaska"));

         assertThrows(Exception.class, () -> {
            so.execute(pozicija);
        });

    }
    
}
    
