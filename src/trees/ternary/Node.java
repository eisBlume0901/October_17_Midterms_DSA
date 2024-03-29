package trees.ternary;

public class Node
{
    private String name;
    private Node leftChild;
    private Node rightChild;

    private Node middleChild;

    public Node(String name)
    {
        this.name = name;
        this.leftChild = null;
        this.rightChild = null;
        this.middleChild = null;
    }

    public String getName() {
        return name;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Node getMiddleChild() {
        return middleChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }


    public void setMiddleChild(Node middleChild) {
        this.middleChild = middleChild;
    }
}