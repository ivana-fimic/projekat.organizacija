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
 * Sistemska operacija za učitavanje podataka o članu iz baze podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije učitavanja.
 */
public class SOUcitajClana extends AbstractSO {
    /**
     * Clan kog ucitavamo iz baze
     */
 Clan ClanIzBaze;
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
     * Izvršava operaciju učitavanja podataka o članu iz baze podataka.
     *
     * @param ado Apstraktni domenski objekat(Clan)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili učitavanja podataka o članu
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       ClanIzBaze=(Clan) DBBroker.getInstance().selectObject(ado);
    }
 /**
     * Vraća člana koji je učitan iz baze podataka.
     *
     * @return Član koji je učitan iz baze podataka
     */
    public Clan getClanIzBaze() {
        return ClanIzBaze;
    }
    
}
