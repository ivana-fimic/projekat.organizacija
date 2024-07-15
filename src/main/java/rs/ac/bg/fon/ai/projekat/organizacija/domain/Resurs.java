/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import com.google.gson.annotations.Expose;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Predstavlja resurs koji se koristi u okviru tima za izvršavanje zadatka.
 * 
 * @author Ivana Fimic
 */
public class Resurs extends AbstractDomainObject {

    /**
     * Identifikacioni broj resursa.
     */
    private int IDResursa;

    /**
     * Naziv resursa kao int.
     */
    @Expose
    private String nazivResursa;

    /**
     * Količina resursa kao String.
     */
    @Expose
    private int kolicina;

    /**
     * Tim koji koristi resurs.
     */
    @Expose
    private Tim tim;

    /**
     * Pravi novi objekat klase Resurs sa zadatim vrednostima.
     * 
     * @param IDResursa identifikacioni broj resursa kao int
     * @param nazivResursa naziv resursa kao String
     * @param kolicina količina resursa kao int
     * @param tim tim koji koristi resurs kao Tim
     */
    public Resurs(int IDResursa, String nazivResursa, int kolicina, Tim tim) {
        this.IDResursa = IDResursa;
        this.nazivResursa = nazivResursa;
        this.kolicina = kolicina;
        this.tim = tim;
    }

    /**
     * Pravi novi objekat klase Resurs.
     * 
     * Polja ostaju neinicijalizovana.
     */
    public Resurs() {}

    /**
     * Vraća identifikacioni broj resursa.
     * 
     * @return identifikacioni broj resursa kao int
     */
    public int getIDResursa() {
        return IDResursa;
    }

    /**
     * Postavlja identifikacioni broj resursa na unetu vrednost.
     * 
     * @param IDResursa identifikacioni broj resursa kao int
     */
    public void setIDResursa(int IDResursa) {
        this.IDResursa = IDResursa;
    }

    /**
     * Vraća naziv resursa.
     * 
     * @return naziv resursa kao String
     */
    public String getNazivResursa() {
        return nazivResursa;
    }

    /**
     * Postavlja naziv resursa na unetu vrednost.
     * 
     * @param nazivResursa naziv resursa kao String
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti naziv resursa null
     * @throws java.lang.IllegalArgumentException
     * ako je uneti naziv resursa prazan
     */
    public void setNazivResursa(String nazivResursa) {
        if (nazivResursa == null) {
            throw new NullPointerException("Naziv resursa ne sme biti null");
        }
        if (nazivResursa.isEmpty()) {
            throw new IllegalArgumentException("Naziv resursa ne sme biti prazan");
        }
        this.nazivResursa = nazivResursa;
    }

    /**
     * Vraća količinu resursa.
     * 
     * @return količina resursa kao int
     */
    public int getKolicina() {
        return kolicina;
    }

    /**
     * Postavlja količinu resursa na unetu vrednost.
     * 
     * @param kolicina količina resursa kao int
     * 
     * @throws java.lang.IllegalArgumentException 
     * ako je uneta količina resursa manja od nule
     */
    public void setKolicina(int kolicina) {
        if (kolicina < 0) {
            throw new IllegalArgumentException("Kolicina ne sme biti negativna");
        }
        this.kolicina = kolicina;
    }

    /**
     * Vraća tim koji koristi resurs.
     * 
     * @return tim koji koristi resurs kao Tim
     */
    public Tim getTim() {
        return tim;
    }

    /**
     * Postavlja tim koji koristi resurs na unetu vrednost.
     * 
     * @param tim tim koji koristi resurs kao Tim
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti tim null
     */
    public void setTim(Tim tim) {
        if (tim == null) {
            throw new NullPointerException("Tim ne sme biti null");
        }
        this.tim = tim;
    }

    /**
     * Generiše string reprezentaciju objekta Resurs.
     * 
     * @return  naziv resursa kao String
     */
    @Override
    public String toString() {
        return nazivResursa;
    }

    /**
     * Poređenje dva objekta Resurs prema nazivu resursa.
     * 
     * @param obj Drugi objekat sa kojim se poredi
     * 
     * @return 
     * true-  ako su oba objekta inicijalizovana, klase su Resurs
     * i imaju iste vrednosti za naziv resursa 
     * false - ako nisu klase Resurs, ako je uneti resurs null ili ako
     * nije ista vrednost za naziv resursa 
     * 
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
        final Resurs other = (Resurs) obj;
        return Objects.equals(this.nazivResursa, other.nazivResursa);
    }
  

    @Override
    public String nazivTabele() {
        return " resurs ";
    }

    @Override
    public String alijas() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN TIM t ON (r.IDTima = t.IDTima) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Date sqlDatumPocetka = rs.getDate("pr.DatumPocetka");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumPocetka = formatter.format(sqlDatumPocetka);

            LocalDate localDatumPocetka = LocalDate.parse(formattedDatumPocetka);

            Date sqlDatumZavrsetka = rs.getDate("pr.DatumZavrsetka");
            SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumZavrsetka = formatter3.format(sqlDatumZavrsetka);
            LocalDate localDatumZavrsetka = LocalDate.parse(formattedDatumZavrsetka);

            Projekat pr = new Projekat(rs.getInt("IDProjekta"),
                    rs.getString("NazivProjekta"), rs.getString("VrstaProjekta"), localDatumPocetka, localDatumZavrsetka);
            Tim t = new Tim(rs.getInt("IDTima"),
                    rs.getString("nazivTima"), rs.getInt("brojClanova"),
                    pr);

            Resurs r = new Resurs(rs.getInt("IDResursa"), rs.getString("nazivResursa"), rs.getInt("kolicina"), tim);
            lista.add(r);
        }
        rs.close();

        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivResursa, kolicina,IDTima) ";

    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivResursa + "', " + kolicina + ", " + tim.getIDTima();
    }

    @Override
    public String uslov() {
        return " r.IDResursa = " + IDResursa;
    }

    @Override
    public String uslovZaDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }

    @Override
    public AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(int generatedKey) {
        setIDResursa(IDResursa);
    }

}
