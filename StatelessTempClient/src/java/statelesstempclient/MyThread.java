/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelesstempclient;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mybean.StatelessTempBeanRemote;

/**
 *
 * @author Study
 */
public class MyThread extends Thread {
    StatelessTempBeanRemote tempBean = lookupStatelessTempBeanRemote();
    Scanner scanner = new Scanner(System.in);
    private float input;
    
    public MyThread(){}
    
    public void run(){
        
        System.out.print("Enter degree in Farenheit: ");
        input = scanner.nextFloat();
        
        System.out.println(input + " Degree Fahrenheit = " + tempBean.fahrenToCelcius(input) + " Degree Celcius");
        
    }
    
    private StatelessTempBeanRemote lookupStatelessTempBeanRemote() {
        try {
            Context c = new InitialContext();
            return (StatelessTempBeanRemote) c.lookup("java:comp/env/StatelessTempBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
