/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.profesor;

import model.Profesor;
import operacija.ApstraktnaGenerickaOperacija;
import validator.Validator;

/**
 *
 * @author Win 10
 */
public class DodajProfesoraOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object objekat) throws Exception {
         if(objekat == null || !(objekat instanceof Profesor)){
            throw new Exception("Систем не може да креира студента");
        }
        Profesor p = (Profesor) objekat;
        if(p.getIme()==null||p.getIme().isEmpty()||p.getPrezime()==null||p.getPrezime().isEmpty()||p.getZvanje() == null)
                {
             throw new Exception("Грешка, неисправан унос");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.dodaj((Profesor)objekat);
    }
    
    
    
}
