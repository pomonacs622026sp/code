public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public void insert(Key key, Value val) {
        root = insert(root, key, val);
    }

    private Node insert(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insert(x.left, key, val);
        else if (cmp > 0)
            x.right = insert(x.right, key, val);
        else
            x.val = val;
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);

        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node temp = x;
            x = min(temp.right);
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        x.size = size(x.left) + size(x.right) + 1;

        return x;
    }

    // get the minimum value of the subtree at x
    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    // delete the minimum val
    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1; // recalculate size given size of subtrees plus self
        return x;
    }

    private int size(Node x) {
        return (x == null) ? 0 : x.size;
    }

    public String toString() {
        return buildTreeString(root, 0);
    }

    private String buildTreeString(Node node, int level) {
        if (node == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(level * 4)).append(node.key).append("\n");
        if (node.left != null || node.right != null) {
            sb.append(buildTreeString(node.left, level + 1));
            sb.append(buildTreeString(node.right, level + 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BST<String, Double> bst = new BST<>();

        bst.insert("Date", 3.49);
        bst.insert("Apple", 1.99);
        bst.insert("Elderberry", 4.99);
        bst.insert("Fig", 2.49);
        bst.insert("Banana", 0.99);
        bst.insert("Cherry", 2.99);
        bst.insert("Grape", 2.79);

        System.out.println("BST structure: \n" + bst);

        System.out.println("Price of Cherry: " + bst.get("Cherry")); // Should print 2.99
        System.out.println("Price of Fig: " + bst.get("Fig")); // Should print 2.49
        System.out.println("Price of Mango: " + bst.get("Mango")); // Should print "null"
        bst.delete("Cherry");

        bst.delete("Date");
        System.out.println("BST structure after deleting date: \n" + bst);

        bst.insert("Grape", 99.99);
        System.out.println("Updating grapes due to inflation: " + bst.get("Grape")); // Should print 99.99

    }
}
