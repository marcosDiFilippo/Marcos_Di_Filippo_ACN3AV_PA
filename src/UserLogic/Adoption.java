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
			
				ticket += "-----------------------------------------------------------------------------------------------------------------------\n";
				
				ticket += adoption.getPet().getRecommendations();
				
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
	
	@Override
	public String getTicket() {
	    String ticket = "----- TICKET DE ADOPCIÓN -----\n";
	    
	    ticket += "Fecha: " + this.date + "\n";
	    
	    ticket += "Empleado: " + (this.employee != null ? this.employee.getName() : "Desconocido") + "\n";
	    
	    ticket += "Cliente: " + (this.customer != null ? this.customer.getName() : "Desconocido") + "\n";
	    
	    ticket += "Mascota Adoptada: " + (this.pet != null ? this.pet.getName() : "Desconocida") + "\n";
	    
	    return ticket;
	}
	
	public Pet getPet() {
		return pet;
	}
}
