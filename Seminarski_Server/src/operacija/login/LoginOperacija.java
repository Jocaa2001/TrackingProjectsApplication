/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Profesor;
import operacija.ApstraktnaGenerickaOperacija;
import validator.LoginValidatorPassword;

/**
 *
 * @author Win 10
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    private Profesor prof;
    
    @Override
    protected void preduslovi(Object objekat) {
        return;
    }
    
    @Override
    protected void izvrsiOperaciju (Object objekat, String kljuc)throws Exception {
        List<Profesor> sviProfesori = broker.pretraga((Profesor) objekat, null);
        
        
        for (Profesor p : sviProfesori) {
             System.out.println(p.getPassword());
            if(p.equals((Profesor)objekat)){
               
                prof = p;
                return;
            }
        }
        prof = null;
    }

    public Profesor getProf() {
        return prof;
    }
    
    
    
}
