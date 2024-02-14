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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Predmet;
import model.Profesor;
import model.Projekat;
import model.Student;

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
        posiljalac.posalji(z);
        
        Odgovor odg = (Odgovor) primalac.primi();
        boolean ispravan = (boolean) odg.getObject();
        return ispravan;
    }

    public List<Student> loadListStudent() {
        Zahtev z = new Zahtev(Operacija.ucitaj_studente, null);
        List <Student> studenti = new ArrayList<>();
        posiljalac.posalji(z);
        
        
        
        Odgovor odg = (Odgovor) primalac.primi();
        studenti = (List<Student>) odg.getObject();
        return studenti;
    }

    public List<Predmet> loadListPredmet() {
        Zahtev z = new Zahtev(Operacija.ucitaj_predmete, null);
        List<Predmet> predmeti = new ArrayList<>();
        posiljalac.posalji(z);
        
        
        Odgovor odg = (Odgovor) primalac.primi();
        predmeti = (List<Predmet>) odg.getObject();
        return predmeti;
    }

    public void deletePredmet(Predmet p) throws Exception {
        Zahtev z = new Zahtev(Operacija.obrisi_predmet, p);
        posiljalac.posalji(z);
        
        Odgovor odg = (Odgovor) primalac.primi();
        
        if(odg.getObject() == null){
            System.out.println("uspeh");
        }else{
            ((Exception) odg.getObject()).printStackTrace();
            throw new Exception("greska");
        }
    }

    public void saveStudent(Student s) throws Exception {
        Zahtev z = new Zahtev(Operacija.dodaj_studenta,s);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        System.out.println(odg.getObject()+"na serverskoj stranii");
         if(odg.getObject() == null){
          
        }else{
            
            throw new Exception("Систем не може да запамти студента");
        }
    }

    public List<Projekat> loadListProjects() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
