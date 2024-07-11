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
/**
 * Sistemska operacija za vraćanje liste statistika zadatka iz baze podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i
 * izvršenje operacije vraćanja liste.
 */
public class SOVratiListuStatistika extends AbstractSO {

    /**
     * Lista statistika zadatka koja se vraća iz baze podataka.
     */
    private List<StatistikaZadatka> lista;

    /**
     * Validira da li je prosleđeni objekat instanca klase StatistikaZadatka.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase
     * StatistikaZadatka
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StatistikaZadatka)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Statistika!");
        }
    }
 /**
     * Vraćanje liste statistika zadatka iz baze podataka.
     * 
     * @param ado Apstraktni domenski objekat koji predstavlja statistiku zadatka
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili vraćanja liste statistika
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> stat = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StatistikaZadatka>) (ArrayList<?>) stat;
    }
  /**
     * Vraća listu statistika zadatka.
     * 
     * @return Lista statistika zadatka
     */
    public List<StatistikaZadatka> getLista() {
        return lista;
    }

 

}
