class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet dsu = new DisjointSet(26);
        int n = s1.length();
        for(int i = 0; i < n; i++) {
            dsu.union((s1.charAt(i) - 'a'), (s2.charAt(i) - 'a'));
        }
        int len = baseStr.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append((char) (dsu.findParent(baseStr.charAt(i) - 'a') + 'a'));
        }
        String res = sb.toString();
        return res;
    }
}


class DisjointSet {
    int n;
    int[] parent;

    public DisjointSet(int n) {
        parent = new int[n];
        this.n = n;
        makeset();
    }

    public void makeset() {
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    public void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        // if(px < py) {
        //     parent[py] = px;
        // }
        if(px <= py) {
            parent[py] = px;
        }
        // else if(px > py) {
        //     parent[px] = py;
        // }
        else {
            parent[px] = py;
        }
    }
}