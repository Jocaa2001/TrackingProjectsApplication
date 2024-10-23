/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.profesor;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ApstraktniDomenskiObjekat;
import model.Profesor;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class SaveProfesor extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
        if(!(ado instanceof Profesor)){
            throw new Exception("Prosledjeni objekat nije instanca klase Termin!");
        }
        
        Profesor p = (Profesor) ado;
        
        ArrayList<Profesor> lista = (ArrayList<Profesor>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Profesor prof : lista) {
            if(prof.getIme().equals(p.getIme())&& prof.getPrezime().equals(p.getPrezime())){
                throw new Exception("U bazi vec postoji profesor sa istim imenom i prezimenom");
            }
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }
    
}
