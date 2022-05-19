package disjointset;

public class QuickUnionDisjointSet {

    private int[] root;

    public QuickUnionDisjointSet(int size) {
        this.root = new int[size];
        for (int i = 0; i < size ; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        if(root[x] == x)
            return root[x];

        return find(root[x]);

    }

    public void union(int x, int y){

        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        QuickUnionDisjointSet ds = new QuickUnionDisjointSet(10);
        // 1-2-5-6-7 3-8-9 4
        ds.union(1, 2);
        ds.union(2, 5);
        ds.union(5, 6);
        ds.union(6, 7);
        ds.union(3, 8);
        ds.union(8, 9);
        System.out.println(ds.connected(1, 5)); // true
        System.out.println(ds.connected(5, 7)); // true
        System.out.println(ds.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        ds.union(9, 4);
        System.out.println(ds.connected(4, 9)); // true

    }
}
