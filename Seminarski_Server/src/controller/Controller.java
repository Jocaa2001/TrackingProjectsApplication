/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Profesor;
import operacija.login.LoginOperacija;
import repository.db.DBConnectionFactory;
import repository.db.impl.DbRepositoryGeneric;

/**
 *
 * @author Win 10
 */
public class Controller {
    public static Controller instance;
    public static Profesor ulogoani;
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
        lo.izvrsi(p, null);
        System.out.println("klasa kontroler "+ p);
        return lo.getProf();
    }

      
    
}
