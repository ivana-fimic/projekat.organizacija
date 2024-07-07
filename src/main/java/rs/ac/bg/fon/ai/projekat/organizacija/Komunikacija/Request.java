/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.projekat.organizacija.Komunikacija
;

import java.io.Serializable;

/**
 *
 * @author Ivana
 */
public class Request implements Serializable {
    private int operacija;
    private Object argument;

    public Request(int operacija, Object argument) {
        this.operacija = operacija;
        this.argument = argument;
    }

    public Request() {
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    @Override
    public String toString() {
        return "Request{" + "operacija=" + operacija + ", argument=" + argument + '}';
    }
    
}
