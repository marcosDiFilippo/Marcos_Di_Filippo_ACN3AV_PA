package UserLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import Exceptions.AdoptionException;
import Exceptions.PetException;

public class VetClinic {
	private static VetClinic vetClinic;
	private String nameClinic;
	
	private ArrayList <Adoption> adoptions;
	private Set <String> species; 
	private ArrayList <Pet> pets;
	
	private VetClinic (String nameClinic) {
		this.nameClinic = nameClinic;
		this.species = new HashSet<String>(Arrays.asList("Mamifero", "Ave", "Pez")); 
		this.pets = new ArrayList<Pet>();
		this.adoptions = new ArrayList<Adoption>();
	}
	
	public static VetClinic getInstance () {
		if (vetClinic == null) {
			vetClinic = new VetClinic("Veterinaria");
		}
		return vetClinic;
	}
	
	public void showAdoptions () {
		try {
			if (!hasAdoptions()) {
				throw new AdoptionException("No se ha realizado ninguna adopción");
			}
			
			String message = "--- ADOPCIONES ---\n\n";
			
			for (Adoption adoption : adoptions) {
				message += adoption.getResume() + "\n";
				message += "-----------------------------------------------";
			}
			
			JOptionPane.showMessageDialog(null, message);
		} 
		catch (AdoptionException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al obtener las adopciones");
		}
	}
	
	public void addAdoption (Adoption adoption) {
		this.adoptions.add(adoption);
	}
	
	public boolean hasSpecie (String specie) {
		return species.contains(specie);
	}
	
	public String[] getNamesPets () {
		String[] names = new String[pets.size()];
		
		for (int i = 0; i < pets.size(); i++) {
			names[i] = pets.get(i).getName();
		}
		
		return names;
	}
	
	public void showPets () {
		try {
			if (!hasPets()) {
				throw new PetException("No hay mascotas cargadas en el sistema!");
			}
			
			String message = "--- MASCOTAS SIN DUEÑO ---\n\n";
			
			for (Pet pet : pets) {
				message += pet + "\n";
			}
			
			JOptionPane.showMessageDialog(null, message);
		} 
		catch (PetException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error al obtener las mascotas");
		}
	}
	
	public boolean hasPets() {
		return pets.size() > 0;
	}
	
	public boolean hasAdoptions () {
		return adoptions.size() > 0;
	}
	
	public void removePet (Pet pet) {
		this.pets.remove(pet);
	}

	public String getNameClinic() {
		return nameClinic;
	}

	public void setNameClinic(String nameClinic) {
		this.nameClinic = nameClinic;
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
