public class Main {

    public static void main(String[] args){

        //Limites
        int[] upper = {55,45,75}, lower = {1,1,1};
        // Probabilidades
        double crossoverRate = 0.5, mutProb = 0.6;
        // Tamanho
        int sizePop = 3;

        Population population = GA.createPopulation(sizePop,upper);
        Population.printPopulationAll(population);
        int iteration = 0;
        do{
            iteration++;
            population = GA.partI(population, upper, crossoverRate, mutProb, lower);
            population = simulation(population);
            population = GA.partII(population, sizePop);
        }while (iteration < 100);

        Population.printPopulationAll(population);

    }

    public static Population simulation(Population pop){
        Population population = new Population();
        for(int i = 0; i < pop.getPopulation().size(); i++){
            double custo = 0;
            double[] custos = {5, 10, 21};
            for(int j = 0; j < pop.getPopulation().get(i).getCromossomo().length; j++){
                custo += custos[j]*pop.getPopulation().get(i).getCromossomo()[j];
            }
            population.setIndividual(population, pop.getPopulation().get(i).getCromossomo(), custo);
            custo = 0;
        }
        return (population);
    }


}
