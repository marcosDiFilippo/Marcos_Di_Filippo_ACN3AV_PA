package UserLogic;

import java.time.LocalDate;

public class Mammal extends Pet {

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
	    return "Recomendaciones para el cuidado de mamíferos:\n" +
	           "- Alimentación: Proporcionar una dieta equilibrada específica para su especie y edad.\n" +
	           "- Hidratación: Mantener siempre agua fresca y limpia a su disposición.\n" +
	           "- Salud: Cumplir con el calendario de vacunación y desparasitación periódica.\n" +
	           "- Higiene: Realizar baños y cepillados constantes según el tipo de pelaje.\n" +
	           "- Ejercicio: Asegurar actividad física diaria para evitar el estrés y la obesidad.\n" +
	           "- Entorno: Proveer un espacio seguro, limpio y protegido de temperaturas extremas.\n" +
	           "- Afecto: Brindar tiempo de calidad y estimulación mental para su bienestar emocional.";
	}
	
	
}
