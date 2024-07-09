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
 * Predstavlja detalje o poziciji unutar tima koja nam govori koliko pozicija ima u kom timu
 * 
 * @autor Ivana
 */
public class DetaljiPozicija extends AbstractDomainObject {

    /**
     * Tim kojem pripada pozicija.
     */
    private Tim tim;

    /**
     * Pozicija unutar tima.
     */
    private Pozicija pozicija;

    /**
     * Broj pozicija u timu tipa int.
     */
    private int brojPozicija;

    /**
     * Pravi nov objekat klase DetaljiPozicija sa zadatim vrednostima.
     * 
     * @param tim tim kojem pripada pozicija kao Tim
     * @param pozicija pozicija unutar tima kao Pozicija
     * @param brojPozicija broj pozicija kao int
     */
    public DetaljiPozicija(Tim tim, Pozicija pozicija, int brojPozicija) {
        this.tim = tim;
        this.pozicija = pozicija;
        this.brojPozicija = brojPozicija;
    }

    /**
     * Pravi nov objekat klase DetaljiPozicija.
     * 
     * Polja ostaju neinicijalizovana.
     */
    public DetaljiPozicija() {
    }

    /**
     * Vraca tim kojem pripada pozicija.
     * 
     * @return tim kojem pripada pozicija kao Tim
     */
    public Tim getTim() {
        return tim;
    }

    /**
     * Postavlja tim kojem pripada pozicija na unetu vrednost.
     * 
     * Uneti tim ne sme biti null.
     * 
     * @param tim tim kojem pripada pozicija kao Tim
     * 
     * @throws java.lang.NullPointerException ako je uneti tim null
     */
    public void setTim(Tim tim) {
        if (tim == null) {
            throw new NullPointerException("Tim ne sme biti null");
        }
        this.tim = tim;
    }

    /**
     * Vraca poziciju unutar tima.
     * 
     * @return pozicija unutar tima kao Pozicija
     */
    public Pozicija getPozicija() {
        return pozicija;
    }

    /**
     * Postavlja poziciju unutar tima na unetu vrednost.
     * 
     * Uneta pozicija ne sme biti null.
     * 
     * @param pozicija pozicija unutar tima kao Pozicija
     * 
     * @throws java.lang.NullPointerException ako je uneta pozicija null
     */
    public void setPozicija(Pozicija pozicija) {
        if (pozicija == null) {
            throw new NullPointerException("Pozicija ne sme biti null");
        }
        this.pozicija = pozicija;
    }

    /**
     * Vraca broj pozicija.
     * 
     * @return broj pozicija kao int
     */
    public int getBrojPozicija() {
        return brojPozicija;
    }

    /**
     * Postavlja broj pozicija na unetu vrednost.
     * 
     * Uneti broj ne sme biti negativan.
     * 
     * @param brojPozicija broj pozicija kao int
     * 
     * @throws java.lang.IllegalArgumentException ako je uneti broj negativan
     */
    public void setBrojPozicija(int brojPozicija) {
        if (brojPozicija < 0) {
            throw new IllegalArgumentException("Broj pozicija ne sme biti negativan");
        }
        this.brojPozicija = brojPozicija;
    }

    /**
     * Vraća string reprezentaciju objekta DetaljiPozicija.
     * 
     * @return naziv tima, naziv pozicije i broj pozicija kao String
     */
    @Override
    public String toString() {
        return tim.getNazivTima() + " " + pozicija.getNazivPozicije() + " " + brojPozicija;
    }

    /**
     * Proverava da li su dva objekta jednaka prema timu i poziciji.
     * 
     * @param obj objekat sa kojim se poredi
     * @return true ako oba objekta imaju isti tim i istu poziciju, 
     * false u suprotnom
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
        final DetaljiPozicija other = (DetaljiPozicija) obj;
        if (!Objects.equals(this.tim, other.tim)) {
            return false;
        }
        return Objects.equals(this.pozicija, other.pozicija);
    }

 
    @Override
    public String nazivTabele() {
         return " detalji_pozicije ";
    }

    @Override
    public String alijas() {
       return " dp ";
    }

    @Override
    public String join() {
      return " JOIN TIM T ON (T.IDTima = DP.idTima) "
                + "JOIN POZICIJA P ON (P.IDPozicije = DP.idPozicije) "+
                "JOIN projekat pr ON (t.IDProjekta= pr.IDProjekta) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
       ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Pozicija p=new Pozicija(rs.getInt("idPozicije"),rs.getString("nazivPozicije"));
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
            DetaljiPozicija dp = new DetaljiPozicija(
                   t,p,rs.getInt("brojPozicija"));

            lista.add(dp);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
      return " (idTima, brojPozicija, idPozicije) ";
    }

    @Override
    public String vrednostiZaInsert() {
     return  tim.getIDTima() + ", " + brojPozicija + " , "
                + pozicija.getIDPozicije();
             
    }

    @Override
    public String uslov() {
      return " dp.idTima = " +tim.getIDTima()+" AND"+ " dp.idPozicije = " +pozicija.getIDPozicije();
    }

    @Override
    public String vrednostiZaUpdate() {
       return " idTima= " +tim.getIDTima()+ ", idPozicije  = " + pozicija.getIDPozicije()
                + ", brojPozicija = " + brojPozicija;
    }

    @Override
    public String uslovZaSelect() {
     return " WHERE t.IDTima = " +tim.getIDTima();
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
         return " idTima = " +tim.getIDTima();
    }
    
}
