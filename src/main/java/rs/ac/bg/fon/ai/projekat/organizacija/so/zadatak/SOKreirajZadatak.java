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
 *Sistemska operacija  za kreiranje novog zadatka i  statistika tih zadataka u bazi podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije.
 * 
 * @author Ivana Fimic
 */

public class SOKreirajZadatak extends AbstractSO {
    /**
     * Kreirani zadatak
     */
private Zadatak z;
    @Override
    /**
     * Validira da li je prosleđeni objekat instanca klase Zadatak.
     * 
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Zadatak
     */
    protected void validate(AbstractDomainObject ado) throws Exception {
       z=(Zadatak) ado;
        if (!(ado instanceof Zadatak)) {
            throw new Exception("Objekat nije instanca Zadatak");
        }
        
       
        
    }
 /**
     * Izvršava operaciju kreiranja novog zadatka i njegovih statistika u bazi podataka.
     * 
     * @param ado Apstraktni domenski objekat koji se koristi za kreiranje (Zadatak)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili kreiranja statistika
     */
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
            throw new Exception("Greska prilikom kreiranja zadatka");
        }
     
    }
     /**
     * Vraća kreirani zadatak.
     * 
     * @return Kreirani zadatak
     */

    public Zadatak getZ() {
        return z;
    }

  

   
    
}
