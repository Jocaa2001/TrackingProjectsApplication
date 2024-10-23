/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.angazovanje;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Angazovanje;
import model.ApstraktniDomenskiObjekat;
import model.Predmet;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class LoadListAngazovanje extends ApstraktnaGenerickaOperacija {

    ArrayList<Angazovanje> lista;

    public ArrayList<Angazovanje> getLista() {
        return lista;
    }
    
    
    
    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Angazovanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Angazovanje!");
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
        ArrayList<ApstraktniDomenskiObjekat> angazovanja = DBBroker.getInstance().select(ado);
         lista = (ArrayList<Angazovanje>) (ArrayList<?>) angazovanja;
    }
    
}
