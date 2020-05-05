public class Main {

    public static void main(String[] args){

        //Limites
        int[] upper = {55,45,75}, lower = {1,1,1};
        // Probabilidades
        double crossoverRate = 0.5, mutProb = 0.6;
        // Tamanho
        int sizePop = 3;

        Population population = GA.partI(sizePop, upper, crossoverRate, mutProb, lower);
        //Simulação
        //GA.partII();
        Population.printPopulationAll(population);
    }


}
