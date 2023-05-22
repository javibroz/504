
package com.prog11.princ;

import com.prog11.BBDD.ConnectionDB;




public class Prog11_Principal {

    
    public static void main(String[] args) {
        
        System.out.println("Inicio ok");
     ConnectionDB con = new ConnectionDB();
     con.openConnection();
    
}
}