package clases;

import java.io.IOException;
import java.util.Date;

import conexionSQL.SentenciasSQL;

/**
 * Clase Visita establece los parametros a utilizar en una visita
 * 
 */
public class Visita {

	public Visita() {
	};

	/**
	 * Clase para registrar las visitas de los pacientes a la consulta
	 */

	String dni;
	String dniProfesional;
	String fecha;
	String hora;
	Double peso;
	Double altura;
	String unidadaltura;
	String resulimc;

	/**
	 * Constructor con parámetros
	 * 
	 * @param dni            almacenamos DNI del Paciente
	 * @param dniProfesional almacenamos DNI del Profesional
	 * @param fecha          almacenamos Visita del Paciente
	 * @param hora           almacenamos la hora de la Visita
	 * @param peso           almacena el peso tomado en la visita
	 * @param altura         alamacenamos la altura medidad en la visita
	 * @param unidadaltura   almacenamos la unidad de altura cm,dm,m...
	 * @param resulimc       alamcena el resultado String "infrapeso","sobrepeso",
	 *                       "pesoideal" que viene del calculo
	 *                       Paciente.resultadoImc()
	 */
	public Visita(String dni, String dniProfesional, String fecha, String hora, Double peso, Double altura,
			String unidadaltura, String resulimc) {
		this.dni = dni;
		this.dniProfesional = dniProfesional;
		this.fecha = fecha;
		this.hora = hora;
		this.peso = peso;
		this.altura = altura;
		this.unidadaltura = unidadaltura;
		this.resulimc = resulimc;
	}

	public String getDni() {
		return dni;
	}

	public String getDniProfesional() {
		return dniProfesional;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public Double getPeso() {
		return peso;
	}

	public Double getAltura() {
		return altura;
	}

	public String getUnidadaltura() {
		return unidadaltura;
	}

	public String getResulimc() {
		return resulimc;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setDniProfesional(String dniProfesional) {
		this.dniProfesional = dniProfesional;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public void setResulimc(String resulimc) {
		this.resulimc = resulimc;
	}

	public void setUnidadaltura(String unidadaltura) {
		this.unidadaltura = unidadaltura;
	}

	/**
	 * Sobrescribe toString() por defecto e imprime las visitas
	 */
	@Override
	public String toString() {

		Profesionales_Medicos profesional = new Profesionales_Medicos();

		// Llamada a buscar al profesional
		try {
			profesional = SentenciasSQL.buscarProfesional(dniProfesional);
		} catch (NumberFormatException e) {
			System.out.println("de formato de lectura  " + e);
			e.printStackTrace();
		}

		return "Dia  " + this.fecha + "  Hora: " + this.hora + "   Profesional Medico: " + profesional.getNombre()
				+ "  Peso  " + this.peso + "  Kgr.  " + " Altura  " + this.altura + " Resultado IMC:  " + this.resulimc;
	}
}
