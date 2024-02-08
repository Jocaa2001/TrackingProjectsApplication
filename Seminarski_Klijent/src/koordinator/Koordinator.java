/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koordinator;

import controllers.LoginController;
import forme.LoginForma;

/**
 *
 * @author Win 10
 */
public class Koordinator {
    private static Koordinator instance;
    private LoginController lc;
    
    private Koordinator() {
        
    }

public static Koordinator getInstance() {
        if(instance == null)
            instance = new Koordinator();
        return instance;
    }   

    public void otvoriLoginFormu() {
        lc = new LoginController(new LoginForma());
        lc.otvoriFormu();
    }
}
