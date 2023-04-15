package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import clases.Paciente;
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

		// Introducimos los datos y capturamos el dni

		String dni = scd.next().toUpperCase();
        
		
		// si existe el dni listamos el Paciente y las visitas
		 if (TratamientoFichero.buscarPaciente(dni) != null ) {
			
			 Paciente paciente = TratamientoFichero.buscarPaciente(dni);
			 
			 System.out.println(paciente.toString());
			 System.out.println("\n");
			 System.out.println(" ------------------------- ");
			   // si hay visitas las lista
			  if (TratamientoFichero.listaVisitas(dni).size() > 0) {
			  System.out.println("   Fin visitas registradas     ");
			  System.out.println(" ------------------------- ");
			  //Si no hay visitas 
			  }else {
				  System.out.println("\n");
				  System.out.println("   El paciente no tiene visitas   ");
				  System.out.println(" ------------------------------------ ");  
				  System.out.println("\n");
			  }
			
			 
		 }else {
			 
			 System.out.println("\n");
			 System.out.println(" Lo sentimos, el DNI introducido no se"
			 		+ "corresponde con pacientes");
			 System.out.println("\n");
			 
		 }
		
        
        
		

	}

}
