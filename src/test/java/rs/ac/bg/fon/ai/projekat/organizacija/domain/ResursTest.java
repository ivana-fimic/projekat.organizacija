/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ivana
 */
public class ResursTest {
    
    public ResursTest() {
    }
    
   Resurs r;
    
    @BeforeEach
    public void setUp() {
        r=new Resurs();
    }
    
    @AfterEach
    public void tearDown() {
        r=null;
    }

   

   
    /**
     * Test of setNazivResursa method, of class Resurs.
     */
    @Test
    public void testSetNazivResursa() {
        System.out.println("setNazivResursa");
        String nazivResursa = "";
        Resurs instance = new Resurs();
        instance.setNazivResursa(nazivResursa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 

    /**
     * Test of setKolicina method, of class Resurs.
     */
    @Test
    public void testSetKolicina() {
        System.out.println("setKolicina");
        int kolicina = 0;
        Resurs instance = new Resurs();
        instance.setKolicina(kolicina);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTim method, of class Resurs.
     */
    
    /**
     * Test of setTim method, of class Resurs.
     */
    @Test
    public void testSetTim() {
        System.out.println("setTim");
        Tim tim = null;
        Resurs instance = new Resurs();
        instance.setTim(tim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Resurs.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Resurs instance = new Resurs();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
