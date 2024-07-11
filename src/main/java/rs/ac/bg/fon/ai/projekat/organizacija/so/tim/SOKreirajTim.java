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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivana
 */
/**
 * Sistemska operacija  za kreiranje novog tima
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije kreiranja.
 */
public class SOKreirajTim extends AbstractSO {
 /**
     * Tim koji se kreira.
     */
    private Tim tim;
     /**
     * Detalji pozicija za novi tim.
     */
    private DetaljiPozicija dp;

 
/**
     * Validira da li je prosleđeni objekat instanca klase Tim.
     * 
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Tim
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {

        tim = (Tim) ado;
        if (!(ado instanceof Tim)) {
            throw new Exception("Objekat nije instanca Tima");
        }
        

    }
/**
     * Kreiranje novog tima i detalja pozicija za taj tim bazi podataka.
     * 
     * @param ado Apstraktni domenski objekat koji predstavlja novi tim
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili kreiranja tima
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        tim = (Tim) DBBroker.getInstance().insert(ado);
        for (DetaljiPozicija dp : tim.getBrojPozicija()) {
            System.out.println(dp.getPozicija().getNazivPozicije());
        }
        try {
            for (DetaljiPozicija dp : tim.getBrojPozicija()) {
                DetaljiPozicija dp2 = new DetaljiPozicija(tim, dp.getPozicija(), dp.getBrojPozicija());
                AbstractDomainObject ado2 = dp2;
                dp2 = (DetaljiPozicija) DBBroker.getInstance().insert(ado2);

            }

        } catch (Exception ex) {
            throw new Exception("Greska prilikom kreiranja tima");
        }
    }
 /**
     * Vraća kreirani tim.
     * 
     * @return Kreirani tim
     */
    public Tim getTim() {
        return tim;
    }

}
