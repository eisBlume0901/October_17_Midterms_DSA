package test.integerversion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleAndRemoveSpecialCharacters {
    private boolean containsSpecialCharacters(String str) {
        return str.matches(".*[^a-zA-Z0-9 ].*");
    }

    public void shuffleAndRemoveSpecialCharacters(List<String> list) {
        List<String> shuffledList = new ArrayList<>();
        List<String> specialCharactersList = new ArrayList<>();

        for (String name : list) {
            if (containsSpecialCharacters(name)) {
                specialCharactersList.add(name);
            } else {
                shuffledList.add(name);
            }
        }

        Collections.shuffle(shuffledList);

        System.out.println("Shuffled List: " + shuffledList);
        System.out.println("Special Characters List: " + specialCharactersList);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John#$%");
        names.add("@Doe");
        names.add("Alice123");
        names.add("Bob");

        ShuffleAndRemoveSpecialCharacters obj = new ShuffleAndRemoveSpecialCharacters();
        obj.shuffleAndRemoveSpecialCharacters(names);
    }
}
