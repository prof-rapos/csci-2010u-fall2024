class AVLTree {

  class Node {
    int key, height;
    Node left, right;

    Node(int key) {
      this.key = key;
      this.height = 1;
    }
  }

  private Node root;

  // Get the height of the node
  int height(Node node) {
    return node == null ? 0 : node.height;
  }

  // Get the balance factor of the node
  int getBalance(Node node) {
    return node == null ? 0 : height(node.left) - height(node.right);
  }

  // Right rotate subtree rooted with y
  Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    // Perform rotation
    x.right = y;
    y.left = T2;

    // Update heights
    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    return x;
  }

  // Left rotate subtree rooted with x
  Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // Perform rotation
    y.left = x;
    x.right = T2;

    // Update heights
    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    return y;
  }

  // Insert a node
  Node insert(Node node, int key) {
    // Perform standard BST insertion
    if (node == null) return new Node(key);

    if (key < node.key) {
      node.left = insert(node.left, key);
    } else if (key > node.key) {
      node.right = insert(node.right, key);
    } else {
      return node; // Duplicate keys not allowed
    }

    // Update height of this ancestor node
    node.height = 1 + Math.max(height(node.left), height(node.right));

    // Get the balance factor to check if it became unbalanced
    int balance = getBalance(node);

    // Left Left Case
    if (balance > 1 && key < node.left.key) return rightRotate(node);

    // Right Right Case
    if (balance < -1 && key > node.right.key) return leftRotate(node);

    // Left Right Case
    if (balance > 1 && key > node.left.key) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    // Right Left Case
    if (balance < -1 && key < node.right.key) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    return node;
  }

  // Wrapper method for inserting a node
  public void insert(int key) {
    root = insert(root, key);
  }

  // Print the tree in-order
  void inOrder(Node node) {
    if (node != null) {
      inOrder(node.left);
      System.out.print(node.key + " ");
      inOrder(node.right);
    }
  }

  public void printInOrder() {
    inOrder(root);
    System.out.println();
  }

  // Extension: Delete a node
  Node delete(Node root, int key) {
    if (root == null) return root;

    if (key < root.key) {
      root.left = delete(root.left, key);
    } else if (key > root.key) {
      root.right = delete(root.right, key);
    } else {
      if ((root.left == null) || (root.right == null)) {
        Node temp = (root.left != null) ? root.left : root.right;
        if (temp == null) {
          root = null;
        } else {
          root = temp;
        }
      } else {
        Node temp = minValueNode(root.right);
        root.key = temp.key;
        root.right = delete(root.right, temp.key);
      }
    }

    if (root == null) return root;

    root.height = Math.max(height(root.left), height(root.right)) + 1;
    int balance = getBalance(root);

    // Balance the tree if needed
    if (balance > 1 && getBalance(root.left) >= 0) return rightRotate(root);
    if (balance > 1 && getBalance(root.left) < 0) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }
    if (balance < -1 && getBalance(root.right) <= 0) return leftRotate(root);
    if (balance < -1 && getBalance(root.right) > 0) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

    return root;
  }

  // Helper function to get the node with the smallest key value
  Node minValueNode(Node node) {
    Node current = node;
    while (current.left != null) current = current.left;
    return current;
  }

  // Wrapper method for deleting a node
  public void delete(int key) {
    root = delete(root, key);
  }
}
