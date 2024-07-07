/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;
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
public class StatistikaZadatka extends AbstractDomainObject {

    private Clan clan;
    private Zadatak zadatak;
    private FazaZadatka FazaZadatka;
    private LocalDate datumDodele;
    private LocalDate KrajnjiRok;
    private String zaClana = "";

    public StatistikaZadatka(Clan clan, Zadatak zadatak, FazaZadatka FazaZadatka, LocalDate datumDodele, LocalDate KrajnjiRok) {
        this.clan = clan;
        this.zadatak = zadatak;
        this.FazaZadatka = FazaZadatka;
        this.datumDodele = datumDodele;
        this.KrajnjiRok = KrajnjiRok;
    }

    public StatistikaZadatka() {
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public String getZaClana() {
        return zaClana;
    }

    public void setZaClana(String zaClana) {
        this.zaClana = zaClana;
    }

    public Zadatak getZadatak() {
        return zadatak;
    }

    public void setZadatak(Zadatak zadatak) {
        this.zadatak = zadatak;
    }

    public FazaZadatka getFazaZadatka() {
        return FazaZadatka;
    }

    public void setFazaZadatka(FazaZadatka FazaZadatka) {
        this.FazaZadatka = FazaZadatka;
    }

    public LocalDate getDatumDodele() {
        return datumDodele;
    }

    public void setDatumDodele(LocalDate datumDodele) {
        this.datumDodele = datumDodele;
    }

    public LocalDate getKrajnjiRok() {
        return KrajnjiRok;
    }

    public void setKrajnjiRok(LocalDate KrajnjiRok) {
        this.KrajnjiRok = KrajnjiRok;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.clan);
        hash = 59 * hash + Objects.hashCode(this.zadatak);
        hash = 59 * hash + Objects.hashCode(this.FazaZadatka);
        hash = 59 * hash + Objects.hashCode(this.datumDodele);
        hash = 59 * hash + Objects.hashCode(this.KrajnjiRok);
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
        final StatistikaZadatka other = (StatistikaZadatka) obj;
        if (!Objects.equals(this.clan, other.clan)) {
            return false;
        }
        if (!Objects.equals(this.zadatak, other.zadatak)) {
            return false;
        }
        if (this.FazaZadatka != other.FazaZadatka) {
            return false;
        }
        if (!Objects.equals(this.datumDodele, other.datumDodele)) {
            return false;
        }
        return Objects.equals(this.KrajnjiRok, other.KrajnjiRok);
    }

    @Override
    public String nazivTabele() {
        return " statistika_zadataka ";
    }

    @Override
    public String alijas() {
        return " sz ";
    }

    @Override
    public String join() {

        return " JOIN CLAN c ON (c.IDClana = sz.IDClana) "
                + " JOIN TIM t ON (c.IDTima = t.IDTima) "
                + " JOIN POZICIJA P ON (P.IDPozicije = c.IDPozicije) "
                + " JOIN ZADATAK z ON (z.IDZadatka = sz.IDZadatka) "
                + " JOIN TIM t2 ON (t2.IDTima = z.IDTima) "+
                "JOIN projekat pr ON (t.IDProjekta= pr.IDProjekta) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Date sqlDatumPocetka = rs.getDate("pr.DatumPocetka");
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumPocetka = formatter2.format(sqlDatumPocetka);

            LocalDate localDatumPocetka = LocalDate.parse(formattedDatumPocetka);

            Date sqlDatumZavrsetka = rs.getDate("pr.DatumZavrsetka");
            SimpleDateFormat formatter4 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumZavrsetka= formatter4.format(sqlDatumZavrsetka);
            LocalDate localDatumZavrsetka = LocalDate.parse(formattedDatumZavrsetka);
            
             Projekat pr = new Projekat(rs.getInt("IDProjekta"),
                    rs.getString("NazivProjekta"), rs.getString("VrstaProjekta"),localDatumPocetka,localDatumZavrsetka);
            
             Tim t = new Tim(rs.getInt("t.IDTima"),
                    rs.getString("t.nazivTima"), rs.getInt("t.brojClanova"),
                   pr);
            //  System.out.println(t.getNazivTima());
            Zadatak z = new Zadatak(rs.getInt("z.IDZadatka"),
                    rs.getString("z.nazivZadatka"), t);
            //  System.out.println(z.getNazivZadatka());
            Pozicija p = new Pozicija(rs.getInt("p.IDPozicije"),
                    rs.getString("p.nazivPozicije"));
            System.out.println(p.getNazivPozicije());
            Clan c = new Clan(rs.getInt("c.IDClana"), rs.getString("c.Ime"),
                    rs.getString("c.Prezime"), rs.getInt("c.GodStudija"), p, t,
                    rs.getString("c.Fakultet"));
            //System.out.println(c.getIme());

            Date sqlDatumDodele = rs.getDate("sz.DatumDodele");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDatumDodele = formatter.format(sqlDatumDodele);

            LocalDate localDatumDodele = LocalDate.parse(formattedDatumDodele);

            Date sqlKrajnjiRok = rs.getDate("sz.KranjiRok");
            SimpleDateFormat formatter3 = new SimpleDateFormat("yyyy-MM-dd");
            String formattedKrajnjiRok = formatter3.format(sqlKrajnjiRok);
            LocalDate localKrajnjiRok = LocalDate.parse(formattedKrajnjiRok);

            FazaZadatka faza = FazaZadatka.valueOf(rs.getString("sz.FazaZadatka"));
            StatistikaZadatka sz = new StatistikaZadatka();
            sz.setClan(c);
            sz.setZadatak(z);
            sz.setDatumDodele(localDatumDodele);
            sz.setKrajnjiRok(localKrajnjiRok);
            sz.setFazaZadatka(faza);
            lista.add(sz);

        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (IDClana, IDZadatka, FazaZadatka, KranjiRok, DatumDodele) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return clan.getIDClana() + ", " + zadatak.getIDZadatka() + " , "
                + "'" + FazaZadatka + "', " + "'" + KrajnjiRok + "', " + "'" + datumDodele + "' ";
    }

    @Override
    public String uslov() {
        if (!zaClana.isEmpty()) {
            return " IDClana = " + clan.getIDClana() + " and IDZadatka = " + zadatak.getIDZadatka();
        }
        return " sz.IDZadatka = " + zadatak.getIDZadatka();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " IDClana= " + clan.getIDClana() + ", IDZadatka = " + zadatak.getIDZadatka()
                + ", FazaZadatka = '" + FazaZadatka + "', KranjiRok = ' " + KrajnjiRok
                + "' , DatumDodele = ' " + datumDodele + " ' ";

    }

    @Override
    public String uslovZaSelect() {
        if (zadatak != null) {
            return " WHERE sz.IDZadatka = " + zadatak.getIDZadatka();
        }
        if (clan != null) {
            return " WHERE sz.IDClana = " + clan.getIDClana();
        }
        return "";
    }

    @Override
    public void setAutoIncrementPrimaryKey(int generatedKey) {
        System.out.println("NEMA KLJUC");
    }

    @Override
    public AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String uslovZaDelete() {
        return " IDZadatka = " + zadatak.getIDZadatka();
    }

}
