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
        assertEquals(1, dp.getTim().getIDProjekta().getIDProjekta());
        assertEquals("BDW", dp.getTim().getIDProjekta().getNazivProjekta());
        assertEquals("dizajn", dp.getTim().getIDProjekta().getVrstaProjekta());
        assertEquals(datumP, dp.getTim().getIDProjekta().getDatumPocetka());
        assertEquals(datumZ, dp.getTim().getIDProjekta().getDatumZavrsetka());

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
        assertEquals(1, dp.getTim().getIDProjekta().getIDProjekta());
        assertEquals("BDW", dp.getTim().getIDProjekta().getNazivProjekta());
        assertEquals("dizajn", dp.getTim().getIDProjekta().getVrstaProjekta());
        assertEquals(datumP, dp.getTim().getIDProjekta().getDatumPocetka());
        assertEquals(datumZ, dp.getTim().getIDProjekta().getDatumZavrsetka());
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

}
