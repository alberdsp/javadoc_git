package clases;


/**
 * Clase Profesionales_Medicos 
 */
public class Profesionales_Medicos  {
	
	private String nombre, apellidos, dni, localidad, telefono, especialidad;


	public Profesionales_Medicos() {
		
	}
	
	public Profesionales_Medicos(int codigo, String nombre, String apellidos, String dni,
			String localidad, String telefono, String especialidad) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;  // usaremos dni como clave primaria
		this.localidad = localidad;
		this.telefono = telefono;
		this.especialidad = especialidad;	
	}
		



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
	
	
}

