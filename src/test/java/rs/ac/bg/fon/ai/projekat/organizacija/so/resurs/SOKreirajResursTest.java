/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.resurs;

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
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Resurs;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.projekat.SOKreirajProjekat;

/**
 *
 * @author Ivana Fimic
 */
@ExtendWith(MockitoExtension.class)

public class SOKreirajResursTest {
    
    public SOKreirajResursTest() {
    }
    
   
     @Mock
    private DBBroker dbBroker;

    
    private SOKreirajResurs so;
    private Resurs r;

    @BeforeEach
    public void setUp()throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        so=new SOKreirajResurs();
        r=new Resurs();
        
        Field instanceBroker = DBBroker.class.getDeclaredField("instance");
        instanceBroker.setAccessible(true);
        instanceBroker.set(null, dbBroker);
    }

    @Test
    public void testValidateProjekatWithValidData() throws Exception {      
        assertDoesNotThrow(() -> {
            so.validate(r);
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

        r = new Resurs(1, "oprema", 3, new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));       

        when(dbBroker.insert(r)).thenReturn(r);
        
        

        so.execute(r);

        Resurs createdResurs = so.getR();
        assertNotNull(createdResurs);
        assertEquals("oprema", createdResurs.getNazivResursa());
        assertEquals(1, createdResurs.getIDResursa());

        verify(dbBroker, times(1)).insert(r);
    }
    
    
    
    @Test
    public void testExecuteNeuspesno() throws Exception {
   
        when(dbBroker.insert(r)).thenThrow(new RuntimeException("Greska prilikom kreiranja resursa"));

         assertThrows(RuntimeException.class, () -> {
            so.execute(r);
        });

    }
}
