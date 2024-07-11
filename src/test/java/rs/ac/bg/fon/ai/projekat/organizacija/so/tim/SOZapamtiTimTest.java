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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;

/**
 *
 * @author Ivana
 */
@ExtendWith(MockitoExtension.class)
public class SOZapamtiTimTest {

    @Mock
    private DBBroker dbBroker;
    private SOZapamtiTim so;
    private Tim tim;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        so = new SOZapamtiTim();
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
            so.validate(new Zadatak());
        });
    }

    @Test
    public void testExecute() throws Exception {
        Tim tim = new Tim();
        DetaljiPozicija dp2 = new DetaljiPozicija();
        DetaljiPozicija dp1 = new DetaljiPozicija();

        dp1.setTim(tim);
        List<DetaljiPozicija> detaljiPozicije = new ArrayList<>();
        detaljiPozicije.add(dp1);
        detaljiPozicije.add(dp2);
        tim.setBrojPozicija(detaljiPozicije);

        doNothing().when(dbBroker).update(tim);
        doNothing().when(dbBroker).delete(dp1);

        for (DetaljiPozicija detalji : detaljiPozicije) {
            when(dbBroker.insert(detalji)).thenReturn(detalji);
        }

        assertDoesNotThrow(() -> so.execute(tim));

        verify(dbBroker, times(1)).update(tim);
        verify(dbBroker, times(1)).delete(any(DetaljiPozicija.class));
        verify(dbBroker, times(1)).insert(dp1);
        verify(dbBroker, times(1)).insert(dp2);

    }

    @Test
    public void testExecuteNeuspesnoUpdate() throws Exception {
        doThrow(new RuntimeException("Greska prilikom pamcenje")).when(dbBroker).update(tim);

        Exception exception = assertThrows(Exception.class, () -> {
            so.execute(tim);
        });

    }

    @Test
    public void testExecuteNeuspesnoDelete() throws Exception {
        DetaljiPozicija dp = new DetaljiPozicija();
        doThrow(new RuntimeException("Greska prilikom brisanja")).when(dbBroker).delete(dp);

        Exception exception = assertThrows(Exception.class, () -> {
            so.execute(tim);
        });

    }

    @Test
    public void testExecuteNeuspesnoInsert() throws Exception {
        DetaljiPozicija dp = new DetaljiPozicija();
        dp.setTim(tim);
        tim.setBrojPozicija(Arrays.asList(dp));

        when(dbBroker.insert(dp)).thenThrow(new RuntimeException("Greska prilikom ubacivanja dp"));

        assertThrows(Exception.class, () -> {
            so.execute(tim);
        });
    }

}
