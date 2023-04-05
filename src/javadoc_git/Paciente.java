package javadoc_git;


/**
 * Declaramos la clase Paciente 
*/


public class Paciente {                      
private final static char sexo_def = 'H';
/**
* Declaramos constante infrapeso 
*/
public static final int infrapeso = -1;      
/**
* Declaramos constante ideal 
*/
public static final int peso_ideal = 0;
/**
* Declaramos constante sobrepeso
*/
public static final int sobrepeso = 1;
private String nombre;
private int edad;
private String dni;
private String calle;
private String localidad;
private String cod_postal;
private char sexo;
private double peso;
private double altura;


public Paciente() {
this("", 0, sexo_def, 0, 0);
}

/**
* Declaramos constructor con parametros (String dni ,String nombre, int edad , double altura, String localidad, String cod_postal)
* lo utilizaremos por defecto en el tratamiento de ficheros
*/



public Paciente(String dni ,String nombre, int edad , char sexo, double peso, double altura, String calle, String localidad, String cod_postal) {

this.dni = dni;
this.nombre = nombre;
this.edad = edad;
this.altura = altura;
this.localidad = localidad;
this.cod_postal = cod_postal;
this.sexo = sexo;
this.peso = peso;
this.calle = calle;


}

/**
* Declaramos constructor con parametros (String nombre, int edad, char sexo)
*/

public Paciente(String dni, int edad, char sexo) {

this.dni = dni;
this.edad = edad;
this.sexo = sexo;
comprobarSexo();
}


/**
* Declaramos constructor con parametros (String nombre, int edad, char sexo, double peso,
double altura)
*/

public Paciente(String nombre, int edad, char sexo, double peso,
double altura) {
this.nombre = nombre;
this.edad = edad;
this.peso = peso;
this.altura = altura;
generarDni();
this.sexo = sexo;
comprobarSexo();
}
private void comprobarSexo() {
if (sexo != 'H' && sexo != 'M') {
this.sexo = sexo_def;
}
}
private void generarDni() {
final int divisor = 23;
int numDNI = ((int) Math.floor(Math.random() * (100000000 -
10000000) + 10000000));
int res = numDNI - (numDNI / divisor * divisor);
char letraDNI = generaLetraDNI(res);
dni = Integer.toString(numDNI) + letraDNI;
}
private char generaLetraDNI(int res) {
char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
return letras[res];
}




/**
* Declaramos setters
*/





public void setDni(String dni) {
this.dni = dni;
}


public void setCalle(String calle) {
this.calle = calle;
}



public void setLocalidad(String localidad) {
this.localidad = localidad;
}



public void setCod_postal(String cod_postal) {
this.cod_postal = cod_postal;
}

public void setNombre(String nombre) {
this.nombre = nombre;
}
public void setEdad(int edad) {
this.edad = edad;
}
public void setSexo(char sexo) {
this.sexo = sexo;
}
public void setPeso(double peso) {
this.peso = peso;
}
public void setAltura(double altura) {
this.altura = altura;
}


/**
* Declaramos getters
*/


public String getNombre() {
return nombre;
}

public int getEdad() {
return edad;
}

public String getDni() {
return dni;
}

public String getCalle() {
return calle;
}

public String getLocalidad() {
return localidad;
}

public String getCod_postal() {
return cod_postal;
}

public char getSexo() {
return sexo;
}

public double getPeso() {
return peso;
}

public double getAltura() {
return altura;
}


public int calcularImc() {
//Calculamos el peso de la persona
double pesoActual = peso / (Math.pow(altura, 2));
//Según el peso, devuelve un código
if (pesoActual >= 20 && pesoActual <= 25) {
return peso_ideal;
} else if (pesoActual < 20) {
return infrapeso;
} else {
return sobrepeso;
}
}



public String toString() {
String sexo;
if (this.sexo == 'H') {
sexo = "hombre";
} else {
sexo = "mujer";
}

// añadimos el código para que imprima si es mayor de edad
String tipopersona = "";

if (this.esMayorDeEdad()) {
	tipopersona = "Mayor de edad";
	} else {
		tipopersona = "Menor de edad";
	}


return "Informacion de la persona:\n"
+ "Nombre: " + nombre + "\n"
+ "Sexo: " + sexo + "\n"
+ "Edad: " + edad + " años\n"
+ "DNI: " + dni + "\n"
+ "Peso: " + peso + " kg\n"
+ "Altura: " + altura + " metros\n"
+ "Condición: " + tipopersona;
} 


// agregamos el método mayor de edad

private boolean esMayorDeEdad() {
	boolean mayoredad = false;
	
	if (edad >= 18) {
		
		mayoredad = true;
	}
	
	
	return mayoredad;
	
	
}		


/**
 * Método que graba el peso ideal de la persona
 * @param p  pasamos como parámetro la clase persona que queremos evaluar
 */

  
public static String resultadoImc(Paciente p) {
 String supeso  =""; // nos devuelve el texto del calculo del IMC
int imc = p.calcularImc();
switch (imc) {
case Paciente.peso_ideal:
supeso = "peso ideal";
break;
case Paciente.infrapeso:
	supeso = "infrapeso";
break;
case Paciente.sobrepeso:
	supeso = "sobrepeso";
break;

}
return supeso;
}
	 

}





