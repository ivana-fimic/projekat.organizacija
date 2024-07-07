/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Ivana
 */
public abstract class AbstractDomainObject implements Serializable {
    public abstract String nazivTabele();
    public abstract String alijas();
    public abstract String join();
    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;
    public abstract String koloneZaInsert();
    public abstract String vrednostiZaInsert();
    public abstract String uslov();
    public abstract String uslovZaDelete();
    public abstract String vrednostiZaUpdate();
    public abstract String uslovZaSelect();
    public abstract AbstractDomainObject vratiObjekat(ResultSet rs) throws SQLException;
    public abstract void setAutoIncrementPrimaryKey(int generatedKey);

    
      
    
    
}
