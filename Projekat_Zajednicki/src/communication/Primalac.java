/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 10
 */
public class Primalac implements Serializable {
    private Socket socket;
    
    public Primalac(Socket socket){
        this.socket = socket;
    }
    
    public Object primi(){
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
