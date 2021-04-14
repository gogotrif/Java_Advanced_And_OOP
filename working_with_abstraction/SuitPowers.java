package OOP;

public enum SuitPowers {
    CLUBS (0),
    DIAMONDS (13),
    HEARTS(26),
    SPADES (39);
    int suitNumber;

    public int getSuitNumber() {
        return this.suitNumber;
    }

    private SuitPowers (int suitNumber){
        this.suitNumber = suitNumber;

    }
}
