public class ListTest {

   /**
    * @param args
    */
   public static void main(String[] args) {

      LinkedListRecursive<Integer> myList = new LinkedListRecursive<Integer>();
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < i+2; j++) {
            myList.insert(i + 100);
         }
      }
      System.out.println(myList);
      System.out.println(myList.count(103));

      myList.delete(100);
      System.out.println(myList);

      myList.delete(101);
      System.out.println(myList);

      myList.delete(987);
      System.out.println(myList);

      myList.insertNth(777, 0);
      myList.insertNth(999, 10);
      myList.insertNth(888, 12);
      System.out.println(myList);
      
      myList.deleteAll(103);
      System.out.println(myList);

      myList.sort();
      System.out.println(myList);

      myList.sortedInsert(555);
      System.out.println(myList);

      myList.removeDuplicates();
      System.out.println(myList);

      myList.removeDuplicates();
      System.out.println(myList);

      LinkedListRecursive<Integer> myList2 = new LinkedListRecursive<Integer>();
      for (int i = 4; i >=0 ; i--) {
            myList2.insert((i + 1)*100);
      }
      System.out.println(myList2);
      myList2.merge(myList);
      System.out.println(myList2);
   }
   
   public static <T> ListCell<T> iterativeReverse(ListCell<T> c) {
      ListCell<T> rev = null;
      for (; c != null; c = c.getNext()) {
         rev = new ListCell<T>(c.getDatum(), rev);
      }
      return rev;
   }

   public static <T> ListCell<T> recursiveReverse(ListCell<T> c) {
      return recursiveReverse(c, null);
   }
   private static <T> ListCell<T> recursiveReverse(ListCell<T> c, ListCell<T> r) {
      if (c == null) return r;
      return recursiveReverse(c.getNext(), new ListCell<T>(c.getDatum(), r));
   }

}
