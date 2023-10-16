package userinterface;

import domain.Person;
import trees.binary.BinaryTree;
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
    private List<Person> personList;
    private TernaryTree ternaryTree;
    private TernaryTree ternaryTreeForSpecialCharacters;
    private BinaryTree binaryTree;
    private BinaryTree binaryTreeForSpecialCharacters;
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
        ternaryTreeForSpecialCharacters = new TernaryTree();
        binaryTree = new BinaryTree();
        binaryTreeForSpecialCharacters = new BinaryTree();
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

        out.println("Shuffled List of Names Starting with A-Z: ");
        Collections.shuffle(shuffledList);
        displayLists(shuffledList);

        out.println("List of Names with Special Characters: ");
        storeNamesWithSpecialCharactersStack();
        displayLists(specialCharactersList);

        out.println("Ternary Tree Order Traversal: ");
        storeToTernaryTree(ternaryTree, shuffledList);
        displayOrderTraversalsFromTernaryTree(ternaryTree);

        out.println("Ternary Tree Order Traversal for Names with Special Characters:");
        storeToTernaryTree(ternaryTreeForSpecialCharacters, specialCharactersList);

        storeToBinaryTree(binaryTree, shuffledList);
        storeToBinaryTree(binaryTreeForSpecialCharacters, specialCharactersList);
        searchAndTraverse(binaryTree, binaryTreeForSpecialCharacters);

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

    private void storeToTernaryTree(TernaryTree tTree, List<String> list)
    {
        Collections.sort(list);
        for (String personName : list)
            tTree.insert(personName);
    }

    private void displayOrderTraversalsFromTernaryTree(TernaryTree tree)
    {
        tree.preorderTraversal();
        tree.inorderTraversal();
        tree.postorderTraversal();
    }

    private void storeToBinaryTree(BinaryTree bTree, List<String> list)
    {
        Collections.sort(list);
        for (String uniqueName : list)
            bTree.insert(uniqueName);
    }
    private void searchAndTraverse(BinaryTree bTree1, BinaryTree bTree2)
    {
        out.println("Enter name to search: ");
        String name = scanner.nextLine();

        boolean foundInbTree1 = bTree1.search(name);
        boolean foundInbTree2 = bTree2.search(name);

        if (foundInbTree1)
        {
            out.println(name + " found in Binary Tree 1 (no special characters). Performing Pre-Order Traversal...");
            bTree1.preOrderTraversal();
        }
        else if (foundInbTree2)
        {
            out.println(name + " found in Binary Tree 2 (with special characters). Performing Pre-Order Traversal...");
            bTree2.postOrderTraversal();
        }
        else
        {
            out.println(name + " not found in Binary Tree 1 and 2. Performing In-Order Traversal...");
            out.println("Binary Tree 1 (no special characters) ");
            bTree1.inOrderTraversal();
            out.println("Binary Tree 2 (with special characters) ");
            bTree2.inOrderTraversal();
        }
    }
}
