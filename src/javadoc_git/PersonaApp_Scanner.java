package javadoc_git;

import java.util.Locale;
import java.util.Scanner;
/**
 * Clase PersonaApp_Scanner que solicita los datos, rellena persona
 * e imprime los atributos y su peso y edad
 *@author Alberto
 *@version v0.1
 */
public class PersonaApp_Scanner {
	
	
	/**
	 * metodo main
	 * @param args argumentos del método main
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		sc.useLocale(Locale.US);
         //Introducimos los datos
		
		System.out.println("Introduce el nombre");
		String nombre = sc.next();
		System.out.println("Introduce la edad");
		sc.reset();
		int edad = sc.nextInt();
		System.out.println("Introduce el sexo");
		sc.reset();
		char sexo = sc.next().charAt(0);
		System.out.println("Introduce el peso");
		sc.reset();
		double peso = sc.nextDouble();
		System.out.println("Introduce la altura");
		sc.reset();
		double altura = sc.nextDouble();
		
		
		Persona persona1 = new Persona();
		/**
		 * instanciamos persona2 y 3 con los datos capturados
		 */
		Persona persona2 = new Persona(nombre, edad, sexo);
		Persona persona3 = new Persona(nombre, edad, sexo, peso, altura);
		/**
		 * Instanciamos por codigo la persona1 
		 */
		persona1.setNombre("Laura");
		persona1.setEdad(30);
		persona1.setSexo('M');
		persona1.setPeso(60);
		persona1.setAltura(1.60);
		persona2.setPeso(90.5);
		persona2.setAltura(1.80);
		
		// imprimimos los datos de cada persona
		System.out.println("Persona1");
		MuestraMensajePeso(persona1);
		System.out.println(persona1.toString());
		System.out.println("Persona2");
		MuestraMensajePeso(persona2);
		System.out.println(persona2.toString());
		System.out.println("Persona3");
		MuestraMensajePeso(persona3);
		System.out.println(persona3.toString());
		sc.close();
		
	}
	
	/**
	 * Método que muestra el texto de cómo es el peso ideal de la persona
	 * @param p  pasamos como parámetro la clase persona que queremos evaluar
	 */
	
      
public static void MuestraMensajePeso(Persona p) {
int IMC = p.calcularIMC();
switch (IMC) {
case Persona.PESO_IDEAL:
System.out.println("La persona esta en su peso ideal");
break;
case Persona.INFRAPESO:
System.out.println("La persona esta por debajo de su peso ideal");
break;
case Persona.SOBREPESO:
System.out.println("La persona esta por encima de su peso ideal");
break;
}
}
}
