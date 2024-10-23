/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import niti.ObradaKlijentskihZahteva;

/**
 *
 * @author Win 10
 */
public class Server extends Thread {
    boolean kraj = false;
    private ServerSocket ss;
    
    @Override
    public void run() {
        try {
            
            ss = new ServerSocket(9000);
            while(!kraj){
                
                Socket s = ss.accept();
                System.out.println("server je pokrenut");
               
                
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                //controller.Controller.getInstance().listaPrijavljenih.add(okz);
                okz.start();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
   
    public void zaustavi(){
        kraj = true;
        try {
            
            ss.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
