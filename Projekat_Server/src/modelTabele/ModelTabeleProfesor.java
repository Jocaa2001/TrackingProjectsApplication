/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelTabele;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Profesor;

/**
 *
 * @author Win 10
 */
public class ModelTabeleProfesor extends AbstractTableModel {

    List<Profesor> lista;
    String[] kolone = {"IDprofesor","ime","prezime","zvanje","password","username"};

    public ModelTabeleProfesor(List<Profesor> lista) {
        this.lista = lista;
    }

    public List<Profesor> getLista() {
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
        Profesor p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getIdprofesora();
            case 1: return p.getIme();
            case 2: return p.getPrezime();
            case 3: return p.getZvanje();
            case 4: return p.getPassword();
            case 5: return p.getUsername();
            
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
