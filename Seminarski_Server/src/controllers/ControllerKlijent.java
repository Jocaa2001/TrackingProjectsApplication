/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forme.LogInForma;
import forme.ServerskaForma;
import hashing.PasswordHasher;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Predmet;
import model.Profesor;
import model.Student;
import operacija.login.LoginOperacija;
import operacija.predmet.ObrisiPredmetOperacija;
import operacija.predmet.UcitajPredmeteOperacija;
import operacija.student.DodajStudentaOperacija;
import operacija.student.UcitajStudenteOperacija;
import repository.db.DBConnectionFactory;
import repository.db.impl.DbRepositoryGeneric;
import validator.Validator;

/**
 *
 * @author Win 10
 */
public class ControllerKlijent {
    private static ControllerKlijent instance;

    public static Profesor ulogovaniAdmin;
    private DbRepositoryGeneric dbr;
   
    
    private ControllerKlijent() {
        
    }

    public static ControllerKlijent getInstance() {
        if(instance == null)
            instance = new ControllerKlijent();
        return instance;
    }

    public Profesor login(Profesor p) throws Exception {
        LoginOperacija lo = new LoginOperacija();
        p.setPassword(new PasswordHasher(p.getPassword()).hash());
        //System.out.println(p.getPassword() + "ovo je iz login");
        lo.izvrsi(p, null);
        return lo.getProf();
    }

    public boolean validacija(String pass) {
        return new Validator().validatorPassworda(pass);
    }

    public List<Student> ucitajStudente() throws Exception {
        UcitajStudenteOperacija operacija = new UcitajStudenteOperacija();
        operacija.izvrsi(null, null);
        //System.out.println("KLASA KONTROLER" + operacija.getStudenti());
        return operacija.getStudenti();
    }

    public List<Predmet> ucitajPredmete() throws Exception {
        UcitajPredmeteOperacija operacija = new UcitajPredmeteOperacija();
        operacija.izvrsi(null, null);
        //System.out.println("KLASA KONTROLER" + operacija.getPredmeti());
        return operacija.getPredmeti();
    }

    public void obrisiPredmet(Predmet pred) throws Exception {
        
        ObrisiPredmetOperacija operacija = new ObrisiPredmetOperacija();
        operacija.izvrsi(pred, null);
        
    }

    public void saveStudent(Student s) throws Exception {
        
        DodajStudentaOperacija dso = new DodajStudentaOperacija();
        dso.izvrsi(s, null);
    }

   

   
    
}
