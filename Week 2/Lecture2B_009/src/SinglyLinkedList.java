public class SinglyLinkedList<E> {

    Node<E> head;
    int size;

    public SinglyLinkedList() {
      this.head = null;
      size = 0;
    }

    public void add(E val){
      Node<E> add = new Node<E>(val);

      if (size == 0) {
        this.head = add;
      } else {
        Node<E> temp = this.head;
        while (temp.next != null) {
          temp = temp.next;
        }
        temp.next = add;
      }
      size++;
    }

    public E get(int ind){
      int temp = 0;
      if (ind > this.size-1 || this.size == 0) {
        return null;
      } else if (ind == 0) {
        return this.head.value;
      } else {
        Node<E> ptr = this.head;
        while (temp < ind && ptr.next != null) {
          temp++;
          ptr = ptr.next;
        }
        return ptr.getValue();
      }

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

    @Override
    public String toString() {
      String result = "[";

      if (this.size != 0) {
        Node<E> temp = this.head;
        while (temp.next != null) {
          result += temp.value + ", ";
          temp = temp.next;
        }
        result += temp.value;
      }

      result += "]";
      return result;
    }

    public static void main(String[] args) {
      SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
      list.add(1);
      list.add(200);
      list.add(3);
      System.out.println(list);
      System.out.println(list.get(2));
      System.out.println(list.get(0));
      System.out.println(list.get(100));
    }


}