package UserLogic;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import Exceptions.DateException;
import Exceptions.PetException;
import Exceptions.UserException;

public class Employee extends User {
	
	private static Employee employee;
	
	public static final int REALIZAR_ADOPCION = 0;
	
	public static final int INGRESAR_MASCOTA = 1;
	
	public static final int VER_ADOPCIONES = 2;
	
	public static final int MASCOTAS_SIN_DUEÑO = 3;

	public static final int VER_PERFIL = 4;
	
	public static final int SALIR = 5;
	
	private String position;
	
	public Employee(String name, int age, String position) {
		super(name, age);
		this.position = position;
	}

	public static Employee getInstance () {
		if (employee == null) {
			employee = createEmployee();
		}
		
		return employee;
	}
	
	//privado para evitar crear desde afuera
	private static Employee createEmployee () {
		Employee employee = null;
		
		boolean isValidEmployee;
		
		do { 
			isValidEmployee = false;

			try {			
				String name = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
				
				if (name.isEmpty()) {
					throw new UserException("El nombre del empleado es obligatorio");
				}
				
				String edad = JOptionPane.showInputDialog("Ingrese la edad del empleado");
				
				if (edad.isEmpty()) {
					throw new UserException("La edad del empleado es obligatoria");
				}
				
				if (Integer.parseInt(edad) < 0 ) {
					throw new UserException("La edad del empleado no puede ser negativa");
				}
				
				if (Integer.parseInt(edad) > 100) {
					throw new UserException("La edad del empleado no es valida");
				}

				String position = JOptionPane.showInputDialog("Ingrese el cargo del empleado");
				
				if (position.isEmpty()) {
					throw new UserException("El cargo del empleado es obligatoria");
				}
				
				employee = new Employee(name, Integer.parseInt(edad), position);
			
				isValidEmployee = true;
			} 
			catch (UserException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "La edad ingresada no es valida");
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar los datos del empleado");
			}
		}
		while (!isValidEmployee);
		
		return employee;
	}
	
	public void createPet () { 
		VetClinic clinic = VetClinic.getInstance();
		
		int chosenOption = 0;
		
		do {
			boolean wasCreated = false;
	
			try {
				String specie = (String) JOptionPane.showInputDialog(null, "Elija la especie del animal", "Especies animales", 0, null, Pet.species(), employee);
				
				if (!clinic.hasSpecie(specie)) {
					throw new PetException("La especie ingresada no esta cargada en el sistema");
				}
				
				String[] animals = Pet.getAnimalsBySpecie(specie);
				
				String animal = (String) JOptionPane.showInputDialog(null, 
						"Elija el tipo de mascota", 
						"Tipo de mascota", 
						chosenOption, 
						null, 
						animals, 
						animals
					);
				
				if (animal.isEmpty()) {
					throw new PetException("El animal es obligatorio");
				}
				
				String name = JOptionPane.showInputDialog("Ingresa el nombre de la mascota");
				
				if (!Pet.isValidName(name)) {
					throw new PetException("El nombre de la mascota es obligatorio");
				}
				
				String weight = JOptionPane.showInputDialog("Ingrese el peso de la mascota");
				
				if (!Pet.isValidWeight(weight)) {
					throw new PetException("El peso de la mascota no es valido");
				}
				
				String year = JOptionPane.showInputDialog("Ingrese el año de nacimiento de la mascota");
				
				String month = JOptionPane.showInputDialog("Ingrese el mes de nacimiento de la mascota");
				
				String day = JOptionPane.showInputDialog("Ingrese el dia de nacimiento de la mascota");
					
				boolean isValidBirthDate = DateValidator.isValidBirthDate(year, month, day);
				
				if (!isValidBirthDate) {
					throw new DateException("La fecha de nacimiento ingresada no es valida");
				}
				
				Pet pet = Pet.createPetBySpecie(
						specie, 
						animal,
						name, 
						LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)), 
						Double.parseDouble(weight));
			
				clinic.getPets().add(pet);
			
				wasCreated = true;
			}
			catch (PetException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch (DateException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error al ingresar la mascota.");
			}
			finally {
				if (wasCreated) {	
					JOptionPane.showMessageDialog(null, "Mascota creada con exito!");
					break;
				}
				chosenOption = JOptionPane.showConfirmDialog(
					null, 
					"¿Desea cancelar la carga de la mascota?", 
					"Confirmación", 
					JOptionPane.YES_NO_OPTION
				);
			}
		} while (chosenOption == JOptionPane.NO_OPTION);
	}
	
	public String[] generalOptions () {
		String [] options = {"Realizar Adopción", "Ingresar Mascota", "Ver Adopciones", "Ver Mascotas Sin Dueño", "Ver Perfil", "Salir"};
		
		return options;
	}
	
	public String profile () {
		VetClinic clinic = VetClinic.getInstance();
		
		String message = "----- Empleado -----\n";
		
		message += "Nombre: " + this.name + "\n";
		message += "Edad: " + this.age + "\n";
		message += "Cargo: " + this.position + "\n\n";
		
		message += "Cantidad de mascotas dadas en adopción: " + clinic.getAdoptions().size();
		
		return message;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
}
