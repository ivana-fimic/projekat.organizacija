/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Ivana
 */
public class Resurs extends AbstractDomainObject {

    private int IDResursa;
    private String nazivResursa;
    private int kolicina;
    private Tim tim;

    public Resurs(int IDResursa, String nazivResursa, int kolicina, Tim tim) {
        this.IDResursa = IDResursa;
        this.nazivResursa = nazivResursa;
        this.kolicina = kolicina;
        this.tim = tim;
    }

    public Resurs() {
    }

    public int getIDResursa() {
        return IDResursa;
    }

    public void setIDResursa(int IDResursa) {
        this.IDResursa = IDResursa;
    }

    public String getNazivResursa() {
        return nazivResursa;
    }

    public void setNazivResursa(String nazivResursa) {
        if (nazivResursa == null) {
            throw new NullPointerException("Naziv resursa ne sme biti null");
        }
        if (nazivResursa == "") {
            throw new IllegalArgumentException("Naziv resursa ne sme biti prazan");

        }
        this.nazivResursa = nazivResursa;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        if (kolicina < 0) {
            throw new IllegalArgumentException("Kolicina ne sme biti negativna");
        }
        this.kolicina = kolicina;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        if (tim == null) {
            throw new NullPointerException("Tim ne sme biti null");
        }
        this.tim = tim;
    }

    @Override
    public String toString() {
        return nazivResursa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

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
        if (this.IDResursa != other.IDResursa) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        if (!Objects.equals(this.nazivResursa, other.nazivResursa)) {
            return false;
        }
        return Objects.equals(this.tim, other.tim);
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
