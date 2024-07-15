/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.clan;

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

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)
public class SOUcitajClanaTest {

    @Mock
    private DBBroker dbBroker;
    private SOUcitajClana so;
    private Clan clan;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        so = new SOUcitajClana();
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        clan = new Clan(1, "Ivana", "Fimic", 4, new Pozicija(1, "Koordinator"), new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)), "FON");

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
    }

    @Test
    public void testValidateClanWithValidData() throws Exception {
        Clan validClan = new Clan();
        assertDoesNotThrow(() -> {
            so.validate(validClan);
        });
    }

    @Test
    public void testValidateClanWithInvalidData() {
        assertThrows(Exception.class, () -> {
            so.validate(new Tim());
        });
    }

    @Test
    public void testExecute() throws Exception {
        when(dbBroker.selectObject(clan)).thenReturn(clan);

        so.execute(clan);

        Clan rezultat = so.getClanIzBaze();
        assertNotNull(rezultat);
        assertEquals(clan, rezultat);

        verify(dbBroker, times(1)).selectObject(clan);
    }

    @Test
    public void testExecuteNeuspesno() throws Exception {
        when(dbBroker.selectObject(clan)).thenThrow(new RuntimeException("Greška prilikom selektovanja člana"));

        assertThrows(Exception.class, () -> {
            so.execute(clan);
        });


    }
}