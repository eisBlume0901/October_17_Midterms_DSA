package trees.ternary;


public class TernaryTree {
    private Node root;

    public void insert(String name) {
        root = insert(root, name);
    }

    private Node insert(Node node, String name) {
        if (node == null) {
            return new Node(name);
        }

        String current = node.getName();
        if (name.compareTo(current) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), name));
        } else if (name.compareTo(current) > 0) {
            node.setRightChild(insert(node.getRightChild(), name));
        } else {
            node.setMiddleChild(insert(node.getMiddleChild(), name));
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
            System.out.print(node.getName() + " ");
            preorderTraversal(node.getLeftChild());
            preorderTraversal(node.getMiddleChild());
            preorderTraversal(node.getRightChild());
        }
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.getLeftChild());
            System.out.print(node.getName() + " ");
            inorderTraversal(node.getMiddleChild());
            inorderTraversal(node.getRightChild());
        }
    }

    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.getLeftChild());
            postorderTraversal(node.getMiddleChild());
            postorderTraversal(node.getRightChild());
            System.out.print(node.getName() + " ");
        }
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
                System.out.println("Root: " + node.getName());
            } else {
                System.out.println(node.getName());
            }
            displayTree(node.getMiddleChild(), level + 1, false);
            displayTree(node.getLeftChild(), level + 1, false);
        }
    }
}
