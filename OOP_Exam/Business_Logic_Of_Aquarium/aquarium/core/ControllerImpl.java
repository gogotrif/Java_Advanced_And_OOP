package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                this.aquariums.add(aquarium);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                this.aquariums.add(aquarium);
                break;
            default:
                throw new NullPointerException("Invalid aquarium type.");
        }
        return String.format("Successfully added %s.", aquariumType);
    }

    @Override
    public String addDecoration(String type) {

        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException("Invalid decoration type.");
        }
        this.decorations.add(decoration);
        return String.format("Successfully added %s.", type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        Aquarium curentAquarium = null;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                curentAquarium = aquarium;
            }
    }

        if (decoration == null) {
            throw new IllegalArgumentException(String.format("There isn't a decoration of type %s.", decorationType));
        }

        assert curentAquarium != null;
        curentAquarium.addDecoration(decoration);

        this.decorations.remove(decoration);
        return String.format("Successfully added %s to %s.", decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        Aquarium curentAquarium = null;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                curentAquarium = aquarium;
            }
        }

        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException("Invalid fish type.");
        }

        if(fish.getSize()>25){
            return "Not enough capacity.";
        }

        if (curentAquarium.getClass().getSimpleName().equals("FreshwaterAquarium") && fishType.equals("FreshwaterFish")) {
            curentAquarium.addFish(fish);
        } else if (curentAquarium.getClass().getSimpleName().equals("SaltwaterAquarium") && fishType.equals("SaltwaterFish")) {
            curentAquarium.addFish(fish);
        } else {
            return "Water not suitable.";
        }
        return String.format("Successfully added %s to %s.", fishType, aquariumName);

    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium curentAquarium = null;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                curentAquarium = aquarium;
            }
        }

        assert curentAquarium != null;
        int count = curentAquarium.getFish().size();
        curentAquarium.feed();
        return String.format("Fish fed: %d", count);}

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium curentAquarium = null;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                curentAquarium = aquarium;
            }
        }

        assert curentAquarium != null;
        double price = 0;
        for (Decoration decoration : curentAquarium.getDecorations()) {
            price += decoration.getPrice();
        }
        for (Fish fish : curentAquarium.getFish()) {
            price += fish.getPrice();
        }
        return String.format("The value of Aquarium %s is %2f.", aquariumName, price);
    }


    @Override
    public String report() { StringBuilder stringBuilder = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            stringBuilder.append(System.lineSeparator()).append(aquarium.getInfo());
        }
        return stringBuilder.toString().trim();
    }
}
