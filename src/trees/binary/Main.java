package trees.binary;

public class Main
{
    public static void main(String[] args)
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert("Arabella");
        binaryTree.insert("Joanna");
        binaryTree.insert("Zobel");
        binaryTree.inOrderTraversal();
        binaryTree.postOrderTraversal();
        binaryTree.preOrderTraversal();
        boolean result = binaryTree.search("Jessie");
        System.out.println(result);
    }
}
