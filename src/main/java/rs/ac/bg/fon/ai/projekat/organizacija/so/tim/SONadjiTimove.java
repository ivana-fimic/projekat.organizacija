/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;

/**
 * Sistemska operacija za pronalaženje timova iz baze podataka. Nasleđuje
 * apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje
 * operacije pretrage.
 * @author Ivana Fimic
 */

public class SONadjiTimove extends AbstractSO {

    /**
     * Lista timova dobijenih iz baze podataka.
     */
    private ArrayList<Tim> lista;

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
     * Pretrazuje timova u bazi podataka.
     *
     * @param ado Apstraktni domenski objekat koji se koristi za pretragu timova
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom
     * podataka ili pretrage timova
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> timovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Tim>) (ArrayList<?>) timovi;

        ArrayList<Tim> novaLista = new ArrayList<>();

        for (Tim zad : lista) {
            if (!novaLista.contains(zad)) {
                novaLista.add(zad);
            }
        }
        lista = novaLista;
    }

    /**
     * Vraća listu pronađenih timova.
     *
     * @return Lista timova pronađenih u bazi podataka
     */
    public ArrayList<Tim> getLista() {
        return lista;
    }

}
