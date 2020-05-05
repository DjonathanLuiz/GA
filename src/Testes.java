import java.util.*;

public class Testes{

    public static void main(String[] args){

        //Limites
        int[] upper = {55,45,75}, lower = {1,1,1};
        // Probabilidades
        double crossoverRate = 0.5, mutProb = 0.6;
        // Tamanho
        int sizePop = 3;

        Population population = createPopulation(sizePop,upper);
        Population sons = crossover(population, crossoverRate);
        Population mutated = mutation(population, sons, mutProb, lower, upper);

        Population.printPopulationAll(mutated);
    }

    public static Population createPopulation(int sizePop, int[] upperLimit){
        Random random = new Random(); //Necessary to create random values
        Population population = new Population();
        for(int j = 0; j < sizePop; j++){
            int[] cromossomo = new int[upperLimit.length]; //Create the individuals
            for(int i = 0; i < upperLimit.length; i++){cromossomo[i] = random.nextInt(upperLimit[i])+1;}
            population.setIndividual(population, cromossomo);
        }
        return (population);
    }

    public static Population crossover(Population popReal, double crossoverRate) {
        Random random = new Random(); //To reach random numbers
        ArrayList<Individual> pop = popReal.getPopulation();
        Population population = new Population();
        int crossoverTimes = (int) Math.round(pop.size()*crossoverRate);

        for(int i = 0; i < crossoverTimes; i++){
            int randInd1; int randInd2;
            int[] newcromo1 = new int[pop.get(1).getCromossomo().length];
            int[] newcromo2 = new int[pop.get(1).getCromossomo().length];
            int crossPoint;
            Individual son1 = new Individual();
            Individual son2 = new Individual();

            do{
                randInd1 = random.nextInt(pop.size()); // Select the first individual
                randInd2 = random.nextInt(pop.size()); // Select the second individual
            }while(randInd1 == randInd2);

            int[] cromo1 = pop.get(randInd1).getCromossomo();
            int[] cromo2 = pop.get(randInd2).getCromossomo();

            crossPoint = random.nextInt(cromo1.length - 2);
            if (crossPoint <= 1){crossPoint = crossPoint + 2;}

            for(int j = 0; j < cromo1.length; j++){
                if(j < crossPoint){
                    newcromo1[j] = cromo1[j];
                    newcromo2[j] = cromo2[j];
                }
                if (j >= crossPoint){
                    newcromo1[j] = cromo2[j];
                    newcromo2[j] = cromo1[j];
                }
            }
            population.setIndividual(population, newcromo1);
            population.setIndividual(population, newcromo2);
        }
        return(population);

    }

    public static Population mutation(Population parents, Population sons, double mutProb, int[] lowerLimit, int[] upperLimit){

        Random random = new Random();
        ArrayList<Individual> pop = sons.getPopulation();
        ArrayList<Individual> popParents = parents.getPopulation();
        Population mutatedSons = new Population();
        for(int i = 0; i < popParents.size(); i++){
            mutatedSons.setIndividual(mutatedSons, popParents.get(i).getCromossomo(), popParents.get(i).getCost());
        }

        int[] valores = {-3, -2, -1, 1, 2, 3};

        for(int i = 0; i < pop.size(); i++){
            double prob2 = random.nextDouble();
            int[] cromossomo = Arrays.copyOf(pop.get(i).getCromossomo(), pop.get(i).getCromossomo().length);

            if(prob2 <= mutProb){
                int position = random.nextInt(cromossomo.length);
                int alfa = valores[random.nextInt(valores.length)];
                cromossomo[position] =  cromossomo[position] + alfa;
                if(cromossomo[position] > upperLimit[position]){
                    cromossomo[position] = upperLimit[position];
                }
                if(cromossomo[position] <= lowerLimit[position]){
                    cromossomo[position] = lowerLimit[position];
                }
                mutatedSons.setIndividual(mutatedSons, cromossomo);
            } else {
                mutatedSons.setIndividual(mutatedSons, pop.get(i).getCromossomo());
            }
        }
        return(mutatedSons);
    }
}
