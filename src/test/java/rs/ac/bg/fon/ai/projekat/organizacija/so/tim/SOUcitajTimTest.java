/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import java.lang.reflect.Field;
import java.time.LocalDate;
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
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.clan.SOUcitajClana;

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)
public class SOUcitajTimTest {

    public SOUcitajTimTest() {
    }

    @Mock
    private DBBroker dbBroker;
    private SOUcitajTim so;
    private Tim tim;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        so = new SOUcitajTim();
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        tim = new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ));

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
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
            so.validate(new Clan());
        });
    }

    @Test
    public void testExecute() throws Exception {
        when(dbBroker.selectObject(tim)).thenReturn(tim);

        so.execute(tim);

        Tim rezultat = so.getTimIzBaze();
        assertNotNull(rezultat);
        assertEquals(tim, rezultat);

        verify(dbBroker, times(1)).selectObject(tim);
    }

    @Test
    public void testExecuteNeuspesno() throws Exception {
        when(dbBroker.selectObject(tim)).thenThrow(new RuntimeException("Greška prilikom selektovanja člana"));

        assertThrows(Exception.class, () -> {
            so.execute(tim);
        });
        verify(dbBroker, times(1)).selectObject(tim);
    }

}
