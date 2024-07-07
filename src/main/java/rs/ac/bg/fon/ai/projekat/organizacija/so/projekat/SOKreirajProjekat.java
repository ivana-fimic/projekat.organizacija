/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.projekat;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;



/**
 *
 * @author Ivana
 */
public class SOKreirajProjekat extends AbstractSO {

    private Projekat p;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Projekat)) {
            throw new Exception("Objekat nije instanca Projekat");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
          p=(Projekat) DBBroker.getInstance().insert(ado);
        }

    public Projekat getP() {
        return p;
    }

}
