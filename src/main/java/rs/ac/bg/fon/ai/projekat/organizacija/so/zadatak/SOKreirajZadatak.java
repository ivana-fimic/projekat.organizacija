/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import rs.ac.bg.fon.ai.projekat.organizacija.so.tim.SOKreirajTim;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Ivana
 */
public class SOKreirajZadatak extends AbstractSO {
private Zadatak z;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       z=(Zadatak) ado;
        if (!(ado instanceof Zadatak)) {
            throw new Exception("Objekat nije instanca Zadatak");
        }if (z.getNazivZadatka().isEmpty()) {
            throw new Exception("Naziv zadatka ne moze biti prazan");
        }if (z.getTim()==null) {
            throw new Exception("Zadatak mora pripadati nekomy timu");
        }
        
       
        
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
      z=(Zadatak) DBBroker.getInstance().insert(ado);
        System.out.println(z.getIDZadatka());
      
       try {
           for(StatistikaZadatka sz: z.getStatistika()){
               StatistikaZadatka stat=new StatistikaZadatka(sz.getClan(), z,sz.getFazaZadatka(), sz.getDatumDodele(),sz.getKrajnjiRok());
             
               AbstractDomainObject ado2=stat;
              stat=(StatistikaZadatka) DBBroker.getInstance().insert(ado2);
               
           }
          
        } catch (Exception ex) {
            Logger.getLogger(SOKreirajTim.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    public Zadatak getZ() {
        return z;
    }

    public void setZ(Zadatak z) {
        this.z = z;
    }

   
    
}
