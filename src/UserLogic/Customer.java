package UserLogic;

import javax.swing.JOptionPane;

import Exceptions.UserException;

public class Customer extends User {
	
	private String address;

	public Customer(String name, int age, String address) {
		super(name, age);
		this.address = address;
	}
	
	public static Customer create () throws UserException {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del adoptante");
		
		if (name.isEmpty()) {
			throw new UserException("El nombre del adoptante es obligatorio");
		}
		
		String age = JOptionPane.showInputDialog("Ingrese la edad del adoptante");
		
		validateAge(age);
		
		String address = JOptionPane.showInputDialog("Ingrese la direccion del empleado");
		
		if (address.isEmpty()) {
			throw new UserException("La direccion del empleado es obligatoria");
		}
		
		return new Customer(name, Integer.parseInt(age), address);
	}
	
	public static void validateAge (String age) throws UserException {
		validateNumericFieldForCustomer(age, "Edad");
	
		int ageValidated = Integer.parseInt(age);
		
		if (ageValidated > 100 || ageValidated <= 0) {
			throw new UserException("La edad ingresada no es valida");
		}
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
}
