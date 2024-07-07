/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.models;

import rs.ac.bg.fon.ai.projekat.organizacija.controller.KlijentController;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.FazaZadatka;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author Ivana
 */
public class ModelTabeleZaIzmenuFazeZadatka extends AbstractTableModel {

    Clan c;
    private List<StatistikaZadatka> statistike;
    private String[] kolone = {"Tim", "Član", "Zadatak", "Faza Zadatka", "Datum dodele", "Krajnji rok"};

    @Override

    public int getRowCount() {
        return statistike.size();
    }

    public ModelTabeleZaIzmenuFazeZadatka(List<StatistikaZadatka> statistike) {
        this.statistike = statistike;
    }

    public ModelTabeleZaIzmenuFazeZadatka(Clan c) {
        this.c = c;
        StatistikaZadatka sz=new StatistikaZadatka();
        sz.setClan(c);
        try {
            statistike = KlijentController.getInstance().vratiStatistike(sz);
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleZaIzmenuFazeZadatka.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                return sz.getClan().getTim().getNazivTima() + "-" + sz.getClan().getTim().getIDProjekta().getNazivProjekta();
            case 1:
                return sz.getClan().getIme() + " " + sz.getClan().getPrezime();
            case 2:
                return sz.getZadatak().getNazivZadatka();
            case 3:
              
                return sz.getFazaZadatka();
            case 4:
                return sz.getDatumDodele();
            case 5:
                return sz.getKrajnjiRok();

            default:
                return "n/a";
        }
    }

    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public void setValueAt(Object faza, int rowIndex, int columnIndex) {
    StatistikaZadatka sz = statistike.get(rowIndex);
        switch (columnIndex) {

            
               
            case 3:
                sz.setFazaZadatka(FazaZadatka.valueOf(faza.toString()));
            break;
            
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return columnIndex==3;
    }

    public List<StatistikaZadatka> getStatistike() {
        return statistike;
    }

    public void setStatistike(List<StatistikaZadatka> statistike) {
        this.statistike = statistike;
    }

}
