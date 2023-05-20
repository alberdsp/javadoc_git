package clases;

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
 * Clase TratamientoFichero para tratar los fichero tanto de clientes
 * como de visitas ruta_clientes establece la ruta donde se guradan los clientes
 * ruta_visitas establece la ruta donde se guradan las visitas
 * 
 * @author Alber
 * 
 */

public class TratamientoFichero {
	
	/**
	 * Constructor por defecto
	 */
	public TratamientoFichero() {}

	/**
	 * ruta del fichero pacientes
	 */
	public static String ruta_pacientes = "almacenamiento/pacientes.txt";
	/**
	 * ruta del fichero visitas
	 */
	public static String ruta_visitas = "almacenamiento/visitas.txt";

	
	public static String ruta_profesionales = "almacenamiento/profesionales.txt";

	
	/**
	 * metodo para escribir pacientes en el fichero pasamos como parametro un
	 * TreeMap con clave = dni del paciente y valor = Objeto tipo Paciente
	 * 
	 * @param pacientes pasamos un objeto paciente
	 */
	public static void grabarPacientes(TreeMap<String, Paciente> pacientes) {

		TreeMap<String, Paciente> listapacientes = pacientes;
		FileWriter fichero = null;
		PrintWriter pw = null;
		String delimitador = ";";

		try {

// Añadimos flag a true para no machacar contenido del fichero de escritura

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

				pw.println(dni + delimitador + nombre + delimitador + edad + delimitador + sexo + delimitador + calle
						+ delimitador + localidad + delimitador + cod_postal);
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
	 * Método leerFichero, el fichero de clientes llamada en la definición de un
	 * procedimmiento definido como estático con la palabra reservada Throws seguida
	 * de las excepciones a capturar.
	 * 
	 * @return Nos devuelve un TreeMap con clave dni y el objeto Paciente con el
	 *         listado de pacientes.
	 * @throws IOException captura excepción
	 */
	public static TreeMap<String, Paciente> leerFicheroPaci() throws IOException {

		TreeMap<String, Paciente> listaPacientes = new TreeMap<String, Paciente>();
		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ";"; // indica como van separados los atributos
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
	 * Método listarVisitas que nos devuelve un TreeMap de las visitas de un
	 * paciente
	 * 
	 * @param ndni pasamos el parámetro ndni como número de deni del paciente
	 * @return devuelve un TreeMap con clave Integer incremental y objeto visita
	 * @throws IOException captura excepción
	 */
	public static TreeMap<Integer, Visita> listaVisitas(String ndni) throws IOException {

		TreeMap<Integer, Visita> listaVisitas = new TreeMap<Integer, Visita>();
		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ";"; // indica como van separados los atributos
		Integer indice = 0; // contador de número de linea
		String dni; // actua también de clave en los mapas
		Visita visita = new Visita(); // clase visitas
		String[] visitaArray; // array para almacenar atributos de la linea del fichero visita

		FileReader f = new FileReader(ruta_visitas);
		BufferedReader b = new BufferedReader(f);
		// añadimos lineas al Map siempre que no esten vacia la linea
		// de ese modo controlamos que si la longitud es myor de 0
		// le leeremos

		while ((cadena = b.readLine()) != null) {

			// creamos un array string con los atributos del metodo split
			// asignamos los valores a los atributos a la clase visita
			// que será devuelta

			visitaArray = cadena.split(delimitador);

			dni = visitaArray[0];
			visita.setDni(visitaArray[0]);
			visita.setDniProfesional(visitaArray[1]);
			visita.setFecha(visitaArray[2]);
			visita.setHora(visitaArray[3]);
			visita.setPeso(Double.parseDouble(visitaArray[4]));
			visita.setAltura(Double.parseDouble(visitaArray[5]));
			visita.setUnidadaltura(visitaArray[6]);
			visita.setResulimc(visitaArray[7]);

			// Grabamos el objeto en el TreeMap con clave indice
			// si coincide con el dni que buscamos

			ndni = ndni.toUpperCase();
			// Grabamos el objeto en el TreeMap con clave DNI si es encontrado
			if (ndni.equals(dni)) {
				++indice;
				listaVisitas.put(indice, visita);
				System.out.println(indice + ". " + visita.toString());
				System.out.println("\n");
			}

			// vaciamos array y paciente
			visitaArray = null;
			visita = new Visita();

		}
		b.close();
		return listaVisitas;

	}

	/**
	 * Método buscar Paciente, busca en el fichero de Pacientes hasta que encuentra
	 * el DNI pasado como parametro String ndni en el fichero indicado o bien llega
	 * al final del fichero y nos devuelve el objeto paciente vacio
	 * 
	 * @param ndni es el número de dni
	 * @return devuelve un objeto paciente si lo encuentra
	 * @throws NumberFormatException captura excepción de error tipo numero
	 * @throws IOException captura excepción
	 */

	public static Paciente buscarPaciente(String ndni) throws NumberFormatException, IOException {

		String cadena; // variable donde almacenanamos cada linea del fichero
		String delimitador = ";"; // indica como van separados los atributos
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
			ndni = ndni.toUpperCase();
			// Grabamos el objeto en el TreeMap con clave DNI si es encontrado
			if (ndni.equals(dni)) {

				encontrado = true;
				// pacienteEncontradoTM.put(dni, paciente);

			} else {

				paciente = new Paciente();
			}

			// vaciamos array y paciente
			pacienteArray = null;

		}
		b.close();

		return paciente; // devuelve el objeto paciente encontrado

	}

	/**
	 * Método grabarVisitas, escribe el fichero pasamos como parametro un TreeMap
	 * con clave = dni del paciente y valor = Objeto Persona este metodo nos permite
	 * grabar de uno en uno varios pacientes según los que pasemos en el TreeMap
	 * 
	 * @param visitas TreeMap que contiene una visita o varias a grabar
	 */
	public static void grabarVisitas(TreeMap<String, Visita> visitas) {

		TreeMap<String, Visita> listavisitas = visitas;
		FileWriter fichero = null;
		PrintWriter pw = null;
		String delimitador = ";";

		try {

// Añadir flag a true para no machacar contenido del fichero de escritura

			fichero = new FileWriter(ruta_visitas, true);
			pw = new PrintWriter(fichero);

			// creamos una variable listmap para recorrerla y grabar los pacientes pasados
			for (Entry<String, Visita> listav : listavisitas.entrySet()) {

				String dni = listav.getValue().getDni();
				String dniProfesional = listav.getValue().getDniProfesional();
				String fecha = listav.getValue().getFecha();
				String hora = listav.getValue().getHora();
				Double peso = listav.getValue().getPeso();
				Double altura = listav.getValue().getAltura();
				String unidadaltura = listav.getValue().getUnidadaltura();
				String resulimc = listav.getValue().getResulimc();

				pw.println(dni + delimitador + dniProfesional + delimitador + fecha + delimitador + hora + delimitador + peso + delimitador + altura
						+ delimitador + unidadaltura + delimitador + resulimc);
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
	
	
	public static void grabarProfesionales(TreeMap<String, Profesionales_Medicos> profesionales) {
	    TreeMap<String, Profesionales_Medicos> listaProfesionales = profesionales;
	    FileWriter fichero = null;
	    PrintWriter pw = null;
	    String delimitador = ";";

	    try {
	        fichero = new FileWriter(ruta_profesionales, true);
	        pw = new PrintWriter(fichero);

	        for (Entry<String, Profesionales_Medicos> listaP : listaProfesionales.entrySet()) {
	            Profesionales_Medicos profesional = listaP.getValue();

	            String dni = profesional.getDni();
	            String nombre = profesional.getNombre();
	            String apellidos = profesional.getApellidos();
	            String localidad = profesional.getLocalidad();
	            String telefono = profesional.getTelefono();
	            String especialidad = profesional.getEspecialidad();

	            pw.println(dni + delimitador + nombre + delimitador + apellidos + delimitador +
	                      localidad + delimitador + telefono + delimitador + especialidad);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (null != fichero) {
	                fichero.close();
	            }
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	}

	
	/**
	 * Método buscar un Profesional, busca en el fichero de Profesionales hasta que encuentra
	 * el DNI pasado como parametro String ndni en el fichero indicado o bien llega
	 * al final del fichero y nos devuelve el objeto paciente vacio
	 * 
	 * @param ndni es el número de dni
	 * @return devuelve un objeto Profesional_Medico si lo encuentra
	 * @throws NumberFormatException captura excepción de error tipo numero
	 * @throws IOException captura excepción
	 */

	public static Profesionales_Medicos buscarProfesional(String ndni) throws NumberFormatException, IOException {
	    String cadena;
	    String delimitador = ";";
	    String dni = "";
	    Profesionales_Medicos profesional = new Profesionales_Medicos();
	    String[] profesionalArray;
	    Boolean encontrado = false;

	    FileReader f = new FileReader(ruta_profesionales);
	    BufferedReader b = new BufferedReader(f);

	    while ((cadena = b.readLine()) != null && !encontrado) {
	        profesionalArray = cadena.split(delimitador);

	       
	        
	        dni = profesionalArray[0].trim(); 
	        profesional.setDni(profesionalArray[0]);
	        profesional.setNombre(profesionalArray[1]);
	        profesional.setApellidos(profesionalArray[2]);
	        profesional.setLocalidad(profesionalArray[3]);
	        profesional.setTelefono(profesionalArray[4]);
	        profesional.setEspecialidad(profesionalArray[5]);

	        ndni = ndni.toUpperCase();

	        if (ndni.equals(dni)) {
	            encontrado = true;
	        } else {
	            profesional = new Profesionales_Medicos();
	        }

	        profesionalArray = null;
	    }
	    
	    b.close();
	    return profesional;
	}
	
	
	public static TreeMap<String, Profesionales_Medicos> leerFicheroProfesionales() throws IOException {
	    TreeMap<String, Profesionales_Medicos> listaProfesionales = new TreeMap<String, Profesionales_Medicos>();
	    String cadena; // variable donde almacenamos cada linea del fichero
	    String delimitador = ";"; // indica cómo van separados los atributos

	    FileReader f = new FileReader(ruta_profesionales);
	    BufferedReader b = new BufferedReader(f);

	    while ((cadena = b.readLine()) != null) {
	        String[] profesionalArray = cadena.split(delimitador);
	        Profesionales_Medicos profesional = new Profesionales_Medicos();
	        profesional.setDni(profesionalArray[0]);
	        profesional.setNombre(profesionalArray[1]);
	        profesional.setApellidos(profesionalArray[2]);
	        profesional.setLocalidad(profesionalArray[3]);
	        profesional.setTelefono(profesionalArray[4]);
	        profesional.setEspecialidad(profesionalArray[5]);

	        listaProfesionales.put(profesional.getDni(), profesional);
	    }

	    b.close();
	    return listaProfesionales;
	}

	


}
