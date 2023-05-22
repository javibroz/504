package com.prog11.BBDD;

import java.sql.*;
import java.util.ArrayList;

public class PropietariosDAO {

    public static int insertarPropietario(ConnectionDB con, int id, String nombre, String dni) {

        try {
            con.openConnection();
            String consulta = "INSERT INTO propietario(id, nombre, dni) VALUES (?,?,?)";
            PreparedStatement st = con.getConnection().prepareStatement(consulta);

            st.setInt(1, id);
            st.setString(id, nombre);
            st.setString(id, dni);
            st.executeUpdate();
            st.close();

            con.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return -1;
    }

    public static ArrayList<String> recuperaVehiculos(ConnectionDB con, String dni) {

        try {
            ArrayList<String> datos = new ArrayList<>();

            con.openConnection();
            String consulta = "SELECT v.matri, v.marca, v.kms, v.precio, v.modelo, p.id, p.nombre, p.dni"
                    + "FROM vehiculo v, propietario p "
                    + "WHERE v.id_prop = p.id "
                    + "AND p.dni = ?";

            PreparedStatement st = con.getConnection().prepareStatement(consulta);

            st.setString(0, dni);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                datos.add("Matricula: " + rs.getString("matri") + ", Marca: " +
                        rs.getString("marca") + ", km: " + 
                        rs.getInt("kms") + ", precio " + rs.getInt("precio")+ 
                        ", Modelo: " +rs.getString("modelo") +
                        ", ID propietario: " + rs.getInt("id") + 
                        ", Nombre propietario: " + rs.getString("nombre") + 
                        ", DNI: " + rs.getString("dni"));
            }

            con.closeConnection();
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    public static int eliminaPropietario(ConnectionDB con, String dni) {

        try {
            con.openConnection();

            String consulta = "DELETE FROM propietario WHERE dni = ?";

            PreparedStatement st = con.getConnection().prepareStatement(consulta);

            st.setString(1, dni);

            int eliminados = st.executeUpdate();

            st.close();
            con.closeConnection();
            return eliminados;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

}
