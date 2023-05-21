package clases;

public class Validadores {

	/**
	 * Método para validar un DNI introducido
	 * 
	 * @param ndni StrinG ndni pasamos DNI completo con letra
	 * @return devuelve true si el DNI es válido o false si no lo es
	 */
	public Boolean validarDni(String ndni) {
		String dni;
		final int divisor = 23;
		Boolean dnivalido = false;
		String strdni = ndni.trim().substring(0, 8);
		int numDNI = Integer.parseInt(strdni);
		int res = numDNI - (numDNI / divisor * divisor);
		char letraDNI = generaLetraDNI(res);
		dni = Integer.toString(numDNI) + letraDNI;

		if (ndni.equals(dni)) {

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

}
