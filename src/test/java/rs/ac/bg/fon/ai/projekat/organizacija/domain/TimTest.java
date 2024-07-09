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
public class TimTest {

    Tim t;

    public TimTest() {
    }

    

    @BeforeEach
    public void setUp() {
        t = new Tim();
    }

    @AfterEach
    public void tearDown() {
        t = null;
    }

    @Test
    void testTim() {
        assertNotNull(t);
        assertEquals(0, t.getIDTima());
        assertNull(t.getNazivTima());
        assertEquals(0, t.getBrojClanova());
        assertNull(t.getProjekat());
    }

    @Test
    void testTimParam() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        t = new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ));

        assertNotNull(t);
        assertEquals(1, t.getIDTima());
        assertEquals("PR", t.getNazivTima());
        assertEquals(8, t.getBrojClanova());

        assertEquals(1, t.getProjekat().getIDProjekta());
        assertEquals("BDW", t.getProjekat().getNazivProjekta());
        assertEquals("dizajn", t.getProjekat().getVrstaProjekta());
        assertEquals(datumP, t.getProjekat().getDatumPocetka());
        assertEquals(datumZ, t.getProjekat().getDatumZavrsetka());

    }

    /**
     * Test of toString method, of class Tim.
     */
    @Test
    public void testToString() {

        t.setNazivTima("PR");
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        t.setProjekat(new Projekat(0, "BDW", "dizajn", datumP, datumZ));

        String st = t.toString();

        System.out.println(st);
        assertTrue(st.contains("PR"));
        assertTrue(st.contains("BDW"));

    }

    @Test
    void testEqualsObject() {
        Tim t2 = t;

        assertTrue(t.equals(t2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(t.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(t.equals(new Zadatak()));
    }

    @ParameterizedTest
    @CsvSource({
        "PR, BDW, PR, BDW, true",
        "PR, BDW, FR, BDW, false",
        "PR, BDW, PR, AIBG, false",
        "PR, BDW, FR, AIBG, false"
    })
    void testEqualsObjectSveOk(String nazivTima, String nazivProjekta,
            String nazivTima2, String nazivProjekta2, boolean eq) {

        t.setNazivTima(nazivTima);
        t.setProjekat(new Projekat());
        t.getProjekat().setNazivProjekta(nazivProjekta);

        Tim t2 = new Tim();
        t2.setNazivTima(nazivTima2);
        t2.setProjekat(new Projekat());
        t2.getProjekat().setNazivProjekta(nazivProjekta2);

        assertEquals(eq, t.equals(t2));
    }

    /**
     * Test of setNazivTima method, of class Tim.
     */
    @Test
    public void testSetNazivTima() {
        t.setNazivTima("PR");
        assertEquals("PR", t.getNazivTima());
    }

    @Test
    void testSetNazivTimaNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> t.setNazivTima(null));

    }

    @Test
    void testSetNazivTimaSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> t.setNazivTima("a5"));

    }

    @Test
    void testSetNazivTimaVelikoPocetno() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> t.setNazivTima("pr"));

    }

    /**
     * Test of setBrojClanova method, of class Tim.
     */
    @Test
    public void testSetBrojClanova() {
        t.setBrojClanova(8);
        assertEquals(8, t.getBrojClanova());

    }

    @Test
    void testSetBrojClanovaManjeOdNula() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> t.setBrojClanova(-5));

    }

    /**
     * Test of setProjekat method, of class Tim.
     */
    @Test
    public void testSetIDProjekta() {
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        t.setProjekat(new Projekat(1, "BDW", "dizajn", datumP, datumZ));
        assertEquals(1, t.getProjekat().getIDProjekta());
        assertEquals("BDW", t.getProjekat().getNazivProjekta());
        assertEquals("dizajn", t.getProjekat().getVrstaProjekta());
        assertEquals(datumP, t.getProjekat().getDatumPocetka());
        assertEquals(datumZ, t.getProjekat().getDatumZavrsetka());
    }

    @Test
    void testSetIDProjektaNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> t.setProjekat(null));

    }

}
