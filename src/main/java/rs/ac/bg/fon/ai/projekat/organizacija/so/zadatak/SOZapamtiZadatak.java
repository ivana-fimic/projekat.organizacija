/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.StatistikaZadatka;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.pomocne.Moodovi;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;



/**
 *
 * @author Ivana
 */
public class SOZapamtiZadatak extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Zadatak)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zadatak!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);

        Zadatak z = (Zadatak) ado;

        if (z.getMoodTabele() == Moodovi.DODATO || z.getMoodTabele() == Moodovi.OBRISANO) {
            StatistikaZadatka sz = new StatistikaZadatka();
            sz.setZadatak(z);
            DBBroker.getInstance().delete(sz);

            for (StatistikaZadatka sz1 : z.getStatistika()) {
                DBBroker.getInstance().insert(sz1);
            }
        } else {
            for (StatistikaZadatka sz : z.getStatistika()) {
                DBBroker.getInstance().update(sz);

            }
        }
    }

}
