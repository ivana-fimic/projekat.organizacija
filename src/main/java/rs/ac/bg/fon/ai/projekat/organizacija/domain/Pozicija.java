/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import com.google.gson.annotations.Expose;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Predstavlja poziciju unutar tima sa IDPozicije i nazivom
 *
 * @autor Ivana Fimic
 */
public class Pozicija extends AbstractDomainObject {

    /**
     * ID pozicije tipa int.
     */
    @Expose(serialize = false)

    private int IDPozicije;

    /**
     * Naziv pozicije tipa String.
     */
    @Expose
    private String nazivPozicije;

    /**
     * Pravi nov objekat klase Pozicija sa zadatim vrednostima.
     *
     * @param IDPozicije ID pozicije kao int
     * @param nazivPozicije naziv pozicije kao String
     */
    public Pozicija(int IDPozicije, String nazivPozicije) {
        this.IDPozicije = IDPozicije;
        this.nazivPozicije = nazivPozicije;
    }

    /**
     * Pravi nov objekat klase Pozicija.
     *
     * Polja ostaju neinicijalizovana.
     */
    public Pozicija() {
    }

    /**
     * Vraca ID pozicije.
     *
     * @return ID pozicije kao int
     */
    public int getIDPozicije() {
        return IDPozicije;
    }

    /**
     * Postavlja ID pozicije na unetu vrednost.
     *
     * @param IDPozicije ID pozicije kao int
     */
    public void setIDPozicije(int IDPozicije) {
        this.IDPozicije = IDPozicije;
    }

    /**
     * Vraca naziv pozicije.
     *
     * @return naziv pozicije kao String
     */
    public String getNazivPozicije() {
        return nazivPozicije;
    }

    /**
     * Postavlja naziv pozicije na unetu vrednost.
     *
     * Uneti naziv ne sme biti null i ne sme biti prazan string.
     *
     * @param nazivPozicije naziv pozicije kao String
     *
     * @throws java.lang.NullPointerException ako je uneti naziv null
     * @throws java.lang.IllegalArgumentException ako je uneti naziv prazan
     * string
     */
    public void setNazivPozicije(String nazivPozicije) {
        if (nazivPozicije == null) {
            throw new NullPointerException("Naziv pozicije ne sme biti null");
        }
        if (nazivPozicije.isEmpty()) {
            throw new IllegalArgumentException("Naziv pozicije ne sme biti prazan");
        }
        this.nazivPozicije = nazivPozicije;
    }

    /**
     * Proverava da li su dva objekta jednaka prema nazivu pozicije.
     *
     * @param obj objekat sa kojim se poredi
     * @return true ako oba objekta imaju isti naziv pozicije, false u suprotnom
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
        final Pozicija other = (Pozicija) obj;
        return Objects.equals(this.nazivPozicije, other.nazivPozicije);
    }

    /**
     * Generiše string reprezentaciju objekta Pozicija.
     *
     * @return naziv pozicije kao String
     */
    @Override
    public String toString() {
        return nazivPozicije;
    }

    @Override
    public String nazivTabele() {
        return " pozicija ";
    }

    @Override
    public String alijas() {
        return " P ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Pozicija p = new Pozicija(rs.getInt("IDPozicije"),
                    rs.getString("nazivPozicije"));

            lista.add(p);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslov() {
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
    public void setAutoIncrementPrimaryKey(int generatedKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslovZaDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
