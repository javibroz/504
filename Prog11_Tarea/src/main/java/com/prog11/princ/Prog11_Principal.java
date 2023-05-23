
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
         //con.openConnection();
               
        
//Insertar varios vehículos y propietarios.
System.out.println("Insertar varios vehículos y propietarios.");
VehiculosDAO.insertarNuevoVehiculo(con, "0000SSS", "Renault", 1300, 13000, "Lugo", 2);
VehiculosDAO.insertarNuevoVehiculo(con, "1234LLL", "Citroen", 1300, 13000, "8", 4);
VehiculosDAO.insertarNuevoVehiculo(con, "5678LLL", "Seat", 1300, 13000, "Leon", 2);
PropietariosDAO.insertarPropietario(con, 06, "Julio Iglesias", "32650218S");
PropietariosDAO.insertarPropietario(con, 07, "Ana Lopez", "32666218S");
PropietariosDAO.insertarPropietario(con, 11, "LOLA Perez", "33333333E");

//Listar todos los vehículos.
System.out.println("******Listar todos los vehículos.");
datos =VehiculosDAO.listarVehiculos(con);
for (String dato :datos){
    System.out.println(dato);
}

//Actualizar propietario de un vehículo.
System.out.println("*******Actualizar propietario de un vehículo.");
VehiculosDAO.actualizaPropietarioVehiculo(con, "1111AAA", 6);


//Listar todos los vehículos.
System.out.println("******Listar todos los vehículos.");
VehiculosDAO.listarVehiculos(con);

//Eliminar un vehículo que exista.
System.out.println("********Eliminar un vehículo que exista.");
if (VehiculosDAO.eliminaVehiculo(con, "2222BBB")==0){
 System.out.println("Se eliminó.");
        } else {
            System.out.println("NO se eliminó");

        }


//Eliminar un vehículo que no exista.
        System.out.println("*******Eliminar un vehículo que no exista.");
        if (VehiculosDAO.eliminaVehiculo(con, "2222AAA") == 0) {
            System.out.println("Se eliminó.");
        } else {
            System.out.println("NO se eliminó");

        }

//Listar todos los vehículos.
System.out.println("******Listar todos los vehículos.");
VehiculosDAO.listarVehiculos(con);
datos =VehiculosDAO.listarVehiculos(con);
for (String dato :datos){
    System.out.println(dato);
}

//Listar los vehículos de una marca.
System.out.println("*******Listar los vehículos de una marca.");
datos= VehiculosDAO.listarVehiculosMarca(con, "Seat");
for (String dato:datos){
    System.out.println(dato);
}


//Listar todos los vehículos de un propietario.
System.out.println("******Listar todos los vehículos de un propietario.");
datos = VehiculosDAO.listVehiculosPropietario(con,"44444444X");
for (String dato : datos){
    System.out.println(dato);
}

//Eliminar un propietario con vehículos.
System.out.println("******Eliminar un propietario con vehículos.");
if (PropietariosDAO.eliminaPropietario(con, "33333333E")==0){
    System.out.println("Se eliminó.");   }
else {
    System.out.println("NO se eliminó");
}
 


////Eliminar un propietario sin vehículos.
System.out.println("******Eliminar un propietario sin vehículos.");
if (PropietariosDAO.eliminaPropietario(con, "11111111A")==0 ){
    System.out.println("Se eliminó");}
else {System.out.println("No se eliminó.");
}
    }
    }




