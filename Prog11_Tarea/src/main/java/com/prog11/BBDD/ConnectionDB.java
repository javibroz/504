

package com.prog11.BBDD;
import java.sql.*;

public class ConnectionDB {
   private Connection con;
   
  public void openConnection(){
      System.out.println("Iniciando conexion........");
       try {
           this.con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/concesionario","user2","user2");
           System.out.println("Conexion OK");
       } catch (SQLException ex) {
           System.out.println("Error de conexion: " + ex.getMessage()); 
       }
      
  }
  
   public void closeConnection(){
       try {
           this.con.close();
       } catch (SQLException ex) {
           
       }
       
       
   }

    public Connection getConnection() {
       
        return this.con;
    }
   
   
   
   
}
