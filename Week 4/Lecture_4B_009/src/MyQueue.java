public class MyQueue<E> {

  Node<E> front;
  Node<E> back;
  int size;

  public MyQueue() {
    this.front = null;
    this.back = null;
    this.size = 0;
  }


  public void enqueue(E e) {
    Node<E> add = new Node<>(e);
    if (empty()) {
      this.front = this.back = add;
    } else {
      this.back.next = add;
      this.back = add;
    }
    this.size++;
  }

  public E dequeue() {
    if(empty()) {
      return  null;
    } else {
      E val = this.front.value;
      this.front = this.front.next;
      this.size--;
      if (empty()) {
        this.back = null;
      }
      return val;
    }
  }

  public int size() {
    return this.size;
  }

  public boolean empty() {
    return this.size == 0;
  }

  public E peek() {
    if(empty()) {
      return null;
    } else {
      return this.front.value;
    }
  }


  private class Node<E> {
    private E value;
    private Node<E> next;

    Node(E value) {
      this.value = value;
      this.next = null;
    }
  }

}