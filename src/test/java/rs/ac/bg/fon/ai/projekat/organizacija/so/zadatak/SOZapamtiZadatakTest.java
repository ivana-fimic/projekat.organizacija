/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.Moodovi;

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)

public class SOZapamtiZadatakTest {

    @Mock
    private DBBroker dbBroker;

    SOZapamtiZadatak so;
    private Zadatak zadatak;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        so = new SOZapamtiZadatak();
        zadatak = new Zadatak();

        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);

    }

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
    public void testExecuteDodatoOrObrisano() throws Exception {

        zadatak.setMoodTabele(Moodovi.DODATO);
        StatistikaZadatka sz = new StatistikaZadatka();
        sz.setZadatak(zadatak);
        List<StatistikaZadatka> statistika = Arrays.asList(sz);
        zadatak.setStatistika(statistika);

        doNothing().when(dbBroker).update(zadatak);
        doNothing().when(dbBroker).delete(sz);
        when(dbBroker.insert(sz)).thenReturn(sz);

        assertDoesNotThrow(() -> so.execute(zadatak));

        verify(dbBroker).update(zadatak);
        verify(dbBroker).delete(sz);
        verify(dbBroker).insert(sz);
    }

    @Test
    public void testExecuteOtherMood() throws Exception {
        zadatak.setMoodTabele(Moodovi.NEIZMENJENO);
        StatistikaZadatka sz = new StatistikaZadatka();
        sz.setZadatak(zadatak);
        List<StatistikaZadatka> statistika = Arrays.asList(sz);
        zadatak.setStatistika(statistika);

        doNothing().when(dbBroker).update(zadatak);
        doNothing().when(dbBroker).update(sz);

        assertDoesNotThrow(() -> so.execute(zadatak));

        verify(dbBroker).update(zadatak);
        verify(dbBroker).update(sz);
    }

    @Test
    public void testExecuteNeuspesnoUpdate() throws Exception {
        doThrow(new RuntimeException("Greska prilikom izmene")).when(dbBroker).update(any(AbstractDomainObject.class));

        assertThrows(Exception.class, () -> {
            so.execute(zadatak);
        });
    }

    @Test
    public void testExecuteNeuspesnoInsert() throws Exception {
        zadatak.setMoodTabele(Moodovi.DODATO);
        StatistikaZadatka sz = new StatistikaZadatka();
        sz.setZadatak(zadatak);
        List<StatistikaZadatka> statistika = Arrays.asList(sz);
        zadatak.setStatistika(statistika);

        when(dbBroker.insert(any(AbstractDomainObject.class))).thenThrow(new RuntimeException("Greska prilikom kreiranja zadatka"));

        assertThrows(Exception.class, () -> {
            so.execute(zadatak);
        });
    }

    @Test
    public void testExecuteNeuspesnoDelete() throws Exception {
        zadatak.setMoodTabele(Moodovi.DODATO);
        StatistikaZadatka sz = new StatistikaZadatka();
        List<StatistikaZadatka> statistika = Arrays.asList(sz);
        zadatak.setStatistika(statistika);
        doThrow(new RuntimeException("Greska prilikom brisanja")).when(dbBroker).delete(any(DetaljiPozicija.class));

        assertThrows(Exception.class, () -> {
            so.execute(zadatak);
        });
    }

}
