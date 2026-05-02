package UserLogic;

import java.time.LocalDate;

public abstract class Pet {
	protected String animal;
	protected String name;
	protected LocalDate birthDate;
	protected double weight;
	
	public Pet() {
		// TODO Auto-generated constructor stub
	}
	
    public Pet(String animal, String name, LocalDate birthDate, double weight) {
        this.animal = animal;
    	this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAnimal() {
		return animal;
	}
    
    public void setAnimal(String animal) {
		this.animal = animal;
	}
    
    public abstract String getSpecie();
    
    public abstract String getRecommendations();
    
    public static Pet createPetBySpecie (String specie, String animal, String name, LocalDate birthDate, double weight) {
    	Pet pet = null;
    	
    	switch (specie.toLowerCase()) {
		case "mamifero":
			pet = new Mammal(animal, name, birthDate, weight);
			break;
		case "ave":
			pet = new Fowl(animal, name, birthDate, weight);
			break;
			
		case "pez":
			pet = new Fish(animal, name, birthDate, weight);
			break;
		default:
			
			break;			
    	}
    	
    	return pet;
    }
    
    public static String[] getAnimalsBySpecie (String specie) {
    	Pet pet = null;
    	
    	switch (specie.toLowerCase()) {
		case "mamifero":
			pet = new Mammal();
			break;
		case "ave":
			pet = new Fowl();
			break;
			
		case "pez":
			pet = new Fish();
			break;
		default:
			
			break;			
    	}
    	
    	return pet.getAnimals();
    }
    
    public static String[] species () {
    	String [] species = {"Mamifero", "Ave", "Pez"};
 
    	return species;
    }
    
    public static boolean isValidName (String name) {
    	if (name.isEmpty()) {
			return false;
		}
    	
    	return true;
    }
    
    public static boolean isValidWeight (String weight) {
    	if (weight.isEmpty()) {
			return false;
		}
		
		for (int i = 0; i < weight.length(); i++) {
			Character character = weight.charAt(i);
			
			if (character.equals('.')) {
				continue;
			}
			if (character.equals(',')) {
				return false;
			}
			if (!Character.isDigit(character)) {
				return false;
			}
		}
		
		return true;
    }

	@Override
	public String toString() {
		return "Nombre: " + name + 
				"\nAnimal: " + animal +
				"\nFecha de nacimiento: " + birthDate + 
				"\nPeso: " + weight + "\n------------------------------------------------------------";
	}
	
	public abstract String[] getAnimals ();
}
