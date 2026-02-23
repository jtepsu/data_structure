
public class AVLTest {
public static void main(String[] args) {
    BST<Integer> myTree = new BST<>();
    for (int i=0; i<15; i++) {
        myTree.insert(i);
    }
    myTree.printTree();
    System.out.println();
    AVLTree myTree2 = new AVLTree();
    for (int i=0; i<15; i++) {
        myTree2.insert(i);
    }
    myTree2.printTree();
}


}
