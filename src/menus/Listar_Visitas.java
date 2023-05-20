package menus;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeMap;

import clases.Paciente;
import clases.TratamientoFichero;
import clases.Visita;
import conexionSQL.SentenciasSQL;

/**
 * Clase Listar_Visitas para listar las visitas de los pacientes
 * 
 * @author Alber
 *
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Listar_Visitas {

    /**
     * Constructor por defecto
     */
    public Listar_Visitas() {
    }

    /**
     * Método para imprimir el menu
     *
     * @throws IOException captura la excepción
     */
    public void printMenu() throws IOException {
        System.out.println("Listado de visitas");
        System.out.println("***********************************");
        System.out.println("Introduzca el DNI del paciente a listar: ");

        Scanner scanner = new Scanner(System.in);
        String dni = scanner.next().toUpperCase();

        // Consultamos las visitas por DNI del paciente
        TreeMap<String, Visita> visitas = SentenciasSQL.leerVisitas(dni);

        if (visitas.isEmpty()) {
            System.out.println("No se encontraron visitas para el paciente con DNI " + dni);
        } else {
            // Print the patient information
            Paciente paciente = SentenciasSQL.buscarPaciente(dni);
            if (paciente != null) {
                System.out.println(paciente.toString());
                System.out.println("------------------------------------");
            }

            // Print the visits
            System.out.println("Visitas registradas:");
            for (Visita visita : visitas.values()) {
                System.out.println(visita.toString());
            }
        }
    }
}
