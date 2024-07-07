/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.pozicije;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Pozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;


/**
 *
 * @author Ivana
 */
public class SOUcitajListuPozicija extends AbstractSO{
  private ArrayList<Pozicija> lista;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof Pozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Pozicija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       ArrayList<AbstractDomainObject> pozicije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Pozicija>) (ArrayList<?>) pozicije;
    }

public ArrayList<Pozicija> getLista() {
    return lista;
}

}
