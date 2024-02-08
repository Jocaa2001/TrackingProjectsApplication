/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 10
 */
public class Posiljalac implements Serializable {
    
    private Socket socket;

    public Posiljalac(Socket socket) {
        this.socket = socket;
    }
    
    public void posalji(Object obj){
        try {
            ObjectOutputStream ous = new ObjectOutputStream(socket.getOutputStream());
            ous.writeObject(obj);
            ous.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                
    }
    
}
