/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import java.lang.reflect.Field;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)

public class SOKreirajTimTest {


    @Mock
    private DBBroker dbBroker;

    
    private SOKreirajTim so;
    private Tim tim;

    @BeforeEach
    public void setUp()throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
         so=new SOKreirajTim();
        tim=new Tim();
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
    public void testExecuteUspesno() throws Exception {
        
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        Tim newTim = new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ));
        List<DetaljiPozicija> pozicije = new ArrayList<>();
        pozicije.add(new DetaljiPozicija(newTim, new Pozicija(1, "Koordinator"), 2));
        pozicije.add(new DetaljiPozicija(newTim, new Pozicija(1, "Koordinator"), 1));
        newTim.setBrojPozicija(pozicije);

        when(dbBroker.insert(newTim)).thenReturn(newTim);
        
        for (DetaljiPozicija dp : pozicije) {
            when(dbBroker.insert(dp)).thenReturn(dp);
        }

        so.execute(newTim);

        Tim createdTim = so.getTim();
        assertNotNull(createdTim);
        assertEquals("PR", createdTim.getNazivTima());
        assertEquals(8, createdTim.getBrojClanova());

        verify(dbBroker, times(1)).insert(newTim);
        verify(dbBroker, times(pozicije.size())).insert(any(DetaljiPozicija.class));
    }
    
    
    
    @Test
    public void testExecuteNeuspesno() throws Exception {
   
        Tim newTim=new Tim();
        List<DetaljiPozicija> pozicije = new ArrayList<>();
        pozicije.add(new DetaljiPozicija());
        newTim.setBrojPozicija(pozicije);

        when(dbBroker.insert(newTim)).thenThrow(new RuntimeException("Greska prilikom kreiranja tima"));

         assertThrows(RuntimeException.class, () -> {
            so.execute(newTim);
        });

       
         
}
}
