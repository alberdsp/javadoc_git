package clases;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conexionSQL.Conexion;
import menus.*;

/**
 * Clase Main carga menú y selecciona añadir alta o visitas
 * 
 * @author Alberto
 * @version v0.2
 */
public class Main {

	/**
	 * constructor por defecto
	 */
	public Main() {
	}

	/**
	 * metodo main
	 * 
	 * @param args argumentos del método main
	 * @throws IOException captura la excepción
	 */
	public static void main(String[] args) throws IOException {
		// iniciamos variables

		boolean salir = false; // controla cuando salir de la aplicación
		int opcionmenu = 0; // opción elegida
		Scanner omenu;
		Menus menuinicial = new Menus(); // cargamos menú

		// cargamos la configuración de la conexión a la base de datos
		TratamientoFichero.leerConexion();

		Conexion conexion = new Conexion();
		

		// cargamos el menú inicial
		do {

			menuinicial.printMenu();

			boolean numbad = true;
			do {
				omenu = new Scanner(System.in);
				try {
					omenu.reset();
					opcionmenu = omenu.nextInt();
					omenu.reset();
					numbad = false;
				} catch (InputMismatchException er) {
					System.out.println("intruduzca un numero valido");

				}
			} while (numbad);
			// evaluamos menú

			switch (opcionmenu) {
			//

			case 1: {

				System.out.println("Ha elegido alta de Pacientes");
				System.out.println("----------------------------------");

				// Instanciamos Alta_Pacientes

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

				// Instanciamos Alta_Visitas
				Alta_Visitas altavisita = new Alta_Visitas();
				altavisita.nuevaVisita();

				break;
			}

			case 3: {

				System.out.println("Ha elegido alta de profesionales médicos");
				System.out.println("----------------------------------");

				// Instanciamos Alta_Profesionales
				Alta_Profesionales altaprofesionales = new Alta_Profesionales();
				altaprofesionales.printMenu();

				Profesionales_Medicos profesional = new Profesionales_Medicos();
				profesional = altaprofesionales.nuevoProfesional();

				System.out.print(profesional.toString());

				break;
			}

			case 4: {

				System.out.println("Ha elegido listado de Pacientes");
				System.out.println("----------------------------------");

				// Instanciamos Listar_Pacientes
				Listar_Pacientes listarpacientes = new Listar_Pacientes();
				listarpacientes.printMenu();
				break;

			}
			case 5: {

				System.out.println("Ha elegido listado de Visitas");
				System.out.println("----------------------------------");

				// Instanciamos Listar_Visitas
				Listar_Visitas listarvisitas = new Listar_Visitas();
				listarvisitas.printMenu();
				break;

			}

			case 6: {

				System.out.println("Ha elegido listado de Visitas por fecha y profesional");
				System.out.println("----------------------------------");

				// Instanciamos Listar_Visitas_fecha_profesional
				Listar_Visitas_fecha_profesional listarvisitas = new Listar_Visitas_fecha_profesional();
				listarvisitas.printMenu();
				break;

			}

			case 7: {

				System.out.println("Ha elegido listado de Profesionales");
				System.out.println("----------------------------------");

				// Instanciamos Listar_Profesionales
				Listar_Profesionales listarprofesionales = new Listar_Profesionales();
				listarprofesionales.printMenu();
				break;

			}

			case 8: {

				System.out.println("Ha elegido modificar conexion a BD");
				System.out.println("----------------------------------");

				// Instanciamos Listar_Visitas
				Modificar_Conexion modconexion = new Modificar_Conexion();
				modconexion.printMenu();
				modconexion.configurarConexion();
				break;

			}
			case 99: {
				// salimos del programa
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

		} while (salir == false);

	}

}
