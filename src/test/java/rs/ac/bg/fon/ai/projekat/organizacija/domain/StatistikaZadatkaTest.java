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
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;

/**
 *
 * @author Ivana Fimic
 */
public class StatistikaZadatkaTest {

    StatistikaZadatka st;

    public StatistikaZadatkaTest() {
    }

    @BeforeEach
    public void setUp() {
        st = new StatistikaZadatka();
    }

    @AfterEach
    public void tearDown() {
        st = null;
    }

    @Test
    void testStatistikaZadatka() {
        assertNotNull(st);
        assertNull(st.getClan());
        assertNull(st.getZadatak());
        assertNull(st.getKrajnjiRok());
        assertNull(st.getDatumDodele());
        assertNull(st.getFazaZadatka());

    }

    @Test
    void testStatistikaZadatkaParam() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);

        st = new StatistikaZadatka(new Clan(1, "Ivana", "Fimic", 4, new Pozicija(1, "Koordinator"), new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)), "FON"),
                new Zadatak(1, "kreiranje objava", new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ))), FazaZadatka.NEZAPOCETO, datumP, datumZ);

        assertNotNull(st);
        assertEquals(1, st.getClan().getIDClana());
        assertEquals("Ivana", st.getClan().getIme());
        assertEquals("Fimic", st.getClan().getPrezime());
        assertEquals("FON", st.getClan().getFakultet());
        assertEquals(4, st.getClan().getGodStudija());

        assertEquals(1, st.getClan().getPozicija().getIDPozicije());
        assertEquals("Koordinator", st.getClan().getPozicija().getNazivPozicije());
        assertEquals(1, st.getClan().getTim().getIDTima());
        assertEquals("PR", st.getClan().getTim().getNazivTima());
        assertEquals(8, st.getClan().getTim().getBrojClanova());
        assertEquals(1, st.getClan().getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", st.getClan().getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", st.getClan().getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, st.getClan().getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, st.getClan().getTim().getProjekat().getDatumZavrsetka());

        assertEquals(1, st.getZadatak().getIDZadatka());
        assertEquals("kreiranje objava", st.getZadatak().getNazivZadatka());
        assertEquals("PR", st.getZadatak().getTim().getNazivTima());
        assertEquals(1, st.getZadatak().getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", st.getZadatak().getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", st.getZadatak().getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, st.getZadatak().getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, st.getZadatak().getTim().getProjekat().getDatumZavrsetka());

        assertEquals(FazaZadatka.NEZAPOCETO, st.getFazaZadatka());
        assertEquals(datumP, st.getDatumDodele());
        assertEquals(datumZ, st.getKrajnjiRok());

    }

   
    @Test
    public void testSetClan() {
        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        st.setClan(new Clan(1, "Ivana", "Fimic", 4, new Pozicija(1, "Koordinator"), new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ)), "FON"));

        assertEquals(1, st.getClan().getIDClana());
        assertEquals("Ivana", st.getClan().getIme());
        assertEquals("Fimic", st.getClan().getPrezime());
        assertEquals("FON", st.getClan().getFakultet());
        assertEquals(4, st.getClan().getGodStudija());

        assertEquals(1, st.getClan().getPozicija().getIDPozicije());
        assertEquals("Koordinator", st.getClan().getPozicija().getNazivPozicije());

        assertEquals(1, st.getClan().getTim().getIDTima());
        assertEquals("PR", st.getClan().getTim().getNazivTima());
        assertEquals(8, st.getClan().getTim().getBrojClanova());
        assertEquals(1, st.getClan().getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", st.getClan().getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", st.getClan().getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, st.getClan().getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, st.getClan().getTim().getProjekat().getDatumZavrsetka());

    }

    @Test
    void testSetClanNull() {
         assertThrows(java.lang.NullPointerException.class,
                () -> st.setClan(null));

    }

    
    public void testSetZadatak() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        LocalDate datumZ = LocalDate.of(2024, 9, 15);
        st.setZadatak(new Zadatak(1, "kreiranje objava", new Tim(1, "PR", 8, new Projekat(1, "BDW", "dizajn", datumP, datumZ))));

        assertEquals(1, st.getZadatak().getIDZadatka());
        assertEquals("kreiranje objava", st.getZadatak().getNazivZadatka());
        assertEquals(1, st.getZadatak().getTim().getIDTima());
        assertEquals("PR", st.getZadatak().getTim().getNazivTima());
        assertEquals(8, st.getZadatak().getTim().getBrojClanova());
        assertEquals(1, st.getZadatak().getTim().getProjekat().getIDProjekta());
        assertEquals("BDW", st.getZadatak().getTim().getProjekat().getNazivProjekta());
        assertEquals("dizajn", st.getZadatak().getTim().getProjekat().getVrstaProjekta());
        assertEquals(datumP, st.getZadatak().getTim().getProjekat().getDatumPocetka());
        assertEquals(datumZ, st.getZadatak().getTim().getProjekat().getDatumZavrsetka());

    }

    @Test
    void testSetZadatakNull() {
         assertThrows(java.lang.NullPointerException.class,
                () -> st.setZadatak(null));

    }

    
    @Test
    public void testSetFazaZadatka() {

        st.setFazaZadatka(FazaZadatka.NEZAPOCETO);
        assertEquals(FazaZadatka.NEZAPOCETO, st.getFazaZadatka());

    }
    
    @Test
    void testSetFazaZadatkaNull() {
      assertThrows(java.lang.NullPointerException.class,
                () -> st.setFazaZadatka(null));

    }
    

  
    @Test
    public void testSetDatumDodele() {

        LocalDate datumP = LocalDate.of(2024, 7, 15);
        st.setDatumDodele(datumP);
        assertEquals(datumP, st.getDatumDodele());

    }
    @Test
    void testSetDatumDodeleNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> st.setDatumDodele(null));

    }
    


    @Test
    public void testSetKrajnjiRok() {

        LocalDate datumP = LocalDate.of(2024, 7, 20);
        st.setKrajnjiRok(datumP);
        assertEquals(datumP, st.getKrajnjiRok());

    }
    
    @Test
    void testSetKrajnjiRokNull() {
         assertThrows(java.lang.NullPointerException.class,
                () -> st.setKrajnjiRok(null));

    }
    
    @Test
    void testSetKrajnjiRokProslost() {
        LocalDate datumP = LocalDate.of(2023, 7, 15);
         assertThrows(java.lang.IllegalArgumentException.class,
                () -> st.setKrajnjiRok(datumP));

    }

    @Test
    public void testToString() {
        st.setClan(new Clan());
        st.getClan().setIme("Ivana");
        st.getClan().setPrezime("Fimic");

        st.setZadatak(new Zadatak());
        st.getZadatak().setNazivZadatka("kreiranje objava");

        String str = st.toString();

        assertTrue(str.contains("Ivana"));
        assertTrue(str.contains("Fimic"));
        assertTrue(str.contains("kreiranje objava"));

    }

    @Test
    void testEqualsObject() {
        StatistikaZadatka st2 = st;

        assertTrue(st.equals(st2));
    }

    @Test
    void testEqualsObjectNull() {
        assertFalse(st.equals(null));
    }

    @Test
    void testEqualsObjectDrugaKlasa() {
        assertFalse(st.equals(new Zadatak()));
    }

    @ParameterizedTest
    @CsvSource({
        "kreiranje objava, Ivana, Fimic, kreiranje objava, Ivana, Fimic, true",
        "kreiranje objava, Ivana, Fimic, promovisanje projekta, Ivana, Fimic, false",
        "kreiranje objava, Ivana, Fimic, kreiranje objava, Dimitrije, Fimic, false",
        "kreiranje objava, Ivana, Fimic, kreiranje objava, Ivana, Siljkovic, false",
        "kreiranje objava, Ivana, Fimic, kreiranje objava, Dimitrije, Siljkovic, false",
        "kreiranje objava, Ivana, Fimic, promovisanje projekta, Dimitrije, Siljkovic, false",
        "kreiranje objava, Ivana, Fimic, promovisanje projekta, Ivana, Siljkovic, false",
        "kreiranje objava, Ivana, Fimic, promovisanje projekta, Dimitrije, Fimic, false",})

    void testEqualsObjectSveOk(String zadatak, String ime, String prezime,
            String zadatak1, String ime1, String prezime1,
            boolean eq) {

        st.setClan(new Clan());
        st.getClan().setIme(ime);
        st.getClan().setPrezime(prezime);
        st.setZadatak(new Zadatak());
        st.getZadatak().setNazivZadatka(zadatak);

        StatistikaZadatka st2 = new StatistikaZadatka();
        st2.setClan(new Clan());
        st2.getClan().setIme(ime1);
        st2.getClan().setPrezime(prezime1);
        st2.setZadatak(new Zadatak());
        st2.getZadatak().setNazivZadatka(zadatak1);

        assertEquals(eq, st.equals(st2));

    }

}
