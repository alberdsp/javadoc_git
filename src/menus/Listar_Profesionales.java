package menus;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

import clases.Profesionales_Medicos;
import clases.TratamientoFichero;
import conexionSQL.SentenciasSQL;

/**
 * Clase Listar_Profesionales para manejar el listado de los profesionales médicos
 * 
 */
public class Listar_Profesionales {

    /**
     * Constructor por defecto
     */
    public Listar_Profesionales() {
    }

    /**
     * Método para imprimir el listado de profesionales médicos
     *
     * @throws IOException captura la excepción
     */
    
    public void printMenu() throws IOException {
        System.out.println("      Listado de Profesionales Médicos  ");
        System.out.println("***************************************");
        System.out.println();

        TreeMap<String, Profesionales_Medicos> listaProfesionales = SentenciasSQL.leerProfesionales();

        for (Entry<String, Profesionales_Medicos> listapro : listaProfesionales.entrySet()) {
            
            System.out.println(listapro.toString());
            
       
        }
    }

}
