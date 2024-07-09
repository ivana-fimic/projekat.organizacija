/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.models;

import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Ivana
 */
public class ModelTabeleTim extends AbstractTableModel implements Runnable {

    String[] kolone = {"ID", "Naziv tima", "Naziv projekta", "Broj clanova"};
    List<Tim> tim = new ArrayList<>();
    private String parametar = "";
    boolean pronadjen = false;
    private boolean stopRequested = false;

    public ModelTabeleTim() {
        try {
            Tim timZaP = new Tim();
            timZaP.setParametarZaPretragu(parametar);
            tim = KlijentController.getInstance().vratiTimove(timZaP);

        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleTim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Tim> getTim() {
        return tim;
    }

    public void setTim(List<Tim> tim) {
        this.tim = tim;
    }

    @Override
    public int getRowCount() {
        return tim.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tim t = tim.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getIDTima();
            case 1:
                return t.getNazivTima();
            case 2:
                return t.getProjekat().getNazivProjekta();
            case 3:
                return t.getBrojClanova();

            default:
                return "n/a";

        }
    }

    public String getColumnName(int column) {

        return kolone[column];
    }

    public Tim vratiOdabraniTim(int row) {
        return tim.get(row);
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
            Tim t = new Tim();
            System.out.println("Usao za refreh");
            t.setParametarZaPretragu(parametar);

            tim = KlijentController.getInstance().vratiTimove(t);
            if (tim.isEmpty()) {
                pronadjen = false;
            }

            if (!(parametar.equals(""))) {
                ArrayList<Tim> novaLista = new ArrayList<>();
                for (Tim t3 : tim) {
                    if (t3.getNazivTima().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t3);
                        System.out.println("usao");
                    }
                }
                tim = novaLista;

            }
          /*  if (pronadjen) {
                JOptionPane.showMessageDialog(null, "Sistem je pronašao timove po zadatoj vrednosti", "POTVRDA", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Sistem ne može da pronađe timove po zadatoj vrednosti", "GRESKA", JOptionPane.ERROR_MESSAGE);
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

    public void stopRefreshing() {
        stopRequested = true;
    }
}
