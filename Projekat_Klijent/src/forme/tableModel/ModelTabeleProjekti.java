/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tableModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;
import model.Projekat;
import model.Student;

/**
 *
 * @author Win 10
 */
public class ModelTabeleProjekti extends AbstractTableModel {
    List<Projekat> lista;
    private String[] kolone = {"Profesor", "Predmet","Student","BrojPoena","Tema","Rok predaje"};
    public ModelTabeleProjekti(List<Projekat> lista) {
        this.lista = lista;
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
        Projekat p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getProfesor();
            case 1: return p.getPredmet();
            case 2: return p.getStudent();
            case 3: return p.getBrojpoena();
            case 4: return p.getTema();
            case 5: 
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                String formatiranDatum = sdf.format(p.getRokPredaje());
                return formatiranDatum;
            default:
                return "n/a";
        }
    }
    
     @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

   public void pretrazi(Profesor prof, Predmet pred, Student stud, String tema, Date datum, Integer brojPoena) {
    List<Projekat> filtriranaLista = lista.stream()
        .filter(projekat -> prof == null || prof.equals(projekat.getProfesor()))  
        .filter(projekat -> pred == null || pred.equals(projekat.getPredmet()))     
        .filter(projekat -> brojPoena == null || brojPoena.equals(projekat.getBrojpoena()))      
        .filter(projekat -> stud == null || stud.equals(projekat.getStudent()))     
        .filter(projekat -> datum == null || datum.equals(projekat.getRokPredaje()))
         .filter(projekat -> tema == null || tema.isEmpty() ||
                            (projekat.getTema() != null && 
                             projekat.getTema().trim().toLowerCase().contains(tema.trim().toLowerCase())))
        .collect(Collectors.toList());                                 
    
    lista.clear();  
    lista.addAll(filtriranaLista);
    fireTableDataChanged();
    
     System.out.println("Rezultati pretrage:");
    filtriranaLista.forEach(projekat -> {
        System.out.println(projekat);
    });
}


    public List<Projekat> getLista() {
        return lista;
    }
    
    public void osvezi(){
        fireTableDataChanged();
    }
    
}
