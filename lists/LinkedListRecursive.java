/**
 * A linked list implementation of List using lots of recursion.
 * 
 */
public class LinkedListRecursive<T extends Comparable<T>> implements List<T> {

   private ListCell<T> head; // head (first cell) of the List

   /**
    * Constructor.
    */
   public LinkedListRecursive() {
      head = null;
   }

   /**
    * Getter.
    */
    public ListCell<T> getHead() {
      return this.head;
   }

   /**
    * Insert an element onto the list.
    * 
    * @param element
    *           the element to insert
    */
   public void insert(T element) {
      head = new ListCell<T>(element, head);
   }

   /**
    * Delete an element from the list.
    * 
    * @param element
    *           the element to delete
    */
   public void delete(T element) {
      head = delete(element, head);
   }

   private ListCell<T> delete(T element, ListCell<T> cell) {
      if (cell == null) return null;
      if (cell.getDatum().equals(element)) return cell.getNext();
      cell.setNext(delete(element, cell.getNext()));
      return cell;
   }

      /**
    * Report true if list contains element.
    * 
    * @param element
    *           the element to check for
    * @return true iff element is in the List
    */
    public boolean contains(T element) {
      return contains(element, head);
   }

   private boolean contains(T element, ListCell<T> cell) {
      if (cell == null) return false;
      return cell.getDatum().equals(element) || contains(element, cell.getNext());
   }

   /**
    * Report number of elements in List.
    * 
    * @return number of elements
    */
   public int size() {
      return size(head);
   }

   private int size(ListCell<T> cell) {
      if (cell == null) return 0;
      return size(cell.getNext()) + 1;
   }

   public int count(T searchFor) {
      return count(this.getHead(), searchFor);
   }

   private int count(ListCell<T> cell, T searchFor) {
      if (size(cell) == 0) return 0;
      if (cell.getDatum().equals(searchFor)) return 1 + count(cell.getNext(), searchFor);
      return count(cell.getNext(), searchFor);
   }

   public void deleteAll(T element) {
      head = deleteAll(this.getHead(), element);
   }

   private ListCell<T> deleteAll(ListCell<T> cell, T element) {
      if (size(cell) == 0) return null;
      if (!(cell.getDatum().equals(element))) {
         cell = new ListCell<T>(cell.getDatum(), deleteAll(cell.getNext(), element));
         return cell;
      } else {
         return deleteAll(cell.getNext(), element);
         }
   }

   public void insertNth(T data, int index) {
      this.head = insertNth(data, index, this.getHead());
   }

   private ListCell<T> insertNth(T data, int index, ListCell<T> cell) {
      if (index == 0) {
         cell = new ListCell(data, cell);
         return cell;
      } else {
         cell = new ListCell(cell.getDatum(), insertNth(data, index-1, cell.getNext()));
         return cell;
      }
   }

   public void sort() {
      ListCell<T> sortedCell = sort(this.getHead());
      if (!(this.getHead().equals(sortedCell))) { // this always returns false for some reason
         this.head = sortedCell;
         this.sort();
      }
      this.head = sortedCell;
   }

   private ListCell<T> sort(ListCell<T> cell) {
      if (cell.getNext() == null) return cell;
      if (cell.getDatum().compareTo(cell.getNext().getDatum()) > 0) {
         ListCell<T> tail = new ListCell(cell.getDatum(), cell.getNext().getNext());
         cell = new ListCell(cell.getNext().getDatum(), tail);
         return cell;
      } else {
         cell = new ListCell(cell.getDatum(), sort(cell.getNext()));
         return cell;
      }
   }

   public void sortedInsert(T data) {

   }

   public void removeDuplicates() {

   }

   public void merge(List<T> otherList) {
      this.head = merge(this.head, ((LinkedListRecursive<T>)otherList).getHead());
   }

   private ListCell<T> merge(ListCell<T> cell1, ListCell<T> cell2) {

      
      return null;
   }

   /**
    * String representation.
    * 
    * @return the String representation
    */
   public String toString() {
      return "[" + toString(head) + " ]";
   }

   private String toString(ListCell<T> cell) {
      if (cell == null) return "";
      return " " + cell.getDatum().toString() + toString(cell.getNext());
   }
}
