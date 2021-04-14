package ExamRetake01;

import java.util.Scanner;

public class Main {
    static int startingRow = 0;
    static int startingCol = 0;
    static int moneyCollected = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrixShop = new char[n][n];
        for (int i = 0; i < n; i++) {
            String lineOfChars = scanner.nextLine();
            matrixShop[i] = lineOfChars.toCharArray();
            if (lineOfChars.contains("S")) {
                startingRow = i;
                startingCol = lineOfChars.indexOf("S");
            }
        }

        boolean inShopTest = true;
        while (moneyCollected < 50 && inShopTest) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    inShopTest = sellerMovment(startingRow - 1, startingCol, matrixShop);
                    break;
                case "down":
                    inShopTest = sellerMovment(startingRow + 1, startingCol, matrixShop);
                    break;
                case "left":
                    inShopTest = sellerMovment(startingRow, startingCol - 1, matrixShop);
                    break;
                case "right":
                    inShopTest = sellerMovment(startingRow, startingCol + 1, matrixShop);
                    break;
            }
        }


        if (inShopTest == false) {
            System.out.println("Bad news! You are out of the pastry shop.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: "  + moneyCollected);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrixShop[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean sellerMovment(int newR, int newC, char[][] matrixShop) {
        matrixShop[startingRow][startingCol] = '-';
        if (inTheShop(newR, newC, matrixShop)) {
            return false;
        }
        char isClient = matrixShop[newR][newC];
        if (Character.isDigit(isClient)) {
            moneyCollected += isClient - '0';
        } else if (isClient == 'P') {
            matrixShop[newR][newC] = '-';
            for (int row = 0; row < matrixShop.length; row++) {
                for (int col = 0; col < matrixShop.length; col++) {
                    if (matrixShop[row][col] == 'P') {
                        newR = row;
                        newC = col;
                        break;
                    }
                }
            }
        }
        matrixShop[newR][newC] = 'S';
        startingRow = newR;
        startingCol = newC;
        return true;
    }


    private static boolean inTheShop(int row, int col, char[][] matrixShop) {
        return  row < 0 || row >= matrixShop.length || col < 0 || col >= matrixShop[row].length;
    }
}
