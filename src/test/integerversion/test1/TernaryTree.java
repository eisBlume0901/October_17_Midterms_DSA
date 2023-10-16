package test.integerversion.test1;

public class TernaryTree {

    private static class Node {
        private String value;
        private Node leftChild;
        private Node middleChild;
        private Node rightChild;

        public Node(String value) {
            this.value = value;
            this.leftChild = null;
            this.middleChild = null;
            this.rightChild = null;
        }

        public String getValue() {
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

    public void insert(String value) {
        root = insert(root, value);
    }

    private Node insert(Node node, String value) {
        if (node == null) {
            return new Node(value);
        }

        String current = node.getValue();
        if (value.startsWith(current)) {
            if (value.compareTo(current) < 0) {
                node.setLeftChild(insert(node.getLeftChild(), value));
            } else if (value.compareTo(current) > 0) {
                node.setRightChild(insert(node.getRightChild(), value));
            } else {
                node.setMiddleChild(insert(node.getMiddleChild(), value));
            }
        } else {
            String minPrefix = getMinPrefix(current, value);
            String nodeValue = current.substring(0, minPrefix.length());
            String valuePrefix = value.substring(0, minPrefix.length());
            if (valuePrefix.compareTo(nodeValue) < 0) {
                node.setLeftChild(insert(node.getLeftChild(), value));
            } else if (valuePrefix.compareTo(nodeValue) > 0) {
                node.setRightChild(insert(node.getRightChild(), value));
            } else {
                node.setMiddleChild(insert(node.getMiddleChild(), value));
            }
        }
        return node;
    }

    private String getMinPrefix(String str1, String str2) {
        int n = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < n && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);
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
        tree.insert("Alvin");
        tree.insert("Aang");
        tree.insert("Blake");
        tree.insert("Brad");

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
