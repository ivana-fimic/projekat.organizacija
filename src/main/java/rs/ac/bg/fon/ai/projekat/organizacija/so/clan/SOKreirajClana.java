/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.clan;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;



/**
 *
 * @author Ivana
 */
public class SOKreirajClana extends AbstractSO{
private Clan c;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
         c=(Clan) ado;
        if (!(ado instanceof Clan)) {
            throw new Exception("Objekat nije instanca Clana");
        }
        if(!(c.getGodStudija()==1 || c.getGodStudija()==2 || c.getGodStudija()==3 || c.getGodStudija()==4)){
            throw new Exception("Godina studija mora biti 1,2,3 ili 4");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
           c=(Clan) DBBroker.getInstance().insert(ado);
    }

    

    public Clan getC() {
        return c;
    }

}
