package Tree;

public class BST<T extends Comparable<T>> extends Tree<T> {

    @Override
    public void insert(T element) {
        root = insert(element, root);
    }

    private TreeCell<T> insert(T element, TreeCell<T> node) {
        if (node == null) {
            return new TreeCell<>(element, null, null);
        }

        // Compare element with node’s datum
        if (element.compareTo(node.getDatum()) <= 0) {
            node.setLeft(insert(element, node.getLeft()));
        } else {
            node.setRight(insert(element, node.getRight()));
        }

        return node;
    }
}