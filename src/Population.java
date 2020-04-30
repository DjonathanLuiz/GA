import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Population {

    private ArrayList<Individual> population;

    public void setPopulation(ArrayList<Individual> population) {
        this.population = population;
    }

    public ArrayList<Individual> getPopulation() {
        return population;
    }

    public static void printPopulationCromo(Population pop){
        ArrayList<Individual> population = pop.getPopulation();
        for(int i = 0; i < population.size(); i++){
            System.out.println("Individuo " + (i+1) + " = " + Arrays.toString(population.get(i).getCromossomo()));
        }
        System.out.println("");
    }

    public static void printPopulationAll(Population pop){
        ArrayList<Individual> population = pop.getPopulation();
        for(int i = 0; i < population.size(); i++){
            System.out.println("Individuo " + (i+1) + ": Cromossomo = " + Arrays.toString(population.get(i).getCromossomo()) +
                     "     Custo = " + population.get(i).getCost());
        }
        System.out.println("");

    }
}
