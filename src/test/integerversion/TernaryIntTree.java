package test.integerversion;
public class TernaryIntTree {

    private NodeInt root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private NodeInt insert(NodeInt node, int value) {
        if (node == null) {
            return new NodeInt(value);
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

    public void display() {
        display(root, 0, true);
    }

    private void display(NodeInt node, int level, boolean isRoot) {
        if (node != null) {
            display(node.getRightChild(), level + 1, false);
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            if (isRoot) {
                System.out.println("Root: " + node.getValue());
            } else {
                System.out.println(node.getValue());
            }
            display(node.getMiddleChild(), level + 1, false);
            display(node.getLeftChild(), level + 1, false);
        }
    }

    private static class NodeInt<T> {
        private int value;
        private NodeInt<T> leftChild;
        private NodeInt<T> middleChild;
        private NodeInt<T> rightChild;

        public NodeInt(int value) {
            this.value = value;
            this.leftChild = null;
            this.middleChild = null;
            this.rightChild = null;
        }

        public int getValue() {
            return value;
        }

        public NodeInt<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(NodeInt<T> leftChild) {
            this.leftChild = leftChild;
        }

        public NodeInt<T> getMiddleChild() {
            return middleChild;
        }

        public void setMiddleChild(NodeInt<T> middleChild) {
            this.middleChild = middleChild;
        }

        public NodeInt<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(NodeInt<T> rightChild) {
            this.rightChild = rightChild;
        }
    }

    public static void main(String[] args) {
        TernaryIntTree tree = new TernaryIntTree();
        tree.insert(30);
        tree.insert(5);
        tree.insert(11);
        tree.insert(63);
        tree.display();
    }
}
