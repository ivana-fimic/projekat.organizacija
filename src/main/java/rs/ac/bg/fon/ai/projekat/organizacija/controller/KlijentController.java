/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.controller;

import java.net.Socket;
import rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija
.Receiver;
import rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija
.Request;
import rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija
.Response;
import rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija
.Sender;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Admin;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Resurs;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.Operacije;
import java.util.List;




/**
 *
 * @author Ivana
 */
public class KlijentController {

    public static KlijentController instance;
    Socket s;
    Sender posiljalac;
    Receiver primalac;

    private KlijentController() throws Exception {
        s = new Socket("localhost", 9000);
        posiljalac = new Sender(s);
        primalac = new Receiver(s);

    }

    public static KlijentController getInstance() throws Exception {
        if (instance == null) {
            instance = new KlijentController();
        }
        return instance;
    }

    public Admin login(Admin a) throws Exception {
        Request zahtev = new Request(Operacije.LOGIN, a);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Admin) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }

    }

    public Tim dodajTim(Tim t) throws Exception {
        Request zahtev = new Request(Operacije.DODAJ_TIM, t);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Tim) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public List<Pozicija> vratiPozicije() throws Exception {
        Request request = new Request(Operacije.VRATI_POZICIJE, null);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {
            return (List<Pozicija>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Tim> vratiTimove(Tim t) throws Exception {
        Request zahtev = new Request(Operacije.VRATI_TIMOVE, t);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (List<Tim>) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }

    }

    public List<DetaljiPozicija> vratiDetaljePozicije(Tim t) throws Exception {
        Request request = new Request(Operacije.VRATI_DETALJEPOZICIJE, t);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {
            return (List<DetaljiPozicija>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void izmeniTim(Tim tim) throws Exception {
        Request request = new Request(Operacije.IZMENI_TIM, tim);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public void obrisiTim(Tim tim) throws Exception {
        Request request = new Request(Operacije.OBRISI_TIM, tim);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public Clan dodajČlana(Clan c) throws Exception {
        Request zahtev = new Request(Operacije.DODAJ_ČLANA, c);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Clan) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public List<Clan> vratiClanove(Clan clan) throws Exception {

        Request zahtev = new Request(Operacije.VRATI_CLANOVE, clan);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (List<Clan>) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }

    }

    public void izmeniClana(Clan c) throws Exception {
        Request request = new Request(Operacije.IZMENI_CLANA, c);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public Zadatak dodajZadatak(Zadatak zadatak) throws Exception {
        Request zahtev = new Request(Operacije.DODAJ_ZADATAK, zadatak);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Zadatak) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public List<Zadatak> vratiZadatke(Zadatak z) throws Exception {
        Request zahtev = new Request(Operacije.VRATI_ZADATKE, z);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (List<Zadatak>) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public void izmeniZadatak(Zadatak z2) throws Exception {
        Request request = new Request(Operacije.IZMENI_ZADATAK, z2);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public List<StatistikaZadatka> vratiStatistike(StatistikaZadatka z) throws Exception {
        Request request = new Request(Operacije.VRATI_STATISTIKE, z);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {
            return (List<StatistikaZadatka>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public Clan loginClan(Clan c) throws Exception {
        Request zahtev = new Request(Operacije.LOGIN_CLAN, c);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Clan) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public void izmeniStatistiku(StatistikaZadatka stat) throws Exception {
        Request request = new Request(Operacije.IZMENI_STATISTIKU, stat);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

    public String odjava() throws Exception {
        Request request = new Request(Operacije.ODJAVA, null);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {
            s.close();
            instance = null;
            return (String) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public String odjavaClana() throws Exception {
        Request request = new Request(Operacije.ODJAVA_CLANA, null);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {
            s.close();
            instance = null;
            return (String) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Tim> vratiTimove() throws Exception {
        Request request = new Request(Operacije.VRATI_SVE_TIMOVE, null);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {
            return (List<Tim>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Clan ucitajClana(Clan c) throws Exception {
        Request zahtev = new Request(Operacije.UCITAJ_CLANA, c);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Clan) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public Tim ucitajTim(Tim t) throws Exception {
        Request zahtev = new Request(Operacije.UCITAJ_TIM, t);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Tim) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }

    }

    public Zadatak ucitajZadatak(Zadatak z) throws Exception {
        Request zahtev = new Request(Operacije.UCITAJ_ZADATAK, z);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Zadatak) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public List<Projekat> vratiProjekte() throws Exception {

        Request request = new Request(Operacije.VRATI_SVE_PROJEKTE, null);
        posiljalac.send(request);
        Response response = (Response) primalac.receive();
        if (response.getException() == null) {
            return (List<Projekat>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Projekat dodajProjekat(Projekat p) throws Exception {
        Request zahtev = new Request(Operacije.DODAJ_PROJEKAT, p);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Projekat) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }
    }

    public Resurs dodajResurs(Resurs r) throws Exception {
        Request zahtev = new Request(Operacije.DODAJ_RESURS, r);
        posiljalac.send(zahtev);
        Response odgovor = (Response) primalac.receive();
        if (odgovor.getException() == null) {
            return (Resurs) odgovor.getResult();
        } else {
            throw odgovor.getException();
        }

    }

}
