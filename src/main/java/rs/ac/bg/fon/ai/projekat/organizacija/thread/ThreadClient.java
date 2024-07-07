/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.thread;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija.Request;
import rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija.Response;
import rs.ac.bg.fon.ai.projekat.organizacija.controllerServer
.ServerController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Admin;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
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
public class ThreadClient extends Thread {

    private Socket socket;
    private boolean signal = true;
    ThreadServer server;
    Admin trenutnoPrijavljeni;
    Clan ulogovaniClan;

    ThreadClient(Socket socket, ThreadServer server) {
        this.socket = socket;
        this.server = server;
    }

    public Clan getUlogovaniClan() {
        return ulogovaniClan;
    }

    public void setUlogovaniClan(Clan ulogovaniClan) {
        this.ulogovaniClan = ulogovaniClan;
    }

    public Admin getTrenutnoPrijavljeni() {
        return trenutnoPrijavljeni;
    }

    public void setTrenutnoPrijavljeni(Admin trenutnoPrijavljeni) {
        this.trenutnoPrijavljeni = trenutnoPrijavljeni;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (SocketException se) {
            server.getListaNiti().remove(this);
        } catch (Exception ex) {
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null);
        try {

            switch (request.getOperacija()) {
                case Operacije.LOGIN:
                    Admin ulogovani = (Admin) request.getArgument();
                    trenutnoPrijavljeni = ServerController.getInstance().login(ulogovani);
                    if (server.dodajKorisnika(trenutnoPrijavljeni) == 0) {
                        response.setResult(trenutnoPrijavljeni);
                    } else {
                        response.setException(new Exception("Ovaj korisnik je vec prijavljen!"));
                    }

                    break;

                case Operacije.DODAJ_TIM:
                    Tim t = (Tim) request.getArgument();
                    t = ServerController.getInstance().dodajTim(t);
                    response.setResult(t);
                    break;

                case Operacije.VRATI_POZICIJE:
                    response.setResult(ServerController.getInstance().vratiPozicije());
                    break;

                case Operacije.VRATI_TIMOVE:
                    Tim tim = (Tim) request.getArgument();
                    List<Tim> timovi = ServerController.getInstance().nadjiTimove(tim);
                    response.setResult(timovi);
                    break;

                

                case Operacije.IZMENI_TIM:
                    ServerController.getInstance().zapamtiTim((Tim) request.getArgument());
                    break;

                case Operacije.OBRISI_TIM:
                    ServerController.getInstance().obrisiTim((Tim) request.getArgument());
                    break;

                case Operacije.DODAJ_ČLANA:
                    Clan c = (Clan) request.getArgument();
                    c = ServerController.getInstance().dodajClana(c);
                    response.setResult(c);
                    break;
                case Operacije.VRATI_CLANOVE:
                    Clan clan = (Clan) request.getArgument();
                    List<Clan> lista = ServerController.getInstance().nadjiClanove(clan);
                    response.setResult(lista);
                    break;

                case Operacije.IZMENI_CLANA:
                    ServerController.getInstance().zapamtiClana((Clan) request.getArgument());
                    break;
                case Operacije.DODAJ_ZADATAK:
                    Zadatak z = (Zadatak) request.getArgument();
                    z = ServerController.getInstance().dodajZadatak(z);
                    response.setResult(z);
                    break;
                case Operacije.VRATI_ZADATKE:
                    Zadatak zad = (Zadatak) request.getArgument();
                    List<Zadatak> zadaci = ServerController.getInstance().nadjiZadatke(zad);
                    response.setResult(zadaci);
                    break;
                case Operacije.IZMENI_ZADATAK:
                    ServerController.getInstance().zapamtiZadatak((Zadatak) request.getArgument());
                    break;

                case Operacije.VRATI_STATISTIKE:
                    response.setResult(ServerController.getInstance().vratiStatistike((StatistikaZadatka) request.getArgument()));
                    break;

                case Operacije.LOGIN_CLAN:
                    Clan cla = (Clan) request.getArgument();
                    ulogovaniClan = ServerController.getInstance().loginClana(cla);

                    if (server.dodajClana(ulogovaniClan) == 0) {
                        response.setResult(ulogovaniClan);
                    } else {
                        response.setException(new Exception("Ovaj clan je vec prijavljen!"));
                    }
                    break;

                case Operacije.ODJAVA:
                    server.odjava(this);
                    response.setResult("Korisnik uspesno odjavljen");
                    break;

                case Operacije.ODJAVA_CLANA:
                    server.odjavaClana(this);
                    response.setResult("Clan uspesno odjavljen");
                    break;
                    
                    case Operacije.VRATI_SVE_TIMOVE:
                    response.setResult(ServerController.getInstance().vratiSveTimove());
                    break;
                    
                    case Operacije.UCITAJ_CLANA:
                    Clan poslatiClan = (Clan) request.getArgument();
                    Clan cizBaze = ServerController.getInstance().ucitajClana(poslatiClan);
                    response.setResult(cizBaze);
                    break;
                    
                    case Operacije.UCITAJ_TIM:
                    Tim poslatiTim = (Tim) request.getArgument();
                    Tim tizBaze = ServerController.getInstance().ucitajTim(poslatiTim);
                    response.setResult(tizBaze);
                    break;
                    
                    case Operacije.UCITAJ_ZADATAK:
                    Zadatak poslatiZadatak = (Zadatak) request.getArgument();
                    Zadatak zizBaze = ServerController.getInstance().ucitajZadatak(poslatiZadatak);
                    response.setResult(zizBaze);
                    break;
                    
                     case Operacije.VRATI_SVE_PROJEKTE:
                    response.setResult(ServerController.getInstance().vratiProjekte());
                    break;
                    
                    case Operacije.DODAJ_PROJEKAT:
                    Projekat p = (Projekat) request.getArgument();
                    p = ServerController.getInstance().dodajProjekat(p);
                    response.setResult(p);
                    break;
                    
                    case Operacije.DODAJ_RESURS:
                    Resurs r = (Resurs) request.getArgument();
                    r = ServerController.getInstance().dodajResurs(r);
                    response.setResult(r);
                    break;

            }

        } catch (Exception ex) {
            response.setException(ex);

        }

        return response;
    }
}
