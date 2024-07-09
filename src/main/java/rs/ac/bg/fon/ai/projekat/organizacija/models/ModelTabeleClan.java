/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.models;

import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Ivana
 */
public class ModelTabeleClan extends AbstractTableModel implements Runnable {

    String[] kolone = {"ID", "Ime", "Prezime", "Godina studija", "Fakultet", "Tim", "Pozicija"};
    List<Clan> clanovi;
    private String parametar = "";
    Clan clan;
    boolean pronadjen = false;

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    public ModelTabeleClan() {
        try {
            clan = new Clan();
            clan.setParametarZaPretragu(parametar);
            clanovi = KlijentController.getInstance().vratiClanove(clan);
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleTim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return clanovi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan c = clanovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getIDClana();
            case 1:
                return c.getIme();
            case 2:
                return c.getPrezime();
            case 3:
                return c.getGodStudija();
            case 4:
                return c.getFakultet();
            case 5:
                return c.getTim().getNazivTima() + "-" + c.getTim().getProjekat().getNazivProjekta();
            case 6:
                return c.getPozicija().getNazivPozicije();

            default:
                return "n/a";

        }
    }

    public String getColumnName(int column) {

        return kolone[column];
    }

    public Clan vratiOdabraniTim(int row) {
        return clanovi.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ModelTabeleTim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshTable() {
        try {

            pronadjen = true;
            clan = new Clan();
            clan.setParametarZaPretragu(parametar);
            clanovi = KlijentController.getInstance().vratiClanove(clan);
            if (clanovi.isEmpty()) {
                pronadjen = false;
            }
            if (!(parametar.equals(""))) {
                ArrayList<Clan> novaLista = new ArrayList<>();

                for (Clan c : clanovi) {
                    if (parametar.matches(".*\\s\\S.*")) {
                        String[] delovi = parametar.split(" ", 2);

                        String ime = delovi[0];
                        String prezime = delovi[1];
                        if (c.getIme().toLowerCase().contains(ime.toLowerCase())
                                && c.getPrezime().toLowerCase().contains(prezime.toLowerCase())) {
                            novaLista.add(c);

                        }
                    } else {
                        if (c.getIme().toLowerCase().contains(parametar.toLowerCase())
                                || c.getPrezime().toLowerCase().contains(parametar.toLowerCase())) {
                            novaLista.add(c);

                        }
                    }
                }
                clanovi = novaLista;
            }
        /*    if (pronadjen) {
                JOptionPane.showMessageDialog(null, "Sistem je pronašao članove po zadatoj vrednosti", "POTVRDA", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Sistem ne može da pronađe članove po zadatoj vrednosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
            }
*/
            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setParametar(String param) {
        parametar = param;
    }

    public Clan vratiOdabranogClana(int row) {
        return clanovi.get(row);
    }

    public boolean isPronadjen() {
        return pronadjen;
    }

    public void setPronadjen(boolean pronadjen) {
        this.pronadjen = pronadjen;
    }

}
