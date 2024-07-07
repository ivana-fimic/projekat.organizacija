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
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ivana
 */
public class Clan extends AbstractDomainObject {

    private int IDClana;
    private String Ime;
    private String Prezime;
    private int GodStudija;
    private Pozicija pozicija;
    private Tim tim;
    private String Fakultet;
    private String parametarZaPretragu;
    private String username;
    private String password;
    private List<StatistikaZadatka> statistikaZad;

    public Clan(int IDClana, String Ime, String Prezime, int GodStudija, Pozicija pozicija, Tim tim, String Fakultet) {
        this.IDClana = IDClana;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.GodStudija = GodStudija;
        this.pozicija = pozicija;
        this.tim = tim;
        this.Fakultet = Fakultet;
    }

    public Clan() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.IDClana;
        hash = 73 * hash + Objects.hashCode(this.Ime);
        hash = 73 * hash + Objects.hashCode(this.Prezime);
        hash = 73 * hash + this.GodStudija;
        hash = 73 * hash + Objects.hashCode(this.pozicija);
        hash = 73 * hash + Objects.hashCode(this.tim);
        return hash;
    }

    @Override
    public String toString() {
        return Ime + " " + Prezime;
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
        final Clan other = (Clan) obj;
        if (this.IDClana != other.IDClana) {
            return false;
        }
        if (this.GodStudija != other.GodStudija) {
            return false;
        }
        if (!Objects.equals(this.Ime, other.Ime)) {
            return false;
        }
        if (!Objects.equals(this.Prezime, other.Prezime)) {
            return false;
        }
        if (!Objects.equals(this.pozicija, other.pozicija)) {
            return false;
        }
        return Objects.equals(this.tim, other.tim);
    }

    public List<StatistikaZadatka> getStatistikaZad() {
        return statistikaZad;
    }

    public void setStatistikaZad(List<StatistikaZadatka> statistikaZad) {
        this.statistikaZad = statistikaZad;
    }

    public int getIDClana() {
        return IDClana;
    }

    public void setIDClana(int IDClana) {
        this.IDClana = IDClana;
    }

    public String getFakultet() {
        return Fakultet;
    }

    public void setFakultet(String Fakultet) {
        if (Fakultet == null) {
            throw new NullPointerException("Fakultet ne sme biti null");
        }
        if (Fakultet.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Fakultet ne sme imati brojeve");
        }

        if (Character.isLowerCase(Fakultet.charAt(0))) {
            throw new IllegalArgumentException("Fakultet ne sme imati malo pocetno slovo");
        }
        this.Fakultet = Fakultet;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        if (Ime == null) {
            throw new NullPointerException("Ime ne sme biti null");
        }
        if (Ime.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Ime ne sme imati brojeve");
        }

        if (Character.isLowerCase(Ime.charAt(0))) {
            throw new IllegalArgumentException("Ime ne sme imati malo pocetno slovo");
        }
        this.Ime = Ime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String Prezime) {
        if (Prezime == null) {
            throw new NullPointerException("Prezime ne sme biti null");
        }
        if (Prezime.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Prezime ne sme imati brojeve");
        }

        if (Character.isLowerCase(Prezime.charAt(0))) {
            throw new IllegalArgumentException("Prezime ne sme imati malo pocetno slovo");
        }
        this.Prezime = Prezime;
    }

    public int getGodStudija() {
        return GodStudija;
    }

    public void setGodStudija(int GodStudija) {
        if (GodStudija < 1 || GodStudija > 4) {
            throw new IllegalArgumentException("Godina studija mora biti izmedju 1 i 4");
        }
        this.GodStudija = GodStudija;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        if (pozicija == null) {
            throw new NullPointerException("Pozicija ne sme biti null");
        }

        this.pozicija = pozicija;
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

    public String getParametarZaPretragu() {
        return parametarZaPretragu;
    }

    public void setParametarZaPretragu(String parametarZaPretragu) {
        this.parametarZaPretragu = parametarZaPretragu;
    }

    @Override
    public String nazivTabele() {
        return " clan ";
    }

    @Override
    public String alijas() {
        return " c ";
    }

    @Override
    public String join() {
        return " JOIN TIM t ON (c.IDTima = t.IDTima) "
                + "JOIN POZICIJA P ON (P.IDPozicije = c.IDPozicije) "
                + "JOIN projekat pr ON (t.IDProjekta= pr.IDProjekta) ";

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
            Pozicija p = new Pozicija(rs.getInt("IDPozicije"),
                    rs.getString("nazivPozicije"));

            Clan c = new Clan(rs.getInt("c.IDClana"), rs.getString("Ime"),
                    rs.getString("Prezime"), rs.getInt("GodStudija"), p, t,
                    rs.getString("Fakultet"));

            c.setUsername(rs.getString("username"));
            c.setPassword(rs.getString("password"));

            lista.add(c);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, GodStudija, IDTima, IDPozicije, Fakultet) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + Ime + "', '" + Prezime + "', "
                + " " + GodStudija + ", '" + tim.getIDTima() + "', '" + pozicija.getIDPozicije() + "', ' "
                + Fakultet + "'";
    }

    @Override
    public String uslov() {
        return " c.IDClana = " + IDClana;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + Ime + "', Prezime = '" + Prezime + "', "
                + "GodStudija = " + GodStudija + ", IDTima = " + tim.getIDTima() + " ,IDPozicije = " + pozicija.getIDPozicije()
                + ", Fakultet = '" + Fakultet + "', username='" + username + " ', password = '" + password + " ' ";

    }

    @Override
    public String uslovZaSelect() {
        if (getParametarZaPretragu().equals("")) {
            if (tim != null) {
                return " WHERE c.IDTima = " + tim.getIDTima();
            }
            return "";
        }

        if (getParametarZaPretragu().matches(".*\\s\\S.*")) {
            String[] delovi = getParametarZaPretragu().split(" ", 2);

            String ime = delovi[0];
            String prezime = delovi[1];
            System.out.println(prezime);
            return " WHERE c.Ime LIKE " + "'" + ime + "%' AND  c.Prezime LIKE " + "'" + prezime + "%' ";
        }
        return " WHERE c.Ime LIKE " + "'" + getParametarZaPretragu() + "%' OR  c.Prezime LIKE " + "'" + getParametarZaPretragu() + "%' ";
    }

    @Override
    public void setAutoIncrementPrimaryKey(int generatedKey) {
        setIDClana(generatedKey);
    }

    @Override
    public AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException {

        Clan c = new Clan();
        while (rs.next()) {
            Date sqlDatumPocetka = rs.getDate("p.DatumPocetka");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumPocetka = formatter.format(sqlDatumPocetka);

            LocalDate localDatumPocetka = LocalDate.parse(formattedDatumPocetka);

            Date sqlDatumZavrsetka = rs.getDate("p.DatumZavrsetka");
            SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumZavrsetka = formatter3.format(sqlDatumZavrsetka);
            LocalDate localDatumZavrsetka = LocalDate.parse(formattedDatumZavrsetka);

            Projekat pr = new Projekat(rs.getInt("IDProjekta"),
                    rs.getString("NazivProjekta"), rs.getString("VrstaProjekta"), localDatumPocetka, localDatumZavrsetka);
            Tim t = new Tim(rs.getInt("IDTima"),
                    rs.getString("nazivTima"), rs.getInt("brojClanova"),
                    pr);
            Pozicija p = new Pozicija(rs.getInt("IDPozicije"),
                    rs.getString("nazivPozicije"));

            c = new Clan(rs.getInt("IDClana"), rs.getString("Ime"),
                    rs.getString("Prezime"), rs.getInt("GodStudija"), p, t,
                    rs.getString("Fakultet"));

            c.setUsername(rs.getString("username"));

            c.setPassword(rs.getString("password"));

        }

        rs.close();
        return c;

    }

    @Override
    public String uslovZaDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
