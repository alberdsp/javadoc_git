package menus;

import java.util.Scanner;
import clases.TratamientoFichero;
import conexionSQL.Conexion;

/**
 * Clase Modificar_Conexion para configurar la conexión a la base de datos.
 * 
 */
public class Modificar_Conexion {
	Conexion conexion = new Conexion();

	/**
	 * Constructor por defecto.
	 */
	public Modificar_Conexion() {
	}

	/**
	 * Método para imprimir el menú.
	 */
	public void printMenu() {
		System.out.println("      Configuración de conexión  ");
		System.out.println("***********************************");
		System.out.println(conexion.toString());
		System.out.println("***********************************");
		System.out.println("  Introduzca los nuevos datos de conexión ");
		System.out.println("\n");

	}

	/**
	 * Método para configurar la conexión a la base de datos.
	 */
	public void configurarConexion() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca el nombre de la base de datos: ");
		System.out.println("Por defecto 'clinica' ");
		String nombreBd = sc.nextLine();

		System.out.println("Introduzca la ubicación del servidor: ");
		System.out.println("Por defecto 'localhost' si está en su equipo");
		String ubicacion = sc.nextLine();

		System.out.println("Introduzca el puerto del servidor: ");
		System.out.println("Por defecto '3306' ");
		String puerto = sc.nextLine();

		System.out.println("Introduzca el usuario de la base de datos: ");
		String usuario = sc.nextLine();

		System.out.println("Introduzca la contraseña de la base de datos: ");
		String clave = sc.nextLine();

		// Establecemos las propiedades de la clase conexión
		Conexion.setNombreBd(nombreBd);
		Conexion.setUbicacion(ubicacion);
		Conexion.setPuerto(puerto);
		Conexion.setUsuario(usuario);
		Conexion.setClave(clave);

		// Grabamos en el fichero
		TratamientoFichero.grabarConexion();

		System.out.println("\n");
		System.out.println("Configuración de conexión guardada correctamente.");
		System.out.println("\n");
		System.out.println("Se va a proceder a cerrar la aplicación para que los cambios");
		System.out.println("surtan efecto.");
		System.out.println("_____________________");
		System.out.println("Saliendo del programa");
		System.exit(0);
		
	}

}
