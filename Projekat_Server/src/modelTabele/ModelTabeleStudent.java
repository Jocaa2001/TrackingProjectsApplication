/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelTabele;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.Projekat;
import model.Student;

/**
 *
 * @author Win 10
 */
public class ModelTabeleStudent extends AbstractTableModel {
    List<Student> lista;
    String[] kolone = {"IDstudent","Ime","Prezime","Broj indeksa", "Broj projekata"};
    
    public ModelTabeleStudent(List<Student> lista) {
        this.lista = lista;
    }

    public List<Student> getLista() {
        return lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = lista.get(rowIndex);
        izbrojProjekte(s);
        switch (columnIndex) {
            case 0: return s.getIdstudent();
            case 1: return s.getIme();
            case 2: return s.getPrezime();
            case 3: return s.getBrojindeksa();
            case 4: return s.getBrojProjekata();
                
                
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void findStudent(int brojIndeksa, String ime, String prezime) {
        List<Student> filtriranaLista = lista.stream()
                .filter(student -> brojIndeksa == 0 || student.getBrojindeksa()== brojIndeksa) 
                .filter(student -> ime == null || ime.isEmpty() || student.getIme().toLowerCase().contains(ime.toLowerCase())) // Filtriranje po imenu
                .filter(student -> prezime == null || prezime.isEmpty() || student.getPrezime().toLowerCase().contains(prezime.toLowerCase())) // Filtriranje po prezimenu
                .collect(Collectors.toList());
        
        this.lista = filtriranaLista;
        fireTableDataChanged();
    }

    private void izbrojProjekte(Student s) {
        try {
            ArrayList<Projekat> projekti = (ArrayList<Projekat>) controller.Controller.getInstance().ucitajListuProjekata();
            int counter = 0;
            
            for (Projekat p : projekti) {
                if(p.getStudent().equals(s)){
                    counter++;
                }
                
            s.setBrojProjekata(counter);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
