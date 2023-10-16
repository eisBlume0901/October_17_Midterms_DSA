package userinterface;

import domain.Person;
import trees.ternary.TernaryTree;
import java.util.*;
import static java.lang.System.*;

public class UserInterface implements InputValidator
{

    private Scanner scanner;
    private Stack<Person> personStack;
    private Stack<Person> stackAtoM;
    private Stack<Person> stackNtoZ;
    private List<String> specialCharactersList;
    private List<String> shuffledList;
    private TernaryTree ternaryTree;

    private List<Person> personList;
    public UserInterface()
    {
        scanner = new Scanner(in);
        personStack = new Stack<>();
        stackAtoM = new Stack<>();
        stackNtoZ = new Stack<>();
        shuffledList = new ArrayList<>();
        specialCharactersList = new ArrayList<>();
        personList = new ArrayList<>();
        ternaryTree = new TernaryTree();
    }

    public void start()
    {
        storeToList();
        storeToStacks();

        out.println("Descending age of names starting with A-M: ");
        sortStack(stackAtoM, false);
        displayStacks(stackAtoM);

        out.println();

        out.println("Ascending age of names starting with N-Z: ");
        sortStack(stackNtoZ, true);
        displayStacks(stackNtoZ);
        out.println();

        removeSpecialCharacters(personList);

        out.println("Shuffled List of names starting with A-Z");
        Collections.shuffle(shuffledList);
        displayLists(shuffledList);

        out.println("List of special names");
        storeNamesWithSpecialCharactersStack();
        displayLists(specialCharactersList);

        out.println("Ternary Tree Order Traversal: ");
        storeToTernaryTree(shuffledList);
        displayOrderTraversalsFromTernaryTree();
    }
    private void storeToList()
    {
        System.out.println("Enter the number of people you would be adding:");
        int n = isInteger();

        for (int i = 0; i < n; i++)
        {
            out.println("Enter the name for person " + (i + 1) + ": ");
            String name = scanner.nextLine();
            out.println("Enter age for person " + (i + 1) + ": ");
            int age = isInteger();

            personList.add(new Person(name, age));
        }
    }

    private void storeToStacks()
    {
        personList.stream()
                .filter(person -> person.getName().matches("[A-Ma-m].*"))
                .forEach(person -> stackAtoM.push(person));

        personList.stream()
                .filter(person -> person.getName().matches("[N-Zn-z].*"))
                .forEach(person -> stackNtoZ.push(person));

    }

    private void displayStacks(Stack<Person> personStack)
    {
        personStack
                .stream()
                .forEach(Person -> out.println(Person.getName() + ", " + Person.getAge() + " years old"));
    }
    private Stack<Person> sortStack(Stack<Person> stack, boolean ascending) {
        stack.sort((p1, p2) -> {
            int age1 = p1.getAge();
            int age2 = p2.getAge();
            return ascending ? Integer.compare(age1, age2) : Integer.compare(age2, age1);
        });
        return stack;
    }

    private void storeNamesWithSpecialCharactersStack()
    {
        personStack.addAll(stackAtoM);
        personStack.addAll(stackNtoZ);
        personStack
                .stream()
                .filter(person -> person.getName().matches(" .*[a-zA-Z0-9].* "))
                .forEach(person -> specialCharactersList.add(person.getName()));
    }

    private void removeSpecialCharacters(List<Person> personList) {

        for (Person person : personList)
        {
            String name = person.getName();
            if (containsSpecialCharacters(name))
                specialCharactersList.add(name);
            else shuffledList.add(name);
        }
    }
    private void displayLists(List<String> stringList)
    {
        stringList
                .stream()
                .forEach(names -> out.println(names));
    }

    private void storeToTernaryTree(List<String> shuffledList)
    {
        Collections.sort(shuffledList);
        for (String personName : shuffledList)
        {
            ternaryTree.insert(personName);
        }
    }

    private void displayOrderTraversalsFromTernaryTree()
    {
        ternaryTree.preorderTraversal();
        ternaryTree.inorderTraversal();
        ternaryTree.postorderTraversal();
    }
}
