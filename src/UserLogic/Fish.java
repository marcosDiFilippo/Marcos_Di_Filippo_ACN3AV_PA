package UserLogic;

import java.time.LocalDate;

public class Fish extends Pet {

	public Fish() {
		// TODO Auto-generated constructor stub
	}
	
	public Fish(String animal, String name, LocalDate birthDate, double weight) {
		super(animal, name, birthDate, weight);
	}

	@Override
	public String getSpecie() {
		// TODO Auto-generated method stub
		return "Pez";
	}
	
	@Override
	public String getRecommendations() {
	    return "Cuidado de peces:\n" +
	           "- Agua: Monitorear pH/químicos y usar siempre anticloro.\n" +
	           "- Filtrado: Mantener sistema acorde al volumen y población.\n" +
	           "- Alimentación: Porciones pequeñas consumibles en 2 minutos.\n" +
	           "- Temperatura: Estable, usando termostato si son tropicales.\n" +
	           "- Limpieza: Cambios parciales (20-30%) semanales, nunca totales.\n" +
	           "- Convivencia: Solo especies con requisitos y carácter similares.";
	}
	
	@Override
	public String[] getAnimals() {
		String [] animals = {
			    "Pejerrey",
			    "Dorado",
			    "Surubí",
			    "Boga",
			    "Tararira",
			    "Pacú",
			    "Madrecita",
			    "Corvina",
			    "Vieja del agua",
			    "Mojarra"
			};
		
		return animals;
	}
}
