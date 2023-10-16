package test.integerversion;

public class CompleteTernaryTree {
    static class Node {
        String label;
        Node left, middle, right;

        Node(String item) {
            label = item;
            left = middle = right = null;
        }
    }

    Node root;

    CompleteTernaryTree() {
        root = null;
    }

    void insert(String label) {
        if (root == null) {
            root = new Node("A");
        }
        root = insertAlphabetically(root, label);
    }

    Node insertAlphabetically(Node node, String label) {
        if (node == null) {
            return new Node(label);
        }

        if (label.compareTo(node.label) < 0) {
            node.left = insertAlphabetically(node.left, label);
        } else if (label.compareTo(node.label) > 0) {
            node.right = insertAlphabetically(node.right, label);
        } else {
            node.middle = insertAlphabetically(node.middle, label);
        }
        return node;
    }

    void preOrderTraversal() {
        preOrderTraversal(root);
    }

    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.label + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.middle);
            preOrderTraversal(node.right);
        }
    }

    void postOrderTraversal() {
        postOrderTraversal(root);
    }

    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.middle);
            postOrderTraversal(node.right);
            System.out.print(node.label + " ");
        }
    }

    public static void main(String[] args) {
        CompleteTernaryTree tree = new CompleteTernaryTree();

        tree.insert("E");
        tree.insert("F");
        tree.insert("G");
        tree.insert("H");
        tree.insert("I");
        tree.insert("J");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("A");

        System.out.print("Preorder Traversal: ");
        tree.preOrderTraversal();
        System.out.println();
        System.out.print("Postorder Traversal: ");
        tree.postOrderTraversal();
        System.out.println();
    }
}
