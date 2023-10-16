package trees.ternary;

import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {

    private final char character;

    private T value;

    private Node<T> leftChild;
    private Node<T> middleChild;
    private Node<T> rightChild;


    public boolean isEndOfWord() {
        return value != null;
    }

}