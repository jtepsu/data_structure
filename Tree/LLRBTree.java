public class LLRBTree<T extends Comparable<T>> extends BST<T> {

    private boolean RED = true;
    private boolean BLACK = false;
    public Node<T> root = null;

    private class Node<T> extends TreeCell<T> {
        T datum;
        Node<T> left, right;
        boolean color;

        public Node(T datum, boolean color) {
            this.datum = datum;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }

    private boolean isRed(Node<T> x) {
        if (x == null) return false;
        return x.color == RED;
    }
    @Override
    public void insert(T x) {
        insert(x, root);
    }

    private Node<T> insert(T element, Node<T> node) {
        if (node == null) return new Node<>(element, RED);
        int cmp = element.compareTo(node.datum);
        if (cmp < 0) node.left = insert(element, node.left);
        else if (cmp > 0) node.right = insert(element, node.right);
        else node.datum = element;

        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    private Node<T> rotateLeft(Node<T> node) {
        assert isRed(node.right);
        Node<T> x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node<T> rotateRight(Node<T> node) {
        assert isRed(node.left);
        Node<T> x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node<T> node) {
        assert !isRed(node);
        assert isRed(node.left);
        assert isRed(node.right);
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }



    
    
}
