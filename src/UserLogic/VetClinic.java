package UserLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class VetClinic {
	private static VetClinic vetClinic;
	private String nameClinic;
	
	private Map<String, User> users;
	private Map<String, Customer> customers;
	private ArrayList <Adoption> adoptions;
	private Set <String> species; 
	private ArrayList <Pet> pets;
	
	private VetClinic (String nameClinic) {
		this.nameClinic = nameClinic;
		this.users = new HashMap<>();
		this.customers = new HashMap<>();
		this.species = new HashSet<String>(Arrays.asList("Mamifero", "Ave", "Pez")); 
		this.pets = new ArrayList<Pet>();
		this.adoptions = new ArrayList<Adoption>();
	}
	
	public static VetClinic getInstance () {
		if (vetClinic == null) {
			vetClinic = new VetClinic("Veterinaria Di Filippo");
		}
		return vetClinic;
	}
	
	public String showAdoptions () {
		if (!hasAdoptions()) {
			return "No se ha realizado ninguna adopción";
		}
		
		String message = "--- ADOPCIONES ---\n\n";
		
		for (Adoption adoption : adoptions) {
			message += adoption.getTicket();
		}
		
		return message;
	}
	
	public void addAdoption (Adoption adoption) {
		this.adoptions.add(adoption);
	}
	
	public boolean hasSpecie (String specie) {
		return species.contains(specie);
	}
	
	public String[] getNamesPets () {
		if (!hasPets()) {
			
		}
		
		String[] names = new String[pets.size()];
		
		for (int i = 0; i < pets.size(); i++) {
			names[i] = pets.get(i).getName();
		}
		
		return names;
	}
	
	public void showPets () {
		if (!hasPets()) {
			JOptionPane.showMessageDialog(null, "No hay mascotas cargadas en el sistema!");
			return;
		}
		
		String message = "--- MASCOTAS SIN DUEÑO ---\n\n";
		
		for (Pet pet : pets) {
			message += pet + "\n";
		}
		
		JOptionPane.showMessageDialog(null, message);
	}
	
	public boolean hasPets() {
		return pets.size() > 0;
	}
	
	public boolean hasAdoptions () {
		return adoptions.size() > 0;
	}
	
	public boolean existsUserWithDni (String dni) {
		return this.users.containsKey(dni);
	}
	
	public void addCustomer (Customer customer) {
		this.customers.put(customer.dni, customer);
	}
	
	public void removePet (Pet pet) {
		this.pets.remove(pet);
	}

	public static VetClinic getVetClinic() {
		return vetClinic;
	}

	public static void setVetClinic(VetClinic vetClinic) {
		VetClinic.vetClinic = vetClinic;
	}

	public String getNameClinic() {
		return nameClinic;
	}

	public void setNameClinic(String nameClinic) {
		this.nameClinic = nameClinic;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public Map<String, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Map<String, Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Adoption> getAdoptions() {
		return adoptions;
	}

	public void setAdoptions(ArrayList<Adoption> adoptions) {
		this.adoptions = adoptions;
	}

	public Set<String> getSpecies() {
		return species;
	}

	public void setSpecies(Set<String> species) {
		this.species = species;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
}
