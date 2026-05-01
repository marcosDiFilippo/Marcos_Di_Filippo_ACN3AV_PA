package UserLogic;

import java.time.LocalDate;

public class Fowl extends Pet {

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
	    return "Recomendaciones para el cuidado de aves:\n" +
	           "- Alimentación: Base de semillas o pienso de calidad, complementado con frutas y verduras frescas.\n" +
	           "- Entorno: Jaula espaciosa que permita estirar las alas y, de ser posible, realizar vuelos cortos.\n" +
	           "- Ubicación: Colocar la jaula en un lugar libre de corrientes de aire y humos de cocina (altamente tóxicos).\n" +
	           "- Higiene: Limpieza diaria de la bandeja y cambio de agua para evitar infecciones fúngicas.\n" +
	           "- Salud: Observar el estado del plumaje y la vitalidad; las aves suelen ocultar signos de enfermedad.\n" +
	           "- Baño: Proporcionar una bañera pequeña o atomizaciones con agua para mantener la calidad de las plumas.\n" +
	           "- Socialización: Necesitan interacción diaria y juguetes para picotear, evitando el aburrimiento y el picaje.";
	}
}
