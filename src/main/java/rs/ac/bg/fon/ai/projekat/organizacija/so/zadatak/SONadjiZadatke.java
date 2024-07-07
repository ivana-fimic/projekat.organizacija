/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;


/**
 *
 * @author Ivana
 */
public class SONadjiZadatke extends AbstractSO {

    private ArrayList<Zadatak> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Zadatak)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zadatak!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> zadaci = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Zadatak>) (ArrayList<?>) zadaci;

        ArrayList<Zadatak> novaLista = new ArrayList<>();

        for (Zadatak zad : lista) {
            if (!novaLista.contains(zad)) {
                novaLista.add(zad);
            }
        }
        lista = novaLista;
        

    }

    public ArrayList<Zadatak> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Zadatak> lista) {
        this.lista = lista;
    }

}
