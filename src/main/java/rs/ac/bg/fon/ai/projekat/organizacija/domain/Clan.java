/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Predstavlja člana tima i pamti u kom timu je i na kojoj poziciji je u tom
 * timu,koji zadatak mu je dodeljen kao i informacije o imenu, prezimenu, godini
 * studija, fakultetu.
 *
 * @autor Ivana
 */
public class Clan extends AbstractDomainObject {

    /**
     * ID člana kao int.
     */
    private int IDClana;

    /**
     * Ime člana kao String.
     */
    private String Ime;

    /**
     * Prezime člana kao String.
     */
    private String Prezime;

    /**
     * Godina studija člana tipa int.
     */
    @SerializedName("Godina studija")
    private int GodStudija;

    /**
     * Pozicija člana unutar tima.
     */
    @Expose

    private Pozicija pozicija;

    /**
     * Tim kojem član pripada.
     */
    @Expose
    private Tim tim;

    /**
     * Fakultet na kojem član studira kao String.
     */
    private String Fakultet;

    /**
     * Pomocna promenljiva za parametar pretrage na formi.
     */
    @Expose

    private String parametarZaPretragu;

    /**
     * Korisničko ime člana za prijavu.
     */
    @Expose

    private String username;

    /**
     * Lozinka člana za prijavu.
     */
    @Expose

    private String password;

    /**
     * Lista statistika zadataka člana.
     */
    @Expose

    private List<StatistikaZadatka> statistikaZad;

    /**
     * Pravi nov objekat klase Clan sa zadatim vrednostima.
     *
     * @param IDClana ID člana kao int
     * @param Ime ime člana kao String
     * @param Prezime prezime člana kao String
     * @param GodStudija godina studija člana kao int
     * @param pozicija pozicija člana kao Pozicija
     * @param tim tim kojem član pripada kao Tim
     * @param Fakultet fakultet na kojem član studira kao String
     */
    public Clan(int IDClana, String Ime, String Prezime, int GodStudija, Pozicija pozicija, Tim tim, String Fakultet) {
        this.IDClana = IDClana;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.GodStudija = GodStudija;
        this.pozicija = pozicija;
        this.tim = tim;
        this.Fakultet = Fakultet;
    }

    /**
     * Pravi nov objekat klase Clan.
     *
     * Polja ostaju neinicijalizovana.
     */
    public Clan() {
    }

    /**
     * Vraća ID člana.
     *
     * @return ID člana kao int
     */
    public int getIDClana() {
        return IDClana;
    }

    /**
     * Postavlja ID člana na unetu vrednost.
     *
     * @param IDClana ID člana kao int
     */
    public void setIDClana(int IDClana) {
        this.IDClana = IDClana;
    }

    /**
     * Vraća ime člana.
     *
     * @return ime člana kao String
     */
    public String getIme() {
        return Ime;
    }

    /**
     * Postavlja ime člana na unetu vrednost.
     *
     * Uneto ime ne sme biti null, ne sme sadržati brojeve i mora počinjati
     * velikim slovom.
     *
     * @param Ime ime člana kao String
     *
     * @throws java.lang.NullPointerException ako je uneto ime null
     * @throws java.lang.IllegalArgumentException ako ime sadrži brojeve ili
     * počinje malim slovom
     */
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

    /**
     * Vraća prezime člana.
     *
     * @return prezime člana kao String
     */
    public String getPrezime() {
        return Prezime;
    }

    /**
     * Postavlja prezime člana na unetu vrednost.
     *
     * Uneto prezime ne sme biti null, ne sme sadržati brojeve i mora počinjati
     * velikim slovom.
     *
     * @param Prezime prezime člana kao String
     *
     * @throws java.lang.NullPointerException ako je uneto prezime null
     * @throws java.lang.IllegalArgumentException ako prezime sadrži brojeve ili
     * počinje malim slovom
     */
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

    /**
     * Vraća godinu studija člana.
     *
     * @return godina studija člana kao int
     */
    public int getGodStudija() {
        return GodStudija;
    }

    /**
     * Postavlja godinu studija člana na unetu vrednost.
     *
     * Uneta godina studija mora biti između 1 i 4.
     *
     * @param GodStudija godina studija člana kao int
     *
     * @throws java.lang.IllegalArgumentException ako je uneta godina studija
     * van opsega 1 do 4
     */
    public void setGodStudija(int GodStudija) {
        if (GodStudija < 1 || GodStudija > 4) {
            throw new IllegalArgumentException("Godina studija mora biti izmedju 1 i 4");
        }
        this.GodStudija = GodStudija;
    }

    /**
     * Vraća poziciju člana unutar tima.
     *
     * @return pozicija člana kao Pozicija
     */
    public Pozicija getPozicija() {
        return pozicija;
    }

    /**
     * Postavlja poziciju člana unutar tima na unetu vrednost.
     *
     * Uneta pozicija ne sme biti null.
     *
     * @param pozicija pozicija člana kao Pozicija
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
     * Vraća tim kojem član pripada.
     *
     * @return tim kojem član pripada kao Tim
     */
    public Tim getTim() {
        return tim;
    }

    /**
     * Postavlja tim kojem član pripada na unetu vrednost.
     *
     * Uneti tim ne sme biti null.
     *
     * @param tim tim kojem član pripada kao Tim
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
     * Vraća fakultet na kojem član studira.
     *
     * @return fakultet na kojem član studira kao String
     */
    public String getFakultet() {
        return Fakultet;
    }

    /**
     * Postavlja fakultet na kojem član studira na unetu vrednost.
     *
     * Uneti fakultet ne sme biti null, ne sme sadržati brojeve i mora počinjati
     * velikim slovom.
     *
     * @param Fakultet fakultet na kojem član studira kao String
     *
     * @throws java.lang.NullPointerException ako je uneti fakultet null
     * @throws java.lang.IllegalArgumentException ako fakultet sadrži brojeve
     * ili počinje malim slovom
     */
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

    /**
     * Vraća parametar za pretragu.
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
     * Vraća korisničko ime člana.
     *
     * @return korisničko ime člana kao String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja korisničko ime člana na unetu vrednost.
     *
     * @param username korisničko ime člana kao String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Vraća lozinku člana.
     *
     * @return lozinka člana kao String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja lozinku člana na unetu vrednost.
     *
     * @param password lozinka člana kao String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Vraća listu statistika zadataka člana.
     *
     * @return lista statistika zadataka člana kao List<StatistikaZadatka>
     */
    public List<StatistikaZadatka> getStatistikaZad() {
        return statistikaZad;
    }

    /**
     * Postavlja listu statistika zadataka člana na unetu vrednost.
     *
     * @param statistikaZad lista statistika zadataka člana kao
     * List<StatistikaZadatka>
     */
    public void setStatistikaZad(List<StatistikaZadatka> statistikaZad) {
        this.statistikaZad = statistikaZad;
    }

    /**
     * Vraća string reprezentaciju objekta Clan.
     *
     * @return ime i prezime člana kao String
     */
    @Override
    public String toString() {
        return Ime + " " + Prezime;
    }

    /**
     * Proverava da li su dva objekta Clan jednaka prema ID-u, imenu i
     * prezimenu.
     *
     * @param obj objekat sa kojim se poredi
     * @return true ako oba objekta imaju isti ID, ime i prezime, false u
     * suprotnom
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
        final Clan other = (Clan) obj;
        if (this.IDClana != other.IDClana) {
            return false;
        }
        if (!Objects.equals(this.Ime, other.Ime)) {
            return false;
        }
        return Objects.equals(this.Prezime, other.Prezime);
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
