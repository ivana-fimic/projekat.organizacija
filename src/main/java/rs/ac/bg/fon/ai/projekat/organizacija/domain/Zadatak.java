/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import com.google.gson.annotations.Expose;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.Moodovi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



/**
 * 
 *Predstavlja Zadatak koji je dodeljen timu i clanu unutar tima za koga se beleze statistike
 * @author Ivana
 */
public class Zadatak extends AbstractDomainObject {

    /**
     * ID zadatka kao int
     */
    private int IDZadatka;
     /**
     * Naziv zadatka kao int
     */
    private String NazivZadatka;
     /**
     * Tim kojem je dodeljen zadatak.
     */
    private Tim tim;
    /**
     * Lista statistika za zadatak.
     */
    private List<StatistikaZadatka> statistika;
    /**
     * Pomocna promenljiva za parametar pretrage na formi
     */
    private String parametarZaPretragu;
    /**
     * Pomocna promenljiva za parametar pretrage na formi
     */
    private Moodovi moodTabele;
    /**
     * Pravi nov objekat klase Zadatak sa zadatim vrednostima.
     * 
     * @param IDZadatka ID zadatka kao int
     * @param NazivZadatka naziv zadatka kao String
     * @param tim tim kojem je zadatak dodeljen kao Tim
     */
    public Zadatak(int IDZadatka, String NazivZadatka, Tim tim) {
        this.IDZadatka = IDZadatka;
        this.NazivZadatka = NazivZadatka;
        this.tim = tim;
    }
     /**
     * Pravi nov objekat klase Zadatak.
     * 
     * Polja ostaju neinicijalizovana.
     */
    public Zadatak() {
    }
    /**
     * Vraca ID zadatka.
     * 
     * @return ID zadatka kao int
     */
     public int getIDZadatka() {
        return IDZadatka;
    }
    
      /**
     * Postavlja ID zadatka na unetu vrednost.
     * 
     * @param IDZadatka ID zadatka kao int
     */
    public void setIDZadatka(int IDZadatka) {
        this.IDZadatka = IDZadatka;
    }
     /**
     * Vraca naziv zadatka.
     * 
     * @return naziv zadatka kao String
     */
     public String getNazivZadatka() {
        return NazivZadatka;
    }
 /**
     * Postavlja naziv zadatka na unetu vrednost.
     * 
     * Uneti naziv ne sme biti null i ne sme sadržati brojeve.
     * 
     * @param NazivZadatka naziv zadatka kao String
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti naziv null
     * @throws java.lang.IllegalArgumentException
     *  ako uneti naziv sadrži brojeve
     */
    public void setNazivZadatka(String NazivZadatka) {
        if(NazivZadatka==null){
            throw new NullPointerException("Naziv zadatka ne sme biti null");
        }
            
        
        if (NazivZadatka.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Naziv zadatka ne sme imati brojeve");

        }
        this.NazivZadatka = NazivZadatka;
    }
     /**
     * Vraca tim kojem je zadatak dodeljen.
     * 
     * @return tim kao Tim
     */

    public Tim getTim() {
        return tim;
    }
/**
     * Postavlja tim kojem je zadatak dodeljen na unetu vrednost.
     * 
     * Uneti tim ne sme biti null.
     * 
     * @param tim tim kao Tim
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti tim null
     */
    public void setTim(Tim tim) {
       
        
        this.tim = tim;
    }
     /**
     * Vraca listu statistika zadatka.
     * 
     * @return lista statistika kao List<StatistikaZadatka>
     */
      public List<StatistikaZadatka> getStatistika() {
        return statistika;
    }
/**
     * Postavlja listu statistika zadatka na unetu vrednost.
     * 
     * @param statistika lista statistika kao List<StatistikaZadatka>
     */
    public void setStatistika(List<StatistikaZadatka> statistika) {
        this.statistika = statistika;
    }
    /**
     * Vraca parametar za pretragu zadatka.
     * 
     * @return parametar za pretragu kao String
     */

    public String getParametarZaPretragu() {
        return parametarZaPretragu;
    }
 /**
     * Postavlja parametar za pretragu zadatka na unetu vrednost.
     * 
     * @param parametarZaPretragu parametar za pretragu kao String
     */
    public void setParametarZaPretragu(String parametarZaPretragu) {
        this.parametarZaPretragu = parametarZaPretragu;
    }
 /**
     * Vraca trenutni mood tabele zadatka.
     * 
     * @return mood tabele kao Moodovi
     */
    public Moodovi getMoodTabele() {
        return moodTabele;
    }
 /**
     * Postavlja mood tabele zadatka na unetu vrednost.
     * 
     * @param moodTabele mood tabele kao Moodovi
     */
    public void setMoodTabele(Moodovi moodTabele) {
        this.moodTabele = moodTabele;
    }
 /**
     * Vraća string reprezentaciju objekta Zadatak.
     * 
     * @return naziv zadatka kao String
     */
    @Override
    public String toString() {
        return NazivZadatka  ;
    }
    /**
     * Poredi dva zadatka prema nazivu.
     * 
     * @param obj Drugi zadatak sa kojim se poredi
     * 
     * @return 
     * true -  ako su oba objekta inicijalizovana, klase su Zadatak
     * i imaju isti naziv 
     * false - ako nisu klase Zadatak, ako je uneti zadatak null ili ako
     * nije isti naziv 
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zadatak other = (Zadatak) obj;
        return Objects.equals(this.NazivZadatka, other.NazivZadatka);
    }

    @Override
    public String nazivTabele() {
        return " zadatak ";
    }

    @Override
    public String alijas() {
        return " z ";
    }

    @Override
    public String join() {
        return " JOIN TIM t ON (z.IDTima = t.IDTima) "
                + " JOIN statistika_zadataka sz ON (z.IDZadatka = sz.IDZadatka) "
                + " JOIN CLAN c ON (c.IDClana = sz.IDClana) "
                + " JOIN POZICIJA P ON (P.IDPozicije = c.IDPozicije) "+
                "JOIN projekat pr ON (t.IDProjekta= pr.IDProjekta) ";

    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        Map<Integer, List<StatistikaZadatka>> statistikaPoZadatku = new HashMap<>();
        while (rs.next()) {
            Date sqlDatumPocetka = rs.getDate("pr.DatumPocetka");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumPocetka = formatter.format(sqlDatumPocetka);

            LocalDate localDatumPocetka = LocalDate.parse(formattedDatumPocetka);

            Date sqlDatumZavrsetka = rs.getDate("pr.DatumZavrsetka");
            SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumZavrsetka= formatter3.format(sqlDatumZavrsetka);
            LocalDate localDatumZavrsetka = LocalDate.parse(formattedDatumZavrsetka);
            
            Projekat pr = new Projekat(rs.getInt("IDProjekta"),
                    rs.getString("NazivProjekta"), rs.getString("VrstaProjekta"),localDatumPocetka,localDatumZavrsetka);
            Tim t = new Tim(rs.getInt("IDTima"),
                    rs.getString("nazivTima"), rs.getInt("brojClanova"),
                    pr);

            Zadatak zad = new Zadatak(rs.getInt("z.IDZadatka"),
                    rs.getString("nazivZadatka"), t);

            Pozicija p = new Pozicija(rs.getInt("p.IDPozicije"),
                    rs.getString("p.nazivPozicije"));

            //System.out.println(p.getNazivPozicije());
            Clan c = new Clan(rs.getInt("c.IDClana"), rs.getString("c.Ime"),
                    rs.getString("c.Prezime"), rs.getInt("c.GodStudija"), p, t,
                    rs.getString("c.Fakultet"));
            //System.out.println(c.getIme());

            Date sqlDatumDodele = rs.getDate("sz.DatumDodele");
            String formattedDatumDodele = formatter.format(sqlDatumDodele);

            LocalDate localDatumDodele = LocalDate.parse(formattedDatumDodele);

            Date sqlKrajnjiRok = rs.getDate("sz.KranjiRok");
            String formattedKrajnjiRok = formatter3.format(sqlKrajnjiRok);
            LocalDate localKrajnjiRok = LocalDate.parse(formattedKrajnjiRok);

            FazaZadatka faza = FazaZadatka.valueOf(rs.getString("sz.FazaZadatka"));
            StatistikaZadatka sz = new StatistikaZadatka();
            sz.setClan(c);
            sz.setZadatak(zad);
            sz.setDatumDodele(localDatumDodele);
            sz.setKrajnjiRok(localKrajnjiRok);
            sz.setFazaZadatka(faza);

            if (!statistikaPoZadatku.containsKey(zad.IDZadatka)) {
                statistikaPoZadatku.put(zad.IDZadatka, new ArrayList<>());
            }

            statistikaPoZadatku.get(zad.IDZadatka).add(sz);
            List<StatistikaZadatka> statZaZad = statistikaPoZadatku.get(zad.IDZadatka);

            zad.setStatistika(statZaZad);

            lista.add(zad);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivZadatka, IDTima) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + NazivZadatka + "', " + tim.getIDTima();
    }

    @Override
    public String uslov() {
        return " z.IDZadatka = " + IDZadatka;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivZadatka = '" + NazivZadatka
                + "', IDTima = " + tim.getIDTima() + " ";
    }

    @Override
    public String uslovZaSelect() {
        if (getParametarZaPretragu().equals("")) {
            return "";
        }
        return " WHERE z.nazivZadatka LIKE  " + "'%" + getParametarZaPretragu() + "%' ";
    }

    @Override
    public void setAutoIncrementPrimaryKey(int generatedKey) {
        setIDZadatka(generatedKey);
    }

    @Override
    public AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException {
        Zadatak zad = new Zadatak();
        Map<Integer, List<StatistikaZadatka>> statistikaPoZadatku = new HashMap<>();
        while (rs.next()) {
            Date sqlDatumPocetka = rs.getDate("pr.DatumPocetka");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumPocetka = formatter.format(sqlDatumPocetka);

            LocalDate localDatumPocetka = LocalDate.parse(formattedDatumPocetka);

            Date sqlDatumZavrsetka = rs.getDate("pr.DatumZavrsetka");
            SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumZavrsetka= formatter3.format(sqlDatumZavrsetka);
            LocalDate localDatumZavrsetka = LocalDate.parse(formattedDatumZavrsetka);
            
             Projekat pr = new Projekat(rs.getInt("IDProjekta"),
                    rs.getString("NazivProjekta"), rs.getString("VrstaProjekta"),localDatumPocetka,localDatumZavrsetka);
            Tim t = new Tim(rs.getInt("IDTima"),
                    rs.getString("nazivTima"), rs.getInt("brojClanova"),
                    pr);

            zad = new Zadatak(rs.getInt("z.IDZadatka"),
                    rs.getString("nazivZadatka"), t);
            Pozicija p = new Pozicija(rs.getInt("p.IDPozicije"),
                    rs.getString("p.nazivPozicije"));

            //System.out.println(p.getNazivPozicije());
            Clan c = new Clan(rs.getInt("c.IDClana"), rs.getString("c.Ime"),
                    rs.getString("c.Prezime"), rs.getInt("c.GodStudija"), p, t,
                    rs.getString("c.Fakultet"));
            //System.out.println(c.getIme());

            Date sqlDatumDodele = rs.getDate("sz.DatumDodele");
            String formattedDatumDodele = formatter.format(sqlDatumDodele);

            LocalDate localDatumDodele = LocalDate.parse(formattedDatumDodele);

            Date sqlKrajnjiRok = rs.getDate("sz.KranjiRok");
            String formattedKrajnjiRok = formatter3.format(sqlKrajnjiRok);
            LocalDate localKrajnjiRok = LocalDate.parse(formattedKrajnjiRok);

            FazaZadatka faza = FazaZadatka.valueOf(rs.getString("sz.FazaZadatka"));
            StatistikaZadatka sz = new StatistikaZadatka();
            sz.setClan(c);
            sz.setZadatak(zad);
            sz.setDatumDodele(localDatumDodele);
            sz.setKrajnjiRok(localKrajnjiRok);
            sz.setFazaZadatka(faza);

            if (!statistikaPoZadatku.containsKey(zad.IDZadatka)) {
                statistikaPoZadatku.put(zad.IDZadatka, new ArrayList<>());
            }

            statistikaPoZadatku.get(zad.IDZadatka).add(sz);
            List<StatistikaZadatka> statZaZad = statistikaPoZadatku.get(zad.IDZadatka);

            zad.setStatistika(statZaZad);

        }

        rs.close();
        return zad;
    }

    @Override
    public String uslovZaDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
