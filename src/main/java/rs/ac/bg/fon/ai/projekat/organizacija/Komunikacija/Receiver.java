/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija
;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Ivana
 */
public class Receiver {
    private Socket s;

    public Receiver(Socket s) {
        this.s = s;
    }
    private ObjectInputStream in;
    
    public Object receive()throws Exception{
       try {
            in=new ObjectInputStream(s.getInputStream());
            return in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        } 
    }
    public void close() throws IOException {
        if (in != null) {
        in.close();
    }
    }
}
