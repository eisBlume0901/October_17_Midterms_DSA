package test.integerversion;

public class TernaryTree {

    private static class Node {
        private int value;
        private Node leftChild;
        private Node middleChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.middleChild = null;
            this.rightChild = null;
        }

        public int getValue() {
            return value;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getMiddleChild() {
            return middleChild;
        }

        public void setMiddleChild(Node middleChild) {
            this.middleChild = middleChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            node.setLeftChild(insert(node.getLeftChild(), value));
        } else if (value > node.getValue()) {
            node.setRightChild(insert(node.getRightChild(), value));
        } else {
            node.setMiddleChild(insert(node.getMiddleChild(), value));
        }
        return node;
    }

    public void preorderTraversal() {
        System.out.print("Preorder Traversal: ");
        preorderTraversal(root);
        System.out.println();
    }

    public void inorderTraversal() {
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();
    }

    public void postorderTraversal() {
        System.out.print("Postorder Traversal: ");
        postorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preorderTraversal(node.getLeftChild());
            preorderTraversal(node.getMiddleChild());
            preorderTraversal(node.getRightChild());
        }
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inorderTraversal(node.getMiddleChild());
            inorderTraversal(node.getRightChild());
        }
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.getLeftChild());
            postorderTraversal(node.getMiddleChild());
            postorderTraversal(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        TernaryTree tree = new TernaryTree();
        tree.insert(5);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(4);
        tree.insert(8);
        tree.insert(9);
        tree.insert(1);

        tree.displayTree();
        tree.preorderTraversal();
        tree.inorderTraversal();
        tree.postorderTraversal();
    }

    public void displayTree() {
        displayTree(root, 0, true);
    }

    private void displayTree(Node node, int level, boolean isRoot) {
        if (node != null) {
            displayTree(node.getRightChild(), level + 1, false);
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            if (isRoot) {
                System.out.println("Root: " + node.getValue());
            } else {
                System.out.println(node.getValue());
            }
            displayTree(node.getMiddleChild(), level + 1, false);
            displayTree(node.getLeftChild(), level + 1, false);
        }
    }
}
