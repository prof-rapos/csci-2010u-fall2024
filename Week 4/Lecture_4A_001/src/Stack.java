public class Stack<F> {
  private Node<F> top;
  public int size;

  public Stack() {
    this.size = 0;
    this.top = null;
  }

  public F pop() {
    if (empty()) {
      return null;
    } else {
      F val = this.top.value;
      this.top = this.top.next;
      this.size--;
      return val;
    }
  }

  public void push(F f) {
    Node<F> node = new Node<>(f);
    if (!empty()) {
      node.next = this.top;
    }
    this.top = node;
    this.size++;
  }


  public boolean empty(){
    return this.size == 0;
  }

  public F peek() {
    if(!empty()){
      return top.value;
    } else {
      return null;
    }
  }
  private class Node<E> {
    E value;
    Node<E> next;

    Node(E value) {
      this.value = value;
      next = null;
    }

    protected E getValue(){
      return this.value;
    }
  }

}