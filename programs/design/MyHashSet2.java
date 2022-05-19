package design;

/*
        Approach 2: Binary Search Tree (BST) as Bucket
Intuition

In the above approach, one of the drawbacks is that we have to scan the entire linkedlist in order to verify if a value already exists in the bucket (i.e. the lookup operation).

To optimize the above process, one of the strategies could be that we maintain a sorted list as the bucket. With the sorted list, we could obtain the \mathcal{O}(\log{N})O(logN) time complexity for the lookup operation, with the binary search algorithm, rather than a linear \mathcal{O}({N})O(N) complexity as in the above approach.

On the other hand, if we implement the sorted list in a continuous space such as Array, it would incur a linear time complexity for the update operations (e.g. insert and delete), since we would need to shift the elements.

So the question is can we have a data structure that have \mathcal{O}(\log{N})O(logN) time complexity, for the operations of search, insert and delete ?

Well. The answer is yes, with Binary Search Tree (BST). Thanks to the properties of BST, we could optimize the time complexity of our first approach with LinkedList.



 */
public class MyHashSet2 {
    private Bucket2[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public MyHashSet2() {
        this.keyRange = 769;
        this.bucketArray = new Bucket2[this.keyRange];
        for (int i = 0; i < this.keyRange; ++i)
            this.bucketArray[i] = new Bucket2();
    }

    protected int _hash(int key) {
        return (key % this.keyRange);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }
}


class Bucket2 {
    private BSTree tree;

    public Bucket2() {
        tree = new BSTree();
    }

    public void insert(Integer key) {
        this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
    }

    public void delete(Integer key) {
        this.tree.root = this.tree.deleteNode(this.tree.root, key);
    }

    public boolean exists(Integer key) {
        TreeNode node = this.tree.searchBST(this.tree.root, key);
        return (node != null);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class BSTree {
    TreeNode root = null;

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val)
            return root;

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val > root.val)
            // insert into the right subtree
            root.right = insertIntoBST(root.right, val);
        else if (val == root.val)
            // skip the insertion
            return root;
        else
            // insert into the left subtree
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    /*
     * One step right and then always left
     */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    /*
     * One step left and then always right
     */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        // delete from the right subtree
        if (key > root.val)
            root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null)
                root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */