package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import clases.Paciente;
import clases.TratamientoFichero;
import conexionSQL.SentenciasSQL;


/**
 * Clase Listar_Pacientes para manejar el listado de los pacientes
 * @author Alber
 *
 */
public class Listar_Pacientes {
	
	  
	/**
	 * Constructor por defecto
	 */
	public Listar_Pacientes() {}
	

	/**
	 * Método para imprimir el menu
	 * 
	 * @throws IOException captura la excepción
	 */
	public void printMenu() throws IOException {

		System.out.println("      Listado de Pacientes  ");
		System.out.println("***********************************");
		System.out.println("\n");
        
		TreeMap<String, Paciente> listapacientes = TratamientoFichero.leerFicheroPaci();    
        
		for (Entry<String, Paciente> listap : listapacientes.entrySet()) {

			System.out.println(listap.toString());

		}
		
		SentenciasSQL.grabarPacientes(listapacientes);
		
		
		

	}

}
