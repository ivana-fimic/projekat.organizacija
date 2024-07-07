/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.clan;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;



/**
 *
 * @author Ivana
 */
public class SOLoginClana extends AbstractSO{
 Clan ulogovani;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
     Clan c = (Clan) ado;
        System.out.println(c.getPassword());
        ArrayList<Clan> sviClanovi
                = (ArrayList<Clan>) (ArrayList<?>) DBBroker.getInstance().select(ado);
     
 
   
       
        for (Clan clan : sviClanovi) {
            if(clan.getUsername()==null && clan.getParametarZaPretragu()==null){
               continue;
            }
            else{
            if (clan.getUsername().equals(c.getUsername())
                    && clan.getPassword().equals(c.getPassword())) {
                ulogovani = clan;
                return ;
            }
            }
           
      
        }

        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
    }

    public Clan getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Clan ulogovani) {
        this.ulogovani = ulogovani;
    }
    
}
