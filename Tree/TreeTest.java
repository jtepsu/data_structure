package Tree;

public class TreeTest {
   public static void main(String[] args) {
      Tree<Integer> binTree = new Tree<Integer>();
      // Tree<Integer> binTree = new BST<Integer>();
      for (int i = 0; i < 11; i++) {
         int element = (int)(Math.random() * 50) + 1;
        System.out.println("Inserting " + element);
         binTree.insertByLevel(element);
      }
      System.out.println("Final tree:");
      binTree.printTree();
      System.out.println();
      System.out.println("Size: " + binTree.size());
      System.out.println("Height: " + binTree.height());
      System.out.println();
      System.out.println("Pre-order:");
      binTree.preorder();
      System.out.println("In-order:");
      binTree.inorder();
      System.out.println("Post-order:");
      binTree.postorder();
    }
}
