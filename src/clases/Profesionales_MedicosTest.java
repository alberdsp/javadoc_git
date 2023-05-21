package clases;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Profesionales_MedicosTest {

	@Test
	public void testProfesionalesMedicos() {

		String nombre = "Penelope";
		String apellidos = "Martínez";
		String dni = "48456925l";
		String localidad = "Orihuela";
		String telefono = "123456789";
		String especialidad = "Traumatología";

		// Probamos creando una instancia de profesionales
		Profesionales_Medicos profesional = new Profesionales_Medicos(nombre, apellidos, dni, localidad, telefono,
				especialidad);

		// Insertamos valores
		
		Assert.assertEquals(nombre, profesional.getNombre());
		Assert.assertEquals(apellidos, profesional.getApellidos());
		Assert.assertEquals(dni, profesional.getDni());
		Assert.assertEquals(localidad, profesional.getLocalidad());
		Assert.assertEquals(telefono, profesional.getTelefono());
		Assert.assertEquals(especialidad, profesional.getEspecialidad());
	}
	
	
	 @Test
	    public void testProfesionalesMedicosToString() {
		 String nombre = "Paco ";
			String apellidos = "Perez";
			String dni = "48612180r";
			String localidad = "Orihuela";
			String telefono = "123456789";
			String especialidad = "Traumatología";

	        // Create an instance of Profesionales_Medicos
	        Profesionales_Medicos profesional = new Profesionales_Medicos(nombre, apellidos, dni, localidad, telefono, especialidad);

	        // Verify the generated string representation
	        String expectedString = "Información del Profesional Médico:\n" +
	                "Nombre: " + nombre + "\n" +
	                "Apellidos: " + apellidos + "\n" +
	                "DNI: " + dni + "\n" +
	                "Localidad: " + localidad + "\n" +
	                "Teléfono: " + telefono + "\n" +
	                "Especialidad: " + especialidad + "\n" +
	                "----------------------------\n";
	        Assert.assertEquals(expectedString, profesional.toString());
	    }

}


