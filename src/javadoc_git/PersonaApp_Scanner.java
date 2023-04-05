package javadoc_git;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * Clase PersonaApp_Scanner que solicita los datos, rellena persona
 * e imprime los atributos y su peso y edad
 *@author Alberto
 *@version v0.2
 */
public class PersonaApp_Scanner {
	
	
	/**
	 * metodo main
	 * @param args argumentos del método main
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		
		// instanciamos listapacientes para ir alamcenando los pacientes
		
		
		 TreeMap<String,Paciente> listaPacientes = new TreeMap<String,Paciente>();
		 
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);
         //Introducimos los datos
		
		System.out.println("Introduce el DNI");
		//String dni = sc.next();
		String dni = "458787733J";
		//sc.reset();
		System.out.println("Introduce el nombre");
		//String nombre = sc.next();
		String nombre = "Pedro Perez";
		//sc.reset();
		System.out.println("Introduce la edad");
		
		//sc.reset();
		//int edad = sc.nextInt();
		int edad = 56;
		System.out.println("Introduce el sexo H hombre o M mujer");
		//sc.reset();
		//char sexo = sc.next().charAt(0);
		char sexo = 'H';
		System.out.println("Introduce el peso");
		//sc.reset();
		//double peso = sc.nextDouble();
		double peso = 89.97;
		System.out.println("Introduce la altura");
		//sc.reset();
		//double altura = sc.nextDouble();
		double altura = 178.97;
		System.out.println("Introduce la dirección");
		//sc.reset();
		//String direccion = sc.next();
		String direccion = "Calle la Mata 23";
		System.out.println("Introduce la localidad");
		//sc.reset();
		//String localidad = sc.next();
		String localidad = "Torrevieja";
		System.out.println("Introduce el codigo postal");
		//sc.reset();
		//String cod_postal = sc.next();
		String cod_postal = "03380";
		Paciente paciente = new Paciente(dni,nombre,edad,sexo,peso,altura,direccion,localidad,cod_postal);
		
		listaPacientes.put(dni, paciente);
		
		TratamientoFichero.grabarPacientes(listaPacientes);
		
		listaPacientes = new TreeMap<String,Paciente>();
				
		
		System.out.println("FICHERO GRABADO");
		
		
		
		listaPacientes = TratamientoFichero.leerFicheroPaci();
		
		System.out.println("nombre: "+ listaPacientes.toString());
		
		
		/**
		 * Instanciamos por codigo la persona1 
		 */
//		persona1.setNombre("Laura");
//		persona1.setEdad(30);
//		persona1.setSexo('M');
//		persona1.setPeso(60);
//		persona1.setAltura(1.60);
//		persona2.setPeso(90.5);
//		persona2.setAltura(1.80);
		
//		// imprimimos los datos de cada persona
//		System.out.println("Persona1");
//		MuestraMensajePeso(persona1);
//		System.out.println(persona1.toString());
//		System.out.println("Persona2");
//		MuestraMensajePeso(persona2);
//		System.out.println(persona2.toString());
//		System.out.println("Persona3");
//		MuestraMensajePeso(persona3);
//		System.out.println(persona3.toString());
//		sc.close();
//		
	}
	

}
