package javadoc_git;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import menus.Menu_Inicial;
import menus.Alta_Pacientes;
import menus.Alta_Visitas;
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
		
		 boolean menuok = false;
		
		
		// instanciamos listapacientes para ir alamcenando los pacientes
		
		
		
			/*
			 * Scanner sc = new Scanner(System.in); sc.useDelimiter("\n");
			 * sc.useLocale(Locale.US); //Introducimos los datos
			 * 
			 * System.out.println("Introduce el DNI"); //String dni = sc.next(); String dni
			 * = "458787733J"; //sc.reset(); System.out.println("Introduce el nombre");
			 * //String nombre = sc.next(); String nombre = "Pedro Perez"; //sc.reset();
			 * System.out.println("Introduce la edad");
			 * 
			 * //sc.reset(); //int edad = sc.nextInt(); int edad = 56;
			 * System.out.println("Introduce el sexo H hombre o M mujer"); //sc.reset();
			 * //char sexo = sc.next().charAt(0); char sexo = 'H';
			 * System.out.println("Introduce el peso"); //sc.reset(); //double peso =
			 * sc.nextDouble(); double peso = 89.97;
			 * System.out.println("Introduce la altura"); //sc.reset(); //double altura =
			 * sc.nextDouble(); double altura = 178.97;
			 * System.out.println("Introduce la dirección"); //sc.reset(); //String
			 * direccion = sc.next(); String direccion = "Calle la Mata 23";
			 * System.out.println("Introduce la localidad"); //sc.reset(); //String
			 * localidad = sc.next(); String localidad = "Torrevieja";
			 * System.out.println("Introduce el codigo postal"); //sc.reset(); //String
			 * cod_postal = sc.next(); String cod_postal = "03380"; Paciente paciente = new
			 * Paciente(dni,nombre,edad,sexo,peso,altura,direccion,localidad,cod_postal);
			 * 
			 * listaPacientes.put(dni, paciente);
			 * 
			 * TratamientoFichero.grabarPacientes(listaPacientes);
			 * 
			 * listaPacientes = new TreeMap<String,Paciente>();
			 * 
			 * 
			 * System.out.println("FICHERO GRABADO");
			 * 
			 * 
			 * 
			 * listaPacientes = TratamientoFichero.leerFicheroPaci();
			 */
		
		 
		 
		 // llamamos al menú inicial
		 
		
		
		
		
		
		do {
			
			Menu_Inicial menuinicial = new Menu_Inicial();
		
		menuinicial.printMenu();
		Scanner omenu = new Scanner(System.in);
		int opcionmenu =0; 
			
			// variable para controlar cuando salir del menú
			
			
		try {
		 
		 
				
			opcionmenu = omenu.nextInt();
			switch (opcionmenu) {
			//

			case 1: {

			
				
				
				System.out.println("Ha elegido alta de Pacientes");
				System.out.println("----------------------------------");
				menuok = true;
				//opcionmenu1 = 1;
				
				
				Alta_Pacientes alta_paciente = new Alta_Pacientes();
				
				alta_paciente.printMenu();
				
				Paciente paciente = new Paciente();
				paciente = alta_paciente.nuevoPaciente();
				
				String dni = paciente.getDni();
			
				
				//System.out.println("nombre: "+ listaPacientes.toString());
				
				System.out.print(paciente.toString());
				
				
			}

			case 2: {
				
			
				System.out.println("Ha elegido alta de Visitas");
				System.out.println("----------------------------------");
				menuok = false;
				//opcionmenu1 = 2;
				
				Alta_Visitas altavisita = new Alta_Visitas();
				altavisita.nuevaVisita();
				
				

			}
			case 99: {

				menuok = true;
				System.out.println("_____________________");
				System.out.println("Saliendo del programa");
				System.exit(0);
				break;
			}
			default:
				
			System.out.println("Opcion incorrecta");
			System.out.println("\n");
				System.out.println("\n");
			
			menuok = false;
			
			}
			
			
		
		} catch (InputMismatchException ex) {
			
			
            System.out.println("Debe ingresar obligatoriamente un número entero.");
            System.out.println("\n");
			System.out.println("\n");
        }
		
		finally {
			
		
				
			}
			
			
			
		
		

		
	} while (menuok == false);
		
		
		//TODO     falta implementar las visitas y comprobar el dni
		// si existe nos quedamos el dni, si no existe lo damos de alta
		
	}
	

}
