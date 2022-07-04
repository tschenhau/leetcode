class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ret = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[i * cols + j] = new int[] { i, j };
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter))
                        - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter));
            }
        });
        return ret;
    }
}

class Solution {
    public:
        int dist(int r1, int c1, int r2, int c2) {
            return abs(r1 - r2) + abs(c1 - c2);
        }

    vector<vector<int>>

    allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
            int maxDist = max(rCenter, rows - 1 - rCenter) + max(cCenter, cols - 1 - cCenter);
            vector<vector<vector<int>>> bucket(maxDist + 1);
    
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int d = dist(i, j, rCenter, cCenter);
                    vector<int> tmp = {i, j};
                    bucket[d].push_back(move(tmp));
                }
            }
            vector<vector<int>> ret;
            for (int i = 0; i <= maxDist; i++) {
                for (auto &it : bucket[i]) {
                    ret.push_back(it);
                }
            }
            return ret;
        }
};

class Solution {
    public:const int dr[4]=
    {1, 1, -1, -1};const int dc[4]=
    {1, -1, -1, 1};

    vector<vector<int>>

    allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
                int maxDist = max(rCenter, rows - 1 - rCenter) + max(cCenter, cols - 1 - cCenter);
                vector<vector<int>> ret;
                int row = rCenter, col = cCenter;
                ret.push_back({row, col});
                for (int dist = 1; dist <= maxDist; dist++) {
                    row--;
                    for (int i = 0; i < 4; i++) {
                        while ((i % 2 == 0 && row != rCenter) || (i % 2 != 0 && col != cCenter)) {
                            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                                ret.push_back({row, col});
                            }
                            row += dr[i];
                            col += dc[i];
                        }
                    }
                }
                return ret;
            }
};
