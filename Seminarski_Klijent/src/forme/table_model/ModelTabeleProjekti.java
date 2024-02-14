/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Projekat;

/**
 *
 * @author Win 10
 */
public class ModelTabeleProjekti extends AbstractTableModel {
    List<Projekat> lista;
    private String[] kolone = {"Profesor", "Predmet","Student","BrojPoena","Tema"};
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
            default:
                return "n/a";
        }
    }
    
     @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
