package userinterface;

import trees.ternary.TernaryTree;

import java.util.*;

public class UserInterface
{
    private static TernaryTree<Integer> tst = new TernaryTree<>();

    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        int n = scanner.nextInt();
        List<String> firstHalf = new ArrayList<>();
        List<String> secondHalf = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name for person " + (i + 1) + ": ");
            String name = scanner.next();
            System.out.println("Enter age for person " + (i + 1) + ": ");
            int age = scanner.nextInt();

            if (name.matches("[A-Ma-m].*")) {
                firstHalf.add(name);
            } else if (name.matches("[N-Zn-z].*")) {
                secondHalf.add(name);
            }

            if (name.matches(".*\\d.*") || !name.matches("[a-zA-Z]+")) {
                System.out.println("Special characters or numbers found in the name. Moving to separate collection.");
                // Add to the separate collection
            } else {
                tst.insert(name, age);
            }
        }

        // Sort firstHalf in descending order and secondHalf in ascending order based on age
        firstHalf.sort(Comparator.reverseOrder());
        secondHalf.sort(Comparator.naturalOrder());

        // Shuffle both stacks together
        Collections.shuffle(firstHalf);
        Collections.shuffle(secondHalf);

        List<String> mergedStack = new ArrayList<>();
        mergedStack.addAll(firstHalf);
        mergedStack.addAll(secondHalf);

        // Display the merged stack
        System.out.println("Merged Stack: " + mergedStack);

    }
}
