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
/**
 * Sistemska operacija za učitavanje liste pozicija Nasleđuje apstraktnu klasu
 * AbstractSO i implementira metode za validaciju i izvršenje operacije
 * učitavanja.
 */
public class SOUcitajListuPozicija extends AbstractSO {

    /**
     * Lista pozicija učitanih iz baze
     */
    private ArrayList<Pozicija> lista;

    /**
     * Validira da li je prosleđeni objekat instanca klase Pozicija.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Pozicija
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Pozicija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Pozicija!");
        }
    }

    /**
     * Ucitavanje liste pozicija iz baze podataka.
     *
     * @param ado Apstraktni domenski objekat koji se koristi za učitavanje
     * pozicija
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom
     * podataka ili učitavanja pozicija
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> pozicije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Pozicija>) (ArrayList<?>) pozicije;
    }

    /**
     * Vraća listu pozicija nakon uspešnog učitavanja
     *
     * @return Lista pozicija učitana iz baze podataka
     */
    public ArrayList<Pozicija> getLista() {
        return lista;
    }

}
