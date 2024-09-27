import java.util.ArrayList;

public class SetTheory {

    // Generate set (All integers from min to max)
    public static ArrayList<Integer> generateSet(int min, int max) {
        ArrayList<Integer> integerList = new ArrayList<>();
        // Max range is 0-99
        for (int i = min; i < max && i < 100; ++i) {
            if (i >= 0) {
                integerList.add(i);
            }
        }
        return integerList;
    }

    // Source (for contains() method) https://www.geeksforgeeks.org/arraylist-contains-java/
    // Union (All elements in both sets)
    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> union = new ArrayList<>();
        // For each element in a check if union.contains(element) and if not, add to union
        for (int i : a) {
            if (!union.contains(i)) {
                union.add(i);
            }
        }
        // Same for b in case b is longer
        for (int i : b) {
            if (!union.contains(i)) {
                union.add(i);
            }
        }
        return union;
    }

    // Intersection (Elements both contain)
    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> intersect = new ArrayList<>();
        // For each element in a check if b.contains(element) and if so, add to union
        for (int i : a) {
            if (b.contains(i) && !intersect.contains(i)) {
                intersect.add(i);
            }
        }
        // Same for b in case b is longer
        for (int i : b) {
            if (a.contains(i) && !intersect.contains(i)) {
                intersect.add(i);
            }
        }
        return intersect;
    }

    // Complement (All numbers 0-100 except elements in set)
    public static ArrayList<Integer> complement(ArrayList<Integer> a) {
        ArrayList<Integer> complement = new ArrayList<>();
        
        for (int i = 0; i < 100 ; ++i) {
            if (!a.contains(i)) {
                complement.add(i);
            }
        }
        return complement;
    }

    // Cardinality (Number of unique elements)
    public static int cardinality(ArrayList<Integer> a) {
        ArrayList<Integer> cardinalityArrayList = new ArrayList<>();
        int cardinality = 0;
        for (int i : a) {
            if (!cardinalityArrayList.contains(i)) {
                cardinalityArrayList.add(i);
                ++cardinality;
            }
        }
        return cardinality;
    }

    // Cardinality of union (Number of elements in union of two sets)
    public static int cardinalityOfUnion(ArrayList<Integer> a, ArrayList<Integer> b) {
        return cardinality(union(a, b));
    }

    // Example call
    public static void main(String[] args){
        // call the "generateSet" method on the SetTheory object
        ArrayList<Integer> exampleSet = generateSet(10, 15);
        // if implemented correctly, "exampleSet" should be an ArrayList of the five integers between `[10, 14]`
        // [10, 11, 12, 13, 14]

        // Union arraylists
        ArrayList<Integer> set1 = new ArrayList<>();
        set1.add(1);
        set1.add(3);
        set1.add(6);
        set1.add(4);
        ArrayList<Integer> set2 = new ArrayList<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(12);

        // Print sets
        System.out.println(exampleSet);

        System.out.println(union(set1, set2));
        System.out.println(intersection(set1, set2));
        System.out.println(complement(set2));

        System.out.println(cardinality(set1));
        System.out.println(cardinality(set2));

        System.out.println(cardinalityOfUnion(set1, set2));
    }
}