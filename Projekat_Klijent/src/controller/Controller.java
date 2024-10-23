/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;

import java.util.List;

import komunikacija.Komunikacija;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;
import model.Projekat;
import model.Student;

/**
 *
 * @author Win 10
 */
public class Controller {
    private static Controller instance;
    public static Profesor ulogovaniProfesor;
    public Controller() {
        
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Profesor login(String username, String password) {
     
       return Komunikacija.getInstance().login(username, password);
       
    }

    public List<Student> loadListStudenti() {
        return Komunikacija.getInstance().loadListStudent();
    }

    public void saveStudent(Student stud) throws Exception {
       Komunikacija.getInstance().saveStudent(stud);
    }

    public List<Predmet> loadListPredmeti() {
        return Komunikacija.getInstance().loadListPredmet();
    }

    public void deletePredmet(Predmet p) throws Exception {
        Komunikacija.getInstance().deletePredmet(p);
    }

    public List<Profesor> loadListProfesor() {
        return Komunikacija.getInstance().loadListProfesor();
    }

    public ArrayList<Angazovanje> loadListAngazovanja() {
        return Komunikacija.getInstance().loadListAngazovanja();
    }

    public List<Projekat> loadListProjekti() {
        return Komunikacija.getInstance().loadListProjects();
    }

    public void saveProjekat(List<Projekat> proj) throws Exception {
        Komunikacija.getInstance().saveProjekat(proj);
    }
     public void saveProjekat(Projekat proj) throws Exception {
        Komunikacija.getInstance().saveProjekat(proj);
    }

    public void izmeniProjekat(Projekat p) throws Exception {
        Komunikacija.getInstance().izmeniProjekat(p);
    }

    
   
   
    
}
