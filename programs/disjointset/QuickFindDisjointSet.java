package disjointset;

public class QuickFindDisjointSet {

    private int[] root;

    public QuickFindDisjointSet(int size) {
        this.root = new int[size];
        for (int i = 0; i < size ; i++) {
            root[i] = i;
        }
    }

    public int find(int i) {
        return root[i];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            for(int i = 0; i < root.length ; i++){
                if( root[i] == rootY)
                    root[i] = rootX;
            }
        }
    }

    public boolean connected(int x, int y){
        return root[x] == root[y];
    }

    public static void main(String[] args) {
        QuickFindDisjointSet ds = new QuickFindDisjointSet(10);
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
