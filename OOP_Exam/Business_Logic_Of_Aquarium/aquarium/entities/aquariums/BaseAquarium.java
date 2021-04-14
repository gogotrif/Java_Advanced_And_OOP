package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.BaseFish;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setName(String name) {
        if(name==null|| name.trim().isEmpty()){
            throw new NullPointerException("Aquarium name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        int sumComfort=0;
        for (Decoration decoration : decorations) {
            sumComfort= decoration.getComfort() + sumComfort;
        }
        return sumComfort;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (fish.getSize()< this.capacity){
            this.fish.add(fish);

        } else{
            throw new IllegalStateException("Not enough capacity.");
        }

    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);

    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);

    }

    @Override
    public void feed() {
        for (Fish fishes : fish) {
                fishes.eat();
        }
    }

    @Override
    public String getInfo() {
        if (fish.isEmpty()){
            return String.format("none%n");
        }
        StringBuilder sb = new StringBuilder();

        sb.append("Fish:");
        for (Fish f : fish) {
            sb.append(" ").append(f.getName());
        }
        sb.append(System.lineSeparator());
        sb.append("Decorations: ").append(this.decorations.size());
        sb.append(System.lineSeparator());
        sb.append("Comfort: ").append(this.calculateComfort());
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
