package salesman;

/**
 * Created by Siddharth on 17-06-415.
 */
public class individual {
    private static int noOfCities = 500;
    public static int route_length = noOfCities;
    public int[] city = new int[noOfCities];
    public int fitness = 0;

    public static void setDefaultGeneLength(int length) {
        route_length = length;
    }

    //generate individual
    public void generateindividual() {
        for (int i = 0; i < noOfCities; i++)
            city[i] = i;
        //randomize its genes
        for (int i = 0; i < 50; i++) {
            if (Math.round(Math.random() * 10.0) > 5) {
                int t3 = this.city[i];
                this.city[i] = city[i + 1];
                this.city[i + 1] = t3;
            }
        }
    }

    public int getGene(int index) {
        return city[index];
    }

    public void setGene(int index, char value) {
        city[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return city.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = fitnessCalc.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}
