public class Candy {
    private float weight;
    private int amount_of_choc;
    private String name = "candy";
    Candy(float weight, int amount_of_choc){
        this.weight = weight;
        this.amount_of_choc = amount_of_choc;
    }
    float getWeight(){
        return weight;
    }

    int getAmount_of_choc(){
        return amount_of_choc;
    }

    String getName(){
        return name;
    }
}
