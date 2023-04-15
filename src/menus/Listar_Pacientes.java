package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import clases.Paciente;
import clases.TratamientoFichero;

public class Listar_Pacientes {
	
	

	/**
	 * Método para imprimir el menu
	 * 
	 * @throws IOException
	 */
	public void printMenu() throws IOException {

		System.out.println("      Listado de Pacientes  ");
		System.out.println("***********************************");
		System.out.println("\n");
        
		TreeMap<String, Paciente> listapacientes = TratamientoFichero.leerFicheroPaci();    
        
		for (Entry<String, Paciente> listap : listapacientes.entrySet()) {

			System.out.println(listap.toString());
//			String nombre = listap.getValue().getNombre();
//			int edad = listap.getValue().getEdad();
//			char sexo = listap.getValue().getSexo();
//			String calle = listap.getValue().getCalle();
//			String localidad = listap.getValue().getLocalidad();
//			String cod_postal = listap.getValue().getCod_postal();
//
//			pw.println(dni + delimitador + nombre + delimitador + edad + delimitador + sexo + delimitador + calle
//					+ delimitador + localidad + delimitador + cod_postal);
		}
		
		
		

	}

}
