/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import communication.Odgovor;
import communication.Operacija;
import communication.Posiljalac;
import communication.Primalac;
import communication.Zahtev;
import controller.Controller;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;
import model.Projekat;
import model.Student;

/**
 *
 * @author Win 10
 */
public class ObradaKlijentskihZahteva extends Thread {
    
    //Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva(Socket socket) {
        //this.socket = socket;
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
                         
                         p = controller.Controller.getInstance().login(p);
                        odgovor.setObject(p);
                         
                      break;
                    case ucitaj_studente:
                       List<Student> studenti = Controller.getInstance().ucitajStudente();
                       odgovor.setObject(studenti);
                       break;
                    case dodaj_studenta:
                        try{
                        Student s = (Student) zahtev.getObject();
                        Controller.getInstance().saveStudent(s);
                        odgovor.setObject(null);
                            
                        }catch(Exception e){
                            odgovor.setObject(e);
                        }
                        break;
                    case ucitaj_predmete:
                       List<Predmet> predmeti = Controller.getInstance().ucitajPredmete();
                       odgovor.setObject(predmeti);
                       break;
                    case obrisi_predmet:
                        try{
                            Predmet pred = (Predmet) zahtev.getObject();
                            
                            Controller.getInstance().obrisiPredmet(pred);
                            odgovor.setObject(null);
                        }catch(Exception e){
                            odgovor.setObject(e);
                        }
                        break;
                    case dodaj_angazovanje:
                        try{
                        Angazovanje a = (Angazovanje) zahtev.getObject();
                        Controller.getInstance().saveAngazovanje(a);
                        odgovor.setObject(null);
                        
                        }catch(Exception e){
                            e.printStackTrace();
                            odgovor.setObject(e);
                        }
                        break;
                    case ucitaj_profesore:
                       List<Profesor> profesori = Controller.getInstance().UcitajListuProfesora();
                       odgovor.setObject(profesori);
                       break;
                    case ucitaj_angazovanja:
                       List<Angazovanje> angazovanja = Controller.getInstance().ucitajListuAngazovanja();
                       odgovor.setObject(angazovanja);
                       break;
                    case ucitaj_projekte:
                        List<Projekat> projekti = controller.Controller.getInstance().ucitajListuProjekata();
                        odgovor.setObject(projekti);
                        break;
                    case dodaj_projekat:
                        try{
                        Projekat proj = (Projekat) zahtev.getObject();
                            System.out.println(proj);
                        Controller.getInstance().saveProjekat(proj);
                            
                        odgovor.setObject(null);
                            
                        }catch(Exception e){
                            e.printStackTrace();
                            
                            odgovor.setObject(e);
                        }
                        break;
                    case izmeni_projekat:
                        try{
                            
                        Projekat proj = (Projekat) zahtev.getObject();
                           
                        Controller.getInstance().izmeniProjekat(proj);
                        odgovor.setObject(null);
                            
                        }catch(Exception e){
                            odgovor.setObject(e);
                            e.printStackTrace();
                        }
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
