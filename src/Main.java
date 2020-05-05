//Espaço para importar classes
import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] upper = {10,46,23,67,12,34,3,3,3}; int[] lower = {0,0,0,0,0,0,1,1,1};
        double mutProb = 0.6; int popSize = 6;
        ArrayList<int[]> pop = GA.GA_Part_1(upper, lower, mutProb, popSize);
        //printPOP(pop);
        //List<Integer> upper2 = Collections.sort(Arrays.asList(upper));
        System.out.println("Upper = " + Arrays.toString(upper));

    }

    public static void printPOP(ArrayList<int[]> pop){
        for(int i = 0; i < pop.size(); i++){
            System.out.println("Individuo " + (i+1) + " = " + Arrays.toString(pop.get(i)));
        }
    }
}
