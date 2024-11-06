import java.util.LinkedList;
import java.util.Queue;

public class Tree {
  // attributes of a tree
  Node root;

  //constructor
  Tree() {
    this.root = null;
  }

  void add(char val) {
    // make node
    Node newNode = new Node(val);

    // If the tree is empty, set the new node as root
    if(root == null) {
      root = newNode;
      return;
    }

    // Use a queue to perform BFS: Start with the root node
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(root);

    //iterate over queue until empty
    while (!queue.isEmpty()) {
      //get first Node from queue
      Node candidate = queue.poll();

      // if no left child add new node here and be done, otherwise add left child to queue
      if (candidate.left == null) {
        candidate.left = newNode;
        return;
      } else {
        queue.offer(candidate.left);
      }

      // same process for right child
      if (candidate.right == null) {
        candidate.right = newNode;
        return;
      } else {
        queue.offer(candidate.right);
      }
    }
  }

  // Method to print the tree (for testing purposes)
  public void printTree(Node node, int depth) {
    //if leaf reached, return
    if (node == null) {
      return;
    }

    //indent by depth
    for (int i = 0; i < depth; i++){
      System.out.print(" ");
    }
    //print the value
    System.out.println(node.val);

    //recursively print subtrees as increased depth
    printTree(node.left, depth+1);
    printTree(node.right, depth+1);
  }

  public void remove(char value) {
    //call recursive method to find new root
    root = removeRecursive(root, value);
  }

  // Helper method for recursive removal
  private Node removeRecursive(Node node, char value) {
    //base case - the node isn't found in this branch
    if(node == null) {
      return null;
    }

    // If the node to be removed is found
    if (node.val == value) {
      // Case 1: Node with two children
      if (node.left != null && node.right != null) {
        // Promote the left child
        Node promoted = node.left;
        // if newly promoted child has no right child, attach right child of removed node
        // otherwise find the rightmost node of the left child
        if (promoted.right == null) {
          promoted.right = node.right;
        } else {
          // Find the rightmost node of the left child
          Node rightmost = promoted.right;
          while(rightmost.right != null) {
            rightmost = rightmost.right;
          }
          // Attach right child to the rightmost of the left child
          rightmost.right = node.right;
        }
        // Promote the left child
        return promoted;

      } else {
        // Case 2: Node with only one or no children
        return (node.left == null) ? node.left : node.right;
      }
    }

    // Recursively search for the node to remove in left and right subtrees
    node.left = removeRecursive(node.left, value);
    node.right = removeRecursive(node.right, value);

    return node; // Return the current node

  }

  public static void main(String[] args) {
    //create, populate and test tree
    Tree tree = new Tree();

    for(int i = 65; i < 80; i++) {
      tree.add((char) i);
    }
    tree.printTree(tree.root, 0);
    tree.remove('E');
    tree.printTree(tree.root, 0);

  }
  
}

class Node{
  //node attributes
  char val;
  Node left;
  Node right;

  //node constructor
  Node(char val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }

}













