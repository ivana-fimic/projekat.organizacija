/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Ivana
 */
public class ProjekatTest {

    public ProjekatTest() {
    }

    Projekat p;

    @BeforeEach
    public void setUp() {
        p = new Projekat();
    }

    @AfterEach
    public void tearDown() {
        p = null;
    }

    @Test
    void testProjekat() {
        assertNotNull(p);
        assertEquals(0, p.getIDProjekta());
        assertNull(p.getNazivProjekta());
        assertNull(p.getVrstaProjekta());
        assertNull(p.getDatumPocetka());
        assertNull(p.getDatumZavrsetka());

    }

    @Test
    void testTimParam() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        p = new Projekat(1, "BDW", "dizajn", datumP, datumZ);

        assertNotNull(p);

        assertEquals(1, p.getIDProjekta());
        assertEquals("BDW", p.getNazivProjekta());
        assertEquals("dizajn", p.getVrstaProjekta());
        assertEquals(datumP, p.getDatumPocetka());
        assertEquals(datumZ, p.getDatumZavrsetka());

    }

    /**
     * Test of setNazivProjekta method, of class Projekat.
     */
    @Test
    public void testSetNazivProjekta() {
        p.setNazivProjekta("BDW");
        assertEquals("BDW", p.getNazivProjekta());

    }
    @Test
    void testSetNazivProjektaNull() {
        
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> p.setNazivProjekta(null));

    }

    @Test
    void testSetNazivProjektaSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setNazivProjekta("a5"));

    }
    
    @Test
    void testSetNazivProjektaVelikaSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setNazivProjekta("aa"));

    }

    /**
     * Test of setVrstaProjekta method, of class Projekat.
     */
    @Test
    public void testSetVrstaProjekta() {
        p.setVrstaProjekta("dizajn");
        assertEquals("dizajn", p.getVrstaProjekta());
    }
    
    @Test
    void testSetVrstaProjektaNull() {
        
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> p.setVrstaProjekta(null));

    }

    @Test
    void testSetVrstaProjektaSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setVrstaProjekta("a5"));

    }
    

    /**
     * Test of setDatumPocetka method, of class Projekat.
     */
    @Test
    public void testSetDatumPocetka() {
        LocalDate d = LocalDate.of(2024, 7, 15);
        p.setDatumPocetka(d);
        assertEquals(d, p.getDatumPocetka());

    }
    
    @Test
    void testSetDatumPocetkaNull() {
        
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> p.setDatumPocetka(null));

    }
    
    

    /**
     * Test of setDatumZavrsetka method, of class Projekat.
     */
    @Test
    public void testSetDatumZavrsetka() {
        LocalDate d = LocalDate.of(2024, 7, 15);
        p.setDatumZavrsetka(d);
        assertEquals(d, p.getDatumZavrsetka());
    }
    
     @Test
    void testSetDatumZavrsetkaNull() {
        
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> p.setDatumZavrsetka(null));

    }

  
    /**
     * Test of toString method, of class Projekat.
     */
    @Test
    public void testToString() {
        p.setNazivProjekta("BDW");

        String st = p.toString();

        assertTrue(st.contains("BDW"));
    }

    @Test
    void testEqualsObject() {
        Projekat t2 = p;

        assertTrue(p.equals(t2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(p.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(p.equals(new Zadatak()));
    }

    @ParameterizedTest
    @CsvSource({
        "BDW, dizajn, BDW, dizajn, true",
        "BDW, dizajn, AIBG, dizajn, false",
        "BDW, dizajn, BDW, hakaton, false",
        "BDW, dizajn, AIBG, hakaton, false",
    })
    void testEqualsObjectSveOk(String nazivProjekta, String vrstaProjekta, String nazivProjekta2,
             String vrstaProjekta2, boolean eq) {

        p.setNazivProjekta(nazivProjekta);
        p.setVrstaProjekta(vrstaProjekta);

        Projekat p2=new Projekat();
        p2.setNazivProjekta(nazivProjekta2);
        p2.setVrstaProjekta(vrstaProjekta2);

        assertEquals(eq, p.equals(p2));
    }

}
