package clases;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import menus.Menu_Inicial;
import menus.Alta_Pacientes;
import menus.Alta_Visitas;

/**
 * Clase PersonaApp_Scanner carga menú y selecciona añadir alta o visitas
 * 
 * 
 * @author Alberto
 * @version v0.2
 */
public class Main {

	/**
	 * metodo main
	 * 
	 * @param args argumentos del método main
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		// iniciamos variables

		boolean salir = false; // controla cuando salir de la aplicación
		int opcionmenu = 0; // opción elegida
		Scanner omenu;
		Menu_Inicial menuinicial = new Menu_Inicial(); // cargamos menú

		// cargamos el menú inicial
		do {

			menuinicial.printMenu();

			
			
			boolean numbad=true;
			do {
			omenu = new Scanner(System.in);	
			try {
		    omenu.reset();
			opcionmenu = omenu.nextInt();
			omenu.reset();
			numbad=false;
			}catch (InputMismatchException er) {
				System.out.println("intruduzca un numero valido");	
				
			}
			}while(numbad);
			// evaluamos menú

			
				
				

				switch (opcionmenu) {
				//

				case 1: {

					System.out.println("Ha elegido alta de Pacientes");
					System.out.println("----------------------------------");
					// opcionmenu1 = 1;

					Alta_Pacientes alta_paciente = new Alta_Pacientes();

					alta_paciente.printMenu();

					Paciente paciente = new Paciente();
					paciente = alta_paciente.nuevoPaciente();

					System.out.print(paciente.toString());

					break;
				}

				case 2: {

					System.out.println("Ha elegido alta de Visitas");
					System.out.println("----------------------------------");
					// opcionmenu1 = 2;

					Alta_Visitas altavisita = new Alta_Visitas();
					altavisita.nuevaVisita();

					break;

				}
				case 99: {
                    // salimos
					salir = true;
					System.out.println("_____________________");
					System.out.println("Saliendo del programa");
					System.exit(0);
					break;
				}
				default:

					System.out.println("Opcion incorrecta");
					System.out.println("\n");
					System.out.println("\n");

					salir = false;

				}

//			} catch (InputMismatchException ex) {
		

		} while (salir == false);

	

	}

}
