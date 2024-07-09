/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.Moodovi;

/**
 *
 * @author Ivana
 */
public class ZadatakTest {

    Zadatak z;

    public ZadatakTest() {
    }

    @BeforeEach
    public void setUp() {
        z = new Zadatak();
    }

    @AfterEach
    public void tearDown() {
        z = null;
    }

    @Test
    void testZadatak() {
        assertNotNull(z);
        assertEquals(0, z.getIDZadatka());
        assertNull(z.getNazivZadatka());
        assertNull(z.getTim());
    }

    @Test
    void testTimParam() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        z = new Zadatak(1, "kreiranje objava", new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));

        assertNotNull(z);
        assertEquals(1, z.getIDZadatka());
        assertEquals("kreiranje objava", z.getNazivZadatka());

        assertEquals(1, z.getTim().getIDTima());
        assertEquals("PR", z.getTim().getNazivTima());
        assertEquals(8, z.getTim().getBrojClanova());
        assertEquals(1, z.getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", z.getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", z.getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, z.getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, z.getTim().getProjekat().getDatumZavrsetka());

    }

    @Test
    void testEqualsObject() {
        Zadatak z2 = z;

        assertTrue(z.equals(z2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(z.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(z.equals(new Tim()));
    }

    @ParameterizedTest
    @CsvSource({
        "kreiranje objava, kreiranje objava, true",
        "kreiranje objava, promovisanje projekta, false",})

    void testEqualsObjectSveOk(String nazivZadatka, String nazivZadatka2,
            boolean eq) {

        z.setNazivZadatka(nazivZadatka);

        Zadatak z2 = new Zadatak();
        z2.setNazivZadatka(nazivZadatka2);

        assertEquals(eq, z.equals(z2));
    }

    /**
     * Test of setNazivZadatka method, of class Zadatak.
     */
    @Test
    void testSetNazivZadatka() {
        z.setNazivZadatka("kreiranje objava");
        assertEquals("kreiranje objava", z.getNazivZadatka());
    }

    @Test
    void testSetNazivZadatkaNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> z.setNazivZadatka(null));

    }

    @Test
    void testSetNazivZadatakSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> z.setNazivZadatka("a5"));

    }

    @Test
    public void testSetTim() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        z.setTim(new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));
        assertEquals(1, z.getTim().getIDTima());
        assertEquals(8, z.getTim().getBrojClanova());
        assertEquals("PR", z.getTim().getNazivTima());
        assertEquals(1, z.getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", z.getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", z.getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, z.getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, z.getTim().getProjekat().getDatumZavrsetka());

    }

    @Test
    void testSetTimNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> z.setTim(null));

    }
    
    
    @Test
    public void testToString() {
       
        z.setNazivZadatka("kreiranje objava");

        String st = z.toString();
        System.out.println(st);
        assertTrue(st.contains("kreiranje objava"));
      

    }

}
