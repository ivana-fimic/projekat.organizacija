/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.statistikaZadatka;

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
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;

/**
 *
 * @author Ivana
 */
@ExtendWith(MockitoExtension.class)
public class SOVratiListuStatistikaTest {

    public SOVratiListuStatistikaTest() {
    }

    @Mock
    private DBBroker dbBroker;
    private SOVratiListuStatistika so;
    private StatistikaZadatka statistika;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        so = new SOVratiListuStatistika();
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        statistika = new StatistikaZadatka(new Clan(1, "Ivana", "Fimic", 4, new Pozicija(1, "Koordinator"), new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)), "FON"),
                new Zadatak(1, "kreiranje objava", new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ))), FazaZadatka.NEZAPOCETO, datumP, datumZ);

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
    }

    @Test
    public void testValidateStatistikaWithValidData() throws Exception {
        StatistikaZadatka validStatistika = new StatistikaZadatka();
        assertDoesNotThrow(() -> {
            so.validate(validStatistika);
        });
    }

    @Test
    public void testValidateStatistikaWithInvalidData() {
        assertThrows(Exception.class, () -> {
            so.validate(new Tim());
        });
    }

    @Test
    public void testExecute() throws Exception {
        List<AbstractDomainObject> statistike = Arrays.asList(statistika);
        when(dbBroker.select(statistika)).thenReturn(new ArrayList<>(statistike));

        so.execute(statistika);

        List<StatistikaZadatka> rezultat = so.getLista();
        assertNotNull(rezultat);
        assertEquals(1, rezultat.size());
        assertTrue(rezultat.contains(statistika));

        verify(dbBroker, times(1)).select(statistika);
    }
    
    
      @Test
    public void testExecuteNeuspesno() throws Exception {
        // Simuliranje izuzetka prilikom poziva select metode
        when(dbBroker.select(statistika)).thenThrow(new RuntimeException("Greška prilikom pronalaska"));

        // Provera da li se izuzetak propušta dalje
        Exception exception = assertThrows(Exception.class, () -> {
            so.execute(statistika);
        });

        
    }

}
