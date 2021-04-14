package OOP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String card = scanner.nextLine();
        String suit = scanner.nextLine();
        Card newcard = new Card(Enums.valueOf(card), SuitPowers.valueOf(suit));

        System.out.println(newcard.toString());
    }
}
