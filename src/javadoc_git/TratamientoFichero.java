package javadoc_git;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author Alber clase para tratar los fichero tanto de clientes como de visitas
 *
 *         ruta_clientes establece la ruta donde se guradan los clientes
 *         ruta_visitas establece la ruta donde se guradan las visitas
 * 
 */

public class TratamientoFichero {

	public static String ruta_clientes = "C:/Users/Alber/eclipse-workspace/persona_edt4/almacenamiento/pacientes.txt";
	public static String ruta_visitas = "C:/Users/Alber/eclipse-workspace/persona_edt4/almacenamiento/visitas.txt";
	private static String ruta; // proporcionará la ruta de fichero a tratar

	/**
	 * 
	 * metodo para escribir el fichero
	 * 
	 */

	private void grabar_Fichero() {

		FileWriter fichero = null;
		PrintWriter pw = null;

		try {

// Añadir flag a true para no machacar contenido del fichero de escritura

			fichero = new FileWriter(ruta, true);
			pw = new PrintWriter(fichero);

			for (int i = 0; i < 10; i++) {
				pw.println("Coche " + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	/*
	 * En este metodo leemos el fichero de clientes llamada en la definición de un
	 * procedimmiento definido como estático con la palabra reservada Throws seguida
	 * de las excepciones a capturar.
	 * Nos devuelve un TreeMap con clave dni y el objeto Paciente con
	 * el listado de pacientes. 
	 *
	 */

	public static TreeMap<String, Paciente> leerFicheroPaci() throws IOException {

		TreeMap<String, Paciente> listaPacientes = new TreeMap<String, Paciente>();
		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ","; // indica como van separados los atributos
		String dni; // actua también de clave en los mapas
		Paciente paciente = new Paciente(); // clase paciente
		String[] pacienteArray; // array para almacenar atributos de la linea del fichero

		ruta = ruta_clientes; // establece la ruta al path del fichero clientes

		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);
		// añadimos lineas al Map siempre que no esten vacia la linea
		// de ese modo controlamos que si la longitud es myor de 0
		// le leeremos

		while ((cadena = b.readLine()).length() > 0) {

			// creamos un array string con los atributos del metodo split
			// asignamos los valores a los atributos a la clase paciente
			// que será devuelta

			pacienteArray = cadena.split(delimitador);

			dni = pacienteArray[0];

			paciente.setDni(pacienteArray[0]);
			paciente.setNombre(pacienteArray[1]);
			paciente.setEdad(Integer.valueOf((pacienteArray[2]).trim()));
			paciente.setCalle(pacienteArray[3]);
			paciente.setLocalidad(pacienteArray[4]);
			paciente.setCod_postal(pacienteArray[5]);

			// Grabamos el objeto en el TreeMap con clave DNI

			listaPacientes.put(dni, paciente);
			// vaciamos array y paciente
			pacienteArray = null;
			paciente = new Paciente();

		}
		b.close();
		return listaPacientes;

	}
	
	

}
	