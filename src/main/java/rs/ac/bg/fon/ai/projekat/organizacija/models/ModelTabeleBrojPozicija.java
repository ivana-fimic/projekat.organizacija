/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.models;

import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
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
public class ModelTabeleBrojPozicija extends AbstractTableModel{
private String[] kolone = {"Pozicija", "Broj pozicija"};
    
    private Tim t;
    private List<DetaljiPozicija> pozicije;

    public ModelTabeleBrojPozicija() {
        pozicije=new ArrayList<>();
    }
    
    

    public ModelTabeleBrojPozicija( List<DetaljiPozicija> pozicije) {
         this.pozicije=pozicije;
    }

    public ModelTabeleBrojPozicija(Tim t) {
        this.t = t;
    try {
        pozicije=KlijentController.getInstance().vratiDetaljePozicije(t);
    } catch (Exception ex) {
        Logger.getLogger(ModelTabeleBrojPozicija.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    @Override
    public int getRowCount() {
       return pozicije.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
                
    }

    public List<DetaljiPozicija> getPozicije() {
        return pozicije;
    }

    public void setPozicije(List<DetaljiPozicija> pozicije) {
        this.pozicije = pozicije;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      DetaljiPozicija p=pozicije.get(rowIndex);
         switch (columnIndex) {
            case 0:
                return p.getPozicija().getNazivPozicije();
            case 1:
                return p.getBrojPozicija();
            default:
                return "n/a";
        }
    }
     public String getColumnName(int column) {
       return kolone[column];
    }

    public void obrisiPoziciju(int row) {
      pozicije.remove(row);
      fireTableDataChanged();
    }

    public boolean postojiPozicija(DetaljiPozicija p) {
        for(DetaljiPozicija poz: pozicije){
            if(poz.getPozicija().getIDPozicije()==p.getPozicija().getIDPozicije()){
                return true;
            }
        }
        return false;
    }

    public void dodajPoziciju(DetaljiPozicija p) {
      pozicije.add(p);
      fireTableDataChanged();
    }

    public void refreshTable() {
        fireTableDataChanged();
    }
     
     
}
