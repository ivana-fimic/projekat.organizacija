/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.projekat;

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
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOKreirajTim;

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)

public class SOKreirajProjekatTest {
    
    public SOKreirajProjekatTest() {
    }
    
    @Mock
    private DBBroker dbBroker;

    
    private SOKreirajProjekat so;
    private Projekat p;

    @BeforeEach
    public void setUp()throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        so=new SOKreirajProjekat();
        p=new Projekat();
        
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
        so.validate(new Zadatak());
    });

}
   

    @Test
    public void testExecuteUspesno() throws Exception {
        
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        p = new Projekat(1, "BDW", "dizajn", datumP, datumZ);
      
        when(dbBroker.insert(p)).thenReturn(p);
    

        so.execute(p);

        Projekat createdProjekat = so.getP();
        assertNotNull(createdProjekat);
        assertEquals("BDW", createdProjekat.getNazivProjekta());
        assertEquals(1, createdProjekat.getIDProjekta());

        verify(dbBroker, times(1)).insert(p);
    }
    
    
    
    @Test
    public void testExecuteNeuspesno() throws Exception {
   
        when(dbBroker.insert(p)).thenThrow(new RuntimeException("Greska prilikom kreiranja projekta"));

        assertThrows(RuntimeException.class, () -> {
            so.execute(p);
        });

         
}
    
}
