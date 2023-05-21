package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
import clases.Validadores;
import conexionSQL.SentenciasSQL;
import clases.Profesionales_Medicos;
import clases.TratamientoFichero;

/**
 * Clase Alta_Profesionales para gestionar el alta de los profesionales médicos
 * 
 */
public class Alta_Profesionales {

	Validadores validadores = new Validadores();

	/**
	 * Constructor por defecto
	 */
	public Alta_Profesionales() {
	}

	/**
	 * Método que imprime el menú de Alta de Profesionales
	 */
	public void printMenu() {
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("      Alta de Profesionales Médicos   ");
		System.out.println("***************************************");
		System.out.println("  Introduzca los datos del profesional");
		System.out.println("\n");
		System.out.println("\n");
	}

	/**
	 * Método para crear un nuevo profesional médico
	 * 
	 * @return devuelve un objeto Profesionales_Medicos
	 * @throws IOException capturamos el error
	 */
	public Profesionales_Medicos nuevoProfesional() throws IOException {
		TreeMap<String, Profesionales_Medicos> listaProfesionales = new TreeMap<String, Profesionales_Medicos>();

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);

		String dni;
		sc.reset();
		Profesionales_Medicos profesional = new Profesionales_Medicos();

		// Validamos el DNI
		do {
			System.out.println("Introduce un DNI válido (8 números y letra)");
			dni = sc.next().trim();
			dni = dni.toUpperCase();
		} while (!validadores.validarDni(dni));

		// Comprobamos si el profesional ya existe
		profesional = TratamientoFichero.buscarProfesional(dni);

		// Si el profesional no existe, lo damos de alta
		if (profesional.getDni() == null) {
			System.out.println("Introduce el nombre");
			Scanner sc1 = new Scanner(System.in).useDelimiter("\n");
			String nombre = sc1.next().trim();
			sc1.reset();

			System.out.println("Introduce los apellidos");
			String apellidos = sc1.next().trim();
			sc1.reset();

			System.out.println("Introduce la localidad");
			String localidad = sc.next().trim();
			sc.reset();

			System.out.println("Introduce el teléfono");
			String telefono = sc.next();
			sc.reset();

			System.out.println("Introduce la especialidad");
			String especialidad = sc.next();
			sc.reset();

			profesional.setDni(dni);
			profesional.setNombre(nombre);
			profesional.setApellidos(apellidos);
			profesional.setLocalidad(localidad);
			profesional.setTelefono(telefono);
			profesional.setEspecialidad(especialidad);

			listaProfesionales.put(dni, profesional);
			SentenciasSQL.grabarProfesionales(listaProfesionales);

			System.out.println("\n");
		} else {
			System.out.println("El profesional ya existe");
			System.out.println("-------------------------");
			System.out.println("\n");
		}

		return profesional;
	}

	/**
	 * Método para dar de alta un profesional médico pasando el DNI
	 * 
	 * @param ndni el DNI del profesional médico
	 * @return devuelve un objeto Profesionales_Medicos
	 */
	public Profesionales_Medicos nuevoProfesional(String ndni) {
		TreeMap<String, Profesionales_Medicos> listaProfesionales = new TreeMap<String, Profesionales_Medicos>();

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);

		String dni;
		sc.reset();
		Profesionales_Medicos profesional = new Profesionales_Medicos();

		// Validamos el DNI
		do {
			System.out.println("Introduce un DNI válido (8 números y letra)");
			dni = sc.next().trim();
			dni = dni.toUpperCase();
		} while (validadores.validarDni(dni));

		System.out.println("Introduce el nombre");
		Scanner sc1 = new Scanner(System.in).useDelimiter("\n");
		String nombre = sc1.next().trim();
		sc1.reset();

		System.out.println("Introduce los apellidos");
		String apellidos = sc1.next().trim();
		sc1.reset();

		System.out.println("Introduce la localidad");
		String localidad = sc.next().trim();
		sc.reset();

		System.out.println("Introduce el teléfono");
		String telefono = sc.next();
		sc.reset();

		System.out.println("Introduce la especialidad");
		String especialidad = sc.next();
		sc.reset();

		profesional = new Profesionales_Medicos(nombre, apellidos, dni, localidad, telefono, especialidad);

		listaProfesionales.put(dni, profesional);
		TratamientoFichero.grabarProfesionales(listaProfesionales);

		return profesional;
	}
}
