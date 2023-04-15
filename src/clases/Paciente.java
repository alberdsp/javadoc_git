package clases;

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
	}

	/**
	 * Declaramos constructor con parametros (String dni ,String nombre, int edad ,
	 * char sexo, String calle, String localidad, String cod_postal) lo utilizaremos
	 * por defecto en el tratamiento de ficheros
	 */

	public Paciente(String dni, String nombre, int edad, char sexo, String calle, String localidad, String cod_postal) {

		this.dni = dni.toUpperCase();
		this.nombre = nombre.toUpperCase();
		this.edad = edad;
		this.calle = calle.toUpperCase();
		this.localidad = localidad.toUpperCase();
		this.cod_postal = cod_postal;
		this.sexo = sexo;

	}

	/**
	 * Método para validar un DNI introducido
	 * @param ndni   StrinG ndni  pasamos  DNI completo con letra
	 * @return devuelve true si el DNI es válido o false si no lo es
	 */
	public Boolean validarDni(String ndni) {
		final int divisor = 23;
		Boolean dnivalido = false;
		String strdni = ndni.trim().substring(0,8);
		int numDNI = Integer.parseInt(strdni);
		int res = numDNI - (numDNI / divisor * divisor);
		char letraDNI = generaLetraDNI(res);
		dni = Integer.toString(numDNI) + letraDNI;
		
		if(ndni.equals(dni)) {
			
			dnivalido = true;
			
		}
		
		return dnivalido;
	}

	
	// nos calcula la letra del DNI
	private char generaLetraDNI(int res) {
		char letras[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		return letras[res];
	}


	
	/**
	 * Declaramos setters
	 */

	public void setDni(String dni) {
		this.dni = dni.toUpperCase();
	}

	public void setCalle(String calle) {
		this.calle = calle.toUpperCase();
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad.toUpperCase();
	}

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
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

	/**
	 * Método que calcularImc , calcula el indice de masa corporal deben estar los
	 * valores almacenados en KILOS y METROS
	 * 
	 */
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

		return "\n" + "Informacion del Paciente:\n" + "Nombre: " + nombre + "\n" + "Sexo: "
				+ sexo + "\n" + "Edad: " + edad + " \n" + " DNI: " + dni + "\n" + "Condicion: " + tipopersona+"\n"+"----------------------------\n";
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
	 * 
	 * @param p pasamos como parámetro la clase persona que queremos evaluar
	 */

	public static String resultadoImc(Paciente p) {
		String supeso = ""; // nos devuelve el texto del calculo del IMC
		int imc = p.calcularImc();
		if (imc == 0) {
			supeso = "peso ideal";
		}
		if (imc == -1) {
			supeso = "infrapeso";
		}
		if (imc == 1) {
			supeso = "sobrepeso";
		}

		return supeso;
	}

}
