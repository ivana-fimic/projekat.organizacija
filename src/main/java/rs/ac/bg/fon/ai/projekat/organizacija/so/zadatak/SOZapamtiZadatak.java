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
 * Sistemska operacija za izmenu zadatka u bazi podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije.
 * 
 * @author Ivana Fimic
 */

public class SOZapamtiZadatak extends AbstractSO {
/**
     * Validira da li je prosleđeni objekat instanca klase Zadatak.
     * 
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Zadatak
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Zadatak)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zadatak!");
        }
    }
 /**
     * Izvršava operaciju update-a zadatka u bazi podataka.
     * Ako je mood tabele zadatka DODATO ili OBRISANO, briše statistiku zadatka iz baze
     * i zatim dodaje novu ili ažurira postojeću statistiku zadatka.
     * 
     * @param ado Apstraktni domenski objekat koji se ažurira (Zadatak)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka
     */
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
