/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Profesor;
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

      
    
}
