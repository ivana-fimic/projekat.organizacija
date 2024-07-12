/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Predstavlja projekat u studentskoj organizaciji sa atributima IDProjekta,NazivProjekta, VrstaProjekta, DatumPocetka i
 * DatumZavrsetka projekta
 *
 * @author Ivana
 */


public class Projekat extends AbstractDomainObject {

    /**
     * ID projekta tipa int.
     */
    @SerializedName("id_projekta")
    private  int IDProjekta;

    /**
     * Naziv projekta tipa String.
     */
    @Expose
    @SerializedName("naziv")
    private String NazivProjekta;

    /**
     * Vrsta projekta tipa String.
     */
    @Expose
    @SerializedName("vrsta")
    private  String VrstaProjekta;

    /**
     * Datum početka projekta tipa LocalDate.
     */
    @Expose
    @SerializedName("datum")
    private  LocalDate DatumPocetka;

    /**
     * Datum završetka projekta tipa LocalDate.
     */
    @Expose
    @SerializedName("datum zavrsetka")
    private   LocalDate DatumZavrsetka;

    /**
     * Pravi nov objekat klase Projekat sa zadatim vrednostima.
     *
     * @param IDProjekta ID projekta kao int
     * @param NazivProjekta naziv projekta kao String
     * @param VrstaProjekta vrsta projekta kao String
     * @param DatumPocetka datum početka projekta kao LocalDate
     * @param DatumZavrsetka datum završetka projekta kao LocalDate
     */
    public Projekat(int IDProjekta, String NazivProjekta, String VrstaProjekta, LocalDate DatumPocetka, LocalDate DatumZavrsetka) {
        this.IDProjekta = IDProjekta;
        this.NazivProjekta = NazivProjekta;
        this.VrstaProjekta = VrstaProjekta;
        this.DatumPocetka = DatumPocetka;
        this.DatumZavrsetka = DatumZavrsetka;
    }

    /**
     * Pravi nov objekat klase Projekat.
     *
     * Polja ostaju neinicijalizovana.
     */
    public Projekat() {
    }

    /**
     * Vraca ID projekta.
     *
     * @return ID projekta kao int
     */
    public int getIDProjekta() {
        return IDProjekta;
    }

    /**
     * Postavlja ID projekta na unetu vrednost.
     *
     * @param IDProjekta ID projekta kao int
     */
    public void setIDProjekta(int IDProjekta) {
        this.IDProjekta = IDProjekta;
    }

    /**
     * Vraca naziv projekta.
     *
     * @return naziv projekta kao String
     */
    public String getNazivProjekta() {
        return NazivProjekta;
    }

    /**
     * Postavlja naziv projekta na unetu vrednost.
     *
     * Uneti naziv ne sme biti null, ne sme sadržati brojeve i mora biti napisan velikim slovima.
     *
     * @param NazivProjekta naziv projekta kao String
     *
     * @throws java.lang.NullPointerException ako je uneti naziv null
     * @throws java.lang.IllegalArgumentException ako uneti naziv sadrži brojeve ili nije napisan velikim slovima
     */
    public void setNazivProjekta(String NazivProjekta) {
        if (NazivProjekta == null) {
            throw new NullPointerException("Naziv projekta ne sme biti null");
        }
        if (NazivProjekta.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Naziv projekta ne sme imati brojeve");
        }
        if (!NazivProjekta.equals(NazivProjekta.toUpperCase())) {
            throw new IllegalArgumentException("Naziv projekta mora biti napisan velikim slovima");
        }
        this.NazivProjekta = NazivProjekta;
    }

    /**
     * Vraca vrstu projekta.
     *
     * @return vrsta projekta kao String
     */
    public String getVrstaProjekta() {
        return VrstaProjekta;
    }

    /**
     * Postavlja vrstu projekta na unetu vrednost.
     *
     * Uneta vrsta ne sme biti null i ne sme sadržati brojeve.
     *
     * @param VrstaProjekta vrsta projekta kao String
     *
     * @throws java.lang.NullPointerException ako je uneta vrsta null
     * @throws java.lang.IllegalArgumentException ako uneta vrsta sadrži brojeve
     */
    public void setVrstaProjekta(String VrstaProjekta) {
        if (VrstaProjekta == null) {
            throw new NullPointerException("Vrsta projekta ne sme biti null");
        }
        if (VrstaProjekta.matches(".*\\d+.*")) {
            throw new IllegalArgumentException("Vrsta projekta ne sme imati brojeve");
        }
        this.VrstaProjekta = VrstaProjekta;
    }

    /**
     * Vraca datum početka projekta.
     *
     * @return datum početka projekta kao LocalDate
     */
    public LocalDate getDatumPocetka() {
        return DatumPocetka;
    }

    /**
     * Postavlja datum početka projekta na unetu vrednost.
     *
     * Uneti datum ne sme biti null.
     *
     * @param DatumPocetka datum početka projekta kao LocalDate
     *
     * @throws java.lang.NullPointerException ako je uneti datum null
     */
    public void setDatumPocetka(LocalDate DatumPocetka) {
        if (DatumPocetka == null) {
            throw new NullPointerException("Datum početka projekta ne sme biti null");
        }
        this.DatumPocetka = DatumPocetka;
    }

    /**
     * Vraca datum završetka projekta.
     *
     * @return datum završetka projekta kao LocalDate
     */
    public LocalDate getDatumZavrsetka() {
        return DatumZavrsetka;
    }

    /**
     * Postavlja datum završetka projekta na unetu vrednost.
     *
     * Uneti datum ne sme biti null.
     *
     * @param DatumZavrsetka datum završetka projekta kao LocalDate
     *
     * @throws java.lang.NullPointerException ako je uneti datum null
     */
    public void setDatumZavrsetka(LocalDate DatumZavrsetka) {
        if (DatumZavrsetka == null) {
            throw new NullPointerException("Datum završetka projekta ne sme biti null");
        }
        this.DatumZavrsetka = DatumZavrsetka;
    }

    /**
     * Proverava da li su dva objekta jednaka prema nazivu i vrsti projekta.
     *
     * @param obj objekat sa kojim se poredi
     * @return true ako oba objekta imaju isti naziv i vrstu projekta, 
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
        final Projekat other = (Projekat) obj;
        if (!Objects.equals(this.NazivProjekta, other.NazivProjekta)) {
            return false;
        }
        return Objects.equals(this.VrstaProjekta, other.VrstaProjekta);
    }


    @Override
    public String nazivTabele() {
        return " projekat ";

    }

    @Override
    public String alijas() {
        return " pr ";

    }

    @Override
    public String join() {
        return "";
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

            lista.add(pr);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivProjekta, VrstaProjekta,DatumPocetka,DatumZavrsetka) ";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + NazivProjekta + "', '" + VrstaProjekta + "', " + "'" + DatumPocetka + "', " + "'" + DatumZavrsetka + "' ";
    }

    @Override
    public String uslov() {
        return " pr.IDProjekta = " + IDProjekta;
    }

    @Override
    public String uslovZaDelete() {
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
    public AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(int generatedKey) {
        setIDProjekta(generatedKey);
    }

    @Override
    public String toString() {
        return NazivProjekta;
    }

    
}
