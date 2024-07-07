/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.models;

import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;





/**
 *
 * @author Ivana
 */
public class ModelTabeleZadatak extends AbstractTableModel implements Runnable {

    String[] kolone = {"ID", "Naziv zadatka", "Tim"};
    List<Zadatak> zadatak = new ArrayList<>();
    private String parametar = "";
    private boolean pronadjen = false;

    public List<Zadatak> getZadatak() {
        return zadatak;
    }

    public ModelTabeleZadatak() {
        try {
            Zadatak zad = new Zadatak();
            zad.setParametarZaPretragu(parametar);
            zadatak = KlijentController.getInstance().vratiZadatke(zad);

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleZadatak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return zadatak.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Zadatak z = zadatak.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return z.getIDZadatka();
            case 1:
                return z.getNazivZadatka();
            case 2:
                return z.getTim().getNazivTima() + "-" + z.getTim().getIDProjekta().getNazivProjekta();

            default:
                return "n/a";

        }

    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ModelTabeleZadatak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshTable() {
        try {
            pronadjen = true;
            Zadatak z = new Zadatak();

            z.setParametarZaPretragu(parametar);
            zadatak = KlijentController.getInstance().vratiZadatke(z);
            if (zadatak.isEmpty()) {
                pronadjen = false;
            }
            if (!(parametar.equals(""))) {
                ArrayList<Zadatak> novaLista = new ArrayList<>();

                for (Zadatak za : zadatak) {

                    if (za.getNazivZadatka().toLowerCase().contains(parametar.toLowerCase()
                    )) {

                        novaLista.add(za);
                    }

                }
                zadatak = novaLista;
              /*  if (pronadjen) {
                    JOptionPane.showMessageDialog(null, "Sistem je pronašao zadatke po zadatoj vrednosti", "POTVRDA", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da pronađe zadatke po zadatoj vrednosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
                }
*/
                fireTableDataChanged();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getParametar() {
        return parametar;
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
    }

    public Zadatak vratiOdabraniZadatak(int row) {
        return zadatak.get(row);
    }

}
