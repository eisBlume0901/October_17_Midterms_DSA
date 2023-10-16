package trees.ternary;

public interface Tree<T extends Comparable<T>> {

    Tree<T> insert(String word, T value);

    boolean contains(String word);

    T get(String key);

    void softDelete(String word);

}