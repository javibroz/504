
package com.prog11.princ;

import com.prog11.BBDD.ConnectionDB;
import  com.prog11.BBDD.VehiculosDAO;
import  com.prog11.BBDD.PropietariosDAO;
import java.sql.*;
import java.util.ArrayList;




public class Prog11_Principal {

    
    public static void main(String[] args) {
         System.out.println("Inicio ok");
     
    
        
        ArrayList<String> datos = new ArrayList<>();
        ConnectionDB con = new ConnectionDB();
         con.openConnection();
               
        
//Insertar varios vehículos y propietarios.

 //VehiculosDAO.insertarNuevoVehiculo(con, 9999KKK, Seat, 100, 10000, Toledo, 8);
//Listar todos los vehículos.
//Actualizar propietario de un vehículo.
//Listar todos los vehículos.
//VehiculosDAO.listarVehiculos(con);
//Eliminar un vehículo que exista.
//Eliminar un vehículo que no exista.
//Listar todos los vehículos.
//Listar los vehículos de una marca.
//Listar todos los vehículos de un propietario.
//Eliminar un propietario con vehículos.
////Eliminar un propietario sin vehículos.
    
}
}