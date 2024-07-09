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
 * Klasa Tim koja sadrzi IDTima, nazivTima, brojClanova, projekat 
 * Predstavlja tim unutar studentske organizacije koji je sastavljen od clanova klase Clan i
 * pozicija klase Pozicija unutar kog se rade zadaci klase Zadatak i prati se na kom projektu radi tim
 *
 * @author Ivana
 */
public class Tim extends AbstractDomainObject {

    /**
     * ID tima tipa int.
     */
    private int IDTima;
    /**
     * Naziv tima tipa String.
     */
    private String nazivTima;
    /**
     * Broj clanova tima tipa int
     */
    private int brojClanova;
    /**
     * Projekat na kom radi tim
     */
    private Projekat projekat;
    /**
     * Pozicije koje postoje unutar tima
     */
    private List<Pozicija> pozicije;
    /**
     * Lista sa DetaljimaPozicija koja nam pokazuje koliko pozicija ima u timu
     */
    private List<DetaljiPozicija> brojPozicija;

    /**
     * Pomocna promenljiva za postavljanje mooda tabele tim na formi
     */
    Moodovi moodTabele;
    /**
     * Pomocna promenljiva za parametar pretrage na formi
     */
    private String parametarZaPretragu;

    /**
     * Pravi nov objekat klase Tim.
     *
     * Polja ostaju neinicijalizovana.
     */
    public Tim() {
    }

    /**
     * Pravi nov objekat klase Tim sa zadatim vrednostima.
     *
     * @param IDTima ID tima kao int
     * @param nazivTima naziv tima kao String
     * @param brojClanova broj članova tima kao int
     * @param projekat projekat tima kao Projekat
     *
     */
    public Tim(int IDTima, String nazivTima, int brojClanova, Projekat IDProjekta) {
        this.IDTima = IDTima;
        this.nazivTima = nazivTima;
        this.brojClanova = brojClanova;
        this.projekat = IDProjekta;

    }

    /**
     * Vraca ID tima.
     *
     * @return ID tima kao int
     */
    public int getIDTima() {
        return IDTima;
    }

    /**
     * Postavlja ID tima na unetu vrednost.
     *
     * @param IDTima ID tima kao int
     */
    public void setIDTima(int IDTima) {
        this.IDTima = IDTima;
    }

    /**
     * Vraca naziv tima.
     *
     * @return naziv tima kao String
     */
    public String getNazivTima() {
        return nazivTima;
    }

    /**
     * Postavlja naziv tima na unetu vrednost.
     *
     * Uneti naziv ne sme biti null, ne sme sadržati brojeve i mora početi
     * velikim slovom.
     *
     * @param nazivTima naziv tima kao String
     *
     * @throws java.lang.NullPointerException ako je uneti naziv null
     * @throws java.lang.IllegalArgumentException ako uneti naziv sadrži brojeve
     * ili počinje malim slovom
     */
    public void setNazivTima(String nazivTima) {
        if (nazivTima == null) {
            throw new NullPointerException("Naziv tima ne sme biti null");
        }
        if (nazivTima.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Naziv tima ne sme imati brojeve");

        }

        if (Character.isLowerCase(nazivTima.charAt(0))) {
            throw new IllegalArgumentException("Naziv tima ne sme imati malo pocetno slovo");
        }
        this.nazivTima = nazivTima;

    }
    
     /**
     * Vraca broj članova tima.
     * 
     * @return broj članova tima kao int
     */

    public int getBrojClanova() {
        return brojClanova;
    }
    
     /**
     * Postavlja broj članova tima na unetu vrednost.
     * 
     * Uneti broj ne sme biti negativan.
     * 
     * @param brojClanova broj članova tima kao int
     * 
     * @throws java.lang.IllegalArgumentException
     *  ako je uneti broj negativan
     */

    public void setBrojClanova(int brojClanova) {
        if (brojClanova < 0) {
            throw new IllegalArgumentException("Broj clanova ne sme biti negativan");
        }
        this.brojClanova = brojClanova;
    }
    
      /**
     * Vraca projekat tima.
     * 
     * @return projekat tima kao Projekat
     */

    public Projekat getProjekat() {

        return projekat;
    }
    
     /**
     * Postavlja projekat tima na unetu vrednost.
     * 
     * Uneti projekat ne sme biti null.
     * 
     * @param projekat projekat tima kao Projekat
     * 
     * @throws java.lang.NullPointerException 
     * ako je uneti projekat null
     */

    public void setProjekat(Projekat IDProjekta) {
        if (IDProjekta == null) {
            throw new NullPointerException("Projekat ne sme biti null");

        }
        this.projekat = IDProjekta;
    }

   
    /**
     * Vraca listu detalja pozicija u timu.
     * 
     * @return lista detalja pozicija kao List<DetaljiPozicija>
     */
    
    public List<DetaljiPozicija> getBrojPozicija() {
        return brojPozicija;
    }
    
    /**
     * Postavlja listu detalja pozicija u timu na unetu vrednost.
     * 
     * @param brojPozicija lista detalja pozicija kao List<DetaljiPozicija>
     */

    public void setBrojPozicija(List<DetaljiPozicija> brojPozicija) {
        this.brojPozicija = brojPozicija;
    }
    
     /**
     * Vraca listu pozicija u timu.
     * 
     * @return lista pozicija kao List<Pozicija>
     */

    public List<Pozicija> getPozicije() {
        return pozicije;
    }
    
     /**
     * Postavlja listu pozicija u timu na unetu vrednost.
     * 
     * @param pozicije lista pozicija kao List<Pozicija>
     */

    public void setPozicije(List<Pozicija> pozicije) {
        this.pozicije = pozicije;
    }
     /**
     * Vraca trenutni mood tabele.
     * 
     * @return mood tabele kao Moodovi
     */

    public Moodovi getMoodTabele() {
        return moodTabele;
    }
    
    /**
     * Postavlja mood tabele na unetu vrednost.
     * 
     * @param moodTabele mood tabele kao Moodovi
     */

    public void setMoodTabele(Moodovi moodTabele) {
        this.moodTabele = moodTabele;
    }
    
    /**
     * Vraca trenutni parametar za pretragu.
     * 
     * @return parametar za pretragu kao String
     */
    
     public String getParametarZaPretragu() {
        return parametarZaPretragu;
    }
    /**
     * Postavlja parametar za pretragu na unetu vrednost.
     * 
     * @param parametarZaPretragu parametar za pretragu kao String
     */
    public void setParametarZaPretragu(String parametarZaPretragu) {
        this.parametarZaPretragu = parametarZaPretragu;
    }
    /**
     * Vraća string reprezentaciju objekta Tim.
     * 
     * @return naziv tima i naziv projekta tima kao String
     */
    @Override
    public String toString() {
        return nazivTima + "-" + projekat.getNazivProjekta();
    }

     /**
         * Proverava da li su dva objekta jednaka prema nazivu tima i projektu
         * @param obj objekat sa kojim se poredi
         * @return true - ako oba objekta imaju istu memorijsku lokaciju,
         * ili ako su objekti iste klase i imaju iste vrednosti naziv tima i projekat
         * false - u svim ostalim slucajevima
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
        final Tim other = (Tim) obj;
        if (!Objects.equals(this.nazivTima, other.nazivTima)) {
            return false;
        }
        return Objects.equals(this.projekat, other.projekat);
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
                + "JOIN POZICIJA P ON (P.IDPozicije = dp.idPozicije) "
                + "JOIN projekat pr ON (t.IDProjekta= pr.IDProjekta) ";
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
            String formattedDatumZavrsetka = formatter3.format(sqlDatumZavrsetka);
            LocalDate localDatumZavrsetka = LocalDate.parse(formattedDatumZavrsetka);

            Projekat pr = new Projekat(rs.getInt("IDProjekta"),
                    rs.getString("NazivProjekta"), rs.getString("VrstaProjekta"), localDatumPocetka, localDatumZavrsetka);

            Tim t = new Tim(rs.getInt("t.IDTima"),
                    rs.getString("nazivTima"), rs.getInt("brojClanova"), pr);

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
                + projekat.getIDProjekta() + " ";
    }

    @Override
    public String uslov() {
        return " t.IDTima = " + IDTima;
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivTima = '" + nazivTima + "', IDProjekta = " + projekat.getIDProjekta() + " "
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
            String formattedDatumZavrsetka = formatter3.format(sqlDatumZavrsetka);
            LocalDate localDatumZavrsetka = LocalDate.parse(formattedDatumZavrsetka);

            Projekat pr = new Projekat(rs.getInt("IDProjekta"),
                    rs.getString("NazivProjekta"), rs.getString("VrstaProjekta"), localDatumPocetka, localDatumZavrsetka);
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
