package rushic24;

public class App {
	public static void main(String args[]) {
		GeneticAlgorithm geneticAlgorithm=new GeneticAlgorithm();
		
		Population population = new Population(100);
		population.initialize();
		
		int generationCounter = 0;
		
		while(population.getFittestIndividual().getFitness()!=Constants.MAX_FITNESS) {
			++generationCounter;
			System.out.println("Generation "+generationCounter +" fittest is "+population.getFittestIndividual().getFitness());
			System.out.println(population.getFittestIndividual());
			population=geneticAlgorithm.evolvePopulation(population);
		}
		
		System.out.println("Solution found ");
		System.out.println(population.getFittestIndividual());
	}
}
