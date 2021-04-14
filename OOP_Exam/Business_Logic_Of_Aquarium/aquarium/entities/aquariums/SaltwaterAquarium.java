package aquarium.entities.aquariums;

public class SaltwaterAquarium extends BaseAquarium {
    private static int CAPACITY = 25;
    public SaltwaterAquarium(String name) {
        super(name, CAPACITY);
    }

    @Override
    public String getInfo() {
        String info = String.format("%s (%s):%n", getName(), getClass().getSimpleName());
        return info + super.getInfo();
    }
}
