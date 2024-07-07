/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.resurs;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Resurs;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;



/**
 *
 * @author Ivana
 */
public class SOKreirajResurs extends AbstractSO {

    private Resurs r;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Resurs)) {
            throw new Exception("Objekat nije instanca Resurs");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        r = (Resurs) DBBroker.getInstance().insert(ado);
    }

    public Resurs getR() {
        return r;
    }

}
