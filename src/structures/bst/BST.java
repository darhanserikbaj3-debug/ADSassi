package structures.bst;
import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.Node> {
    private Node root;
    private int size = 0;

    public class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        public K getKey() { return key; }
        public V getValue() { return val; }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

   
    public int size() {
        return size;
    }

    private Node put(Node x, K key, V val) {
        if (x == null) { size++; return new Node(key, val); }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node>() {
            private Stack<Node> stack = new Stack<>();
            { pushLeft(root); }

            private void pushLeft(Node node) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            @Override
            public boolean hasNext() { return !stack.isEmpty(); }

            @Override
            public Node next() {
                Node node = stack.pop();
                pushLeft(node.right);
                return node;
            }
        };
    }
}