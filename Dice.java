import java.util.ArrayList;
import java.util.Random;

public class Dice {
    protected int value;
    Random random = new Random();
    
    public int getValue() {
        return value;
    }

    public Dice() {
        this.value = random.nextInt(6)+1;
    }
    
    public static ArrayList<Dice> sequenceOfDice(int n) {
        ArrayList<Dice> dice = new ArrayList<>();
        for (int i = 0; i < n ; ++i) {
            Dice die = new Dice();
            dice.add(die);
        }
        return dice;
    }

    public static int highestAdjacentRolls(ArrayList<Dice> sequence) {
        if (sequence == null || sequence.size() < 2) {
            throw new IllegalArgumentException("The sequence must contain at least two dice.");
        }
    
        int max = Integer.MIN_VALUE;
    
        for (int j = 1; j < sequence.size(); j++) {
            int sum = sequence.get(j - 1).getValue() + sequence.get(j).getValue();
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static int smallestAdjacentRolls(ArrayList<Dice> sequence) {
        if (sequence == null || sequence.size() < 2) {
            throw new IllegalArgumentException("The sequence must contain at least two dice.");
        }
    
        int min = Integer.MAX_VALUE;
    
        for (int j = 1; j < sequence.size(); j++) {
            int sum = sequence.get(j - 1).getValue() + sequence.get(j).getValue();
            if (sum < min) {
                min = sum;
            }
        }
        return min;
    }
    

    public static void main(String[] args) {
        ArrayList<Dice> diceList = sequenceOfDice(5);
        ArrayList<Integer> diceValues = new ArrayList<>();

        for (Dice dice : diceList) {
            diceValues.add(dice.getValue());
        }
        for (int value : diceValues) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("============");
        System.out.println("Highest adjacent: " + highestAdjacentRolls(diceList));
        System.out.println("============");
        System.out.println("Smallest adjacent: " + smallestAdjacentRolls(diceList));
    }
}
