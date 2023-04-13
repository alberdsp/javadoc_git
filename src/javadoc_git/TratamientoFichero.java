package javadoc_git;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
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

	/**
	 * metodo para escribir el fichero pasamos como parametro un TreeMap con clave =
	 * dni del paciente y valor = Objeto tipo Paciente
	 * 
	 * @param pacientes
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
				String calle = listap.getValue().getCalle();
				String localidad = listap.getValue().getLocalidad();
				String cod_postal = listap.getValue().getCod_postal();

				pw.println(dni + delimitador + nombre + delimitador + edad + delimitador + sexo + delimitador 
					    + calle + delimitador + localidad + delimitador
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

	/**
	 * En este metodo leemos el fichero de clientes llamada en la definición de un
	 * procedimmiento definido como estático con la palabra reservada Throws seguida
	 * de las excepciones a capturar.
	 * 
	 * @return Nos devuelve un TreeMap con clave dni y el objeto Paciente con el
	 *         listado de pacientes.
	 * @throws IOException
	 */
	public static TreeMap<String, Paciente> leerFicheroPaci() throws IOException {

		TreeMap<String, Paciente> listaPacientes = new TreeMap<String, Paciente>();
		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ","; // indica como van separados los atributos
		String dni; // actua también de clave en los mapas
		Paciente paciente = new Paciente(); // clase paciente
		String[] pacienteArray; // array para almacenar atributos de la linea del fichero

		FileReader f = new FileReader(ruta_pacientes);
		BufferedReader b = new BufferedReader(f);
		// añadimos lineas al Map siempre que no esten vacia la linea
		// de ese modo controlamos que si la longitud es myor de 0
		// le leeremos

		while ((cadena = b.readLine()) != null) {

			// creamos un array string con los atributos del metodo split
			// asignamos los valores a los atributos a la clase paciente
			// que será devuelta

			pacienteArray = cadena.split(delimitador);

			dni = pacienteArray[0]; // será la clave del treemap
			paciente.setDni(pacienteArray[0]);
			paciente.setNombre(pacienteArray[1]);
			paciente.setEdad(Integer.valueOf((pacienteArray[2]).trim()));
			paciente.setSexo(pacienteArray[3].charAt(0));
			paciente.setCalle(pacienteArray[4]);
			paciente.setLocalidad(pacienteArray[5]);
			paciente.setCod_postal(pacienteArray[6]);

			// Grabamos el objeto en el TreeMap con clave DNI

			listaPacientes.put(dni, paciente);
			// vaciamos array y paciente
			pacienteArray = null;
			paciente = new Paciente();

		}
		b.close();
		return listaPacientes;

	}


	/**
	 * * En este método busca en el fichero de Pacientes hasta que encuentra el DNI
	 * pasado como parametro String ndni en el fichero indicado o bien llega al
	 * final del fichero y nos devuelve el objeto paciente  vacio
	 * @param ndni   es el número de dni
	 * @return  devuelve un objeto paciente si lo encuentra
	 * @throws IOException
	 */
	
	
	//TODO   a falta de terminar el metodo de busqueda
	public static Paciente buscarPaciente(String ndni) throws IOException {

	//	TreeMap<String, Paciente> pacienteEncontradoTM = new TreeMap<String, Paciente>();
		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ","; // indica como van separados los atributos
		String dni = ""; // actua también de clave en los mapas
		Paciente paciente = new Paciente(); // clase paciente
		String[] pacienteArray; // array para almacenar atributos de la linea del fichero
		Boolean encontrado = false; // nos indica si hemos encontrado el registro buscado
		FileReader f = new FileReader(ruta_pacientes);
		BufferedReader b = new BufferedReader(f);
		// añadimos lineas al Map siempre que no esten vacia la linea
		// de ese modo controlamos que si la longitud es myor de 0
		// le leeremos

		while ((cadena = b.readLine()) != null && encontrado == false) {

			// creamos un array string con los atributos del metodo split
			// asignamos los valores a los atributos a la clase paciente
			// que será devuelta

			pacienteArray = cadena.split(delimitador);

			dni = pacienteArray[0].trim(); // será la clave
			paciente.setDni(pacienteArray[0]);
			paciente.setNombre(pacienteArray[1]);
			paciente.setEdad(Integer.valueOf((pacienteArray[2]).trim()));
			paciente.setSexo((pacienteArray[3]).charAt(0));
			paciente.setCalle(pacienteArray[4]);
			paciente.setLocalidad(pacienteArray[5]);
			paciente.setCod_postal(pacienteArray[6]);

			// Grabamos el objeto en el TreeMap con clave DNI si es encontrado
			if (ndni.equals(dni)) {

				encontrado = true;
			//	pacienteEncontradoTM.put(dni, paciente);
				
			}else {
				
				paciente = new Paciente();
			}

			// vaciamos array y paciente
			pacienteArray = null;
			

		}
		b.close();
		
		
		
		
		return paciente; // devuelve el objeto paciente encontrado

	}

	/**
	 * 
	 * metodo para escribir el fichero pasamos como parametro un TreeMap con clave =
	 * dni del paciente y valor = Objeto Persona
	 * 
	 */

	public static void grabarVisitas(TreeMap<String, Visita> visitas) {

		TreeMap<String, Visita> listavisitas = visitas;
		FileWriter fichero = null;
		PrintWriter pw = null;
		String delimitador = ",";

		try {

// Añadir flag a true para no machacar contenido del fichero de escritura

			fichero = new FileWriter(ruta_visitas, true);
			pw = new PrintWriter(fichero);

			// creamos una variable listmap para recorrerla y grabar los pacientes pasados
			for (Entry<String, Visita> listav : listavisitas.entrySet()) {

				String dni = listav.getValue().getDni();
				String fecha = listav.getValue().getFecha();
				String hora = listav.getValue().getHora();
				Double peso = listav.getValue().getPeso();
				Double altura = listav.getValue().getAltura();
				String unidadaltura = listav.getValue().getUnidadaltura();
				String resulimc = listav.getValue().getResulimc();

				pw.println(dni + delimitador + fecha + delimitador + hora + delimitador + peso + delimitador
						+ delimitador + altura + delimitador + unidadaltura + delimitador + resulimc);
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

}
