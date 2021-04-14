package restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    private double caffeine;
    final static double COFFEE_MILLILITERS = 50;
    final static BigDecimal COFFEE_PRICE = new BigDecimal(3.50);


    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
