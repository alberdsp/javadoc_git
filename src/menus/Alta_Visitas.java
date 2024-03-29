package menus;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import clases.Paciente;
import clases.Profesionales_Medicos;
import clases.TratamientoFichero;
import clases.Visita;
import conexionSQL.SentenciasSQL;

import java.time.LocalDateTime;

/**
 * Clase Alta_Visitas para manejar el alta de visitas
 * 
 */
public class Alta_Visitas {
	private static final DateTimeFormatter FORMATTER_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter FORMATTER_HORA = DateTimeFormatter.ofPattern("HH:mm");

	/**
	 * Método constructor por defecto
	 */
	public Alta_Visitas() {

	}

	/**
	 * Método para imprimir el menú de alta de visitas
	 */
	public void printMenu() {
		System.out.println("      Alta de Visitas  ");
		System.out.println("***********************************");
		System.out.println("  Introduzca los datos de la visita ");
		System.out.println("\n");
	}

	/**
	 * Método para grabar una nueva visita
	 * 
	 * @throws IOException captura la excepción de entrada y salida
	 */
	public void nuevaVisita() throws IOException {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		System.out.println("Introduce el DNI del paciente:");
		String dniPaciente = scanner.next();
		dniPaciente = dniPaciente.toUpperCase();

		
		
		
		
		
		try {
		
		// Buscamos el paciente por el dni
		Paciente paciente = SentenciasSQL.buscarPaciente(dniPaciente);
		if (paciente.getDni() == null) {
			System.out.println("Paciente no encontrado. Procediendo al alta de paciente.");
			System.out.println();

			Alta_Pacientes altaPaciente = new Alta_Pacientes();
			paciente = altaPaciente.nuevoPaciente(dniPaciente);
		} else {
			System.out.println("Paciente encontrado:");
			System.out.println(paciente.toString());
			System.out.println();
		}

		// imprimimos los profesionales medicos
		Listar_Profesionales profesionaleslist = new Listar_Profesionales();

		profesionaleslist.printMenu();

		System.out.println("Introduce el DNI del profesional médico:");
		String dniProfesional = scanner.next();
		dniProfesional = dniProfesional.toUpperCase();
		Profesionales_Medicos profesional = SentenciasSQL.buscarProfesional(dniProfesional);
		if (profesional.getDni() == null) {
			System.out.println("Profesional médico no encontrado. La visita se registrará sin profesional.");
			System.out.println();
		}

		LocalDateTime now = LocalDateTime.now();
		String fecha = FORMATTER_FECHA.format(now);
		String hora = FORMATTER_HORA.format(now);

		double peso = getInputValue("Introduce el peso en kilogramos:");
		double altura = getInputValue("Introduce la altura en metros:");
		String resulimc = Paciente.resultadoImc(paciente);

		Visita nuevaVisita = new Visita(dniPaciente, dniProfesional, fecha, hora, peso, altura, "metros", resulimc);

		TreeMap<String, Visita> visitas = new TreeMap<String, Visita>();
		visitas.put(dniPaciente, nuevaVisita);

		SentenciasSQL.grabarVisitas(visitas);

		System.out.println("\n");
		System.out.println("Visita grabada correctamente.");
		System.out.println();
		
		// capturamos excepción de conexion
		} catch (Exception e) {
		    // Handle the CommunicationsException
		    System.err.println("Error de conexion con el servidor: " + e.getMessage());
		    // Additional error handling or recovery logic can be added here
		    // For example, you can log the error, retry the operation, or show an error message to the user
		}
		
		
		
		
		
	}

	/**
	 * Método auxiliar para obtener un valor numérico de entrada
	 * 
	 * @param prompt mensaje de entrada
	 * @return el valor numérico ingresado
	 */
	private double getInputValue(String prompt) {
		Scanner scanner = new Scanner(System.in);
		double value = 0.0;
		boolean validInput = false;

		while (!validInput) {
			try {
				System.out.println(prompt);
				value = scanner.nextDouble();
				validInput = true;
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Introduce un valor numérico válido.");
				scanner.nextLine();
			}
		}

		return value;
	}
}
