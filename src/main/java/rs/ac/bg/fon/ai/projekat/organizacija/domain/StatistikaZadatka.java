/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import com.google.gson.annotations.Expose;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;



/**
 *Predstavlja statistiku vezanu za izvršavanje zadatka od strane člana tima u kojoj se beleze
 * faza,datum dodele i krajnji rok zadatka
 * 
 * @author Ivana Fimic
 */
public class StatistikaZadatka extends AbstractDomainObject {

    /**
     * Član tima koji je zadužen za izvršavanje zadatka.
     */
        
@Expose
    private Clan clan;

    /**
     * Zadatak na koji se statistika odnosi.
     */
     @Expose
    private Zadatak zadatak;

    /**
     * Faza zadatka u do koje je clan dosao sa izvršavanjem zadatka.
     */
      @Expose
    private FazaZadatka FazaZadatka;

    /**
     * Datum dodele zadatka članu.
     */
       @Expose
    private LocalDate datumDodele;

    /**
     * Krajnji rok za izvršavanje zadatka.
     */
        @Expose
    private LocalDate KrajnjiRok;

    /**
     * Pomocni parametar za uslov vezan za člana (opciono).
     */
    private String zaClana = "";

    /**
     * Pravi nov objekat klase StatistikaZadatka sa zadatim vrednostima.
     * 
     * @param clan član tima kao Clan
     * @param zadatak zadatak kao Zadatak
     * @param FazaZadatka faza zadatka kao FazaZadatka
     * @param datumDodele datum dodele zadatka kao LocalDate
     * @param KrajnjiRok krajnji rok za izvršavanje zadatka kao LocalDate
     */
    public StatistikaZadatka(Clan clan, Zadatak zadatak, FazaZadatka FazaZadatka, LocalDate datumDodele, LocalDate KrajnjiRok) {
        this.clan = clan;
        this.zadatak = zadatak;
        this.FazaZadatka = FazaZadatka;
        this.datumDodele = datumDodele;
        this.KrajnjiRok = KrajnjiRok;
    }

    /**
     * Pravi nov objekat klase StatistikaZadatka.
     * 
     * Polja ostaju neinicijalizovana.
     */
    public StatistikaZadatka() {}

    /**
     * Vraća člana tima koji je zadužen za izvršavanje zadatka.
     * 
     * @return član tima kao Clan
     */
    public Clan getClan() {
        return clan;
    }

    /**
     * Postavlja člana tima koji je zadužen za izvršavanje zadatka na unetu vrednost.
     * 
     * @param clan član tima kao Clan
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti član null
     */
    public void setClan(Clan clan) {
        
        if(clan==null){
            throw new NullPointerException("Clan ne sme biti null");
        }
        this.clan = clan;
    }

    /**
     * Vraća dodatni parametar vezan za člana.
     * 
     * @return dodatni parametar kao String
     */
    public String getZaClana() {
        return zaClana;
    }

    /**
     * Postavlja dodatni parametar vezan za člana na unetu vrednost.
     * 
     * @param zaClana dodatni parametar kao String
     */
    public void setZaClana(String zaClana) {
        this.zaClana = zaClana;
    }

    /**
     * Vraća zadatak na koji se statistika odnosi.
     * 
     * @return zadatak kao Zadatak
     */
    public Zadatak getZadatak() {
        return zadatak;
    }

    /**
     * Postavlja zadatak na koji se statistika odnosi na unetu vrednost.
     * 
     * @param zadatak zadatak kao Zadatak
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti zadatak null
     */
    public void setZadatak(Zadatak zadatak) {
        if (zadatak == null)
            throw new NullPointerException("Naziv zadatka ne sme biti null");
        
        this.zadatak = zadatak;
    }

    /**
     * Vraća fazu zadatka u kojoj se nalazi statistika.
     * 
     * @return faza zadatka kao FazaZadatka
     */
    public FazaZadatka getFazaZadatka() {
        return FazaZadatka;
    }

    /**
     * Postavlja fazu zadatka na unetu vrednost.
     * 
     * @param FazaZadatka faza zadatka kao FazaZadatka
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneta faza zadatka null
     */
    public void setFazaZadatka(FazaZadatka FazaZadatka) {
        if (FazaZadatka == null)
            throw new NullPointerException("Faza zadatka ne sme biti null");
        
        this.FazaZadatka = FazaZadatka;
    }

    /**
     * Vraća datum dodele zadatka članu.
     * 
     * @return datum dodele kao LocalDate
     */
    public LocalDate getDatumDodele() {
        return datumDodele;
    }

    /**
     * Postavlja datum dodele zadatka članu na unetu vrednost.
     * 
     * @param datumDodele datum dodele kao LocalDate
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti datum dodele null
     */
    public void setDatumDodele(LocalDate datumDodele) {
        if (datumDodele == null)
            throw new NullPointerException("Datum dodele ne sme biti null");
        
        this.datumDodele = datumDodele;
    }

    /**
     * Vraća krajnji rok za izvršavanje zadatka.
     * 
     * @return krajnji rok kao LocalDate
     */
    public LocalDate getKrajnjiRok() {
        return KrajnjiRok;
    }

    /**
     * Postavlja krajnji rok za izvršavanje zadatka na unetu vrednost.
     * 
     * @param KrajnjiRok krajnji rok kao LocalDate
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti krajnji rok null
     * @throws java.lang.IllegalArgumentException
     *  ako je uneti krajnji rok u prošlosti
     */
    public void setKrajnjiRok(LocalDate KrajnjiRok) {
        if (KrajnjiRok == null)
            throw new NullPointerException("Krajnji Rok ne sme biti null");
        
        if (KrajnjiRok.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Datum ne sme biti u proslosti");
        
        this.KrajnjiRok = KrajnjiRok;
    }

    /**
     * Poredi dve statistike prema zadatku i clanu.
     * 
     * @param obj Druga statistika sa kojim se poredi
     * 
     * @return 
     * true -  ako su oba objekta inicijalizovana, klase su StatistikaZadatka
     * i imaju istog clana i zadatak 
     * false - ako nisu klase StatistikaZadatka, ako je uneta statistika null ili ako
     * nisu isti clan i zadatak
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
        final StatistikaZadatka other = (StatistikaZadatka) obj;
        if (!Objects.equals(this.clan, other.clan)) {
            return false;
        }
        return Objects.equals(this.zadatak, other.zadatak);
    }

    
    
     /**
     * Vraća string reprezentaciju objekta StatistikaZadatka.
     * 
     * @return clan, zadatak i fazu kao String
     */
    @Override
    public String toString() {
        return clan + " " + zadatak + " " + FazaZadatka;
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
