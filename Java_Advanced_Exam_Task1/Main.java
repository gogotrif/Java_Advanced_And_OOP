package ExamRetake;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stackTulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(e -> stackTulips.push(e));
        ArrayDeque<Integer> queueDaffodils = Arrays.stream((scanner.nextLine()).split(", ")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int storedFlowers =0;
        int boquetsNeeded = 0;
        while (!stackTulips.isEmpty() && !queueDaffodils.isEmpty()) {
            int sumBoquets = stackTulips.peek() + queueDaffodils.peek();

            if (sumBoquets == 15) {
                boquetsNeeded += 1;
                stackTulips.pop();
                queueDaffodils.poll();
            } else if (sumBoquets > 15) {
                stackTulips.push(stackTulips.pop() - 2);
            } else if (sumBoquets < 15) {
                storedFlowers += stackTulips.pop();
                storedFlowers += queueDaffodils.pop();
            }
        }
        while (storedFlowers>15){
            boquetsNeeded +=1;
            storedFlowers -=15;
        }

        if (boquetsNeeded >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", boquetsNeeded);
        } else {
            boquetsNeeded = 5 - boquetsNeeded;
            System.out.printf("You failed... You need more %d bouquets.", boquetsNeeded);
        }
    }
}
