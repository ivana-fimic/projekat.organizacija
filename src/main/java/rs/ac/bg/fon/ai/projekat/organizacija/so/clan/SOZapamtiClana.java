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
 * Sistemska operacija za čuvanje podataka o clanu u bazi podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije čuvanja.
 * 
 * @author Ivana Fimic
 */

public class SOZapamtiClana extends AbstractSO{
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
     * Izvršava operaciju čuvanja podataka o članu u bazi podataka.
     *
     * @param ado Apstraktni domenski objekat koji sadrži podatke o članu koji se čuva
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili čuvanja podataka o članu
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
       DBBroker.getInstance().update(ado);
    }
    
}
