package rushic24;

public class Population {
	private Individual[] individuals;
	 
	public Population(int populationSize) {
		individuals=new Individual[populationSize];
	}
	
	public void initialize() {
		for(int i=0;i<individuals.length;i++) {
			Individual newIndividual = new Individual();
			newIndividual.generateIndividual();
			saveIndividual(i,newIndividual);
		}
	}
	
	public Individual getIndividual(int index) {
		return this.individuals[index];
	}
	
	public Individual getFittestIndividual() {
		Individual fittest=individuals[0];
		for(int i=1;i<individuals.length;i++) {
			if(getIndividual(i).getFitness() >= fittest.getFitness()) {
				fittest=getIndividual(i);
			}
		}
		return fittest;
	}
	
	public int size() {
		return this.individuals.length;
	}
	
	public void saveIndividual(int i, Individual individual) {
		this.individuals[i]	= individual;
	}
}
