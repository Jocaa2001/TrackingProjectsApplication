/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forme.DodajProfesoraForma;
import forme.ServerskaForma;
import hashing.PasswordHasher;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Angazovanje;
import model.ApstraktniDomenskiObjekat;
import model.Predmet;
import model.Profesor;
import model.Projekat;
import model.Student;
import model.Zvanje;
import niti.ObradaKlijentskihZahteva;
import operacija.angazovanje.DodajAngazovanjeOperacija;
import operacija.angazovanje.LoadListAngazovanje;
import operacija.login.LoginOperacija;
import operacija.predmet.DeletePredmet;
import operacija.predmet.LoadListPredmet;
import operacija.profesor.SaveProfesor;
import operacija.profesor.LoadListProfesor;
import operacija.projekat.DodajProjekatOperacija;
import operacija.projekat.SaveProject;
import operacija.projekat.IzmeniProjekatOperacija;
import operacija.projekat.LoadListProjects;
import operacija.student.SaveStudent;
import operacija.student.LoadListStudents;
import validator.Validator;

/**
 *
 * @author Win 10
 */
public class Controller {
     private static Controller instance;
     public static Profesor ulogovaniAdmin;
     private ServerskaForma sf;
     //private DodajProfesoraForma dpf;
     //public ArrayList<ObradaKlijentskihZahteva> listaPrijavljenih = new ArrayList<ObradaKlijentskihZahteva>();
     
    private Controller() {
         
    }

    public ServerskaForma getSf() {
        return sf;
    }

//    public DodajProfesoraForma getDpf() {
//        return dpf;
//    }

    
    
    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }

//    public void setDpf(DodajProfesoraForma dpf) {
//        this.dpf = dpf;
//    }
    
    
    
    public static void setUlogovaniAdmin(Profesor ulogovaniAdmin) {
        Controller.ulogovaniAdmin = ulogovaniAdmin;
    }
    
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

     public void login(String username, String password) { //login sa serverske strane
        try {
       
        Profesor p = new Profesor(password, username);
        LoginOperacija lo = new LoginOperacija();
        lo.templateExecute(p);
        p = lo.getProf();
        
        if(p != null){
            JOptionPane.showMessageDialog(null, "Успешно сте се пријавили на систем");
            ulogovaniAdmin = p;
            
           
        }else{
            JOptionPane.showMessageDialog(null, "Систем не може да нађе професора на основу датих вредности");
            }
            sf.pripremiFormu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
         
    }

    public List<Profesor> UcitajListuProfesora() throws Exception {
        LoadListProfesor upo = new LoadListProfesor();
        upo.templateExecute(new Profesor());
        return upo.getLista();
    }

    public void saveProfesor(Profesor p) throws Exception {
        SaveProfesor dpo = new SaveProfesor();
        dpo.templateExecute(p);
    }

    public Profesor login(Profesor profesor) throws Exception {
//        if(Controller.getInstance().listaPrijavljenih.size() > 1){
//            return null;
//        }
        LoginOperacija lo = new LoginOperacija();
        profesor.setPassword(new PasswordHasher(profesor.getPassword()).hash());
        lo.templateExecute(profesor);
        return lo.getProf();
    }

    public List<Student> ucitajStudente() throws Exception {
        LoadListStudents uso = new LoadListStudents();
        uso.templateExecute(new Student());
        return uso.getLista();
    }

    public void saveStudent(Student s) throws Exception {
        SaveStudent dso = new SaveStudent();
        dso.templateExecute(s);
    }

    public List<Predmet> ucitajPredmete() throws Exception {
        LoadListPredmet upo = new LoadListPredmet();
        upo.templateExecute(new Predmet());
        return upo.getLista();
    }

    public void obrisiPredmet(Predmet pred) throws Exception {
        DeletePredmet opo = new DeletePredmet();
        opo.templateExecute(pred);
    }

    public void saveAngazovanje(Angazovanje a) throws Exception {
        DodajAngazovanjeOperacija dao = new DodajAngazovanjeOperacija();
        dao.templateExecute(a);
    }

    public List<Angazovanje> ucitajListuAngazovanja() throws Exception {
        LoadListAngazovanje uao = new LoadListAngazovanje();
        uao.templateExecute(new Angazovanje());
        return uao.getLista();
    }

    public List<Projekat> ucitajListuProjekata() throws Exception {
        LoadListProjects upo = new LoadListProjects();
        upo.templateExecute(new Projekat());
        return upo.getLista();
    }

    public void saveProjekat(Projekat proj) throws Exception {
        SaveProject dpo = new SaveProject();
        dpo.templateExecute(proj);
    }
    
  

    public void izmeniProjekat(Projekat proj) throws Exception {
        IzmeniProjekatOperacija ipo = new IzmeniProjekatOperacija();
        ipo.templateExecute(proj);
    }

    

   
}
