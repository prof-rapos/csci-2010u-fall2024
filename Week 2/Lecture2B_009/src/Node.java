public class Node<E> {
  E value;
  Node<E> next;

  public Node(E value) {
    this.value = value;
    this.next = null;
  }

  public E getValue(){
    return value;
  }

  public Node<E> getNext(){
    return next;
  }

  public void setValue(E val){
    value = val;
  }

  public void setNext(Node<E> next){
    this.next = next;
  }
  
}
