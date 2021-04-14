package OOP;

public class Card {
    private Enums rank;
    private SuitPowers suit;
    private int power;

    public Card(Enums rank, SuitPowers suit) {
        this.rank = rank;
        this.suit = suit;
        calcolatePower();
    }
    private void calcolatePower(){
        this.power = rank.getCardScore() + suit.getSuitNumber();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",this.rank,this.suit,this.power);
    }
}
