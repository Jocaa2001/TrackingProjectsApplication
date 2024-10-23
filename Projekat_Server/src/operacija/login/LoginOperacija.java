/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApstraktniDomenskiObjekat;
import model.Profesor;
import operacija.ApstraktnaGenerickaOperacija;
import validator.Validator;

/**
 *
 * @author Win 10
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    private Profesor prof;

    public Profesor getProf() {
        return prof;
    }

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
         if(ado == null || !(ado instanceof Profesor)){
            throw new Exception("Prosledjeni objekat nije instance profesor");
        }
    }

    @Override
    public void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
         ArrayList<ApstraktniDomenskiObjekat> sviObjekti = DBBroker.getInstance().select(ado);
         ArrayList<Profesor> sviProfesori = new ArrayList<>();

    for (ApstraktniDomenskiObjekat objekat : sviObjekti) {
        if (objekat instanceof Profesor) {
            sviProfesori.add((Profesor) objekat);
        }
    }
       
        
        for (Profesor p : sviProfesori) {
             
            if(p.equals((Profesor)ado)){ 
                prof = p;
                return;
            }
        }
        prof = null;
    }
    
    
    
}
