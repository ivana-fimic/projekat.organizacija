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
 * @author Ivana Fimic
 */
public class ResursTest {

    public ResursTest() {
    }

    Resurs r;

    @BeforeEach
    public void setUp() {
        r = new Resurs();
    }

    @AfterEach
    public void tearDown() {
        r = null;
    }

    @Test
    void testZadatak() {
        assertNotNull(r);
        assertEquals(0, r.getIDResursa());
        assertNull(r.getNazivResursa());
        assertEquals(0, r.getKolicina());
        assertNull(r.getTim());

    }

    @Test
    void testTimParam() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        r = new Resurs(1, "oprema", 3, new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));

        assertNotNull(r);
        assertEquals(1, r.getIDResursa());
        assertEquals("oprema", r.getNazivResursa());
        assertEquals(3, r.getKolicina());

        assertEquals(1, r.getTim().getIDTima());
        assertEquals("PR", r.getTim().getNazivTima());
        assertEquals(8, r.getTim().getBrojClanova());
        assertEquals(1, r.getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", r.getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", r.getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, r.getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, r.getTim().getProjekat().getDatumZavrsetka());

    }

    
    @Test
    public void testSetNazivResursa() {
        r.setNazivResursa("oprema");
        assertEquals("oprema", r.getNazivResursa());

    }

    @Test
    void testSetNazivResursaNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> r.setNazivResursa(null));

    }

    @Test
    void testSetNazivResursaPrazno() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> r.setNazivResursa(""));

    }

    
    @Test
    public void testSetKolicina() {
        r.setKolicina(3);
        assertEquals(3, r.getKolicina());
    }

    @Test
    void testSetKolicinaManjeOdNula() {
        
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> r.setKolicina(-5));

    }

    @Test
    public void testSetTim() {
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        r.setTim(new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));
        assertEquals(1, r.getTim().getIDTima());
        assertEquals(1, r.getTim().getProjekat().getIDProjekta());
        assertEquals(8, r.getTim().getBrojClanova());
        assertEquals("PR", r.getTim().getNazivTima());
        assertEquals("BDW", r.getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", r.getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, r.getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, r.getTim().getProjekat().getDatumZavrsetka());

    }

    @Test
    void testSetTimNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> r.setTim(null));

    }

  
    @Test
    public void testToString() {
        r.setNazivResursa("oprema");

        String st = r.toString();
        System.out.println(st);
        assertTrue(st.contains("oprema"));
    }

    @Test
    void testEqualsObject() {
        Resurs z2 = r;

        assertTrue(r.equals(z2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(r.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(r.equals(new Tim()));
    }

    @ParameterizedTest
    @CsvSource({
        "oprema, oprema, true",
        "oprema, marker, false",})

    void testEqualsObjectSveOk(String nazivResursa, String nazivResursa2,
            boolean eq) {

        r.setNazivResursa(nazivResursa);

        Resurs r2 = new Resurs();
        r2.setNazivResursa(nazivResursa2);

        assertEquals(eq, r.equals(r2));
    }

}
