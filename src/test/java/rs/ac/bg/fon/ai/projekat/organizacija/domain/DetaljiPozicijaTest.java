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
public class DetaljiPozicijaTest {

    public DetaljiPozicijaTest() {
    }

    DetaljiPozicija dp;

    @BeforeEach
    public void setUp() {
        dp = new DetaljiPozicija();
    }

    @AfterEach
    public void tearDown() {
        dp = null;
    }

    @Test
    void testDetaljiPozicija() {
        assertNotNull(dp);
        assertEquals(0, dp.getBrojPozicija());
        assertNull(dp.getPozicija());
        assertNull(dp.getTim());

    }

    @Test
    void testTimParam() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        dp = new DetaljiPozicija(new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)), new Pozicija(1, "Koordinator"), 4);

        assertNotNull(dp);

        assertEquals(4, dp.getBrojPozicija());

        assertEquals(1, dp.getPozicija().getIDPozicije());
        assertEquals("Koordinator", dp.getPozicija().getNazivPozicije());

        assertEquals(1, dp.getTim().getIDTima());
        assertEquals("PR", dp.getTim().getNazivTima());
        assertEquals(8, dp.getTim().getBrojClanova());
        assertEquals(1, dp.getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", dp.getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", dp.getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, dp.getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, dp.getTim().getProjekat().getDatumZavrsetka());

    }

    /**
     * Test of setTim method, of class DetaljiPozicija.
     */
    @Test
    public void testSetTim() {
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        dp.setTim(new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));
        assertEquals(1, dp.getTim().getIDTima());
        assertEquals(8, dp.getTim().getBrojClanova());
        assertEquals("PR", dp.getTim().getNazivTima());
        assertEquals(1, dp.getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", dp.getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", dp.getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, dp.getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, dp.getTim().getProjekat().getDatumZavrsetka());
    }

    @Test
    void testSetTimNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> dp.setTim(null));

    }

    /**
     * Test of setPozicija method, of class DetaljiPozicija.
     */
    @Test
    public void testSetPozicija() {
        dp.setPozicija(new Pozicija(1, "Koordinator"));
        assertEquals(1, dp.getPozicija().getIDPozicije());
        assertEquals("Koordinator", dp.getPozicija().getNazivPozicije());
    }

    @Test
    void testSetPozicijaNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> dp.setPozicija(null));

    }

    /**
     * Test of setBrojPozicija method, of class DetaljiPozicija.
     */
    @Test
    public void testSetBrojPozicija() {
        dp.setBrojPozicija(4);
        assertEquals(4, dp.getBrojPozicija());
    }

    @Test
    void testSetBrojPozicijaBroj() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> dp.setBrojPozicija(-1));

    }

    @Test
    public void testToString() {
        dp.setTim(new Tim());
        dp.getTim().setNazivTima("PR");
        dp.setPozicija(new Pozicija(1, "Koordinator"));
        dp.setBrojPozicija(4);

        String st = dp.toString();
       

        assertTrue(st.contains("Koordinator"));
        assertTrue(st.contains("4"));
        assertTrue(st.contains("PR"));

    }

    @Test
    void testEqualsObject() {
        DetaljiPozicija dp2 = dp;

        assertTrue(dp.equals(dp2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(dp.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(dp.equals(new Zadatak()));
    }
    
     @ParameterizedTest
    @CsvSource({
        "Koordinator, PR, BDW, Koordinator, PR, BDW, true",
        "Koordinator, PR, BDW, Clan , PR, BDW, false",
        "Koordinator, PR, BDW, Koordinator, FR, BDW, false",
        "Koordinator, PR, BDW , Koordinator, PR, AIBG, false",
        "Koordinator, PR, BDW , Clan, PR, AIBG, false",
        "Koordinator, PR, BDW , Koordinator, FR, AIBG, false",
        "Koordinator, PR, BDW, Clan, FR, BDW, false",
        "Koordinator, PR, BDW, Clan, FR, AIBG, false",

      
    })

    void testEqualsObjectSveOk(String pozicija, String nazivTima, String nazivProjekta,
            String pozicija1, String nazivTima1, String nazivProjekta1,
            boolean eq) {

        dp.setPozicija(new Pozicija());
        dp.getPozicija().setNazivPozicije(pozicija);
        dp.setTim(new Tim());
        dp.getTim().setNazivTima(nazivTima);
        dp.getTim().setProjekat(new Projekat());
        dp.getTim().getProjekat().setNazivProjekta(nazivProjekta);
        
        DetaljiPozicija dp2=new DetaljiPozicija();
        dp2.setPozicija(new Pozicija());
        dp2.getPozicija().setNazivPozicije(pozicija1);
        dp2.setTim(new Tim());
        dp2.getTim().setNazivTima(nazivTima1);
        dp2.getTim().setProjekat(new Projekat());
        dp2.getTim().getProjekat().setNazivProjekta(nazivProjekta1);
        
       

        assertEquals(eq, dp.equals(dp2));

    }

}
