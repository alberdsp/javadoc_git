package menus;

import java.util.Locale;
import java.util.Scanner;

import javadoc_git.Paciente;

/**
 * 
 * @author Alber clase menu para el alta de los pacientes
 *
 */

public class Alta_Pacientes {

	public Alta_Pacientes() {
	}

	/**
	 * Método que imprime el menú de Alta de Pacientes
	 */

	public void printMenu() {

		System.out.println("      Alta de Pacientes 2023");
		System.out.println("***********************************");
		System.out.println("  Introduzca los datos del paciente");
		System.out.println("\n");

	}

	/**
	 * Método para crear un nuevo paciente
	 * 
	 * @return devuelve un objeto Paciente
	 */

	public Paciente nuevoPaciente() {

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);
		// Introducimos los datos

		System.out.println("Introduce el DNI");
		String dni = sc.next().trim();
		sc.reset();
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
		System.out.println("Introduce el peso, ejemplo 60,50");

		double peso = sc.nextDouble();
		sc.reset();
		System.out.println("Introduce la altura, ejemplo 175,10");

		double altura = sc.nextDouble();
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

		Paciente paciente = new Paciente(dni, nombre, edad, sexo, peso, altura, direccion, localidad, cod_postal);
		sc.close();
        sc1.close();
		return paciente;

	}

}
