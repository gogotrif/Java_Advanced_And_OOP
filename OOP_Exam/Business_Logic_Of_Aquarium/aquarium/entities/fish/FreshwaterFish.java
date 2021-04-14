package aquarium.entities.fish;

public class FreshwaterFish extends BaseFish{
    private static int SIZE=3;
    private static int SIZE_INC=3;
       public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(SIZE);
    }

    @Override
    public void eat() {
        this.setSize(this.getSize() +SIZE_INC);

    }
}
