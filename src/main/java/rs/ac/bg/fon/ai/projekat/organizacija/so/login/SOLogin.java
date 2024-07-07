/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.so.login;

import rs.ac.bg.fon.ai.projekat.organizacija.dbb.DBBroker;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.AbstractDomainObject;
import rs.ac.bg.fon.ai.projekat.organizacija.domain.Admin;
import rs.ac.bg.fon.ai.projekat.organizacija.so.AbstractSO;
import java.util.ArrayList;



/**
 *
 * @author Ivana
 */
public class SOLogin extends AbstractSO{
Admin ulogovani;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Admin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Admin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Admin a = (Admin) ado;

        ArrayList<Admin> sviAdministratori
                = (ArrayList<Admin>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Admin admin : sviAdministratori) {
            if (admin.getKorisnickoIme().equals(a.getKorisnickoIme())
                    && admin.getLozinka().equals(a.getLozinka())) {
                ulogovani = admin;
                return;
            }
        }

        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
    }
    public Admin getUlogovani() {
        return ulogovani;
    }
    
}
