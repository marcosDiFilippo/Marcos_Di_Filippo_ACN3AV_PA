package UserLogic;

import java.time.LocalDate;

public class Fowl extends Pet {

	public Fowl() {
		// TODO Auto-generated constructor stub
	}
	
	public Fowl(String animal, String name, LocalDate birthDate, double weight) {
		super(animal, name, birthDate, weight);
	}

	@Override
	public String getSpecie() {
		// TODO Auto-generated method stub
		return "Ave";
	}
	
	@Override
	public String getRecommendations() {
	    return "Cuidado de aves:\n" +
	           "- Dieta: Semillas, pienso, frutas y verduras frescas.\n" +
	           "- Hábitat: Espacio amplio, sin corrientes de aire ni humos.\n" +
	           "- Higiene: Limpieza diaria de base y recambio de agua.\n" +
	           "- Salud: Controlar plumaje, vitalidad y proveer baños.\n" +
	           "- Bienestar: Interacción diaria y juguetes para evitar estrés.";
	}
	
	@Override
	public String[] getAnimals() {
		String[] animals = {
			    "Cotorra argentina",
			    "Hornero",
			    "Calandria",
			    "Cardenal",
			    "Zorzal",
			    "Benteveo",
			    "Loro hablador",
			    "Canario",
			    "Cacatúa ninfa",
			    "Agapornis"
			};
		
		return animals;
	}
}
