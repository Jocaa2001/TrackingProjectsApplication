/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import communication.Odgovor;
import communication.Posiljalac;
import communication.Primalac;
import communication.Zahtev;
import java.net.Socket;

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
            Zahtev zahtev = (Zahtev) primalac.primi();
            Odgovor odgovor = new Odgovor();
            switch (zahtev.getOperation()) {
               // case val:
                    
                   // break;
                default:
                    System.out.println("ok");
            }
             posiljalac.posalji(odgovor);
        }
       
    }
    
    
    
}
