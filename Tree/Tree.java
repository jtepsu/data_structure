package Tree;

import java.util.List;

public class Tree<T> {

    protected TreeCell<T> root;

    public Tree() {
        root = null;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeCell<T> node) {
        if (node == null)
            return -1;
        if (isLeaf(node))
            return 0;
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    private boolean isLeaf(TreeCell<T> node) {
        return (node != null) && (node.getLeft() == null) && (node.getRight() == null);
    }

    public void insert(T element) {
        root = insert(element, root);
    }

    private TreeCell<T> insert(T element, TreeCell<T> node) {
        if (node == null) {
            node = new TreeCell<T>(element, null, null);
            return node;
        }
        if (height(node.getLeft()) <= height(node.getRight())) {
            node.setLeft(insert(element, node.getLeft()));
        } else {
            node.setRight(insert(element, node.getRight()));
        }
        return node;
    }

    public void insertByLevel(T element) {
        root = insertByLevel(element, root);
    }

    private TreeCell<T> insertByLevel(T element, TreeCell<T> node) {
        if (node == null) {
            node = new TreeCell<T>(element, null, null);
            return node;
        }
        if (height(node.getLeft()) == height(node.getRight())) { // if left and right subtree are the same height, left must already by complete
            if (size(node.getRight()) < ((Math.pow(2, (height(node.getRight()) + 1))) - 1)) { // check if the right subtree is complete
                node.setRight(insertByLevel(element, node.getRight())); // if the right is not complete, insert
            } else {
                node.setLeft(insertByLevel(element, node.getLeft())); // if the right is complete, start a new level on the left
            }
        } else { // in the case that left subtree has more height
            if (size(node.getLeft()) < ((Math.pow(2, (height(node.getLeft()) + 1))) - 1)) { // check if the left subtree is complete
                node.setLeft(insertByLevel(element, node.getLeft())); // if the left is not complete, insert
            } else {
                node.setRight(insertByLevel(element, node.getRight())); // if the left is complete, start insert on the right
            }
        }
        return node;
    }

    public boolean search(T element) {
        return search(element, root);
    }

    private boolean search(T element, TreeCell<T> node) {
        if (node == null)
            return false;
        if (node.getDatum().equals(element))
            return true;
        return search(element, node.getLeft()) || search(element, node.getRight());
    }

    public int size() {
        return size(root);
    }

    private int size(TreeCell<T> root) {
        if (root == null)
            return 0;
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(TreeCell<T> node, int level) {
        if (node == null)
            return;
        printTree(node.getRight(), level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("      ");
        }
        System.out.println(node.getDatum());
        printTree(node.getLeft(), level + 1);
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeCell<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getDatum() + " ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeCell<T> node) {
        if (node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getDatum() + " ");
        inorder(node.getRight());
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeCell<T> node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getDatum() + " ");
    }

    private void printTreePreOrder(TreeCell<T> node, int level) {
        if (node == null)
            return;
        for (int i = 0; i < level; i++) {
            System.out.print("      ");
        }
        System.out.println(node.getDatum() + " ");
        System.out.println();
        printTreePreOrder(node.getLeft(), level + 1);
        printTreePreOrder(node.getRight(), level + 1);
    }

}