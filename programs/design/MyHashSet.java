package design;

import java.util.LinkedList;

/*

       Design a HashSet without using any built-in hash table libraries.


        Implement MyHashSet class:

        void add(key) Inserts the value key into the HashSet.
        bool contains(key) Returns whether the value key exists in the HashSet or not.
        void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


        Example 1:

        Input
        ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
        [[], [1], [2], [1], [3], [2], [2], [2], [2]]
        Output
        [null, null, null, true, false, null, true, null, false]

        Explanation
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)

*/

public class MyHashSet {
    private Bucket[] bucket;
    private int keyRange;

    public MyHashSet() {
        this.keyRange = 769;
        this.bucket = new Bucket[this.keyRange];
        for(int i=0; i< this.keyRange; i++){
            this.bucket[i] = new Bucket();
        }

    }

    protected int _hash(int key){
        return (key % this.keyRange);
    }

    public void add(int key) {
        int index = this._hash(key);
        this.bucket[index].insert(key);

    }

    public void remove(int key) {
        int index = this._hash(key);
        this.bucket[index].delete(key);

    }

    public boolean contains(int key) {
        int index = this._hash(key);
        return this.bucket[index].exists(key);
    }
}

class Bucket{
    LinkedList<Integer> container;

    public Bucket(){
        container = new LinkedList<>();
    }

    public void insert(int key) {
        if(container.indexOf(key) == -1)
            container.addFirst(key);
    }

    public void delete(Integer key) {
        this.container.remove(key);
    }

    public boolean exists(int key) {
        int index =  container.indexOf(key);
        return (index != -1);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));  // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));// return False, (already removed)
    }
}