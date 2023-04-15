package clases;

import java.util.Date;

public class Visita {

	/**
	 * Constructor por defecto
	 */
	public Visita() {
	};

	/**
	 * Clase para registrar las visitas de los pacientes a la consulta
	 */

	String dni;
	String fecha;
	String hora;
	Double peso;
	Double altura;
	String unidadaltura;
	String resulimc;

	/**
	 * Constructor con parámetros
	 * 
	 * @param dni          almacenamos DNI del Paciente
	 * @param fecha        almacenamos Visita del Paciente
	 * @param hora         almacenamos la hora de la Visita
	 * @param peso         almacena el peso tomado en la visita
	 * @param altura       alamacenamos la altura medidad en la visita
	 * @param unidadaltura almacenamos la unidad de altura cm,dm,m...
	 * @param resulimc     alamcena el resultado String "infrapeso","sobrepeso",
	 *                     "pesoideal" que viene del calculo Paciente.resultadoImc()
	 */

	public Visita(String dni, String fecha, String hora, Double peso, Double altura, String unidadaltura,
			String resulimc) {
		this.dni = dni;
		this.fecha = fecha;
		this.hora = hora;
		this.peso = peso;
		this.altura = altura;
		this.unidadaltura = unidadaltura;
		this.resulimc = resulimc;

	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return devuelve la fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @return devuelve la hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @return devuelve el peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * @return devuelve la altura
	 */
	public Double getAltura() {
		return altura;
	}

	/**
	 * @return devuelve la unidad de altura
	 */
	public String getUnidadaltura() {
		return unidadaltura;
	}

	/**
	 * @return devuelve el resultado del IMC
	 */
	public String getResulimc() {
		return resulimc;
	}

	/**
	 * @param dni establece el dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @param fecha establece la fecha de la visita
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @param hora establece la hora de la visita
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * @param peso establece el peso de la visita
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/**
	 * @param altura establece la altura de la visita
	 */
	public void setAltura(Double altura) {
		this.altura = altura;
	}

	/**
	 * @param resulimc establece el resultado del calculo Paciente.resultadoImc()
	 */
	public void setResulimc(String resulimc) {
		this.resulimc = resulimc;
	}

	/**
	 * @param unidadaltura establece la unidad de altura
	 */
	public void setUnidadaltura(String unidadaltura) {
		this.unidadaltura = unidadaltura;
	}

	@Override
	public String toString() {

		return "Dia " + this.fecha + " Hora: " + this.hora + "  Peso  " + this.peso  + "  Kgr.  " + " Altura  " + this.altura
				+ " Resultado IMC:  " + this.resulimc;

	}

}
