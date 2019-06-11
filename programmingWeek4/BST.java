package programmingWeek4;

public class BST<Key extends Comparable<Key>> {
    private Node root;   // root of BST
    int n;
    
    public BST(int n) {
    	this.n = n;
    }

    private class Node {
        private final Key key;       // sorted by key
        private int val = 1;           // associated data
        private Node left, right;    // left and right subtrees
       

        public Node(Key key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
        
    public void put(Key key, int val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == 0) {
            return;
        }
        root = put(root, key, val);
        
    }

    private Node put(Node x, Key key, int val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else  x.val += val;
       
        return x;
    }
}
