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
	    return "Recomendaciones para el cuidado de peces:\n" +
	           "- Calidad del agua: Monitorear niveles de amoníaco, nitritos y pH de forma regular.\n" +
	           "- Filtración: Mantener un sistema de filtrado adecuado al volumen del acuario y número de peces.\n" +
	           "- Alimentación: Dar pequeñas cantidades que puedan consumir en 2 o 3 minutos para evitar residuos.\n" +
	           "- Temperatura: Usar un calentador con termostato si son especies tropicales para evitar cambios bruscos.\n" +
	           "- Mantenimiento: Realizar cambios parciales de agua (20-30%) semanalmente, nunca el 100%.\n" +
	           "- Acondicionamiento: Utilizar siempre un anticloro al añadir agua nueva para proteger sus branquias.\n" +
	           "- Compatibilidad: Asegurarse de que las especies convivientes tengan temperamentos y requisitos similares.";
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
