/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tableModel;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;
import model.Student;

/**
 *
 * @author Win 10
 */
public class ModelTabeleAngazovanja extends AbstractTableModel {
    List<Angazovanje> lista;
    String[] kolone = {"Profesor","Predmet","Napomena"};

    public ModelTabeleAngazovanja(List<Angazovanje> lista) {
        this.lista = lista;
    }

    public List<Angazovanje> getLista() {
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
         Angazovanje a = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return a.getProfesor();
            case 1: return a.getPredmet();
            case 2: return a.getNapomena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
     public void pretrazi(Profesor prof, Predmet pred) {
       List<Angazovanje> filtriranaLista = lista.stream()
            .filter(angazovanje -> prof == null || prof.equals(angazovanje.getProfesor()))  
            .filter(angazovanje -> pred == null || pred.equals(angazovanje.getPredmet()))     
            .collect(Collectors.toList());                                   
    
    lista.clear();  
    lista.addAll(filtriranaLista);  
    fireTableDataChanged();
    }
}
