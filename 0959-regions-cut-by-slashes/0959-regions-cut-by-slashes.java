class Solution {
      class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = grid[i].charAt(j);

                if (c == ' ') {
                    uf.union(index, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                } else if (c == '/') {
                    uf.union(index, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (c == '\\') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                }

                if (j + 1 < n) {
                    uf.union(index + 1, 4 * (i * n + (j + 1)) + 3);
                }

                if (i + 1 < n) {
                    uf.union(index + 2, 4 * ((i + 1) * n + j));
                }
            }
        }

        return uf.getCount();       
    }
}