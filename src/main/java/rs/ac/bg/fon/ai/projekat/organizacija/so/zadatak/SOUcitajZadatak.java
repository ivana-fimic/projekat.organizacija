/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;

/**
 * Sistemska operacija za učitavanje zadatka iz baze podataka. Nasleđuje
 * apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije.
 *
 * @author Ivana Fimic
 */

public class SOUcitajZadatak extends AbstractSO {

    /**
     * Zadatak koji ucitavamo iz baze
     */
    Zadatak zadatakIzBaze;

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
     * Izvršava operaciju učitavanja zadatka iz baze podataka. Postavlja učitani
     * Zadatak iz baze u privatni atribut zadatakIzBaze.
     *
     * @param ado Apstraktni domenski objekat koji se učitava (Zadatak)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom
     * podataka
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        zadatakIzBaze = (Zadatak) DBBroker.getInstance().selectObject(ado);
    }

    /**
     * Vraća učitani Zadatak iz baze.
     *
     * @return Zadatak učitan iz baze
     */
    public Zadatak getZadatakIzBaze() {
        return zadatakIzBaze;
    }

}
