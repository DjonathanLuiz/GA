import java.util.ArrayList;
import java.util.Random;

public class GA {

    public static ArrayList<int[]> GA_Part_1(int[] upperLimit, int[] lowerLimit, double mutProb, int popSize){
        ArrayList<int[]> population = createPopulation(popSize, upperLimit);
        ArrayList<int[]> sons = crossover(population);
        //ArrayList<int[]> mutatedSons = mutation(sons, mutProb, lowerLimit, upperLimit);
        //population.addAll(mutatedSons);
        return(population);
    }

    public static ArrayList<int[]> createPopulation(int sizePop, int[] upperLimit){

        Random random = new Random(); //Necessary to create random values

        ArrayList<int[]> population = new ArrayList<>(); // The Array that will be returned
        for(int j = 0; j < sizePop; j++){
            int[] individual = new int[upperLimit.length]; //Create the individuals
            for(int i = 0; i < upperLimit.length; i++){
                individual[i] = random.nextInt(upperLimit[i])+1; //Set a random value to each position restricted by the upper limit
            }
            population.add(individual); // Add the individual to the population
        }
        return population; // Return the population
    }

    public static ArrayList<int[]> crossover(ArrayList<int[]> pop) {

        Random random = new Random(); //To reach random numbers
        ArrayList<int[]> newPop= new ArrayList<>(); //population with only mutated chromosomes

        for(int i = 0; i < (pop.size()/2); i++){
            int randInd1; int randInd2;
            int[] newind1 = new int[pop.get(1).length]; int[] newind2 = new int[pop.get(1).length];
            int crossPoint;

            do{
                randInd1 = random.nextInt(pop.size()); // Select the first individual
                randInd2 = random.nextInt(pop.size()); // Select the second individual
            }while(randInd1 == randInd2);

            int[] ind1 = pop.get(randInd1); int[] ind2 = pop.get(randInd2);

            crossPoint = random.nextInt(ind1.length - 2);
            if (crossPoint <= 1){crossPoint = crossPoint + 2;}

            for(int j = 0; j < ind1.length; j++){
                if(j < crossPoint){
                    newind1[j] = ind1[j];
                    newind2[j] = ind2[j];
                }
                if (j >= crossPoint){
                    newind1[j] = ind2[j];
                    newind2[j] = ind1[j];
                }
            }
            newPop.add(newind1);
            newPop.add(newind2);
        }

        return(newPop);

    }



    public static ArrayList<int[]> breakIt(ArrayList<int[]> pop){
        ArrayList<int[]> pop2 = new ArrayList<>();
        for(int i = 0; i < pop.size(); i++){
            int[] individuo = new int[pop.get(1).length];
            for(int j = 0; j < pop.get(1).length; j++){
                individuo[j] = pop.get(i)[j];
            }
            pop2.add(individuo);
        }
        return (pop2);
    }
}
