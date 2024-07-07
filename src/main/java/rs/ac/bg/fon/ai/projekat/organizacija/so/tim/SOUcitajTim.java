/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;



/**
 *
 * @author Ivana
 */
public class SOUcitajTim extends AbstractSO {
Tim timIzBaze;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       timIzBaze=(Tim) DBBroker.getInstance().selectObject(ado);
    }

    public Tim getTimIzBaze() {
        return timIzBaze;
    }
    
}
