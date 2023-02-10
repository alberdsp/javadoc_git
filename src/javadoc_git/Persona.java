package javadoc_git;

/**
 * Esta es la calse persona que contiene datos, peso y altura 
 * @author Alberto
 * @version 0.0
 *
 */

public class Persona {
	

	private final static char SEXO_DEF = 'H';
	public static final int INFRAPESO = -1;
	public static final int PESO_IDEAL = 0;
	public static final int SOBREPESO = 1;
	private String nombre;
	private int edad;
	private String DNI;
	private char sexo;
	private double peso;
	private double altura;
	
	
	/**
	 * Constructor por defecto si no hay dato
	 * se espedifica sexo varón  H
	 * 
	 */

	public Persona() {
		this("", 0, SEXO_DEF, 0, 0);
	}
	
	
	/**
	 * Constuctor reducido
	 * @param nombre 
	 * @param edad
	 * @param sexo
	 */

	public Persona(String nombre, int edad, char sexo) {
		this(nombre, edad, sexo, 0, 0);
	}
	
	/**
	 * Constructor completo
	 * @param nombre
	 * @param edad
	 * @param sexo
	 * @param peso
	 * @param altura
	 */

	public Persona(String nombre, int edad, char sexo, double peso, double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.altura = altura;
		generarDni();
		this.sexo = sexo;
		comprobarSexo();
	}

	/**
	 * método para comprobar sexo o establecer H por defecto
	 */
	
	
	private void comprobarSexo() {
		if (sexo != 'H' && sexo != 'M') {
			this.sexo = SEXO_DEF;
		}
	}

	/**
	 * método para generar DNI aleatorio
	 */
	
	private void generarDni() {
		final int divisor = 23;
		int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
		int res = numDNI - (numDNI / divisor * divisor);
		char letraDNI = generaLetraDNI(res);
		DNI = Integer.toString(numDNI) + letraDNI;
	}
	
	/**
	 * Método para generar letra DNI aleatorio
	 */
	

	private char generaLetraDNI(int res) {
		char letras[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		return letras[res];
	}

	/**
	 *  Establace nombre
	 * @param nombre   nombre de la persona
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Establace edad
	 * @param edad   edad de la persona
	 */

	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Establece sexo de la persona
	 * @param sexo sexo de la persona debe ser H (Hombre) o M (Mujer)
	 */
	
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	/**
	 * Establece peso de la persona
	 * @param peso peso de la pesona
	 */

	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * Establece la altura de la persona
	 * @param altura  establece la altura tipo 1,80 
	 */
	
	public void setAltura(double altura) {
		this.altura = altura;
	}

	/**
	 * Método que calcula el índice de peso de la persona
	 * @return    -1 para INFRAPESO , 0 para IDEAL Y +1 SOBREPESO 
	 */
	
	
	public int calcularIMC() {
		// Calculamos el peso de la persona
		double pesoActual = peso / (Math.pow(altura, 2));
		// Segun el peso, devuelve un codigo
		if (pesoActual >= 20 && pesoActual <= 25) {
			return PESO_IDEAL;
		} else if (pesoActual < 20) {
			return INFRAPESO;
		} else {
			return SOBREPESO;
		}
	}

	/**
	 * método que nos devuelve string con los atributos de la clase Persona
	 */
	
	
	public String toString() {
		String sexo;
		if (this.sexo == 'H') {
			sexo = "hombre";
		} else {
			sexo = "mujer";
		}
		return "Informacion de la persona:\n" + "Nombre: " + nombre + "\n" + "Sexo: " + sexo + "\n" + "Edad: " + edad
				+ " años\n" + "DNI: " + DNI + "\n" + "Peso: " + peso + " kg\n" + "Altura: " + altura + " metros\n";
	}
}