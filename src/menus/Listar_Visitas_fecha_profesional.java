package menus;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import clases.Paciente;
import clases.Profesionales_Medicos;
import clases.TratamientoFichero;
import clases.Validadores;
import clases.Visita;
import conexionSQL.SentenciasSQL;

/**
 * Clase Listar_Visitas_fecha_profesional para listar las visitas de los
 * pacientes por fecha y por profesional
 * 
 */
public class Listar_Visitas_fecha_profesional {

	private Validadores validador = new Validadores();

	/**
	 * Constructor por defecto
	 */
	public Listar_Visitas_fecha_profesional() {
	}

	/**
	 * Método para imprimir el menú
	 *
	 * @throws IOException captura la excepción
	 */
	public void printMenu() throws IOException {
		String fecha;
		String dniProfesional;
		TreeMap<Integer, Visita> visitas = new TreeMap<Integer, Visita>();

		System.out.println("Listado de visitas por fecha y profesional");
		System.out.println("***********************************");
		System.out.println("Introduzca la fecha (dd/MM/yyyy) y el DNI del profesional médico a listar");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		// Introducir la fecha

		// Validar el formato de fecha

		// Pedimos fecha hasta que sea correcta
		do {
			System.out.print("Introduzca la fecha (dd/MM/yyyy): ");
			fecha = sc.next().trim();

			// Validate the format of the date
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				LocalDate.parse(fecha, dateFormatter);
			} catch (DateTimeParseException e) {
				System.out
						.println("Fecha en formato incorrecto. Por favor, introduzca la fecha en formato dd/MM/yyyy.");
				continue; // repite hasta que sea correcto
			}

			break; // salimos del bucle si es correcto
		} while (true);

		// Introducir el DNI del profesional médico

		// lanzamos mientras sea incorrecto el DNI
		do {
			System.out.print("Introduzca el DNI del profesional médico: ");
			dniProfesional = sc.next().toUpperCase();

			// Validar el DNI del profesional médico
			if (!validador.validarDni(dniProfesional)) {
				System.out.println("DNI del profesional médico inválido. Por favor, introduzca un DNI válido.");
				return;
			}

			break; // Salimos si es correcto
		} while (true);

		
		try {
		
		
		// Buscar el profesional médico
		Profesionales_Medicos profesional = SentenciasSQL.buscarProfesional(dniProfesional);

		if (profesional != null) {
			System.out.println(profesional.toString());
			System.out.println();
			System.out.println("-------------------------");

			// Obtener la lista de visitas por fecha y profesional
			visitas = SentenciasSQL.listaVisitas(dniProfesional, fecha);
			if (!visitas.isEmpty()) {
				System.out.println(" Fin del listado de Visitas.");

				System.out.println("-------------------------");
			} else {
				System.out.println("No se encontraron visitas para la fecha y el profesional médico especificados.");
				System.out.println("-------------------------");
			}
		} else {
			System.out.println();
			System.out.println("Lo sentimos, el DNI del profesional médico no se encontró en el sistema.");
			System.out.println();
		}
		
		
		// capturamos excepción de conexion
	} catch (Exception e) {
	    // Handle the CommunicationsException
	    System.err.println("Error de conexion con el servidor: " + e.getMessage());
	    // Additional error handling or recovery logic can be added here
	    // For example, you can log the error, retry the operation, or show an error message to the user
	}
		
		
	}

}