public class Individual implements Comparable<Individual>{
    private int[] cromossomo;
    private double cost;

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

    @Override
    public int compareTo(Individual individual) {

        double compareQuantity = ((Individual) individual).getCost();

        //ascending order
        return this.cost - compareQuantity;

        //descending order
        //return compareQuantity - this.quantity;

    }
}
