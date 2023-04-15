package clases;

import java.util.Date;

/**
 * Clase Visita establece los parametros a utilizar en una visita
 * @author Alber
 *
 */
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
	 * Devuelve DNI
	 * @return  dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Devuelve Fecha
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * devuelve la hora
	 * @return hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * devuelve el peso
	 * @return peso
	 */
	public Double getPeso() {
		return peso;
	}

	/**
	 * devuelve la altura
	 * @return  altura
	 */
	public Double getAltura() {
		return altura;
	}

	/**
	 * devuelve la unidad de altura
	 * @return unidad de altura
	 */
	public String getUnidadaltura() {
		return unidadaltura;
	}

	/**
	 * devuelve el resultado del IMC
	 * @return resultado del IMC
	 */
	public String getResulimc() {
		return resulimc;
	}

	/**
	 * Establece Dni
	 * @param dni establece el dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Establece Fecha
	 * @param fecha de la visita
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Establece Hora de la visita
	 * @param hora pasamos hora de la visita
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * Establece  peso de la visita
	 * @param peso pasamos  peso de la visita
	 */
	public void setPeso(Double peso) {
		this.peso = peso;
	}

	/**
	 * Establece la altura de la visita
	 * @param altura  pasamos altura de la visita
	 */ 
	public void setAltura(Double altura) {
		this.altura = altura;
	}

	/**
	 * Establece el resultado del calculo Paciente.resultadoImc()
	 * @param resulimc  pasamos el resultado de IMC
	 */
	public void setResulimc(String resulimc) {
		this.resulimc = resulimc;
	}

	/**
	 * Establece la unidad de altura
	 * @param unidadaltura  pasamos la unidad de altura metros generalmente
	 */
	public void setUnidadaltura(String unidadaltura) {
		this.unidadaltura = unidadaltura;
	}

	
	/**
	 * Sobrescribe toString() por defecto e imprime las visitas
	 * @return string con la visita
	 */
	@Override
	public String toString() {

		return "Dia " + this.fecha + " Hora: " + this.hora + "  Peso  " + this.peso  + "  Kgr.  " + " Altura  " + this.altura
				+ " Resultado IMC:  " + this.resulimc;

	}

}
