import java.util.Arrays;

public class Individual implements Comparable<Individual>{

    int[] cromossomo;
    double cost;

    public Individual(int[] cromo, double cost){
        this.cromossomo = cromo;
        this.cost = cost;
    }

    public Individual(int[] cromo){
        this.cromossomo = cromo;
        this.cost = 0;
    }

    public Individual(){}

    public double getCost() {
        return cost;
    }

    public int[] getCromossomo() {
        return cromossomo;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCromossomo(int[] cromossomo) {
        this.cromossomo = cromossomo;
    }

    public void printIndividuo(){
        System.out.println("Cromossomo = " + Arrays.toString(this.cromossomo));
        System.out.println("Custo = " + this.cost);
    }

    @Override
    public int compareTo(Individual individual) {

        double compareQuantity = 100*((Individual) individual).getCost();
        double thisCost = 100*this.cost;

        //ascending order
        return (int) Math.round(thisCost - compareQuantity);
    }
}
