package UserLogic;

import java.time.LocalDate;

public class Mammal extends Pet {

	public Mammal() {
		// TODO Auto-generated constructor stub
	}
	
	public Mammal(String animal, String name, LocalDate birthDate, double weight) {
		super(animal, name, birthDate, weight);
	}

	@Override
	public String getSpecie() {
		// TODO Auto-generated method stub
		return "Mamifero";
	}
	
	@Override
	public String getRecommendations() {
	    return "Cuidado de mamíferos:\n" +
	           "- Nutrición: Dieta equilibrada y agua fresca siempre disponible.\n" +
	           "- Salud: Vacunación, desparasitación y controles periódicos.\n" +
	           "- Higiene: Baños y cepillado según el tipo de pelaje.\n" +
	           "- Actividad: Ejercicio diario y estimulación mental.\n" +
	           "- Entorno: Espacio seguro, limpio y clima controlado.\n" +
	           "- Bienestar: Tiempo de calidad y afecto constante.";
	}
	
	@Override
	public String[] getAnimals() {
		String [] animals = {
			    "Perro",
			    "Gato",
			    "Conejo",
			    "Cobayo",
			    "Hámster",
			    "Hurón",
			    "Chinchilla",
			    "Carpincho",
			    "Guanaco",
			    "Erizo"
			};
		
		return animals;
	}
}
