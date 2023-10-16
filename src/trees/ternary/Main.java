package trees.ternary;

public class Main
{
    public static void main(String[] args) {
        TernaryTree tree = new TernaryTree();
//        tree.insert("Alvin");
//        tree.insert("Aang");
        tree.insert("Blake");
        tree.insert("Brad");
        tree.insert("Arabella");
        tree.insert("Alvin");
        tree.insert("Aang");

        tree.displayTree();
        tree.preorderTraversal();
        tree.inorderTraversal();
        tree.postorderTraversal();
    }

}
