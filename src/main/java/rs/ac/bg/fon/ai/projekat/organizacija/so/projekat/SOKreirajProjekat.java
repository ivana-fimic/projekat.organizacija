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
 * Sistemska operacija za kreiranje novog projekta i čuvanje u bazu podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i
 * izvršenje operacije kreiranja.
 * @author Ivana Fimic
 */

public class SOKreirajProjekat extends AbstractSO {

    /**
     * Projekat koji će biti kreiran
     */
    private Projekat p;

    /**
     * Validira da li je prosleđeni objekat instanca klase Projekat.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Projekat
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Projekat)) {
            throw new Exception("Objekat nije instanca Projekat");
        }
    }
     /**
     * Sistemska operacija kreiranja projekta
     *
     * @param ado Apstraktni domenski objekat koji predstavlja projekat koji se kreira
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili čuvanja projekta
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        p = (Projekat) DBBroker.getInstance().insert(ado);
    }
    /**
     * Vraća kreirani projekat nakon uspešnog izvršenja operacije.
     *
     * @return Kreirani projekat
     */

    public Projekat getP() {
        return p;
    }

}
