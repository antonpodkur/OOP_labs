public class Roshen extends Candy {
    private boolean nuts;
    private String name = "Roshen";
    Roshen(float w, int amc, boolean nuts){
        super(w,amc);
        this.nuts = nuts;
    }

    String getName(){
        return name;
    }
}
