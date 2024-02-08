/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Win 10
 */
public class Zahtev implements Serializable {
    
    private Operacija operation;
    private Object object;

    public Zahtev() {
    }

    public Zahtev(Operacija operation, Object object) {
        this.operation = operation;
        this.object = object;
    }

    public Operacija getOperation() {
        return operation;
    }

    public void setOperation(Operacija operation) {
        this.operation = operation;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    
    
    
}
