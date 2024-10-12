public class BiasedDice extends Dice {
    public BiasedDice() {
        this.value = random.nextFloat() < 0.5 ? 6 : 1 + random.nextInt(5);
    }
}
