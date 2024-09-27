import java.util.ArrayList;
import java.util.Random;

public class Dice {
    int value;
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

    // public static int highestAdjacentRolls(ArrayList<Dice> sequence) {
    //     int current = 0;
    //     int next;
    //     // Fortsätt här
    // }
}
