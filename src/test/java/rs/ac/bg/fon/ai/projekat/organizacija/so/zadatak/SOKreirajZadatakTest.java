/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOKreirajTim;

/**
 *
 * @author Ivana
 */
@ExtendWith(MockitoExtension.class)

public class SOKreirajZadatakTest {

    public SOKreirajZadatakTest() {
    }

    @Mock
    private DBBroker dbBroker;

    SOKreirajZadatak so;
    private Zadatak z;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        so = new SOKreirajZadatak();
        z=new Zadatak();

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of validate method, of class SOKreirajZadatak.
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

    @Test
    public void testExecuteUspesno() throws Exception {
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        z = new Zadatak(1, "kreiranje objava", new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));
        List<StatistikaZadatka> statistike = new ArrayList<>();
        statistike.add(new StatistikaZadatka(new Clan(1, "Ivana", "Fimic", 4, new Pozicija(1, "Koordinator"), new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)), "FON"),
                new Zadatak(1, "kreiranje objava", new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ))), FazaZadatka.NEZAPOCETO, datumP, datumZ));
        z.setStatistika(statistike);
        
        when(dbBroker.insert(z)).thenReturn(z);
        for (StatistikaZadatka st : statistike) {
            when(dbBroker.insert(st)).thenReturn(st);
        }

        so.execute(z);

        Zadatak createdZadatak = so.getZ();
        assertNotNull(createdZadatak);
        assertEquals(1,createdZadatak.getIDZadatka() );
        assertEquals("kreiranje objava", createdZadatak.getNazivZadatka());
        
        verify(dbBroker, times(1)).insert(z);
        verify(dbBroker, times(statistike.size())).insert(any(StatistikaZadatka.class));
    }
    
    @Test
    public void testExecuteNeuspesno() throws Exception {

        List<StatistikaZadatka> stat = new ArrayList<>();
        stat.add(new StatistikaZadatka());
        z.setStatistika(stat);

        when(dbBroker.insert(any(AbstractDomainObject.class))).thenThrow(new RuntimeException("Greska prilikom kreiranja zadatka"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            so.execute(z);
        });

         
}

}
