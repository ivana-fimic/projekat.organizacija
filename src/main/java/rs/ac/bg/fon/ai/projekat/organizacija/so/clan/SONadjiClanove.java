/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.clan;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Ivana
 */
/**
 * Sistemska operacija za pretragu i učitavanje liste članova iz baze podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije pretrage.
 */
public class SONadjiClanove extends AbstractSO{
List<Clan> lista;
/**
     * Validira da li je prosleđeni objekat instanca klase Clan.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Clan
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
         if (!(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
    }
    }
 /**
     * Izvršava operaciju pronalaženja clana u bazi podataka na osnovu prosleđenog clana.
     *
     * @param ado Apstraktni domenski objekat koji može sadržati kriterijume pretrage članova
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili pretrage članova
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> clanovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Clan>) (ArrayList<?>) clanovi;
     /*    ArrayList<Clan> novaLista = new ArrayList<>();
         for (Clan cl : lista) {
            if (!novaLista.contains(cl)) {
                novaLista.add(cl);
            }
        }
        lista = novaLista;
*/
    }
    /**
     * Vraća listu članova koja je učitana iz baze podataka.
     *
     * @return Lista članova učitana iz baze podataka
     */

    public List<Clan> getLista() {
        return lista;
    }
    
}
