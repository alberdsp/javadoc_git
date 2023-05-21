package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import com.mysql.jdbc.CommunicationsException;

import clases.Paciente;
import clases.TratamientoFichero;
import clases.Validadores;
import conexionSQL.SentenciasSQL;

/**
 * Clase Alta_Pacientes para gestionar el alta de los pacientes
 * 
 * @author Alber
 *
 */

public class Alta_Pacientes {

	private Validadores validador = new Validadores();
	
	
	/**
	 * Constructor por defecto
	 */
	public Alta_Pacientes() {
	}

	/**
	 * Método que imprime el menú de Alta de Pacientes
	 */

	public void printMenu() {

		System.out.println("\n");
		System.out.println("\n");
		System.out.println("      Alta de Pacientes   ");
		System.out.println("***********************************");
		System.out.println("  Introduzca los datos del paciente");
		System.out.println("\n");
		System.out.println("\n");
	}

	/**
	 * Método para crear un nuevo paciente
	 * 
	 * @return devuelve un objeto Paciente
	 * @throws IOException capturamos el error
	 */

	@SuppressWarnings("resource")
	public Paciente nuevoPaciente() throws IOException {

		TreeMap<String, Paciente> listaPacientes = new TreeMap<String, Paciente>();

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);

		String dni;
		sc.reset();
		Paciente paciente = new Paciente();

		
		try {
		
		
		
		// validamos dni
		do {

			System.out.println("Introduce DNI valido 8 numeros y letra");
			dni = sc.next().trim();
			dni = dni.toUpperCase();

		} while (validador.validarDni(dni) == false);

		
		
		
		
		paciente = SentenciasSQL.buscarPaciente(dni);

		
		
		
		if (paciente.getDni() == null) {
			System.out.println("Introduce el nombre");
			Scanner sc1 = new Scanner(System.in).useDelimiter("\n");

			String nombre = "";

			nombre = sc1.next().trim();

			sc1.reset();
			System.out.println("Introduce la edad");

			int edad = sc.nextInt();
			sc.reset();
			System.out.println("Introduce el sexo H hombre o M mujer");

			char sexo = sc.next().toUpperCase().charAt(0);
			sc.reset();

			System.out.println("Introduce la calle");
			Scanner sc2 = new Scanner(System.in).useDelimiter("\n");
			String calle = "";
			calle = sc2.next().trim();
			sc2.reset();

			System.out.println("Introduce la localidad");
			String localidad = "";
			localidad = sc.next().trim();
			sc.reset();
			System.out.println("Introduce el codigo postal");

			String cod_postal = sc.next();
			sc.reset();

			paciente.setDni(dni);
			paciente.setNombre(nombre);
			paciente.setEdad(edad);
			paciente.setSexo(sexo);
			paciente.setCalle(calle);
			paciente.setLocalidad(localidad);
			paciente.setCod_postal(cod_postal);

			listaPacientes.put(dni, paciente);
			
			// comprobamos si existe el paciente
			try {
				SentenciasSQL.grabarPacientes(listaPacientes);
			   
			} catch (Exception e) {
			   
			   System.out.println("error de conexión con la base de datos");
			}
			
			
			System.out.println("\n");

		} else {

			System.out.println("el paciente ya existe");
			System.out.println("---------------------");
			System.out.println("\n");

		}

		
		
		// capturamos excepción de conexion
		} catch (Exception e) {
		    // Handle the CommunicationsException
		    System.err.println("Error de conexion con el servidor: " + e.getMessage());
		    // Additional error handling or recovery logic can be added here
		    // For example, you can log the error, retry the operation, or show an error message to the user
		}
		
		
		
		return paciente;
		
		

	}

	/**
	 * Metodo para dar de alta paciente pasando ndni
	 * 
	 * @param ndni String ndni será el número de dni pasado
	 * @return devuelve objeto Paciente
	 */

	public Paciente nuevoPaciente(String ndni) {
		TreeMap<String, Paciente> listaPacientes = new TreeMap<String, Paciente>();

//// Introducimos los datos
//

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);

		String dni;
		sc.reset();
		Paciente paciente = new Paciente();

		
		try {
		
		
		// validamos dni
		do {

			System.out.println("Introduce DNI valido 8 numeros y letra");
			dni = sc.next().trim();
			dni = dni.toUpperCase();

		} while (paciente.validarDni(dni) == false);

		System.out.println("Introduce el nombre");
		Scanner sc1 = new Scanner(System.in).useDelimiter("\n");

		String nombre = "";

		nombre = sc1.next().trim();

		sc1.reset();
		System.out.println("Introduce la edad");

		int edad = sc.nextInt();
		sc.reset();
		System.out.println("Introduce el sexo H hombre o M mujer");

		char sexo = sc.next().toUpperCase().charAt(0);
		sc.reset();

		System.out.println("Introduce la dirección");

		String direccion = "";
		direccion = sc1.next().trim();
		sc1.reset();

		System.out.println("Introduce la localidad");
		String localidad = "";
		localidad = sc.next().trim();
		sc.reset();
		System.out.println("Introduce el codigo postal");

		String cod_postal = sc.next();
		sc.reset();

		paciente = new Paciente(dni, nombre, edad, sexo, direccion, localidad, cod_postal);

		listaPacientes.put(dni, paciente);
		SentenciasSQL.grabarPacientes(listaPacientes);

		
		
		
		// capturamos excepción de conexion
	} catch (Exception e) {
	    // Handle the CommunicationsException
	    System.err.println("Error de conexion con el servidor: " + e.getMessage());
	    // Additional error handling or recovery logic can be added here
	    // For example, you can log the error, retry the operation, or show an error message to the user
	}
		
		
		return paciente;
	}

}
