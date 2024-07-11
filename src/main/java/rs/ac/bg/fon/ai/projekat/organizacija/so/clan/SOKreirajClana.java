/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.clan;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Clan;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;

/**
 *
 * @author Ivana
 */
/**
 * Sistemska operacija za kreiranje novog člana Nasleđuje apstraktnu klasu
 * AbstractSO i implementira metode za validaciju i izvršenje operacije
 * kreiranja.
 */
public class SOKreirajClana extends AbstractSO {

    /**
     * Clan kog cemo kreirati
     */
    private Clan c;

    /**
     * Validira da li je prosleđeni objekat instanca klase Clan.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Clan
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        c = (Clan) ado;
        if (!(ado instanceof Clan)) {
            throw new Exception("Objekat nije instanca Clana");
        }

    }
     /**
     * Kreiranje novog člana 
     *
     * @param ado Apstraktni domenski objekat koji predstavlja novog člana
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili kreiranja člana
     */

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        c = (Clan) DBBroker.getInstance().insert(ado);
    }
    
    /**
     * Vraća objekat člana koji je kreiran
     *
     * @return Objekat člana koji je kreiran i sačuvan
     */

    public Clan getC() {
        return c;
    }

}
