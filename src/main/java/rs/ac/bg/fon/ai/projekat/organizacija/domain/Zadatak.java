/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

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
 * @author Ivana
 */
public class Zadatak extends AbstractDomainObject {

    private int IDZadatka;
    private String NazivZadatka;
    private Tim tim;
    private List<StatistikaZadatka> statistika;
    private String parametarZaPretragu;
    private Moodovi moodTabele;

    public Zadatak(int IDZadatka, String NazivZadatka, Tim tim) {
        this.IDZadatka = IDZadatka;
        this.NazivZadatka = NazivZadatka;
        this.tim = tim;
    }

    public Zadatak() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IDZadatka;
        hash = 97 * hash + Objects.hashCode(this.NazivZadatka);
        hash = 97 * hash + Objects.hashCode(this.tim);
        return hash;
    }

    public String getParametarZaPretragu() {
        return parametarZaPretragu;
    }

    public void setParametarZaPretragu(String parametarZaPretragu) {
        this.parametarZaPretragu = parametarZaPretragu;
    }

    public Moodovi getMoodTabele() {
        return moodTabele;
    }

    public void setMoodTabele(Moodovi moodTabele) {
        this.moodTabele = moodTabele;
    }

    @Override
    public String toString() {
        return NazivZadatka  ;
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
        final Zadatak other = (Zadatak) obj;
        if (this.IDZadatka != other.IDZadatka) {
            return false;
        }
        if (!Objects.equals(this.NazivZadatka, other.NazivZadatka)) {
            return false;
        }
        return Objects.equals(this.tim, other.tim);
    }

    public int getIDZadatka() {
        return IDZadatka;
    }

    public void setIDZadatka(int IDZadatka) {
        this.IDZadatka = IDZadatka;
    }

    public List<StatistikaZadatka> getStatistika() {
        return statistika;
    }

    public void setStatistika(List<StatistikaZadatka> statistika) {
        this.statistika = statistika;
    }

    public String getNazivZadatka() {
        return NazivZadatka;
    }

    public void setNazivZadatka(String NazivZadatka) {
        if(NazivZadatka==null){
            throw new NullPointerException("Naziv zadatka ne sme biti null");
        }
            
        
        if (NazivZadatka.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Naziv zadatka ne sme imati brojeve");

        }
        this.NazivZadatka = NazivZadatka;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        if(tim==null){
            throw new NullPointerException("Tim ne sme biti null");
        }
        this.tim = tim;
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
