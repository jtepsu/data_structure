import java.util.Scanner;
public class LLRBTest {
    public static void main(String[] args) {
// Ask a user how many items he/she wants to insert.
// Ask the user if he/she wants ascending or descending order
        Scanner x = new Scanner(System.in);
        System.out.println("How many items to insert?");
        int amount = x.nextInt();
        Scanner y = new Scanner(System.in);
        System.out.println("In ascending or descending order?");
        String order = y.nextLine();

        BST<Integer> myTree = new BST<>();

// Insert n items in strictly ascending or descending order to myTree.
// Fill in your code here.
        // if (order.equals("ascending")) insertAscending(myTree, amount);
        // if (order.equals("descending")) insertDescending(myTree, amount);

        // myTree.printTree();
        // System.out.println();
        BST<Integer> myTree2 = new LLRBTree<>();
 
// Insert n items in strictly ascending or descending order to myTree2.
// Fill in your code here.
        if (order.equals("ascending")) insertAscending(myTree2, amount);
        if (order.equals("descending")) insertDescending(myTree2, amount);
        myTree2.printTree();
    }

    private static void insertAscending(BST<Integer> tree, int a) {
        for (int i = 0; i < a; i++) {
                tree.insert(i);
        }
    }

    private static void insertDescending(BST<Integer> tree, int a) {
        for (int i = a; i > 0; i--) {
        tree.insert(i);
        }
    }
}

