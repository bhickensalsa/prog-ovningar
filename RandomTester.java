import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class RandomTester {
    public static ArrayList<Integer> generateNumbers(int n) {
        Random random = new Random();
        ArrayList<Integer> randomArrayList = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            randomArrayList.add(random.nextInt());
        }
        return randomArrayList;
    }

    public static ArrayList<Integer> shuffle(ArrayList<Integer> list) {
        ArrayList<Integer> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        return copy;
    }

    // public static ArrayList<Dice> remove(ArrayList<Dice> sequence, int n) {
        
    // }

    public static void main(String[] args) {
        // When declaring a constant, it is a convention to put the name in capital letters
        final int AMOUNT_OF_NUMBERS = 5;

        // Generate a list with random numbers
        ArrayList<Integer> randomNumbers = generateNumbers(AMOUNT_OF_NUMBERS);
        ArrayList<Integer> shuffledNumbers = shuffle(randomNumbers);

        // Print the numbers
        // Every time you run this example, it should produce new numbers
	    System.out.println("The following " + AMOUNT_OF_NUMBERS + " numbers were generated:");
        for (Integer number : randomNumbers) {
            System.out.println(number);
        }
        System.out.println();
        for (Integer number : shuffledNumbers) {
            System.out.println(number);
        }
    }
}