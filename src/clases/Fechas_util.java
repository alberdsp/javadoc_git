package clases;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fechas_util {
	
	
	  
	
	
	   public Fechas_util(){}
	
	
	
	/**
	 * este método nos devuelve una fecha en formato "yyyy-MM-dd" 
	 * @param inputDate  "dd-MM-yyyy"
	 * @return String "yyyy-MM-dd" 
	 */
	public static String fechaStrESPtoMysql(String inputDate) {
		
	        // Creamos el formato de entrada
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        // Creamos el formato de salida
	        LocalDate date = LocalDate.parse(inputDate, inputFormatter);

	        // Creamos el formato de salida
	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        // Creamos la variable de salida
	        String convertedDateStr = date.format(outputFormatter);

	        return convertedDateStr;
	    }
	
	
	
	
	
	/**
	 * este método nos devuelve una fecha en formato "dd-MM-yyyy"
	 * @param inputDate  "yyyy-MM-dd" 
	 * @return String "dd-MM-yyyy" 
	 */
	public static String fechaStrMysqltoESP(String inputDate) {
		 // Creamos el formato de entrada
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Creamos el formato de salida
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);

        // Creamos el formato de salida
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Creamos la variable de salida
        String convertedDateStr = date.format(outputFormatter);

        return convertedDateStr;
	}

}
