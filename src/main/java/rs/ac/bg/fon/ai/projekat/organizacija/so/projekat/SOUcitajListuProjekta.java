/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.projekat;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Projekat;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;



/**
 *
 * @author Ivana
 */
public class SOUcitajListuProjekta extends AbstractSO {

    private ArrayList<Projekat> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Projekat)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Projekat!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> projekti = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Projekat>) (ArrayList<?>) projekti;
        ArrayList<Projekat> novaLista = new ArrayList<>();

        for (Projekat p : lista) {
            if (!novaLista.contains(p)) {
                novaLista.add(p);
            }
        }
        lista = novaLista;

    }

    public ArrayList<Projekat> getLista() {
        return lista;
    }

}
