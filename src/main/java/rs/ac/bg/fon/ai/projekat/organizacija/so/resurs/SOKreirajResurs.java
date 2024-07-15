/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.resurs;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Resurs;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;



/**
 * Sistemska operacija  za kreiranje resursa u bazi podataka.
 * Nasleđuje apstraktnu klasu AbstractSO i implementira metode za validaciju i izvršenje operacije kreiranja.
 * @author Ivana Fimic
 */

public class SOKreirajResurs extends AbstractSO {
  /**
     * Resurs koji se kreira
     */
    private Resurs r;
/**
     * Validira da li je prosleđeni objekat instanca klase Resurs.
     *
     * @param ado Apstraktni domenski objekat koji se validira
     * @throws Exception ako prosleđeni objekat nije instanca klase Resurs
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Resurs)) {
            throw new Exception("Objekat nije instanca Resurs");
        }
    }
 /**
     *  Kreira resurs u bazi podataka.
     *
     * @param ado Apstraktni domenski objekat koji predstavlja resurs koji treba kreirati
     * @throws Exception ako se desi greška prilikom komunikacije sa bazom podataka ili kreiranja resursa
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        r = (Resurs) DBBroker.getInstance().insert(ado);
    }
/**
     * Vraća kreirani resurs
     *
     * @return Kreirani resurs
     */
    public Resurs getR() {
        return r;
    }

}
