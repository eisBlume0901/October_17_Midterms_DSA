package trees.ternary;

public class Main {
    public static void main(String[] args) {
        TernaryTree<Integer> tst = new TernaryTree<>();
        tst.insert("A", 0).insert("B", 2);
        tst.insert("C", 3);
        tst.insert("D", 4);

        System.out.println(tst.get("Alvin"));
        System.out.println(tst.contains("Brad"));
        tst.softDelete("Brad");
        System.out.println(tst.contains("Brad"));

        // Display the tree
        tst.displayTree();
    }
}
