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
 *Sistemska operacija  za učitavanje liste projekata iz baze podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije učitavanja.
 * @author Ivana Fimic
 */

public class SOUcitajListuProjekta extends AbstractSO {
/**
     * Lista projekata učitana iz baze
     */
    private ArrayList<Projekat> lista;
 /**
     * Validira da li je prosleđeni objekat instanca klase Projekat.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Projekat
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Projekat)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Projekat!");
        }
    }
 /**
     * Izvršava operaciju učitavanja liste projekata iz baze podataka.
     *
     * @param ado Apstraktni domenski objekat koji predstavlja kriterijum pretrage projekata
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili učitavanja projekata
     */
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
/**
     * Vraća listu projekata nakon uspešnog izvršenja operacije.
     *
     * @return Lista projekata
     */
    public ArrayList<Projekat> getLista() {
        return lista;
    }

}
