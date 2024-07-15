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
import static org.mockito.ArgumentMatchers.eq;
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
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)
public class SOObrisiTimTest {

    @Mock
    private DBBroker dbBroker;
    private SOObrisiTim so;
    private Tim tim;

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        so = new SOObrisiTim();
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
        DetaljiPozicija dp = new DetaljiPozicija();
        dp.setTim(tim);
        List<AbstractDomainObject> detaljiPozicije = Arrays.asList(dp);
        when(dbBroker.select(dp)).thenReturn(new ArrayList<>(detaljiPozicije));

        for (AbstractDomainObject detalji : detaljiPozicije) {
            doNothing().when(dbBroker).delete(detalji);
        }
        doNothing().when(dbBroker).delete(tim);

        assertDoesNotThrow(() -> so.execute(tim));

        verify(dbBroker, times(detaljiPozicije.size())).delete(any(DetaljiPozicija.class));
        verify(dbBroker, times(1)).delete(tim);
    }

    @Test
    public void testExecuteNeuspesno() throws Exception {
        
        doThrow(new RuntimeException("Greska prilikom brisanja")).when(dbBroker).delete(any(AbstractDomainObject.class));

        assertThrows(Exception.class, () -> {
            so.execute(tim);
        });

    }
}
