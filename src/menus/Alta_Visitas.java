package menus;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import clases.Paciente;
import clases.TratamientoFichero;
import clases.Visita;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Clase para mostrar menu de alta y métodos de alta de Visitas
 * 
 * @author Alber
 *
 */
public class Alta_Visitas {
	// establecemos los formatos de fecha y hora
	DateTimeFormatter forma_fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter forma_hora = DateTimeFormatter.ofPattern("HH:mm");

	/**
	 * Método constructor por defecto
	 */
	public Alta_Visitas() {

	}

	/**
	 * Método que imprime el menú de Alta de visitas
	 */
	public void printMenu() {

		System.out.println("      Grabar nueva visita  ");
		System.out.println("***********************************");
		System.out.println("  Introduzca los datos de la visita ");
		System.out.println("\n");

	}

	/**
	 * método para grabar nueva visita completa
	 * 
	 * @throws IOException
	 */
	public String nuevaVisita() throws IOException {

		Scanner sc = new Scanner(System.in);
		// sc.useDelimiter("\n");
		sc.useLocale(Locale.US);

		String insertado = " Visita grabada";

		// Introducimos los datos

		System.out.println("Introduce el DNI");
		String dni = sc.next().toUpperCase();

		// buscamos el DNI en el fichero, si lo encuentra grabamos
		// el DNI, si no lo encuentra llamamos al método Alta_Pacientes
		Paciente paciente = TratamientoFichero.buscarPaciente(dni);
		if (paciente.getDni() != null) {

			System.out.println("\n");
			System.out.println("\n");
			System.out.println("****************************");
			System.out.println("    Paciente encontrado     ");
			System.out.println("****************************");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println(TratamientoFichero.buscarPaciente(dni).toString());
			System.out.println("\n");
			System.out.println("\n");

		} else {

			System.out.println("\n");
			System.out.println("\n");
			System.out.println("paciente no encontrado");
			System.out.println("----------------------");
			System.out.println("Procedemos a dar de alta");
			System.out.println("\n");
			System.out.println("\n");

			/**
			 * Instanciamos la clase Alta_Pacientes
			 */
			Alta_Pacientes alta_paciente = new Alta_Pacientes();

			alta_paciente.printMenu();

			// pasamos dni como paramatro para grabar paciente con dni
			paciente = alta_paciente.nuevoPaciente(dni);

		}

		// Se establece la fecha y la hora a la del momento de grabar

		LocalDateTime now = LocalDateTime.now();
		String fecha = forma_fecha.format(now);
		String hora = forma_hora.format(now);
		// Scanner scd = new Scanner(System.in);
		double peso = 0;
		double altura = 0;
		Boolean error = true; // para detectar error de entrada de datos

		do {
			Scanner scd = new Scanner(System.in);
			try {
				scd.reset();
				System.out.println("Introduce el peso, ejemplo 60,50 (Será en Kilogramos");

				peso = scd.nextDouble();
				error = false;
				paciente.setPeso(peso);
				scd.reset();
			} catch (InputMismatchException i) {

				System.out.println("ha introducido el peso incorrecto");
				System.out.println("---------------------------------");
				System.out.println("\n");

			}
		} while (error);

		error = true;

		do {
			Scanner scd2 = new Scanner(System.in);
			try {

				System.out.println("Introduce la altura, ejemplo 1,75 (Será en Metros");

				scd2.reset();
				altura = scd2.nextDouble();
				scd2.reset();
				paciente.setAltura(altura);
				error = false;
			} catch (InputMismatchException i2) {

				System.out.println("ha introducido una altura incorrecta");
				System.out.println("---------------------------------");
				System.out.println("\n");

			}

		} while (error);

		String unidadaltura = "metros";
		String resulimc = Paciente.resultadoImc(paciente);
		Visita nuevavisita = new Visita(dni, fecha, hora, peso, altura, unidadaltura, resulimc);

		// lista de visitas, puede grabar de una en una o varias en el futuro
		TreeMap<String, Visita> visitas = new TreeMap<String, Visita>();
		visitas.put(dni, nuevavisita);

		TratamientoFichero.grabarVisitas(visitas);

		return insertado;

	}

}
