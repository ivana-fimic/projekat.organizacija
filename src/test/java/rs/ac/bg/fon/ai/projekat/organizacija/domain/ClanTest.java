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

/**
 *
 * @author Ivana
 */
public class ClanTest {

    public ClanTest() {
    }

    Clan c;

    @BeforeEach
    public void setUp() {
        c = new Clan();
    }

    @AfterEach
    public void tearDown() {
        c = null;
    }

    @Test
    void testClan() {
        assertNotNull(c);
        assertEquals(0, c.getIDClana());
        assertNull(c.getIme());
        assertNull(c.getPrezime());
        assertNull(c.getFakultet());
        assertEquals(0, c.getGodStudija());
        assertNull(c.getPozicija());
        assertNull(c.getTim());

    }

    @Test
    void testTimParam() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        c = new Clan(1, "Ivana", "Fimic", 4, new Pozicija(1, "Koordinator"), new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)), "FON");

        assertNotNull(c);
        assertEquals(1, c.getIDClana());
        assertEquals("Ivana", c.getIme());
        assertEquals("Fimic", c.getPrezime());
        assertEquals("FON", c.getFakultet());
        assertEquals(4, c.getGodStudija());

        assertEquals(1, c.getPozicija().getIDPozicije());
        assertEquals("Koordinator", c.getPozicija().getNazivPozicije());

        assertEquals(1, c.getTim().getIDTima());
        assertEquals("PR", c.getTim().getNazivTima());
        assertEquals(8, c.getTim().getBrojClanova());
        assertEquals(1, c.getTim().getIDProjekta().getIDProjekta());
        assertEquals("BDW", c.getTim().getIDProjekta().getNazivProjekta());
        assertEquals("dizajn", c.getTim().getIDProjekta().getVrstaProjekta());
        assertEquals(datumP, c.getTim().getIDProjekta().getDatumPocetka());
        assertEquals(datumZ, c.getTim().getIDProjekta().getDatumZavrsetka());

    }

    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToString() {
        c.setIme("Ivana");
        c.setPrezime("Fimic");

        String st = c.toString();
        assertTrue(st.contains("Ivana"));
        assertTrue(st.contains("Fimic"));

    }

    /**
     * Test of setFakultet method, of class Clan.
     */
    @Test
    public void testSetFakultet() {
        c.setFakultet("FON");
        assertEquals("FON", c.getFakultet());
    }
    
      @Test
    void testSetFakultetNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> c.setFakultet(null));

    }

    @Test
    void testSetFakultetSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> c.setFakultet("a5"));

    }

    @Test
    void testSetFakultetVelikoPocetno() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> c.setFakultet("fon"));

    }
    
    

    /**
     * Test of setIme method, of class Clan.
     */
    @Test
    public void testSetIme() {
        c.setIme("Ivana");
        assertEquals("Ivana", c.getIme());
    }

    @Test
    void testSetImeNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> c.setIme(null));

    }

    @Test
    void testSetImeSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> c.setIme("a5"));

    }

    @Test
    void testSetImeVelikoPocetno() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> c.setIme("ivana"));

    }

    /**
     * Test of setPrezime method, of class Clan.
     */
    @Test
    public void testSetPrezime() {
        c.setPrezime("Fimic");
        assertEquals("Fimic", c.getPrezime());
    }

    @Test
    void testSetPrezimeNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> c.setPrezime(null));

    }

    @Test
    void testSetPrezimeSlova() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> c.setPrezime("a5"));

    }

    @Test
    void testSetPrezimeVelikoPocetno() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> c.setPrezime("fimic"));

    }

    /**
     * Test of setGodStudija method, of class Clan.
     */
    @Test
    public void testSetGodStudija() {
        c.setGodStudija(4);
        assertEquals(4, c.getGodStudija());
    }

    @Test
    void testSetGodStudijaRang() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> c.setGodStudija(8));

    }

    /**
     * Test of setPozicija method, of class Clan.
     */
    @Test
    public void testSetPozicija() {
        c.setPozicija(new Pozicija(1, "Koordinator"));
        assertEquals(1, c.getPozicija().getIDPozicije());
        assertEquals("Koordinator", c.getPozicija().getNazivPozicije());
    }
    
    @Test
    void testSetPozicijaNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> c.setPozicija(null));

    }

    /**
     * Test of setTim method, of class Clan.
     */
    @Test
    public void testSetTim() {
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        c.setTim(new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)));
        assertEquals(1, c.getTim().getIDTima());
        assertEquals(8, c.getTim().getBrojClanova());
        assertEquals("PR", c.getTim().getNazivTima());
        assertEquals(1, c.getTim().getIDProjekta().getIDProjekta());
        assertEquals("BDW", c.getTim().getIDProjekta().getNazivProjekta());
        assertEquals("dizajn", c.getTim().getIDProjekta().getVrstaProjekta());
        assertEquals(datumP, c.getTim().getIDProjekta().getDatumPocetka());
        assertEquals(datumZ, c.getTim().getIDProjekta().getDatumZavrsetka());
    }
    
    @Test
    void testSetTimNull() {
        Exception e = assertThrows(java.lang.NullPointerException.class,
                () -> c.setTim(null));

    }

    @Test
    void testEqualsObject() {
        Clan c2 = c;

        assertTrue(c.equals(c2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(c.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(c.equals(new Zadatak()));
    }

    @ParameterizedTest
    @CsvSource({
        "Ivana, Fimic, Ivana, Fimic, true",
        "Ivana, Fimic, Ivana, Siljkovic, false",
        "Ivana, Fimic, Dimitrije, Fimic, false",
        "Ivana, Fimic, Dimitrije, Siljkovic, false",})
    void testEqualsObjectSveOk(String ime, String prezime,
            String ime2, String prezime2, boolean eq) {

        c.setIme(ime);
        c.setPrezime(prezime);

        Clan c2 = new Clan();
        c2.setIme(ime2);
        c2.setPrezime(prezime2);

        assertEquals(eq, c.equals(c2));
    }

}
