package trees.binary;

public class Node
{
    private String name;
    private Node leftChild;
    private Node rightChild;

    public Node(String name)
    {
        this.name = name;
        this.leftChild = null;
        this.rightChild = null;
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

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}