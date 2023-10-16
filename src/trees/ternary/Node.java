package trees.ternary;

public class Node {
    private String name;
    private Node leftChild;
    private Node middleChild;
    private Node rightChild;

    public Node(String name) {
        this.name = name;
        this.leftChild = null;
        this.middleChild = null;
        this.rightChild = null;
    }

    public String getName() {
        return name;
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