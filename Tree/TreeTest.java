package Tree;

public class TreeTest {
   public static void main(String[] args) {
      // Tree<Integer> binTree = new Tree<Integer>();
      
      // for (int i = 0; i < 11; i++) {
      //    int element = (int)(Math.random() * 50) + 1;
      //   System.out.println("Inserting " + element);
      //    binTree.insert(element);
      //}
      BST<Integer> binTree = new BST<Integer>();
      Integer[] nums = {18, 12, 25, 4, 15, 25, 30, 1, 13, 17, 28, 3, 14, 29};
      for (int i = 0; i < nums.length; i++) {
         System.out.println("Inserting " + nums[i]);
         binTree.insert(nums[i]);
      }
      System.out.println("Final tree:");
      binTree.printTree();
      System.out.println();
      System.out.println("Size: " + binTree.size());
      System.out.println("Height: " + binTree.height());
      System.out.println();
      System.out.print("Pre-order: ");
      binTree.preorder();
      System.out.println();
      System.out.print("In-order: ");
      binTree.inorder();
      System.out.println();
      System.out.print("Post-order: ");
      binTree.postorder();
      System.out.println();
      System.out.print("Search result for 13: " + binTree.search(13));
      System.out.println();
      System.out.print("Search result for 31: " + binTree.search(31));
      System.out.println();
    }
}
