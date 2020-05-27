public class Twix extends Candy {
    private int amount_of_parts;
    private String name = "Twix";
    Twix(float w, int amc, int amp){
        super(w,amc);
        amount_of_parts = amp;
    }

    String getName(){
        return name;
    }
    @Override
    public String toString()
    {
        return name;
    }
}
