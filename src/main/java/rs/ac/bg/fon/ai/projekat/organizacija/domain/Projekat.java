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
public class Projekat extends AbstractDomainObject {

    int IDProjekta;
    String NazivProjekta;
    String VrstaProjekta;
    LocalDate DatumPocetka;
    LocalDate DatumZavrsetka;

    public Projekat(int IDProjekta, String NazivProjekta, String VrstaProjekta, LocalDate DatumPocetka, LocalDate DatumZavrsetka) {
        this.IDProjekta = IDProjekta;
        this.NazivProjekta = NazivProjekta;
        this.VrstaProjekta = VrstaProjekta;
        this.DatumPocetka = DatumPocetka;
        this.DatumZavrsetka = DatumZavrsetka;
    }

    public Projekat() {
    }

    public int getIDProjekta() {
        return IDProjekta;
    }

    public void setIDProjekta(int IDProjekta) {
        this.IDProjekta = IDProjekta;
    }

    public String getNazivProjekta() {
        return NazivProjekta;
    }

    public void setNazivProjekta(String NazivProjekta) {
        if (NazivProjekta == null) {
            throw new NullPointerException("Naziv projekta ne sme biti null");
        }
        if (NazivProjekta.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Naziv projekta ne sme imati brojeve");

        }
        if (!(NazivProjekta.equals(NazivProjekta.toUpperCase()))) {

            throw new IllegalArgumentException("Naziv projekta ne sme imati mala slova");
        }
        this.NazivProjekta = NazivProjekta;
    }

    public String getVrstaProjekta() {
        return VrstaProjekta;
    }

    public void setVrstaProjekta(String VrstaProjekta) {
        if (VrstaProjekta == null) {
            throw new NullPointerException("Vrsta projekta ne sme biti null");
        }
        if (VrstaProjekta.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Vrsta projekta ne sme imati brojeve");

        }

        
        this.VrstaProjekta = VrstaProjekta;
    }

    public LocalDate getDatumPocetka() {
        return DatumPocetka;
    }

    public void setDatumPocetka(LocalDate DatumPocetka) {
        if (DatumPocetka == null) {
            throw new NullPointerException("Datum pocetka projekta ne sme biti null");

        }
        this.DatumPocetka = DatumPocetka;
    }

    public LocalDate getDatumZavrsetka() {
        return DatumZavrsetka;
    }

    public void setDatumZavrsetka(LocalDate DatumZavrsetka) {
        if (DatumZavrsetka == null) {
            throw new NullPointerException("Datum zavrsetka projekta ne sme biti null");

        }
        this.DatumZavrsetka = DatumZavrsetka;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Projekat other = (Projekat) obj;
        if (this.IDProjekta != other.IDProjekta) {
            return false;
        }
        if (!Objects.equals(this.NazivProjekta, other.NazivProjekta)) {
            return false;
        }
        if (!Objects.equals(this.VrstaProjekta, other.VrstaProjekta)) {
            return false;
        }
        if (!Objects.equals(this.DatumPocetka, other.DatumPocetka)) {
            return false;
        }
        return Objects.equals(this.DatumZavrsetka, other.DatumZavrsetka);
    }

    @Override
    public String nazivTabele() {
        return " projekat ";

    }

    @Override
    public String alijas() {
        return " pr ";

    }

    @Override
    public String join() {
        return "";
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

            lista.add(pr);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivProjekta, VrstaProjekta,DatumPocetka,DatumZavrsetka) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + NazivProjekta + "', '" + VrstaProjekta + "', " + "'" + DatumPocetka + "', " + "'" + DatumZavrsetka + "' ";
    }

    @Override
    public String uslov() {
        return " pr.IDProjekta = " + IDProjekta;
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
        setIDProjekta(generatedKey);
    }

    @Override
    public String toString() {
        return NazivProjekta;
    }

}
