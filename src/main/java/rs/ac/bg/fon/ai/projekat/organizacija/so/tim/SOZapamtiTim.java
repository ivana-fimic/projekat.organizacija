/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.tim;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.DetaljiPozicija;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Tim;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;



/**
 *
 * @author Ivana
 */

/**
 * Sistemska operacija za ažuriranje tima i njegovih detalja u bazi podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije.
 */
public class SOZapamtiTim extends AbstractSO {
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
     * Izvršava operaciju ažuriranja tima i njegovih detalja u bazi podataka.
     * 
     * @param ado Apstraktni domenski objekat koji se ažurira (Tim)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili ažuriranja detalja
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);

        Tim t = (Tim) ado;
        DetaljiPozicija dp = new DetaljiPozicija();
        dp.setTim(t);
        DBBroker.getInstance().delete(dp);

        for (DetaljiPozicija dp1 : t.getBrojPozicija()) {
            DBBroker.getInstance().insert(dp1);
        }

    }
}
