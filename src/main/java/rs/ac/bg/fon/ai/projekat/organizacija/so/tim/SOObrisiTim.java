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
import java.util.ArrayList;
import java.util.List;



/**
 *Sistemska operacijaza brisanje tima iz baze podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije brisanja.
 * @author Ivana Fimic
 */

public class SOObrisiTim extends AbstractSO {
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
     * Izvršava operaciju brisanja tima a pre tima  pronalazi i brise detalje za taj tim iz baze podataka.
     * 
     * @param ado Apstraktni domenski objekat koji se briše (Tim)
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili brisanja tima
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Tim t = (Tim) ado;
        DetaljiPozicija dp = new DetaljiPozicija();
        dp.setTim(t);
        ArrayList<AbstractDomainObject> detaljiPozicije = DBBroker.getInstance().select(dp);
        List<DetaljiPozicija> detaljiIzBaze = (ArrayList<DetaljiPozicija>) (ArrayList<?>) detaljiPozicije;

        for (DetaljiPozicija ddp : detaljiIzBaze) {
            AbstractDomainObject ado2 = ddp;
            DBBroker.getInstance().delete(ado2);
        }

        DBBroker.getInstance().delete(ado);
    }

}
