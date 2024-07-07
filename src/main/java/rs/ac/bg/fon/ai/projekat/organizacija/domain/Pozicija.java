/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ivana
 */
public class Pozicija  extends AbstractDomainObject{
    private int IDPozicije;
    private String nazivPozicije;

    public Pozicija(int IDPozicije, String nazivPozicije) {
        this.IDPozicije = IDPozicije;
        this.nazivPozicije = nazivPozicije;
    }

    public Pozicija() {
    }

    public int getIDPozicije() {
        return IDPozicije;
    }

    public void setIDPozicije(int IDPozicije) {
        this.IDPozicije = IDPozicije;
    }

    public String getNazivPozicije() {
        return nazivPozicije;
    }

    public void setNazivPozicije(String nazivPozicije) {
        if (nazivPozicije == null) {
            throw new NullPointerException("Naziv pozicije ne sme biti null");
        }
        if (nazivPozicije == "") {
            throw new IllegalArgumentException("Naziv pozicije ne sme biti prazan");

        }
        this.nazivPozicije = nazivPozicije;
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
        final Pozicija other = (Pozicija) obj;
        if (this.IDPozicije != other.IDPozicije) {
            return false;
        }
        return Objects.equals(this.nazivPozicije, other.nazivPozicije);
    }

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
