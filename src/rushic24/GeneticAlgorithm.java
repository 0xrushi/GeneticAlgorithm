package rushic24;

import java.util.Random;

public class GeneticAlgorithm {
	
	public Random randomGenerator;
	
	public GeneticAlgorithm() {
		this.randomGenerator=new Random();
	}
	
	public Population evolvePopulation(Population population) {
		Population newPopulation =new Population(population.size());
		
		for(int i=0;i<population.size();i++) {
			Individual firstindividual=randomSelection(population);
			Individual secondindividual=randomSelection(population);
			Individual newIndividual=crossover(firstindividual,secondindividual);
			newPopulation.saveIndividual(i, newIndividual);
		}
		
		for(int i=0;i<newPopulation.size();i++) {
			mutate(newPopulation.getIndividual(i));
		}
		
		return newPopulation;
	}

	private void mutate(Individual individual) {
		for(int i=0;i<Constants.CHROMOSOME_LENGTH;i++) {
			if(Math.random()<= Constants.MUTATION_RATE) {
				int gene = randomGenerator.nextInt(10);
				individual.setGene(i, gene);
			}
		}
	}

	private Individual crossover(Individual firstindividual, Individual secondindividual) {
		
		Individual newSolution= new Individual();
		for(int i=0;i<Constants.CHROMOSOME_LENGTH;i++) {
			if(Math.random()<= Constants.CROSSOVER_RATE) {
				newSolution.setGene(i, firstindividual.getGene(i));
			}
			else {
				newSolution.setGene(i, secondindividual.getGene(i));
			}
		}
		
		return newSolution;
	}

	private Individual randomSelection(Population population) {
		Population newPopulation= new Population(Constants.TOURNAMENT_SIZE);
		
		for(int i=0;i<Constants.TOURNAMENT_SIZE;i++) {
			int randomIndex= (int) (Math.random() * population.size());
			newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
		}
		Individual fittestIndividual=newPopulation.getFittestIndividual();
		return fittestIndividual;
	}

}
