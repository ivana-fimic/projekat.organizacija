/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

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
 * @author Ivana
 */
public class Tim extends AbstractDomainObject {

    private int IDTima;
    private String nazivTima;
    private int brojClanova;
    private Projekat projekat;
    private List<Pozicija> pozicije;
    private List<DetaljiPozicija> brojPozicija;
    Moodovi moodTabele;
    private String parametarZaPretragu;

  
  
   public Moodovi getMoodTabele() {
        return moodTabele;
    }

    public void setMoodTabele(Moodovi moodTabele) {
        this.moodTabele = moodTabele;
    }
    @Override
    public String toString() {
        return nazivTima + "-" + projekat.getNazivProjekta();
    }

    public String getParametarZaPretragu() {
        return parametarZaPretragu;
    }

    public void setParametarZaPretragu(String parametarZaPretragu) {
        this.parametarZaPretragu = parametarZaPretragu;
    }

    public List<DetaljiPozicija> getBrojPozicija() {
        return brojPozicija;
    }

    public void setBrojPozicija(List<DetaljiPozicija> brojPozicija) {
        this.brojPozicija = brojPozicija;
    }

    public List<Pozicija> getPozicije() {
        return pozicije;
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
        final Tim other = (Tim) obj;
        if (this.IDTima != other.IDTima) {
            return false;
        }
        if (this.brojClanova != other.brojClanova) {
            return false;
        }
        if (!Objects.equals(this.nazivTima, other.nazivTima)) {
            return false;
        }
        if (!Objects.equals(this.parametarZaPretragu, other.parametarZaPretragu)) {
            return false;
        }
        if (!Objects.equals(this.projekat, other.projekat)) {
            return false;
        }
        if (!Objects.equals(this.pozicije, other.pozicije)) {
            return false;
        }
        if (!Objects.equals(this.brojPozicija, other.brojPozicija)) {
            return false;
        }
        return this.moodTabele == other.moodTabele;
    }

    public Tim() {
    }

    public Tim(int IDTima, String nazivTima, int brojClanova, Projekat IDProjekta) {
        this.IDTima = IDTima;
        this.nazivTima = nazivTima;
        this.brojClanova = brojClanova;
        this.projekat = IDProjekta;
       
    }

    public void setPozicije(List<Pozicija> pozicije) {
        this.pozicije = pozicije;
    }

    public String getNazivTima() {
        return nazivTima;
    }

    public void setNazivTima(String nazivTima) {
        this.nazivTima = nazivTima;
    }

    public int getBrojClanova() {
        return brojClanova;
    }

    public void setBrojClanova(int brojClanova) {
        this.brojClanova = brojClanova;
    }

    public Projekat getIDProjekta() {
        return projekat;
    }

    public void setIDProjekta(Projekat IDProjekta) {
        this.projekat = IDProjekta;
    }

   

    public int getIDTima() {
        return IDTima;
    }

    public void setIDTima(int IDTima) {
        this.IDTima = IDTima;
    }

    @Override
    public String nazivTabele() {
        return " tim ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " JOIN detalji_pozicije dp ON (dp.IDTima = t.IDTima) "
                + "JOIN POZICIJA P ON (P.IDPozicije = dp.idPozicije) "+
                "JOIN projekat pr ON (t.IDProjekta= pr.IDProjekta) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        Map<Integer, List<DetaljiPozicija>> detaljiPoTimu = new HashMap<>();
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
            
            Tim t = new Tim(rs.getInt("t.IDTima"),
                    rs.getString("nazivTima"), rs.getInt("brojClanova"),pr);

            Pozicija p = new Pozicija(rs.getInt("IDPozicije"),
                    rs.getString("nazivPozicije"));
            DetaljiPozicija dp = new DetaljiPozicija(
                    t, p, rs.getInt("brojPozicija"));

            if (!detaljiPoTimu.containsKey(t.getIDTima())) {
                detaljiPoTimu.put(t.getIDTima(), new ArrayList<>());
            }

            detaljiPoTimu.get(t.getIDTima()).add(dp);
            List<DetaljiPozicija> detaljiZaTim = detaljiPoTimu.get(t.getIDTima());
            
                    
            t.setBrojPozicija(detaljiZaTim);
            lista.add(t);

        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivTima, brojClanova, IDProjekta) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivTima + "', " + brojClanova + " , "
                + projekat.getIDProjekta()+ " ";
    }

    @Override
    public String uslov() {
        return " t.IDTima = " + IDTima;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivTima = '" + nazivTima + "', IDProjekta = " + projekat.getIDProjekta()+ " "
                + "brojClanova = " + brojClanova + " ";
    }

    @Override
    public String uslovZaSelect() {
        if (parametarZaPretragu == null) {
            return "";
        }
        return " WHERE t.nazivTima LIKE " + "'" + getParametarZaPretragu() + "%' ";
    }

    @Override
    public void setAutoIncrementPrimaryKey(int generatedKey) {
        setIDTima(generatedKey);
    }

    @Override
    public AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException {
        Tim t = new Tim();
          Map<Integer, List<DetaljiPozicija>> detaljiPoTimu = new HashMap<>();
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
            t = new Tim(rs.getInt("IDTima"),
                    rs.getString("nazivTima"), rs.getInt("brojClanova"),
                    pr);
            Pozicija p = new Pozicija(rs.getInt("IDPozicije"),
                    rs.getString("nazivPozicije"));
            DetaljiPozicija dp = new DetaljiPozicija(
                    t, p, rs.getInt("brojPozicija"));

            if (!detaljiPoTimu.containsKey(t.getIDTima())) {
                detaljiPoTimu.put(t.getIDTima(), new ArrayList<>());
            }

            detaljiPoTimu.get(t.getIDTima()).add(dp);
            List<DetaljiPozicija> detaljiZaTim = detaljiPoTimu.get(t.getIDTima());
            
                    
            t.setBrojPozicija(detaljiZaTim);
            

        }

        rs.close();
        return t;
    }

    @Override
    public String uslovZaDelete() {
       return " IDTima = " + IDTima;
    }

}
