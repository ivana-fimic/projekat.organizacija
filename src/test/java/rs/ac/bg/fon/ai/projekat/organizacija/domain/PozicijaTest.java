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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Ivana Fimic
 */
public class PozicijaTest {

    public PozicijaTest() {
    }

    Pozicija p;

    @BeforeEach
    public void setUp() {
        p = new Pozicija();
    }

    @AfterEach
    public void tearDown() {
        p = null;
    }

    @Test
    void testPozicija() {
        assertNotNull(p);
        assertEquals(0, p.getIDPozicije());
        assertNull(p.getNazivPozicije());

    }

    @Test
    void testPozicijaParam() {
        p = new Pozicija(1, "Koordinator");
        assertNotNull(p);
        assertEquals(1, p.getIDPozicije());
        assertEquals("Koordinator", p.getNazivPozicije());

    }

    @Test
    public void testSetNazivPozicije() {
        p.setNazivPozicije("Koordinator");
        assertEquals("Koordinator", p.getNazivPozicije());

    }
     @Test
    void testSetNazivPozicijaNull() {
       assertThrows(java.lang.NullPointerException.class,
                () -> p.setNazivPozicije(null));

    }

    @Test
    void testSetNazivPozicijaPrazno() {
         assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setNazivPozicije(""));

    }

    @Test
    public void testToString() {
        p.setNazivPozicije("Koordinator");

        String st = p.toString();
        assertTrue(st.contains("Koordinator"));
    }
       @Test
    void testEqualsObject() {
        Pozicija p2 = p;

        assertTrue(p.equals(p2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(p.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(p.equals(new Tim()));
    }

    @ParameterizedTest
    @CsvSource({
        "Koordinator, Koordinator, true",
        "Koordinator, Clan, false",})

    void testEqualsObjectSveOk(String nazivPozicije, String nazivPozicije2,
            boolean eq) {

        p.setNazivPozicije(nazivPozicije);

        Pozicija p2=new Pozicija();
        p2.setNazivPozicije(nazivPozicije2);

        assertEquals(eq, p.equals(p2));
    }

}
