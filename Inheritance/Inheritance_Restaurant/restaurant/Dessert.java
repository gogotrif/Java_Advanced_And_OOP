package restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {
    public double calories;
    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(price, name, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
