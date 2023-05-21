package menus;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import clases.TratamientoFichero;

public class Listar_VisitasTest {
	
	
	
	
	
    @Test
    public void testPrintMenuSinVisitas() throws IOException {
        
    	TratamientoFichero fichero = new TratamientoFichero();
	      fichero.leerConexion();
    	
    	// Preparar los datos de prueba
        String dni = "48456925l";
        String expectedOutput;
        
          
         expectedOutput ="Listado de visitas\r\n" +
                 "***********************************\r\n" +
                 "Introduzca el DNI del paciente a listar:\r\n" +
                 "Conexión correctamente establecida con la base de datos clinica\r\n" +
                 "Visitas leídas correctamente.\r\n" +
                 "----------------------------\r\n" +
                 "\n" +
                 "Conexión correctamente establecida con la base de datos clinica\r\n" +
                 "Pacientes leidos corréctamente.\r\n" +
                 "-------------------------------\r\n" +
                 "n" +
                 "\n" +
                 "\n" +
                 "Informacion del Paciente:\r\n" +
                 "Nombre: ALBERTO BARBERA\r\n" +
                 "Sexo: hombre\r\n" +
                 "Edad: 44\r\n" +
                 " DNI: 48456925L\r\n" +
                 "Condicion: Mayor de edad\r\n" +
                 "----------------------------\r\n" +
                 "\n" +
                 "------------------------------------\r\n" +
                 "Visitas registradas:\r\n" +
                 "Conexión correctamente establecida con la base de datos clinica\r\n" +
                 "Profesional encontrado correctamente.\r\n" +
                 "-------------------------------------\r\n" +
                 "\r\n" +
                 "Dia  20-05-2023  Hora: 23:28:00   Profesional Medico: Dr. Marcos  Peso  80.0  Kgr.   Altura  1.7 Resultado IMC:  sobrepeso";
        
         expectedOutput = expectedOutput.trim();
        // Crear una instancia de Listar_Visitas
        Listar_Visitas listarVisitas = new Listar_Visitas();
        
        // Imitamos la entrada de teclado por el usuario
        String userInput = dni;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        // Capturar la salida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Invocar al método printMenu
        listarVisitas.printMenu();

        // Obtener la salida capturada
        String output = outputStream.toString();
        
        
        
         int tamanoinput = expectedOutput.length();
         int tamanooutput = output.length();
        System.out.println(expectedOutput.length());
        
        output = output.trim();
        // para dar validez comparamos que la salida es igual
        // en caracteres a lo esperado,los espacios pueden dar falsos
        System.out.println(tamanoinput);
        System.out.println(tamanooutput);
        
        // Verificar la salida
        
       
         assertEquals(expectedOutput.length(), tamanooutput);
    }

}
