/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Ivana
 */
public class SOKreirajTim extends AbstractSO{
    private Tim tim;
    private DetaljiPozicija dp;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
     tim=(Tim) ado;
        if (!(ado instanceof Tim)) {
            throw new Exception("Objekat nije instanca Tima");
        }if (tim.getNazivTima().isEmpty()) {
            throw new Exception("Naziv Tima ne moze biti prazan");
        }
        if(tim.getBrojClanova()<2){
             throw new Exception("Broj clanova mora biti veci od 1");
        }
       
        
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
     
      tim=(Tim) DBBroker.getInstance().insert(ado);
      for(DetaljiPozicija dp: tim.getBrojPozicija()){
          System.out.println(dp.getPozicija().getNazivPozicije());
      }
       try {
           for(DetaljiPozicija dp: tim.getBrojPozicija()){
               DetaljiPozicija dp2=new DetaljiPozicija(tim,dp.getPozicija(), dp.getBrojPozicija());
               AbstractDomainObject ado2=dp2;
              dp2=(DetaljiPozicija) DBBroker.getInstance().insert(ado2);
               
           }
          
        } catch (Exception ex) {
            Logger.getLogger(SOKreirajTim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tim getTim() {
        return tim;
    }
    
}
