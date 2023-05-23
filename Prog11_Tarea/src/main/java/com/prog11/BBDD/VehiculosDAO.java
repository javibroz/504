package com.prog11.BBDD;

import java.sql.*;
import java.util.ArrayList;

public class VehiculosDAO {

    public static int insertarNuevoVehiculo(ConnectionDB con, String matri, String marca, int kms, int precio, String modelo, int id) {

        try {
            con.openConnection();
            String consulta = "INSERT INTO vehiculo VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.getConnection().prepareStatement(consulta);

            st.setString(1, matri);
            st.setString(2, marca);
            st.setInt(3, kms);
            st.setInt(4, precio);
            st.setString(5, modelo);
            st.setInt(6, id);

            st.executeUpdate();

            st.close();
            con.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return -1;

    }

    public static int actualizaPropietarioVehiculo(ConnectionDB con, String matri, int id) {

        try {
            con.openConnection();

            PreparedStatement st = con
                    .getConnection()
                    .prepareStatement(
                            "UPDATE vehiculo "
                            + "SET id_prop = ? "
                            + "WHERE matri = ?");
            st.setInt(1, id);
            st.setString(2, matri);

            int actualizados = st.executeUpdate();

            if (actualizados == 0) {
                return -1;
            }

            st.close();
            con.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return -1;

    }

    public static int eliminaVehiculo(ConnectionDB con, String matri) {

        try {
            con.openConnection();

            PreparedStatement st = con
                    .getConnection()
                    .prepareStatement(
                            "DELETE FROM vehiculo WHERE matri= ?");
            st.setString(1, matri);

            int eliminados = st.executeUpdate();

            if (eliminados == 0) {
                return -1;
            }

            st.close();
            con.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        return -1;

    }

    public static ArrayList<String> listVehiculosPropietario(ConnectionDB con, String dni) {

        try {
            ArrayList<String> datos = new ArrayList<>();

            con.openConnection();
            String consulta = "SELECT matri, marca,id_prop, kms, precio, modelo, id, nombre, dni " +
                     "FROM vehiculo , propietario  "+
                     "WHERE vehiculo.id_prop = propietario.id "+
                     "AND dni=?";

            PreparedStatement st = con.getConnection().prepareStatement(consulta);
            st.setString(1, dni);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                datos.add("Matricula: " + rs.getString("matri") + ", marca: " + rs.getString("marca") + ", km: " + rs.getInt("kms") + ", precio " + rs.getInt("precio") + ", Modelo: " + rs.getString("modelo") + ", Id propietario: " + rs.getInt("id_prop") + ", Nombre : " + rs.getString("nombre") + ", DNI: " + rs.getString("dni"));
            }

            con.closeConnection();
            return datos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static ArrayList<String> listarVehiculosMarca(ConnectionDB con, String marca) {

        try {
            ArrayList<String> datos = new ArrayList<>();

            con.openConnection();
            String consulta = "SELECT matri, marca, kms, precio, modelo, id, nombre, dni "
                    + "FROM vehiculo v, propietario p "
                    + "WHERE v.id_prop = p.id "
                    + "AND marca = ?";

            PreparedStatement st = con.getConnection().prepareStatement(consulta);

            st.setString(1, marca);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                datos.add("Matricula: " + rs.getString("matri") +
                        ", marca: " + rs.getString("marca") +
                        ", km: " + rs.getInt("kms") +
                        ", precio " + rs.getInt("precio") +
                        ", Modelo: " + rs.getString("modelo") +
                        ", id propietario: " + rs.getInt("id") + 
                        ", nombre propietario: " + rs.getString("nombre") +
                        ", dni propietario: " + rs.getString("dni"));
            }

            con.closeConnection();
            return datos;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static ArrayList<String> listarVehiculos(ConnectionDB con) {

        try {
            ArrayList<String> datos = new ArrayList<>();

            con.openConnection();
            String consulta = "SELECT matri, marca, kms, precio, modelo, id_prop FROM vehiculo ";
            PreparedStatement st = con.getConnection().prepareStatement(consulta);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                datos.add("Matricula: " + rs.getString("matri")
                        + ", Marca: " + rs.getString("marca")
                        + ", Kms: " + rs.getInt("kms")
                        + ", Precio " + rs.getInt("precio")
                        + ", Modelo: " + rs.getString("Modelo")
                        + ", ID propietario: " + rs.getInt("id_prop"));
            }

            con.closeConnection();
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

}
