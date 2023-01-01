package edu.yu.introtoalgs;

public class UnionFind {
    private int[] id;

    private int[] incompatible;

    private int[] sz;
    private int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            sz[i] = 1;
        }
    }

    public int count () {
        return count;
    }
    public boolean connected (int p, int q) {
        return find(p) == find(q);
    }
    public void union(int x, int y){
        int i = find(x);
        int j = find(y);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    // Setting 2 nodes incompatible do a find on x and a find on y and

    public int find(int p){
        while (p != id[p]) {
            id [p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
