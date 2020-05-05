import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Population {

    private ArrayList<Individual> population;

    public Population(){
        ArrayList<Individual> pop = new ArrayList<>();
        this.population = pop;
    }

    public void setPopulation(ArrayList<Individual> population) {
        this.population = population;
    }

    public void setIndividual(Population pop, int[] cromossomo, double custo){
        pop.getPopulation().add(new Individual(cromossomo, custo));
    }

    public void setIndividual(Population pop, int[] cromossomo){
        pop.getPopulation().add(new Individual(cromossomo, 0));
    }

    public ArrayList<Individual> getPopulation() {
        return population;
    }

    public static void printPopulation(Population pop){
        ArrayList<Individual> population = pop.getPopulation();
        for(int i = 0; i < population.size(); i++){
            System.out.println("Individuo " + (i+1) + ": Cromossomo = " + Arrays.toString(population.get(i).getCromossomo()) +
                    "     Custo = " + population.get(i).getCost());
        }
        System.out.println("");

    }

    public static void ranking(Population population){
        ArrayList<Individual> pop = population.getPopulation();
        Collections.sort(pop);
    }
}