package conexionSQL;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

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
			//e.printStackTrace();
			
		} 
		
		
		
		
		

		return conexion;
	}

	/**
	 * metodo para consultar el nombre de la bd
	 * 
	 * @return nombre bd
	 */
	public static String getNombreBd() {
		return NOMBRE_BD;
	}

	/**
	 * metodo para consultar servidor de la bd
	 * 
	 * @return ruta ip o nombre del servidor
	 */
	public static String getUbicacion() {
		return UBICACION;
	}

	/**
	 * metodo para consultar el puerto del servidor
	 * 
	 * @return puerto del servidor
	 */
	public static String getPuerto() {
		return PUERTO;
	}

	/**
	 * metodo para consultar el usuario de la bd
	 * 
	 * @return usuario de la bd
	 */
	public static String getUsuario() {
		return USUARIO;
	}

	/**
	 * metodo para consultar el password de la bd
	 * 
	 * @return password de la bd
	 */
	public static String getClave() {
		return CLAVE;
	}





	/**
	 * Método para establecer el nombre de la BD
	 * @param nombreBd 
	 */
	public static void setNombreBd(String nombreBd) {
		NOMBRE_BD = nombreBd;
	}

	/**
	 * Método para establecer el ubicacion de la BD
	 * @param ubicacion 
	 */
	public static void setUbicacion(String ubicacion) {
		UBICACION = ubicacion;
	}

	/**
	 * Método para establecer el puerto de la BD
	 * @param puerto
	 */
	public static void setPuerto(String puerto) {
		PUERTO = puerto;
	}

	/**
	 * Método para establecer el usuario de la BD
	 * @param usuario 
	 */
	public static void setUsuario(String usuario) {
		USUARIO = usuario;
	}

	/**
	 * Método para establecer el password de la BD
	 * @param clave
	 */
	public static void setClave(String clave) {
		CLAVE = clave;
	}

	/**
	 * sobrescribimos el metodo toString para imprimir los datos de la conexion
	 */
	@Override
	public String toString() {
		return "Conexion{" + "nombreBd='" + getNombreBd() + '\'' + ", ubicacion='" + getUbicacion() + '\''
				+ ", puerto='" + getPuerto() + '\'' + ", usuario='" + getUsuario() + '\'' + ", clave='" + getClave()
				+ '\'' + '}';
	}

	
}
