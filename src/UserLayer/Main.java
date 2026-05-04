package UserLayer;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import UserLogic.Adoption;
import UserLogic.Employee;
import UserLogic.Fish;
import UserLogic.Fowl;
import UserLogic.Mammal;
import UserLogic.VetClinic;

public class Main {
	public static void main(String[] args) {
		
		//aplique singleton en la veterinaria
		VetClinic clinic = VetClinic.getInstance();
			
		clinic.getPets().add(new Mammal("Gato", "Luna", LocalDate.of(2018, 5, 15), 24.5));

		clinic.getPets().add(new Mammal("Perro", "Rocky", LocalDate.now(), 0.8));

		clinic.getPets().add(new Fowl("Horne", "Paco", LocalDate.of(2021, 10, 10), 1.2));

		clinic.getPets().add(new Fish("Bagre", "Nemo", LocalDate.of(2023, 1, 3), 0.15));
		
		JOptionPane.showMessageDialog(null, "Bienvenido a la " + clinic.getNameClinic());
		
		int optionEmployee = 0;
		
		//dentro de getinstance se registran datos del empleado manualmente
		Employee employee = Employee.getInstance();
		
		do {
			optionEmployee = JOptionPane.showOptionDialog(null, 
					"Bienvenido " + employee.getName() + "!", "Veterinaria", 0, 0, null, employee.generalOptions(), null);
			
			switch (optionEmployee) {
			case Employee.REALIZAR_ADOPCION:
				
				Adoption.create();
				break;
			case Employee.INGRESAR_MASCOTA:
				
				employee.createPet();
				break;
			case Employee.VER_ADOPCIONES:
				
				clinic.showAdoptions();
				break;
			case Employee.MASCOTAS_SIN_DUEÑO:
				
				clinic.showPets();
				break;
			case Employee.VER_PERFIL:
				
				employee.showProfile();
				break;
			case Employee.SALIR:
				break;
			default:
				JOptionPane.showMessageDialog(null, "No se ha identificado esta accion");
				break;
			}
			
			
		} while (optionEmployee != Employee.SALIR);
	}
}
