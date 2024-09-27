class Arrays {

    // Int average
    public static int average(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum/array.length;
    }

    // Double average
    public static double average(double[] array) {
        double sum = 0;
        for (double i : array) {
            sum += i;
        }
        return sum/array.length;
    }

    // Smallest int
    public static int smallestElement(int[] array) {
        int min = array[0]; // Start checking the first index
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    // Reverse int
    public static int[] reverse(int[] array) {
        int[] yarra = new int[array.length];
        for (int i = 0, j = array.length; i < array.length || j > 0; ++i, --j) {
            yarra[i] = array[j-1];
        }
        return yarra;
    }

    // Even int
    public static int[] evenNumbers(int[] array) {
        int count = 0;
        // First for-loop checks number of elements in array
        for (int i : array) {
            if (i % 2 == 0) {
                ++count;
            }
        }
        int[] even = new int[count];
        int j = 0;
        // Second loop adds elements
        for (int i : array) {
            if (i % 2 == 0) {
                even[j] = i;
                ++j;
            }
        }
        return even;
    }

    // Main
    public static void main(String[] args) {
        // Create arrays
        int[] intArray = {8, 13, 9, 10, 65, 164, 2032};
        double[] doubleArray = {2.0, 3.0, 4.0, 5.0, 7.0};
        // Print calculations
        System.out.println(average(intArray));
        System.out.println(average(doubleArray));
        System.out.println(smallestElement(intArray));
        // Print array loops
        for (int i : reverse(intArray)) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();

        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : evenNumbers(intArray)) {
            System.out.print(i + " ");
        }
    }
}