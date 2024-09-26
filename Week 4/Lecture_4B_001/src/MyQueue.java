public class MyQueue<E> {
  private Node<E> front;
  private Node<E> back;
  private int size;

  public MyQueue(){
    this.front = null;
    this.back  = null;
    this.size  = 0;
  }

  public void enqueue(E value) {
    Node<E> node = new Node<>(value);
    if(empty()) {
      this.front = this.back = node;
    } else {
      this.back.next = node;
      this.back = node;
    }
    this.size++;
  }

  public E dequeue() {
    if(empty()) {
      return null;
    } else {
      E value = this.front.value;
      this.front = this.front.next;
      this.size--;
      if (empty()) {
        this.back = null;
      }
      return value;
    }
  }

  public E peek() {
    if (empty()) {
      return null;
    } else {
      return this.front.value;
    }
  }

  public int size() {
    return this.size;
  }

  public boolean empty() {
    return this.size == 0;
  }

  private class Node<E> {
    E value;
    Node<E> next;

    Node(E value) {
      this.value = value;
    }
  }
}