/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Student;

/**
 *
 * @author Win 10
 */
public class ModelTabeleStudent extends AbstractTableModel {
    List<Student> lista;
    String[] kolone = {"IDstudent","Ime","Prezime","Broj indeksa"};

    public ModelTabeleStudent(List<Student> lista) {
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
        Student s = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return s.getIdstudent();
            case 1: return s.getIme();
            case 2: return s.getPrezime();
            case 3: return s.getBrojindeksa();
                
                
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
