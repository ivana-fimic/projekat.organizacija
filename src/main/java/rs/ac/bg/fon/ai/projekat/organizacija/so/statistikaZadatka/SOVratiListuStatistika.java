/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.statistikaZadatka;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Ivana
 */
public class SOVratiListuStatistika extends AbstractSO {
private List<StatistikaZadatka> lista;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
       if (!(ado instanceof StatistikaZadatka)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Statistika!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> stat = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StatistikaZadatka>) (ArrayList<?>) stat;
    }

    public List<StatistikaZadatka> getLista() {
        return lista;
    }

    public void setLista(List<StatistikaZadatka> lista) {
        this.lista = lista;
    }
    
}
