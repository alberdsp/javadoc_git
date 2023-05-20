package clases;


/**
 * Clase Profesionales_Medicos Almacena los profesionales que pasan consulta
 */
public class Profesionales_Medicos  {
	
	private String nombre, apellidos, dni, localidad, telefono, especialidad;


	public Profesionales_Medicos() {
		
	}
	
	public Profesionales_Medicos( String nombre, String apellidos, String dni,
			String localidad, String telefono, String especialidad) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;  // usaremos dni como clave primaria
		this.localidad = localidad;
		this.telefono = telefono;
		this.especialidad = especialidad;	
	}
		


/**
 *  metodo que devuelve nombre
 * @return
 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
	    return "Información del Profesional Médico:\n" +
	           "Nombre: " + nombre + "\n" +
	           "Apellidos: " + apellidos + "\n" +
	           "DNI: " + dni + "\n" +
	           "Localidad: " + localidad + "\n" +
	           "Teléfono: " + telefono + "\n" +
	           "Especialidad: " + especialidad + "\n" +
	           "----------------------------\n";
	}

	
}

