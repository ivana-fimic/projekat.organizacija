/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Admin;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Ivana
 */
public class ThreadServer extends Thread {

   
    private ServerSocket serverSocket;
    private List<Admin> listaPrijavljenih = new ArrayList<>();
    private List<ThreadClient> listaNitiAdmin = new ArrayList<>();
    private List<Clan> listaPrijavljenihClanova = new ArrayList<>();
    private List<ThreadClient> listaNitiClanova = new ArrayList<>();
    
    public ThreadServer() {
        try {
            serverSocket = new ServerSocket(9000);
        } catch (IOException e) {
            System.out.println("Greska prilikom pokretanja servera!" + e);
        }
    }

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                ThreadClient th = new ThreadClient(socket,this);
                listaNitiAdmin.add(th);
                listaNitiClanova.add(th);
                th.start();
            }
        } catch (SocketException se ) {
//            e.printStackTrace();
        }
        catch (IOException ex) {
            System.out.println("Neuspesno povezivanje klijenta na socket!" + ex);
        } finally {
            for (ThreadClient nit : listaNitiAdmin) {
                try {
                    nit.getSocket().close();
                } catch (IOException ex) {
                    System.out.println("Neuspesno povezivanje klijenta na socket!" + ex);
                }
            }

        }
    }

    public List<ThreadClient> getListaNiti() {
        return listaNitiAdmin;
    }

    public void setListaNiti(List<ThreadClient> listaNiti) {
        this.listaNitiAdmin = listaNiti;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public List<Admin> getListaPrijavljenih() {
        return listaPrijavljenih;
    }

    public void setListaPrijavljenih(List<Admin> listaPrijavljenih) {
        this.listaPrijavljenih = listaPrijavljenih;
    }
    

    int dodajKorisnika(Admin ulogovani) {
       if (listaPrijavljenih.contains(ulogovani)) {
            return -1;
        }
        listaPrijavljenih.add(ulogovani);
        
        return 0;
    }

   public void odjava(ThreadClient th) {
        listaNitiAdmin.remove(th);
        listaPrijavljenih.remove(th.getTrenutnoPrijavljeni());
    }

    int dodajClana(Clan ulogovaniClan) {
      if (listaPrijavljenihClanova.contains(ulogovaniClan)) {
            return -1;
        }
        listaPrijavljenihClanova.add(ulogovaniClan);
        
        return 0;
    }

    void odjavaClana(ThreadClient th) {
        listaNitiClanova.remove(th);
        listaPrijavljenihClanova.remove(th.getUlogovaniClan());
    }
}
