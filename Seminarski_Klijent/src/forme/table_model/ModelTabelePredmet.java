/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.table_model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Predmet;
import model.Student;

/**
 *
 * @author Win 10
 */
public class ModelTabelePredmet extends AbstractTableModel {
    List<Predmet> lista;
    String[] kolone = {"ID","ESPB","Naziv","Obavezan"};

    public ModelTabelePredmet(List<Predmet> lista) {
        this.lista = lista;
    }

    public List<Predmet> getLista() {
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
         Predmet p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getIdpredmet();
            case 1: return p.getEspb();
            case 2: return p.getNaziv();
            case 3: return p.isObavezan();
                
                
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
