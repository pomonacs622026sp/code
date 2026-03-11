public class BinaryTree<T extends Comparable<T>> {

    private static class Node<E> {
        E key;
        Node<E> left;
        Node<E> right;

        Node(E key) {
            this.key = key;
        }
    }

    private Node<T> root;

    /**
     * Inserts a new key into the binary tree. This method inserts the specified key
     * into the binary tree by delegating
     * to the recursive insertion method. If the tree is empty, the key becomes the
     * root. Otherwise, it is placed in the
     * appropriate position according to the binary search tree property.
     *
     * @param key the key to be inserted into the tree
     */
    public void insert(T key) {
        root = insertRecursive(root, key);
    }

    private Node<T> insertRecursive(Node<T> node, T key) {
        if (node == null) {
            return new Node<>(key);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = insertRecursive(node.left, key);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, key);
        } else {
            // Key already exists — you can decide to ignore or handle duplicates
            // For now, do nothing.
        }
        return node;
    }

    /**
     * Determines whether this binary tree contains a node whose value equals the
     * given key. This method delegates to a
     * recursive search starting at the root node.
     *
     * @param key the value to search for in the tree
     * @return true if the key exists in the tree; false otherwise
     */
    public boolean searchRecursive(T key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node<T> node, T key) {
        if (node == null) {
            return false;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return searchRecursive(node.left, key);
        } else if (cmp > 0) {
            return searchRecursive(node.right, key);
        } else {
            return true;
        }
    }

    /**
     * Searches for a key in the binary search tree using an iterative approach.
     *
     * @param key the key to search for in the tree
     * @return true if the key is found in the tree, false otherwise
     * @throws NullPointerException if the key is null
     */
    public boolean searchIterative(T key) {
        Node<T> current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    /**
     * Performs an in-order traversal of the binary tree. In-order traversal visits
     * nodes in the following order: left
     * subtree, current node, right subtree. For a binary search tree, this results
     * in visiting nodes in ascending
     * order.
     */
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node<T> node) {
        if (node == null)
            return;
        inorderRecursive(node.left);
        System.out.print(node.key + " ");
        inorderRecursive(node.right);
    }

    /**
     * Performs a preorder traversal of this binary tree and prints each visited
     * node in preorder sequence (root, left
     * subtree, right subtree). This method delegates traversal to a recursive
     * helper starting at the root, then prints
     * a trailing newline after traversal output.
     */
    public void preorderTraversal() {
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(Node<T> node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }

    /**
     * Performs a postorder traversal of this binary tree and prints each visited
     * node in postorder sequence (left
     * subtree, right subtree, root). This method delegates traversal to a recursive
     * helper starting at the root, then
     * prints a trailing newline after traversal output.
     */
    public void postorderTraversal() {
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(Node<T> node) {
        if (node == null)
            return;
        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.key + " ");
    }

    /**
     * The main method serves as an entry point to demonstrate the functionality of
     * the BinaryTree class. It creates a
     * binary tree, inserts several integer values, and then performs in-order,
     * pre-order, and post-order traversals to
     * display the structure of the tree. Finally, it checks for the presence of
     * specific values in the tree and prints
     * the results.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Insert some values
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(9);

        System.out.print("Inorder:   ");
        tree.inorderTraversal();

        System.out.print("Preorder:  ");
        tree.preorderTraversal();

        System.out.print("Postorder: ");
        tree.postorderTraversal();

        System.out.println("Contains 4? " + tree.searchRecursive(4));
        System.out.println("Contains 8? " + tree.searchRecursive(8));
    }
}
