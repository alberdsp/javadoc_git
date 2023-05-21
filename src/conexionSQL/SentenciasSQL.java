package conexionSQL;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map.Entry;
import java.util.TreeMap;

import clases.Fechas_util;
import clases.Paciente;
import clases.Profesionales_Medicos;
import clases.Visita;

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

	/**
	 * Método para grabar los pacientes en mysql
	 * 
	 * @param pacientes TreeMap
	 */
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

	/**
	 * Método para grabar profesionales en Mysql
	 * 
	 * @param profesionales TreeMap
	 */
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

	/**
	 * Método para grabar visitas en Mysql
	 * 
	 * @param visitas TreeMap
	 */
	public static void grabarVisitas(TreeMap<String, Visita> visitas) {
		TreeMap<String, Visita> listaVisitas = visitas;

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;

		String insertTableSQL = "INSERT INTO visitas (dni, dniProfesional, fecha, hora, peso, altura, unidadaltura, resulimc) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			cn = conexion.conectar();
			ps = cn.prepareStatement(insertTableSQL);

			for (Entry<String, Visita> lista : listaVisitas.entrySet()) {
				String dni = lista.getValue().getDni();
				String dniProfesional = lista.getValue().getDniProfesional();
				String fecha = lista.getValue().getFecha();
				String hora = lista.getValue().getHora();
				Double peso = lista.getValue().getPeso();
				Double altura = lista.getValue().getAltura();
				String unidadaltura = lista.getValue().getUnidadaltura();
				String resulimc = lista.getValue().getResulimc();

				// Adecuamos el formato de fecha "20/05/2023" to "20-05-2023"
				String fecha_ = fecha.replaceAll("/", "-");
				String[] dateParts = fecha_.split("-");
				String fechamysql = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];

				ps.setString(1, dni);
				ps.setString(2, dniProfesional);
				ps.setString(3, fechamysql);
				ps.setString(4, hora);
				ps.setDouble(5, peso);
				ps.setDouble(6, altura);
				ps.setString(7, unidadaltura);
				ps.setString(8, resulimc);
				ps.executeUpdate();
			}

			System.out.println("Visitas guardadas correctamente en la tabla 'visitas'.");

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

	/**
	 * Método para leer los pacientes de la BD
	 * 
	 * @return TreeMap de pacientes
	 */
	public static TreeMap<String, Paciente> leerPacientes() {
		TreeMap<String, Paciente> listaPacientes = new TreeMap<>();

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stmt = cn.createStatement();
			String query = "SELECT * FROM pacientes";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Paciente paciente = new Paciente();
				String dni = rs.getString("dni");

				paciente.setDni(dni);
				paciente.setNombre(rs.getString("nombre"));
				paciente.setEdad(rs.getInt("edad"));
				paciente.setSexo(rs.getString("sexo").charAt(0));
				paciente.setCalle(rs.getString("calle"));
				paciente.setLocalidad(rs.getString("localidad"));
				paciente.setCod_postal(rs.getString("cod_postal"));

				listaPacientes.put(dni, paciente);
			}

			System.out.println("Pacientes leidos corréctamente.");
			System.out.println("-------------------------------");
			System.out.println("\n");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaPacientes;
	}

	/**
	 * Método que consulta los pacientes en la BD
	 * 
	 * @param dni pasamos el dni que queremos filtrar
	 * @return TreeMap con el resultado
	 */
	public static Paciente buscarPaciente(String dni) {
		Paciente paciente = new Paciente();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stmt = cn.createStatement();
			String query = "SELECT * FROM pacientes WHERE dni = " + "'" + dni + "'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {

				String dnis = rs.getString("dni");

				paciente.setDni(dnis);
				paciente.setNombre(rs.getString("nombre"));
				paciente.setEdad(rs.getInt("edad"));
				paciente.setSexo(rs.getString("sexo").charAt(0));
				paciente.setCalle(rs.getString("calle"));
				paciente.setLocalidad(rs.getString("localidad"));
				paciente.setCod_postal(rs.getString("cod_postal"));

			}

			System.out.println("Pacientes leidos corréctamente.");
			System.out.println("-------------------------------");
			System.out.println("\n");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return paciente;
	}

	/**
	 * Método para buscar profesionales por dni
	 * 
	 * @param dni
	 * @return
	 */
	public static Profesionales_Medicos buscarProfesional(String dni) {
		Profesionales_Medicos profesional = new Profesionales_Medicos();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stmt = cn.createStatement();
			String query = "SELECT * FROM profesionales_medicos WHERE dni = '" + dni + "'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				profesional.setDni(rs.getString("dni"));
				profesional.setNombre(rs.getString("nombre"));
				profesional.setEspecialidad(rs.getString("especialidad"));
				// Set other attributes as needed...
			}

			System.out.println("Profesional encontrado correctamente.");
			System.out.println("-------------------------------------");
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return profesional;
	}

	/**
	 * Método para consultar los profesionales en la BD
	 * 
	 * @return TreeMap con el resultado
	 */
	public static TreeMap<String, Profesionales_Medicos> leerProfesionales() {

		TreeMap<String, Profesionales_Medicos> listaProfesionales = new TreeMap<>();

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String selectQuery = "SELECT * FROM profesionales_medicos";

		try {
			cn = conexion.conectar();
			stmt = cn.createStatement();
			rs = stmt.executeQuery(selectQuery);

			while (rs.next()) {
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String localidad = rs.getString("localidad");
				String telefono = rs.getString("telefono");
				String especialidad = rs.getString("especialidad");

				Profesionales_Medicos profesional = new Profesionales_Medicos(nombre, apellidos, dni, localidad,
						telefono, especialidad);
				listaProfesionales.put(dni, profesional);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaProfesionales;
	}

	/**
	 * Método que lee las visitas de pacientes por dni
	 * 
	 * @param dni del paciente
	 * @return TreeMap con las visitas
	 */
	public static TreeMap<String, Visita> leerVisitas(String dni) {
		TreeMap<String, Visita> listaVisitas = new TreeMap<>();

		Conexion conexion = new Conexion();
		Connection cn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			String query = "SELECT * FROM visitas WHERE dni = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, dni);
			rs = ps.executeQuery();

			while (rs.next()) {
				Visita visita = new Visita();
				String fecha = rs.getString("fecha");

				fecha = Fechas_util.fechaStrMysqltoESP(fecha);

				visita.setDni(rs.getString("dni"));
				visita.setDniProfesional(rs.getString("dniProfesional"));
				visita.setFecha(fecha);
				visita.setHora(rs.getString("hora"));
				visita.setPeso(rs.getDouble("peso"));
				visita.setAltura(rs.getDouble("altura"));
				visita.setUnidadaltura(rs.getString("unidadaltura"));
				visita.setResulimc(rs.getString("resulimc"));

				listaVisitas.put(fecha, visita);
			}

			System.out.println("Visitas leídas correctamente.");
			System.out.println("----------------------------");
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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

		return listaVisitas;
	}

	/**
	 * Método para listar visitas por dni del profesional y fecha
	 * 
	 * @param ndni  del profesional
	 * @param fecha de visita
	 * @return TreeMap con la lista de visitas
	 */
	public static TreeMap<Integer, Visita> listaVisitas(String ndni, String fecha) {
		TreeMap<Integer, Visita> listaVisitas = new TreeMap<Integer, Visita>();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String fechaESP = fecha;
		fecha = Fechas_util.fechaStrESP_barra_toMysql(fecha);
		try {
			cn = conexion.conectar();
			stmt = cn.createStatement();
			String query = "SELECT * FROM visitas WHERE dniProfesional = '" + ndni + "' AND fecha = '" + fecha + "'";
			rs = stmt.executeQuery(query);

			int indice = 0;
			while (rs.next()) {
				Visita visita = new Visita();
				visita.setDni(rs.getString("dni"));
				visita.setDniProfesional(rs.getString("dniProfesional"));
				visita.setFecha(fechaESP);
				visita.setHora(rs.getString("hora"));
				visita.setPeso(rs.getDouble("peso"));
				visita.setAltura(rs.getDouble("altura"));
				visita.setUnidadaltura(rs.getString("unidadaltura"));
				visita.setResulimc(rs.getString("resulimc"));

				indice++;
				listaVisitas.put(indice, visita);
				System.out.println(indice + ". " + visita.toString());
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return listaVisitas;
	}

}
