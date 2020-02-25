public class Lion extends Candy {
    private int amount_of_salt;
    private String name = "Lion";
    Lion(float w, int amc, int ams){
        super(w,amc);
        this.amount_of_salt = ams;
    }

    String getName(){
        return name;
    }

}
