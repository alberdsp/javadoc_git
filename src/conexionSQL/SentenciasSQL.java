package conexionSQL;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map.Entry;
import java.util.TreeMap;

import clases.Paciente;
import clases.Profesionales_Medicos;

public class SentenciasSQL {

	private static String selectTableSQL;
	private static String insertTableSQL;
	private static String updateTableSQL;

	public static void cerrar_conexion(Connection cn, Statement stm, ResultSet rs) {
		// Liberar recursos revisar el orden en el que se cierran, orden inverso
		try {
			if (rs != null) {
				rs.close();
			}
			if (stm != null) {
				stm.close();
			}
			if (cn != null) {
				cn.close();
			}
			System.out.println("La conexión se ha cerrado con éxito");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
		}

	}

	public static void grabarPacientes(TreeMap<String, Paciente> pacientes) {
		TreeMap<String, Paciente> listapacientes = pacientes;

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		insertTableSQL = "INSERT INTO pacientes (dni, nombre, edad, sexo, calle, localidad, cod_postal) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {

			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			for (Entry<String, Paciente> listap : listapacientes.entrySet()) {
				String dni = listap.getValue().getDni();
				String nombre = listap.getValue().getNombre();
				int edad = listap.getValue().getEdad();
				String sexo = String.valueOf(listap.getValue().getSexo());
				String calle = listap.getValue().getCalle();
				String localidad = listap.getValue().getLocalidad();
				String cod_postal = listap.getValue().getCod_postal();

				ps.setString(1, dni);
				ps.setString(2, nombre);
				ps.setInt(3, edad);
				ps.setString(4, sexo);
				ps.setString(5, calle);
				ps.setString(6, localidad);
				ps.setString(7, cod_postal);
				ps.executeUpdate();
			}

			System.out.println("Pacientes guardados correctamente en la tabla 'pacientes'.");
			ps.close();

		} catch (SQLException e) { // TODO: handle exception

			e.printStackTrace();

		} finally { // Liberar recursos revisar el orden en el que se cierran
			try {

				if (ps != null) {
					ps.close();
				}

				if (cn != null) {
					cn.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}
		}

	}
	
	public static void grabarProfesionales(TreeMap<String, Profesionales_Medicos> profesionales) {
	    TreeMap<String, Profesionales_Medicos> listaProfesionales = profesionales;

	    Conexion conexion = new Conexion();
	    Connection cn = null;
	    PreparedStatement ps = null;

	    String insertTableSQL = "INSERT INTO profesionales_medicos (dni, nombre, apellidos, localidad, telefono, especialidad) VALUES (?, ?, ?, ?, ?, ?)";

	    try {
	        cn = conexion.conectar();
	        ps = cn.prepareStatement(insertTableSQL);

	        for (Entry<String, Profesionales_Medicos> lista : listaProfesionales.entrySet()) {
	            String dni = lista.getValue().getDni();
	            String nombre = lista.getValue().getNombre();
	            String apellidos = lista.getValue().getApellidos();
	            String localidad = lista.getValue().getLocalidad();
	            String telefono = lista.getValue().getTelefono();
	            String especialidad = lista.getValue().getEspecialidad();

	            ps.setString(1, dni);
	            ps.setString(2, nombre);
	            ps.setString(3, apellidos);
	            ps.setString(4, localidad);
	            ps.setString(5, telefono);
	            ps.setString(6, especialidad);
	            ps.executeUpdate();
	        }

	        System.out.println("Profesionales guardados correctamente en la tabla 'profesionales_medicos'.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	            if (cn != null) {
	                cn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
}
