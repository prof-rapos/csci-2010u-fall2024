import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
  // Root of the Binary Search Tree
  private Node root;

  // Node class to represent each element in the tree
  static class Node {
    int data;
    Node left, right;

    // Constructor
    public Node(int data) {
      this.data = data;
      this.left = this.right = null;
    }
  }

  // Constructor for the BST
  public BinarySearchTree() {
    this.root = null;
  }

  // Insertion method for adding a value to the tree
  public void insert(int data) {
    root = insertRecursive(root, data);
  }

  // Helper method for recursive insertion
  private Node insertRecursive(Node node, int data) {
    if (node == null) {
      return new Node(data); // Insert the data as a new node
    }

    if (data < node.data) {
      node.left = insertRecursive(node.left, data); // Insert in the left subtree
    } else if (data > node.data) {
      node.right = insertRecursive(node.right, data); // Insert in the right subtree
    }

    return node;
  }

  // Depth-First Search (DFS) method for searching a specific value
  public boolean dfsSearch(int target) {
    return dfsSearchRecursive(root, target);
  }

  // Recursive DFS Search helper method
  private boolean dfsSearchRecursive(Node node, int target) {
    if (node == null) {
      return false; // Base case: value not found
    }

    // Check if the current node contains the target value
    if (node.data == target) {
      return true;
    }

    // Recursively search in the left or right subtrees
    if (target < node.data) {
      return dfsSearchRecursive(node.left, target);
    } else {
      return dfsSearchRecursive(node.right, target);
    }
  }

  // In-order Traversal method
  public void inOrderTraversal() {
    inOrderRecursive(root);
  }

  // Helper method for in-order traversal
  private void inOrderRecursive(Node node) {
    if (node != null) {
      inOrderRecursive(node.left); // Visit left child
      System.out.print(node.data + " "); // Visit node
      inOrderRecursive(node.right); // Visit right child
    }
  }

  // Deletion method for removing a value from the tree
  public void delete(int data) {
    root = deleteRecursive(root, data);
  }

  // Helper method for recursive deletion
  private Node deleteRecursive(Node node, int data) {
    if (node == null) {
      return null; // Base case: node not found
    }

    if (data < node.data) {
      node.left = deleteRecursive(node.left, data); // Search in the left subtree
    } else if (data > node.data) {
      node.right = deleteRecursive(node.right, data); // Search in the right subtree
    } else {
      // Node to be deleted is found
      if (node.left == null) {
        return node.right; // Node has only right child or no child
      } else if (node.right == null) {
        return node.left; // Node has only left child or no child
      }

      // Node has two children: Get the inorder successor (smallest in the right subtree)
      node.data = findMin(node.right).data;
      node.right = deleteRecursive(node.right, node.data); // Delete the inorder successor
    }

    return node;
  }

  // Helper method to find the minimum value in the tree
  private Node findMin(Node node) {
    while (node.left != null) {
      node = node.left; // Traverse to the leftmost node
    }
    return node;
  }

  // Balancing method (simplified version)
  public void balance() {
    // Step 1: Store the elements of the BST in a sorted list
    List<Integer> sortedList = new ArrayList<>();
    storeInOrder(root, sortedList);

    // Step 2: Rebuild the tree by recursively inserting the middle element
    root = buildBalancedTree(sortedList, 0, sortedList.size() - 1);
  }

  // Helper method to perform an in-order traversal and store elements in a sorted list
  private void storeInOrder(Node node, List<Integer> list) {
    if (node != null) {
      storeInOrder(node.left, list);
      list.add(node.data);
      storeInOrder(node.right, list);
    }
  }

  // Helper method to rebuild the tree from the sorted list
  private Node buildBalancedTree(List<Integer> sortedList, int start, int end) {
    if (start > end) {
      return null;
    }

    // Find the middle element and make it the root
    int mid = (start + end) / 2;
    Node node = new Node(sortedList.get(mid));

    // Recursively build the left and right subtrees
    node.left = buildBalancedTree(sortedList, start, mid - 1);
    node.right = buildBalancedTree(sortedList, mid + 1, end);

    return node;
  }

  // Method to print the tree in a visually hierarchical way
  public void printTree() {
    printTreeRecursive(root, "", true);
  }

  // Helper method to print the tree recursively
  private void printTreeRecursive(Node node, String indent, boolean isLeft) {
    if (node == null) {
      return;
    }

    // Print the current node value with its indentation
    System.out.println(indent + (isLeft ? "L--- " : "R--- ") + node.data);

    // Recursively print the left and right subtrees
    printTreeRecursive(node.left, indent + (isLeft ? "|   " : "    "), true);
    printTreeRecursive(node.right, indent + (isLeft ? "|   " : "    "), false);
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();


    // Insertion
    bst.insert(7);
    bst.insert(4);
    bst.insert(11);
    bst.insert(2);
    bst.insert(5);
    bst.insert(1);
    bst.insert(3);
    bst.insert(10);
    bst.insert(14);
    bst.insert(9);

    bst.printTree();


    // DFS Search
    System.out.println("DFS Search for 3: " + bst.dfsSearch(3)); // true
    System.out.println("DFS Search for 100: " + bst.dfsSearch(100)); // false



    // In-order Traversal
    System.out.print("In-order Traversal: ");
    bst.inOrderTraversal();
    System.out.println();



    // Deletion
    bst.delete(3);
    System.out.println("After Deletion of 3: ");
    bst.printTree();



    // Balancing
    bst = new BinarySearchTree();
    bst.insert(20);
    bst.insert(10);
    bst.insert(5);
    bst.insert(11);
    bst.insert(2);
    bst.insert(8);
    bst.insert(15);
    bst.insert(14);
    bst.insert(16);
    bst.insert(13);
    bst.insert(17);

    System.out.println("unbalanced tree: ");
    bst.printTree();

    // Balancing
    bst.balance();
    System.out.println("after Balancing: ");
    bst.printTree();

  }
}
