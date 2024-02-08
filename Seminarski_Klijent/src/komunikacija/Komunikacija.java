/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import communication.Odgovor;
import communication.Operacija;
import communication.Posiljalac;
import communication.Primalac;
import communication.Zahtev;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Profesor;

/**
 *
 * @author Win 10
 */
public class Komunikacija {
    
    private Socket socket;
    private static Komunikacija instance;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private Komunikacija() {
    }

    public static Komunikacija getInstance() {
        if(instance == null){
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public void konekcija(){
        
        try {
            socket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            System.out.println("Server nije povezan");
        }
        
    }

    public Profesor login(String username, String pass) {
        Profesor p = new Profesor(pass, username);
        Zahtev z = new Zahtev(Operacija.login, p);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        p = (Profesor) odg.getObject();
        return p;
        
    }

    public boolean validate(String pass) {
        Zahtev z = new Zahtev(Operacija.validate, pass);
        return false;
    }

    
    
    
}
