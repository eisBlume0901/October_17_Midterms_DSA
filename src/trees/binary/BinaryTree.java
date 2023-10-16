package trees.binary;


import userinterface.InputValidator;

public class BinaryTree implements InputValidator {
    private Node root;

    public void insert(String name) {
        root = insert(root, name);
    }

    private Node insert(Node node, String name) {
        if (node == null) {
            return new Node(name);
        }

        String currentName = node.getName();

        // Define your priority criteria here.
        // For example, compare names with special characters having higher priority.
        if (compareNamePriority(name, currentName) < 0) {
            node.setLeftChild( insert(node.getLeftChild(), name));
        } else {
            node.setRightChild( insert(node.getRightChild(), name));
        }

        return node;
    }
    private int compareNamePriority(String name1, String name2) {
        // Define your priority criteria here.
        // For example, compare names based on the presence of special characters.
        boolean hasSpecialChars1 = containsSpecialCharacters(name1);
        boolean hasSpecialChars2 = containsSpecialCharacters(name2);

        if (hasSpecialChars1 && !hasSpecialChars2) {
            return -1;
        } else if (!hasSpecialChars1 && hasSpecialChars2) {
            return 1;
        } else {
            // If both names have or don't have special characters, compare lexicographically.
            return name1.compareTo(name2);
        }
    }
    public boolean search(String name){
        return search(root, name);
    }
    private boolean search(Node node, String name){
        if(node == null){
            return  false;
        }
        String currentName = node.getName();
        if(currentName.equals(name)){
            return true;
        } else if (name.compareTo(currentName) < 0) {
            return search(node.getLeftChild(), name);
        } else {
            return search(node.getRightChild(), name);
        }
    }
    public void preOrderTraversal(){
        System.out.print("Pre-order Traversal: ");
        preOrderTraversal(root);
        System.out.println();
    }
    private void preOrderTraversal(Node node){
        if(node != null){
            System.out.print(node.getName() + " ");
            preOrderTraversal(node.getLeftChild());
            preOrderTraversal(node.getRightChild());
        }
    }
    public void postOrderTraversal() {
        System.out.print("Post-order Traversal: ");
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.getLeftChild());
            postOrderTraversal(node.getRightChild());
            System.out.print(node.getName() + " ");
        }
    }
    public void inOrderTraversal() {
        System.out.print("In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
    }
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.print(node.getName() + " ");
            inOrderTraversal(node.getRightChild());
        }
    }
}