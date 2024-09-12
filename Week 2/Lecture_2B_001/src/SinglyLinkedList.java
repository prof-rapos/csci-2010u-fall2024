public class SinglyLinkedList<E> {

    Node<E> head;
    int size;

    public SinglyLinkedList() {
      this.head = null;
      size = 0;
    }

    public void add(E val){
      Node<E> add = new Node<E>(val);
      Node<E> temp = this.head;
      if (size == 0) {
        this.head = add;
        size++;
        return;
      }
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = add;
      size++;
    }

    public E get(int ind){
      return null;
    }

    public void set(int ind, E val){

    }

    public E remove(int ind){
      return null;
    }

    public int size(){
      return size;
    }

    public boolean contains(E val){
      return false;
    }

    public int indexOf(E val){
      return -1;
    }

    public void clear(){

    }

    public String toString() {
      String result = "[";
      Node<E> temp = this.head;
      if (size == 0) {
        return "[]";
      }
      while (temp.next != null) {
        result += temp.value + ", ";
        temp = temp.next;
      }
      result += temp.value;
      result += "]";
      return  result;
    }
    public static void main(String[] args) {
      SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
      System.out.println(myList);
      myList.add(1);
      myList.add(3456);
      myList.add(42);
      System.out.println(myList);
    }

}















