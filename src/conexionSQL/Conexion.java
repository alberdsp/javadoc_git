package conexionSQL;


import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

import clases.TratamientoFichero;

public class Conexion {

	private static String NOMBRE_BD = TratamientoFichero.getNOMBRE_BD();
	private static String UBICACION = TratamientoFichero.getUBICACION();
	private static String PUERTO = TratamientoFichero.getPUERTO();
	private static String USUARIO = TratamientoFichero.getUSUARIO();
	private static String CLAVE = TratamientoFichero.getCLAVE();

	// Para versión mysql-conector-java-5.1.6.jar + mysql Server 5.7
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://" + getUbicacion() + ":" + getPuerto() + "/" + getNombreBd()
			+ "?useUnicode=true&characterEncoding=utf-8";

	// RECUERDA CAMBIAR!!

	// Para versión mysql-conector-java-8.0.11.jar + mysql Server 8.0.33

	// private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";

	/*
	 * private static final String URL = "jdbc:mysql://localhost:3306/" + nombreBd +
	 * "?useUnicode=true&use" +
	 * "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" +
	 * "serverTimezone=UTC";
	 */

	static {

		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
		
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;

		try {

			// Establecemos la conexión para eso java nos prporciona conexion =
			conexion = DriverManager.getConnection(URL, getUsuario(), getClave());

			System.out.println("Conexión correctamente establecida con la base de datos " + getNombreBd());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}

		return conexion;
	}

	
	/**
	 *  metodo para consultar el nombre de la bd
	 * @return  nombre bd
	 */
	public static String getNombreBd() {
		return NOMBRE_BD;
	}

	
	/**
	 *  metodo para consultar servidor de la bd
	 * @return  ruta ip o nombre del servidor
	 */
	public static String getUbicacion() {
		return UBICACION;
	}

	
	/**
	 *  metodo para consultar el puerto del servidor
	 * @return  puerto del servidor
	 */
	public static String getPuerto() {
		return PUERTO;
	}

	
	/**
	 *  metodo para consultar el usuario de la bd
	 * @return  usuario de la bd
	 */
	public static String getUsuario() {
		return USUARIO;
	}
	/**
	 *  metodo para consultar el password de la bd
	 * @return  password de la bd
	 */
	public static String getClave() {
		return CLAVE;
	}


	/**
	 * @param nombreBd nombre de la bd a asignar
	 */
	public static void setNombreBd(String nombreBd) {
		NOMBRE_BD = nombreBd;
	}

	/**
	 * @param ubicacion ip o nombre del servidor
	 */
	public static void setUbicacion(String ubicacion) {
		UBICACION = ubicacion;
	}

	/**
	 * @param puerto puerto del servidor
	 */
	public static void setPuerto(String puerto) {
		PUERTO = puerto;
	}

	/**
	 * @param usuario usuario con permisos
	 */
	public static void setUsuario(String usuario) {
		USUARIO = usuario;
	}

	/**
	 * @param clave password
	 */
	public static void setClave(String clave) {
		CLAVE = clave;
	}
	
	
	
	/**
	 * sobrescribimos el metodo toString para imprimir los
	 * datos de la conexion
	 */
	@Override
    public String toString() {
        return "Conexion{" +
                "nombreBd='" + getNombreBd() + '\'' +
                ", ubicacion='" + getUbicacion() + '\'' +
                ", puerto='" + getPuerto() + '\'' +
                ", usuario='" + getUsuario() + '\'' +
                ", clave='" + getClave() + '\'' +
                '}';
    }
	
	
	

	// SEGUNDA ACTUALIZACION

	// @SuppressWarnings("unused")

	/*
	 * public Connection conectar() { Connection conexion = null;
	 * 
	 * try { Class.forName(CONTROLADOR);
	 * 
	 * // Establecemos la conexión para eso java nos prporciona conexion =
	 * DriverManager.getConnection(URL, USUARIO, CLAVE);
	 * 
	 * System.out.println("Conexión establecida con BD correctamente");
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println("Error al cargar el controlador"); e.printStackTrace(); }
	 * catch (SQLException e) { // TODO Auto-generated catch block
	 * System.out.println("Error en la conexión"); e.printStackTrace(); }
	 * 
	 * return conexion; }
	 */

	/*
	 * public static void conectar() {
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * String userName = "root"; String password = "root";
	 * 
	 * String url =*
	 * "jdbc:mysql://localhost:3306/bd_ejemplo?useUnicode=true&characterEncoding=utf-8"
	 * ;// recuerda // cambiar!!
	 * 
	 * DriverManager.getConnection(url, userName, password);
	 * System.out.println("Conexión establecida con BD correctamente");
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println("Error al cargar el controlador"); e.printStackTrace();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * System.out.println("Error en la conexión"); e.printStackTrace(); }
	 * 
	 * }
	 */

	
	/*
	 * public static void main(String[] args) {
	 * 
	 * // conectar();
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * // Establecemos la conexión para eso java nos prporciona
	 * 
	 * String userName = "root"; String password = "root";
	 * 
	 * String url =
	 * "jdbc:mysql://localhost:3306/bd_ejemplo?useUnicode=true&characterEncoding=utf-8"
	 * ;// recuerda // cambiar!!
	 * 
	 * DriverManager.getConnection(url, userName, password);
	 * System.out.println("Conexión establecida con BD correctamente");
	 * 
	 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * 
	 * System.out.println("Error al cargar el controlador"); e.printStackTrace();
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * System.out.println("Error en la conexión"); e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */
}

