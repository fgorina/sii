/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii;

import es.gorina.sqlobjects.DataConnection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paco
 */
public class Sii {

    
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Set some debug options
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        java.util.Date now;
        java.util.Date date;
        now = new java.util.Date();
        date = new java.util.Date(now.getTime()-68400000);
        String dateStr;
        dateStr = dateFormat.format(date);
        
         
        System.out.println(dateStr);
    
        
        DataConnection dc = new DataConnection("gorina", "n190491", "@213.4.33.145:1521:xe");
        //DataConnection dc = new DataConnection("gorina", "n190491", "@192.168.0.17:1521:xe");
        int n_factures = 0;
        int n_factures_e = 0;
        int n_factures_r = 0;
        try {
            dc.doQuery("alter session set nls_numeric_characters = '.,'");
        } catch (SQLException ex) {
            Logger.getLogger(Sii.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sii.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        
        // Now se set the keystores. That is ULTRAIMPORTANTS i hem de tenir el certificat a la keystore. Si no no va res
        
        
        System.setProperty("javax.net.ssl.keyStore","/Users/paco/Library/Application Support/Oracle/Java/Deployment/security/trusted.clientcerts");
        System.setProperty("javax.net.ssl.keyStorePassword","axz93klm");
        //System.setProperty("javax.net.ssl.trustStore","/Users/paco/Library/Application Support/Oracle/Java/Deployment/security/trusted.clientcerts");
        //System.setProperty("javax.net.ssl.trustStorePassword","qwerty");
        try {
            n_factures_e = sendFacturas(dc, dateStr);
            dc.commit();
            n_factures_r = sendFacturasRecibidas(dc, dateStr);
            dc.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Sii.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sii.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        n_factures = n_factures_e + n_factures_r;
        
        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                                                                     |");
        System.out.println("|    All work done: " + n_factures + " factures. Big Brother must be proud of me!!!    |");
        System.out.println("|                                                                     |");
        System.out.println("+---------------------------------------------------------------------+");
   
    }

    @SuppressWarnings("empty-statement")
    public static int sendFacturas(DataConnection dc, String tillDate) throws SQLException, ClassNotFoundException{
        
       
        return FacturaEmitida.procesaFacturesPendentsFinsAl(dc, tillDate);
  
    }

     @SuppressWarnings("empty-statement")
    public static int sendFacturasRecibidas(DataConnection dc, String tillDate) throws SQLException, ClassNotFoundException{
        
       
        return FacturaRecibida.procesaFacturesPendentsFinsAl(dc, tillDate);
  
    }

     
}
