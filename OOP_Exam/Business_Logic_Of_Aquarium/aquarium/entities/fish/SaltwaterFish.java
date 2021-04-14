package aquarium.entities.fish;

public class SaltwaterFish extends BaseFish {
    private static int SIZE=5;
    private static int SIZE_INC=2;
    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.setSize(SIZE);
    }

    @Override
    public void eat() {
      this.setSize(this.getSize()+SIZE_INC);
    }
}
