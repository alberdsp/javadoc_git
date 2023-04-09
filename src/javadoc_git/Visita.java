package javadoc_git;

import java.util.Date;

public class Visita {
	
	/**
	 * Clase para registrar las visitas de los pacientes a la consulta
	 */
	
	
	String dni;
	Date fecha;
	Date hora;
	Double peso;
	Double altura;
	String resulimc;
	
		
	

	/**
	  * 
	  * @param dni almacenamos DNI del Paciente
	  * @param fecha almacenamos Visita del Paciente
	  * @param hora  almacenamos la hora de la Visita
	  * @param peso  almacena el peso tomado en la visita
	  * @param altura alamacenamos la altura medidad en la visita
	  * @param resulimc alamcena el resultado String "infrapeso","sobrepeso", "pesoideal"
	  * que viene del calculo  Paciente.resultadoImc()
	  */
	
	 
	 public Visita(String dni,Date fecha,Date hora,Double peso,Double altura,String resulimc) {
	 this.dni = dni;
	 this.fecha = fecha;
	 this.hora = hora;
	 this.peso = peso;
	 this.altura = altura;
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
		public Date getFecha() {
			return fecha;
		}


		/**
		 * @return devuelve la hora
		 */
		public Date getHora() {
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
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}


		/**
		 * @param hora establece la hora de la visita
		 */
		public void setHora(Date hora) {
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

	 
	 
	 
	 
	 
	 

}
