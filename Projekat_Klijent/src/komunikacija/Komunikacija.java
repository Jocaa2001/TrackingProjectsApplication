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
import model.Angazovanje;
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
        konekcija();
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
            
        }else{
            ((Exception) odg.getObject()).printStackTrace();
            throw new Exception("greska");
        }
    }

    public void saveStudent(Student s) throws Exception {
        Zahtev z = new Zahtev(Operacija.dodaj_studenta,s);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
       
         if(odg.getObject() == null){
          
        }else{
            
            throw new Exception("Систем не може да запамти студента");
        }
    }

    public List<Projekat> loadListProjects() {
        Zahtev z = new Zahtev(Operacija.ucitaj_projekte, null);
        List<Projekat> projekti = new ArrayList<>();
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        projekti = (List<Projekat>) odg.getObject();
        return projekti;
    }
    
    public List<Profesor> loadListProfesor() {
        Zahtev z = new Zahtev(Operacija.ucitaj_profesore, null);
        List<Profesor> profesori = new ArrayList<>();
        posiljalac.posalji(z);
        
        
        Odgovor odg = (Odgovor) primalac.primi();
        profesori = (List<Profesor>) odg.getObject();
        
        return profesori;
    }

    public void saveAngazovanje(Angazovanje angazovanje) throws Exception {
        Zahtev z = new Zahtev(Operacija.dodaj_angazovanje,angazovanje);
        posiljalac.posalji(z);
        Odgovor odg = (Odgovor) primalac.primi();
        
         if(odg.getObject() == null){
          
        }else{
            
            throw new Exception("Систем не може да запамти ангажовање");
        }
    }

    public ArrayList<Angazovanje> loadListAngazovanja() {
        Zahtev z = new Zahtev(Operacija.ucitaj_angazovanja, null);
        ArrayList<Angazovanje> angazovanja = new ArrayList<>();
        posiljalac.posalji(z);
        
        
        Odgovor odg = (Odgovor) primalac.primi();
        angazovanja = (ArrayList<Angazovanje>) odg.getObject();
        
        return angazovanja;
    }

    public void saveProjekat(List<Projekat> proj) throws Exception {
        Zahtev z = new Zahtev(Operacija.dodaj_vise_projekata,proj);
        posiljalac.posalji(z);
        
        Odgovor odg = (Odgovor) primalac.primi();
         if(odg.getObject() == null){
          
        }else{
            
            throw new Exception("Систем не може да запамти пројекат");
        }
    }
     public void saveProjekat(Projekat proj) throws Exception {
        Zahtev z = new Zahtev(Operacija.dodaj_projekat,proj);
        posiljalac.posalji(z);
        
        Odgovor odg = (Odgovor) primalac.primi();
         
         if(odg.getObject() == null){
          
        }else{
            
            throw new Exception("Систем не може да запамти пројекат");
        }
    }

    public void izmeniProjekat(Projekat p) throws Exception {
        Zahtev z = new Zahtev(Operacija.izmeni_projekat,p);
        posiljalac.posalji(z);
        
        Odgovor odg = (Odgovor) primalac.primi();
         if(odg.getObject() == null){
          
        }else{
            
            throw new Exception("Систем не може да запамти пројекат");
        }
    }
}
