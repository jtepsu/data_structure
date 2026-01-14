package Tree;

class TreeCell<T> {
    private T datum;
    private TreeCell<T> left, right;

    public TreeCell(T x) {
        datum = x;
    }

    public TreeCell(T x, TreeCell<T> lft, TreeCell<T> rgt) {
        datum = x;
        left = lft;
        right = rgt;
    }
    
    public T getDatum() {
        return datum;
    }
    public void setDatum(T datum) {
        this.datum = datum;
    }
    public TreeCell<T> getLeft() {
        return left;
    }
    public void setLeft(TreeCell<T> left) {
        this.left = left;
    }
    public TreeCell<T> getRight() {
        return right;
    }
    public void setRight(TreeCell<T> right) {
        this.right = right;
    }
}