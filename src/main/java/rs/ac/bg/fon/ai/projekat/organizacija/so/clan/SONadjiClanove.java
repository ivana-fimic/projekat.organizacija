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
public class SONadjiClanove extends AbstractSO{
List<Clan> lista;
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
         if (!(ado instanceof Clan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Clan!");
    }
    }

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

    public List<Clan> getLista() {
        return lista;
    }
    
}
