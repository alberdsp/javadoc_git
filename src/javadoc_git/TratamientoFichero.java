package javadoc_git;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
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

	public static String ruta_pacientes = "C:/Users/Alber/eclipse-workspace/javadoc_git/almacenamiento/pacientes.txt";
	public static String ruta_visitas = "C:/Users/Alber/eclipse-workspace/javadoc_git/almacenamiento/visitas.txt";
	private static String ruta; // proporcionará la ruta de fichero a tratar

	/**
	 * 
	 * metodo para escribir el fichero pasamo como parametro un TreeMap
	 * 
	 */

	public static void grabarPacientes(TreeMap<String, Paciente> pacientes) {

		TreeMap<String, Paciente> listapacientes = pacientes;
		FileWriter fichero = null;
		PrintWriter pw = null;
		String delimitador = ",";

		try {

// Añadir flag a true para no machacar contenido del fichero de escritura

			fichero = new FileWriter(ruta_pacientes, true);
			pw = new PrintWriter(fichero);

			// cremos una variable listmap para recorrerla y grabar los pacientes pasados
			for (Entry<String, Paciente> listap : listapacientes.entrySet()) {

				String dni = listap.getValue().getDni();
				String nombre = listap.getValue().getNombre();
				int edad = listap.getValue().getEdad();
				char sexo = listap.getValue().getSexo();
				double peso = listap.getValue().getPeso();
				double altura = listap.getValue().getAltura();
				String calle = listap.getValue().getCalle();
				String localidad = listap.getValue().getLocalidad();
				String cod_postal = listap.getValue().getCod_postal();

				pw.println(dni + delimitador + nombre + delimitador + edad + delimitador + sexo + delimitador + peso
						+ delimitador + altura + delimitador + calle + delimitador + localidad + delimitador
						+ cod_postal);
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
	 * de las excepciones a capturar. Nos devuelve un TreeMap con clave dni y el
	 * objeto Paciente con el listado de pacientes.
	 *
	 */

	public static TreeMap<String, Paciente> leerFicheroPaci() throws IOException {

		TreeMap<String, Paciente> listaPacientes = new TreeMap<String, Paciente>();
		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ","; // indica como van separados los atributos
		String dni; // actua también de clave en los mapas
		Paciente paciente = new Paciente(); // clase paciente
		String[] pacienteArray; // array para almacenar atributos de la linea del fichero

		ruta = ruta_pacientes; // establece la ruta al path del fichero clientes

		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);
		// añadimos lineas al Map siempre que no esten vacia la linea
		// de ese modo controlamos que si la longitud es myor de 0
		// le leeremos

		while  ((cadena = b.readLine()) != null) {
		
			// creamos un array string con los atributos del metodo split
			// asignamos los valores a los atributos a la clase paciente
			// que será devuelta

		
			pacienteArray = cadena.split(delimitador);

			dni = pacienteArray[0]; // será la clave del treemap
			paciente.setDni(pacienteArray[0]);
			paciente.setNombre(pacienteArray[1]);
			paciente.setEdad(Integer.valueOf((pacienteArray[2]).trim()));
			paciente.setSexo(pacienteArray[3].charAt(0));
			paciente.setPeso(Double.valueOf((pacienteArray[4]).trim()));
			paciente.setAltura(Double.valueOf((pacienteArray[5]).trim()));
			paciente.setCalle(pacienteArray[6]);
			paciente.setLocalidad(pacienteArray[7]);
			paciente.setCod_postal(pacienteArray[8]);

			// Grabamos el objeto en el TreeMap con clave DNI

			listaPacientes.put(dni, paciente);
			// vaciamos array y paciente
			pacienteArray = null;
			paciente = new Paciente();

		}
		b.close();
		return listaPacientes;

	}

	/*
	 * En este método busca en el ficehro de Pacientes hasta que encuentra el DNI
	 * pasado como parametro String ndni en el fichero indicado o bien llega al
	 * final del fichero y nos devuelve el fichero vacio
	 *
	 */

	public static TreeMap<String, Paciente> buscarPaciente(String ndni) throws IOException {

		TreeMap<String, Paciente> pacienteEncontrado = new TreeMap<String, Paciente>();
		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ","; // indica como van separados los atributos
		String dni = ""; // actua también de clave en los mapas
		Paciente paciente = new Paciente(); // clase paciente
		String[] pacienteArray; // array para almacenar atributos de la linea del fichero
		Boolean encontrado = false; // nos indica si hemos encontrado el registro buscado
		ruta = ruta_pacientes; // establece la ruta al path del fichero clientes

		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);
		// añadimos lineas al Map siempre que no esten vacia la linea
		// de ese modo controlamos que si la longitud es myor de 0
		// le leeremos

		while (((cadena = b.readLine()).length() > 0) && encontrado == false) {

			// creamos un array string con los atributos del metodo split
			// asignamos los valores a los atributos a la clase paciente
			// que será devuelta

			pacienteArray = cadena.split(delimitador);

			dni = pacienteArray[0]; // será la clave
			paciente.setDni(pacienteArray[0]);
			paciente.setNombre(pacienteArray[1]);
			paciente.setEdad(Integer.valueOf((pacienteArray[2]).trim()));
			paciente.setAltura(Double.valueOf((pacienteArray[3]).trim()));
			paciente.setCalle(pacienteArray[4]);
			paciente.setLocalidad(pacienteArray[5]);
			paciente.setCod_postal(pacienteArray[6]);

			// Grabamos el objeto en el TreeMap con clave DNI si es encontrado
			if (ndni.equals(dni)) {

				encontrado = true;
				pacienteEncontrado.put(dni, paciente);
			}

			// vaciamos array y paciente
			pacienteArray = null;
			paciente = new Paciente();

		}
		b.close();
		return pacienteEncontrado;

	}

}
