package menus;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.IOException;
import java.time.LocalDateTime;
import javadoc_git.Paciente;
import javadoc_git.TratamientoFichero;
import javadoc_git.Visita;

public class Alta_Visitas {
	// establecemos los formatos de fecha
	DateTimeFormatter forma_fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter forma_hora = DateTimeFormatter.ofPattern("HH:mm");

	/**
	 * Clase que gestiona el alta de las visitas
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
	 * método para grabar nueva visita
	 * 
	 * @throws IOException
	 */
	public String nuevaVisita() throws IOException {

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);
		Paciente paciente;
		String insertado = " Visita grabada";
		
		// Introducimos los datos

		System.out.println("Introduce el DNI");
		String dni = sc.next().trim();
		

		// buscamos el DNI en el fichero, si lo encuentra grabamos
		// el DNI, si no lo encuentra llamamos al método Alta_Pacientes
		if (TratamientoFichero.buscarPaciente(dni).getNombre() != null) {

			System.out.println("    Paciente encontrado     ");
			System.out.println("****************************");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println(TratamientoFichero.buscarPaciente(dni).toString());

			paciente = TratamientoFichero.buscarPaciente(dni);

		} else {

			Alta_Pacientes alta_paciente = new Alta_Pacientes();
			paciente = alta_paciente.nuevoPaciente(dni);

		}

		// Se establece la fecha y la hora a la del momento de grabar

		LocalDateTime now = LocalDateTime.now();
		String fecha = forma_fecha.format(now);
		String hora = forma_hora.format(now);

		String resulimc = Paciente.resultadoImc(paciente);
		System.out.println("Introduce el peso, ejemplo 60,50");

		double peso = sc.nextDouble();
		sc.reset();

		System.out.println("Introduce la altura, ejemplo 175,10");

		double altura = sc.nextDouble();
		sc.reset();

		System.out.println("Introduce la unidad de altura cm,dm,m...");

		String unidadaltura = sc.next();
		sc.reset();

		Visita nuevavisita = new Visita(dni, fecha, hora, peso, altura, unidadaltura, resulimc);
		TreeMap<String, Visita> visitas = new TreeMap<String, Visita>();
		visitas.put(dni, nuevavisita);

		TratamientoFichero.grabarVisitas(visitas);

		return insertado;

	}

}
