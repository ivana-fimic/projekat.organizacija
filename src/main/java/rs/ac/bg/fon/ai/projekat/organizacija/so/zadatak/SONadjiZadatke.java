/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.zadatak;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Zadatak;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;


/**
 *
 * @author Ivana
 */

/**
 * Sistemska operacija sistema za pronalaženje zadataka u bazi podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije.
 */
public class SONadjiZadatke extends AbstractSO {
   /**
    * Lista pronadjenih zadataka kao ArrayList
    */
    private ArrayList<Zadatak> lista;
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
     * Izvršava operaciju pronalaženja zadataka u bazi podataka na osnovu prosleđenog zadatka.
     * Primenjuje filtriranje i čišćenje duplikata u pronađenoj listi zadataka.
     * 
     * @param ado Apstraktni domenski objekat koji se koristi za pretragu (Zadatak)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> zadaci = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Zadatak>) (ArrayList<?>) zadaci;

        ArrayList<Zadatak> novaLista = new ArrayList<>();

        for (Zadatak zad : lista) {
            if (!novaLista.contains(zad)) {
                novaLista.add(zad);
            }
        }
        lista = novaLista;
        

    }
/**
     * Vraća listu pronađenih zadataka.
     * 
     * @return Lista pronađenih zadataka
     */
    public ArrayList<Zadatak> getLista() {
        return lista;
    }

  

}
