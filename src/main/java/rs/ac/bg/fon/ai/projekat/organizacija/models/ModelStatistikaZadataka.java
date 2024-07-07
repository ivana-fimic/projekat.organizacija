/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.models;



import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivana
 */
public class ModelStatistikaZadataka extends AbstractTableModel {

    Zadatak z;
    private List<StatistikaZadatka> statistike;
    private boolean editable=true;
    private String[] kolone = {"Član", "Faza Zadatka", "Datum dodele", "Krajnji rok"};
    private boolean[] editableColumns={false,true,true,true}; 
    public ModelStatistikaZadataka() {
        statistike = new ArrayList<>();
    }

    public ModelStatistikaZadataka(List<StatistikaZadatka> statistike) {
        this.statistike = statistike;
    }

    public ModelStatistikaZadataka(Zadatak z) {
        this.z = z;
        try {
            StatistikaZadatka sz = new StatistikaZadatka();
            sz.setZadatak(z);
            statistike = KlijentController.getInstance().vratiStatistike(sz);
            /*  for(StatistikaZadatka s: statistike){
      System.out.println(s.getZadatak().getNazivZadatka()+" "+s.getClan().getIme());
       }*/
        } catch (Exception ex) {
            Logger.getLogger(ModelStatistikaZadataka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<StatistikaZadatka> getStatistike() {
        return statistike;
    }

    public void setStatistike(List<StatistikaZadatka> statistike) {
        this.statistike = statistike;
    }

    @Override
    public int getRowCount() {
        return statistike.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StatistikaZadatka sz = statistike.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sz.getClan();
            
            case 1:
                return sz.getFazaZadatka();
            case 2:
                return sz.getDatumDodele();
            case 3:
                return sz.getKrajnjiRok();

            default:
                return "n/a";
        }
    }

    public String getColumnName(int column) {
        return kolone[column];
    }

    public void obrisiClana(int row) {
        statistike.remove(row);
        fireTableDataChanged();
    }

    public boolean postojiClan(StatistikaZadatka s) {
        for (StatistikaZadatka sz : statistike) {
            if (sz.getClan().getIDClana() == s.getClan().getIDClana()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setValueAt(Object vrednost, int rowIndex, int columnIndex) {
        StatistikaZadatka sz = statistike.get(rowIndex);
        switch (columnIndex) {
           
                
            case 1:
                sz.setFazaZadatka(FazaZadatka.valueOf(vrednost.toString()));
                break;
                
            case 2:
                String datum = (String) vrednost;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate datumDodele = LocalDate.parse(datum, formatter);
                sz.setDatumDodele(datumDodele);
                break;
            case 3:
                String datum2 = (String) vrednost;
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate krajanjiRok = LocalDate.parse(datum2, formatter2);
                sz.setKrajnjiRok(krajanjiRok);
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editableColumns[columnIndex];
    }

    public void dodajClana(StatistikaZadatka sz) {
        statistike.add(sz);
        fireTableDataChanged();
    }

    public void refreshTable() {
        fireTableDataChanged();
    }
 public void setEditable(boolean editable) {
        for (int i = 0; i < editableColumns.length; i++) {
        editableColumns[i] = false;
    }
        fireTableStructureChanged(); // Obavještavamo tabelu o promjeni strukture
    }
}
