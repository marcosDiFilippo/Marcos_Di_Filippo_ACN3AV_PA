package UserLogic;

import javax.swing.JOptionPane;

import Exceptions.UserException;

public class Customer extends User {

	public Customer(String name, String dni, int age) {
		super(name, dni, age);
	}

	@Override
	public boolean isCustomer() {
		
		return true;
	}
	
	public static Customer create () throws UserException {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del adoptante");
		
		if (name.isEmpty()) {
			throw new UserException("El nombre del adoptante es obligatorio");
		}
		
		String dni = JOptionPane.showInputDialog("Ingrese el dni del adoptante");
		
		validateDni(dni);
		
		String age = JOptionPane.showInputDialog("Ingrese la edad del adoptante");
		
		validateAge(age);
		
		return new Customer(name, dni, Integer.parseInt(age));
	}
	
	public static void validateNumericFieldForCustomer (String dni, String field) throws UserException {
		if (dni.isEmpty()) {
			throw new UserException("El campo " + field + " es obligatorio");
		}
		
		for (int i = 0; i < dni.length(); i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				throw new UserException("El campo " + field + " no puede contener letras ni caracteres especiales");
			}
		}
	}
	
	public static void validateDni (String dni) throws UserException {
		VetClinic clinic = VetClinic.getInstance();
		
		validateNumericFieldForCustomer(dni, "Dni");
		
		if (clinic.existsUserWithDni(dni)) {
			throw new UserException("Ya hay un usuario con el dni " + dni + " registrado en el sistema");
		}
	}
	
	public static void validateAge (String age) throws UserException {
		validateNumericFieldForCustomer(age, "Edad");
	
		int ageValidated = Integer.parseInt(age);
		
		if (ageValidated > 100 || ageValidated <= 0) {
			throw new UserException("La edad ingresada no es valida");
		}
	}
}
