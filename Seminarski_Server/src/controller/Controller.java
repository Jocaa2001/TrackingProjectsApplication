/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import hashing.PasswordHasher;
import model.Profesor;
import operacija.login.LoginOperacija;
import repository.db.DBConnectionFactory;
import repository.db.impl.DbRepositoryGeneric;
import validator.LoginValidatorPassword;

/**
 *
 * @author Win 10
 */
public class Controller {
    private static Controller instance;
    private static Profesor ulogovani;
    private DbRepositoryGeneric dbr;
    private Controller() {
        
    }

    public static Controller getInstance() {
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public Profesor login(Profesor p) throws Exception {
        LoginOperacija lo = new LoginOperacija();
        p.setPassword(new PasswordHasher(p.getPassword()).hash());
        System.out.println(p.getPassword() + "ovo je iz login");
        lo.izvrsi(p, null);
        return lo.getProf();
    }

    public boolean validacija(String pass) {
        return new LoginValidatorPassword(pass).Validacija();
    }

      
    
}
