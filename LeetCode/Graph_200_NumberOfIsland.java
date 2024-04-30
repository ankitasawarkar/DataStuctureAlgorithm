import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class Graph_200_NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };

    Solution1 solution = new Solution1();
    int numIslands = solution.numIslands(grid);
    System.out.println("Solution1: Number of islands: " + numIslands);

    Solution2 solution2 = new Solution2();
    int numIslands2 = solution2.numIslands(grid);
    System.out.println("Solution2: Number of islands: " + numIslands2);
    }
}

class Solution1{

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> visited = new HashSet<>();
        int island = 0;

        if (grid.length == 0) {
            return 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r + "-" + c)) {
                    bfs(grid, r, c, visited, queue, directions);
                    island++;
                }
            }
        }
        return island;
    }

    private void bfs(char[][] grid, int row, int col, Set<String> visited, Queue<int[]> queue, int[][] directions) {
        int rows = grid.length;
        int cols = grid[0].length;

        visited.add(row + "-" + col);
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for (int[] direction : directions) {
                int r = currentRow + direction[0];
                int c = currentCol + direction[1];

                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == '1' && !visited.contains(r + "-" + c)) {
                    queue.add(new int[]{r, c});
                    visited.add(r + "-" + c);
                }
            }
        }
    }
    
}

class Solution2{

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[] count = new int[1]; // Counter for islands

        // Perform DFS on each cell
        IntStream.range(0, rows).forEach(r ->
                IntStream.range(0, cols).forEach(c -> {
                    if (grid[r][c] == '1') {
                        dfs(grid, r, c);
                        count[0]++;
                    }
                }));

        return count[0];
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != '1') return;

        grid[row][col] = '0'; // Mark as visited

        // Explore adjacent cells
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }
}