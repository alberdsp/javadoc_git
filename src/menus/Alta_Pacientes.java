package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import javadoc_git.Paciente;
import javadoc_git.TratamientoFichero;

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

		System.out.println("\n");
		System.out.println("\n");
		System.out.println("      Alta de Pacientes   ");
		System.out.println("***********************************");
		System.out.println("  Introduzca los datos del paciente");
		System.out.println("\n");
		System.out.println("\n");
	}

	/**
	 * Método para crear un nuevo paciente
	 * 
	 * @return devuelve un objeto Paciente
	 * @throws IOException 
	 */

	public Paciente nuevoPaciente() throws IOException {
		
		TreeMap<String,Paciente> listaPacientes = new TreeMap<String,Paciente>();
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);
		
		// Introducimos los datos

		System.out.println("Introduce el DNI");
		String dni = sc.next().trim();
		sc.reset();
		
		// comprobamos si existe el paciente
		Paciente paciente = TratamientoFichero.buscarPaciente(dni);
		// si no existe pasamos a darlo de alta
		
		if (paciente.getDni() == null) {
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
		
		System.out.println("Introduce la dirección");
		Scanner sc2 = new Scanner(System.in).useDelimiter("\n");
		String calle = "";
		calle = sc2.next().trim();
		sc2.reset();

		System.out.println("Introduce la localidad");
		String localidad = "";
		localidad = sc.next().trim();
		sc.reset();
		System.out.println("Introduce el codigo postal");

		String cod_postal = sc.next();
		sc.reset();

		//paciente = new Paciente(dni, nombre, edad, sexo, calle, localidad, cod_postal);
		paciente.setDni(dni);
		paciente.setNombre(nombre);
		paciente.setEdad(edad);
		paciente.setSexo(sexo);
		paciente.setCalle(calle);
		paciente.setLocalidad(localidad);
		paciente.setCod_postal(cod_postal);
			
		
		
		
		listaPacientes.put(dni, paciente);
		TratamientoFichero.grabarPacientes(listaPacientes);
		System.out.println("\n");
		
			
		}    else {
			
			
			System.out.println("el paciente ya existe");
			System.out.println("---------------------");
			System.out.println(paciente.toString());
			System.out.println("\n");
			
			
			
			
		}
		
		
		
	
		
		return paciente;

	}

	/**
	 * Metodo para dar de alta paciente pasando ndni
	 * 
	 * @param ndni String ndni será el número de dni pasado
	 * @return devuelve objeto Paciente
	 */

	public Paciente nuevoPaciente(String ndni) {
		TreeMap<String,Paciente> listaPacientes = new TreeMap<String,Paciente>();

Scanner sc = new Scanner(System.in);
sc.useDelimiter("\n");
sc.useLocale(Locale.US);
// Introducimos los datos

String dni = ndni.trim();
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

Paciente paciente = new Paciente(dni, nombre, edad, sexo, direccion, localidad, cod_postal);
sc.close();
sc1.close();

listaPacientes.put(dni, paciente);
TratamientoFichero.grabarPacientes(listaPacientes);

return paciente;
	}

}
