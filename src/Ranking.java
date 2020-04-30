import java.util.ArrayList;
import java.util.Arrays;

public class Ranking {

    public static ArrayList<int[]> ranking(ArrayList<int[]> pop){

        ArrayList<int[]> population = noReference(pop);
        ArrayList<int[]> rankedPop = new ArrayList<>();
        return(rankedPop);
    }

    public static ArrayList<int[]> noReference(ArrayList<int[]> pop){

        ArrayList<int[]> newPOP = new ArrayList<>();
        for(int i = 0; i < pop.size(); i++){
            newPOP.add(Arrays.copyOf(pop.get(i), pop.get(i).length));
        }
        return(newPOP);
    }

}
