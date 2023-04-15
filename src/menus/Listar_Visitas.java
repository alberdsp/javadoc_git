package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import clases.TratamientoFichero;
import clases.Visita;

/**
 * Clase para listar las visitas de los pacientes
 * 
 * @author Alber
 *
 */
public class Listar_Visitas {

	/**
	 * Constructor por defecto
	 */

	public Listar_Visitas() {
	}

	/**
	 * Método para imprimir el menu
	 * 
	 * @throws IOException
	 */
	public void printMenu() throws IOException {

		System.out.println("      Listado de visitas  ");
		System.out.println("***********************************");
		System.out.println("  Introduzca dni del paciente a listar ");
		System.out.println("\n");

		Scanner scd = new Scanner(System.in);
		// sc.useDelimiter("\n");
		scd.useLocale(Locale.US);

		// Introducimos los datos

		String dni = scd.next().toUpperCase();

		TratamientoFichero.listaVisitas(dni);

	}

}
