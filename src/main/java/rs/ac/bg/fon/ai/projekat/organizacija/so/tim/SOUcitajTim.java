/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;

/**
 *
 * @author Ivana
 */
/**
 * Sistemska operacija za učitavanje tima iz baze podataka. Nasleđuje apstraktnu
 * klasu AbstractSO i implementira metode za validaciju i izvršenje operacije.
 */
public class SOUcitajTim extends AbstractSO {

    /**
     * Tim koji ucitavamo iz baze
     */
    Tim timIzBaze;

    /**
     * Validira da li je prosleđeni objekat instanca klase Tim.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Tim
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Tim!");
        }
    }

    /**
     * Izvršava učitavanje tima iz baze podataka.
     *
     * @param ado Apstraktni domenski objekat koji se učitava (Tim)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom
     * podataka ili učitavanja tima
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        timIzBaze = (Tim) DBBroker.getInstance().selectObject(ado);
    }

    /**
     * Vraća učitani tim iz baze podataka.
     *
     * @return Tim koji je učitan iz baze podataka
     */
    public Tim getTimIzBaze() {
        return timIzBaze;
    }

}
