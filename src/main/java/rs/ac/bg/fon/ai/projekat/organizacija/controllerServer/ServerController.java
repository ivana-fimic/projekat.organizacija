/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.controllerServer
;

import rs.ac.bg.fon.ai.projekat.organizacija.domain.Admin;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Resurs;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.clan.SOKreirajClana;
import rs.ac.bg.fon.ai.projekat.organizacija.so.clan.SOLoginClana;
import rs.ac.bg.fon.ai.projekat.organizacija.so.clan.SONadjiClanove;
import rs.ac.bg.fon.ai.projekat.organizacija.so.clan.SOUcitajClana;
import rs.ac.bg.fon.ai.projekat.organizacija.so.clan.SOZapamtiClana;
import rs.ac.bg.fon.ai.projekat.organizacija.so.login.SOLogin;
import rs.ac.bg.fon.ai.projekat.organizacija.so.pozicije.SOUcitajListuPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.so.projekat.SOKreirajProjekat;
import rs.ac.bg.fon.ai.projekat.organizacija.so.projekat.SOUcitajListuProjekta;
import rs.ac.bg.fon.ai.projekat.organizacija.so.resurs.SOKreirajResurs;
import rs.ac.bg.fon.ai.projekat.organizacija.so.statistikaZadatka.SOVratiListuStatistika;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOKreirajTim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOObrisiTim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOUcitajListuTimova;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOUcitajTim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOZapamtiTim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak.SOKreirajZadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak.SONadjiZadatke;
import rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak.SOUcitajZadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak.SOZapamtiZadatak;
import java.util.List;
import so.tim.SONadjiTimove;




/**
 *
 * @author Ivana
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Admin login(Admin admin) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(admin);
        return so.getUlogovani();
    }

    public Tim dodajTim(Tim t) throws Exception {
        SOKreirajTim so = new SOKreirajTim();
        so.templateExecute(t);
        return so.getTim();
    }

    public List<Pozicija> vratiPozicije() throws Exception {
        SOUcitajListuPozicija so = new SOUcitajListuPozicija();
        so.templateExecute(new Pozicija());
        return so.getLista();
    }

    public List<Tim> nadjiTimove(Tim t) throws Exception {
        SONadjiTimove so = new SONadjiTimove();
        so.templateExecute(t);
        return so.getLista();
    }

    public void zapamtiTim(Tim tim) throws Exception {
        SOZapamtiTim so = new SOZapamtiTim();
        so.templateExecute(tim);
    }

    public void obrisiTim(Tim tim) throws Exception {
        SOObrisiTim so = new SOObrisiTim();
        so.templateExecute(tim);
    }

    public Clan dodajClana(Clan c) throws Exception {
        SOKreirajClana so = new SOKreirajClana();
        so.templateExecute(c);
        return so.getC();
    }

    public List<Clan> nadjiClanove(Clan clan) throws Exception {
        SONadjiClanove so = new SONadjiClanove();
        so.templateExecute(clan);
        return so.getLista();
    }

    public void zapamtiClana(Clan clan) throws Exception {
        SOZapamtiClana so = new SOZapamtiClana();
        so.templateExecute(clan);
    }

    public Zadatak dodajZadatak(Zadatak z) throws Exception {
        SOKreirajZadatak so = new SOKreirajZadatak();
        so.templateExecute(z);
        return so.getZ();
    }

    public List<Zadatak> nadjiZadatke(Zadatak zad) throws Exception {
        SONadjiZadatke so = new SONadjiZadatke();
        so.templateExecute(zad);
        return so.getLista();
    }

    public void zapamtiZadatak(Zadatak zadatak) throws Exception {
        SOZapamtiZadatak so = new SOZapamtiZadatak();
        so.templateExecute(zadatak);
    }

    public Object vratiStatistike(StatistikaZadatka z) throws Exception {
        SOVratiListuStatistika so = new SOVratiListuStatistika();

        so.templateExecute(z);
        return so.getLista();
    }

    public Clan loginClana(Clan c) throws Exception {
        SOLoginClana so = new SOLoginClana();
        so.templateExecute(c);
        return so.getUlogovani();
    }

    public List<Tim> vratiSveTimove() throws Exception {
        SOUcitajListuTimova so = new SOUcitajListuTimova();
        so.templateExecute(new Tim());
        return so.getLista();
    }

    public Clan ucitajClana(Clan poslatiClan) throws Exception {
        SOUcitajClana so = new SOUcitajClana();
        so.templateExecute(poslatiClan);
        return so.getClanIzBaze();

    }

    public Tim ucitajTim(Tim poslatiTim) throws Exception {
        SOUcitajTim so = new SOUcitajTim();
        so.templateExecute(poslatiTim);
        return so.getTimIzBaze();
    }

    public Zadatak ucitajZadatak(Zadatak poslatiZadatak) throws Exception {
        SOUcitajZadatak so = new SOUcitajZadatak();
        so.templateExecute(poslatiZadatak);
        return so.getZadatakIzBaze();
    }

    public List<Projekat> vratiProjekte() throws Exception {
        SOUcitajListuProjekta so = new SOUcitajListuProjekta();
        so.templateExecute(new Projekat());
        return so.getLista();

    }

    public Projekat dodajProjekat(Projekat p) throws Exception {
        SOKreirajProjekat so = new SOKreirajProjekat();
        so.templateExecute(p);
        return so.getP();

    }

    public Resurs dodajResurs(Resurs r) throws Exception {
        SOKreirajResurs so = new SOKreirajResurs();
        so.templateExecute(r);
        return so.getR();
    }

}
