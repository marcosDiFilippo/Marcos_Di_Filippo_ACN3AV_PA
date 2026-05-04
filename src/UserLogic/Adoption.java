package UserLogic;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import Exceptions.UserException;

public class Adoption implements Ticket {
	private LocalDate date;
	private Employee employee;
	private Customer customer;
	private Pet pet;
	
	public Adoption(LocalDate date, Employee employee, Customer customer, Pet pet) {
        this.date = date;
        this.employee = employee;
        this.customer = customer;
        this.pet = pet;
    }
	
	public static void create() {
		VetClinic clinic = VetClinic.getInstance();
		
		if (!clinic.hasPets()) {
			JOptionPane.showMessageDialog(null, "No hay mascotas en el sistema");
			return;
		}
		
		Employee employee = Employee.getInstance();
		
		int chosenOption = 0;
		
		do {
			boolean wasCreated = false;

			try {
				String[] namesPets = clinic.getNamesPets();
				
				int index = JOptionPane.showOptionDialog(null, "Elija una mascota para la adopcion", null, 0, 0, null, namesPets, namesPets);
				
				Pet pet = clinic.getPets().get(index);
				
				Customer customer = Customer.create();
				
				Adoption adoption = new Adoption(LocalDate.now(), employee, customer, pet);
				
				clinic.removePet(pet);
				
				clinic.addAdoption(adoption);
				
				wasCreated = true;
				
				String ticket = adoption.getTicket();
			
				ticket += "---------------------------------------------------------------------------------------\n";
				
				ticket += adoption.pet.getRecommendations();
				
				JOptionPane.showMessageDialog(null, ticket);
			} 
			catch (UserException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el sistema");
			}
			finally {
				if (wasCreated) {					
					break;
				}
				chosenOption = JOptionPane.showConfirmDialog(
					null, 
					"¿Desea cancelar la adopcion?", 
					"Confirmación", 
					JOptionPane.YES_NO_OPTION
				);
			}
		} while (chosenOption == JOptionPane.NO_OPTION);
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String getTicket() {
	    String ticket = "----- TICKET DE ADOPCIÓN -----\n";
	    
	    ticket += this.toString();
	    
	    return ticket;
	}
	
	public String getResume () {
		return "Fecha: " + this.date + "\n" +
			"Adoptante: " + this.customer.getName() + "\n" +
			"Mascota: " + this.pet.getName() + " - " + this.pet.getAnimal() + "\n" +
			"Empleado: " + this.employee.getName();
	}
	
	@Override
	public String toString() {
		return "Fecha: " + this.date + "\n\n" +
	    "Datos del Adoptante: \n" +
	    "Nombre: " + (this.customer != null ? this.customer.getName() : "Desconocido") + "\n" +
	    "Edad: " + (this.customer != null ? this.customer.getAge() : "Desconocido") + "\n" +
	    "Dirección: " + (this.customer != null ? this.customer.getAddress() : "Desconocido") + "\n\n" +
	    
	    "Datos de la mascota: \n" +
	    "Mascota: " + (this.pet != null ? this.pet.getAnimal() : "Desconocida") + "\n" +
	    "Nombre: " + (this.pet != null ? this.pet.getName() : "Desconocida") + "\n" +
	    "Peso: " + (this.pet != null ? this.pet.getWeight() : "Desconocida") + "\n" +
	    "Especie: " + (this.pet != null ? this.pet.getSpecie() : "Desconocida") + "\n" +
	    "Fecha de nacimiento: " + (this.pet != null ? this.pet.getBirthDate() : "Desconocida") + "\n\n" +

	    "Datos del empleado: \n" +
	    "Nombre: " + (this.employee != null ? this.employee.getName() : "Desconocido") + "\n" +
	    "Edad: " + (this.employee != null ? this.employee.getAge() : "Desconocido") + "\n" +
		"Cargo: " + (this.employee != null ? this.employee.getPosition() : "Desconocido") + "\n\n";
	}
}
