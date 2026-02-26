
class Node <T extends Comparable<T>> {
    T key;
    int height;
    Node<T> left;
    Node<T> right;
    
    public Node(T key) {
        this.key = key;
    }
}

public class AVLTree<T extends Comparable<T>> extends BST<T> {

    public Node<T> root;

    public AVLTree() {
        this.root = null;
    }

    void updateHeight(Node<T> n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node<T> n) {
        return n == null ? -1 : n.height;
    }

    int getBalance(Node<T> n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    Node<T> rotateLeft(Node<T> y) {
        Node<T> x = y.right;
        Node<T> z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    
    Node<T> rebalance(Node<T> z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    @Override
    public void insert(T key) {
        root = insert(root, key);
    }

    private Node<T> insert(Node<T> node, T key) {
        if (node == null) {
            return new Node<>(key);
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    @Override
    public void printTree() {
        printTree(this.root, 0);
    }

    private void printTree(Node<T> node, int level) {
        if (node == null)
            return;
        printTree(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("      ");
        }
        System.out.println(node.key);
        printTree(node.left, level + 1);
    }
}
