/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import communication.Odgovor;
import communication.Posiljalac;
import communication.Primalac;
import communication.Zahtev;
import controller.klijent.ControllerLogin;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Predmet;
import model.Profesor;
import model.Student;

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
                        p = ControllerLogin.getInstance().login(p);
                        odgovor.setObject(p);
                        break;
                    case validate: 
                        String pass = (String) zahtev.getObject();
                        boolean ispravan = ControllerLogin.getInstance().validacija(pass);
                        odgovor.setObject(ispravan);
                        break;
                    case ucitaj_studente:
                        List<Student> studenti = ControllerLogin.getInstance().ucitajStudente();
                        odgovor.setObject(studenti);
                        break;
                    case ucitaj_predmete:
                        List<Predmet> predmeti = ControllerLogin.getInstance().ucitajPredmete();
                        odgovor.setObject(predmeti);
                        break;
                    case obrisi_predmet:
                        try{
                            Predmet pred = (Predmet) zahtev.getObject();
                            
                            ControllerLogin.getInstance().obrisiPredmet(pred);
                            odgovor.setObject(null);
                        }catch(Exception e){
                            odgovor.setObject(e);
                        }
                        break;
                    case dodaj_studenta:
                        Student s = (Student) zahtev.getObject();
                        ControllerLogin.getInstance().dodajStudenta(s);
                        odgovor.setObject(null);
                        break;
                    default:
                        System.out.println("Greska");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    
    
}
