/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import communication.Odgovor;
import communication.Posiljalac;
import communication.Primalac;
import communication.Zahtev;
import controller.Controller;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Profesor;

/**
 *
 * @author Win 10
 */
public class ObradaKlijentskihZahteva extends Thread {
    
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }
    
    
    
    @Override
    public void run() {
        while(true){
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = new Odgovor();
                switch (zahtev.getOperation()) {
                    case login:
                        Profesor p = (Profesor) zahtev.getObject();
                        p = Controller.getInstance().login(p);
                        odgovor.setObject(p);
                        break;
                    default:
                        System.out.println("ok");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    
    
}
