import java.util.*;

class riedl {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> findShortestPath(int[][] grid, int startX, int startY, int goalX, int goalY) {
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(distance[i], Integer.MAX_VALUE);

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        distance[startX][startY] = 0;
        Point[][] parent = new Point[rows][cols];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int[] dir : directions) {
                int newX = current.x + dir[0], newY = current.y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 0 && distance[newX][newY] == Integer.MAX_VALUE) {
                    queue.add(new Point(newX, newY));
                    distance[newX][newY] = distance[current.x][current.y] + 1;
                    parent[newX][newY] = current;
                }
            }
        }

        List<Point> path = new ArrayList<>();
        for (Point p = new Point(goalX, goalY); p != null; p = parent[p.x][p.y]) {
            path.add(p);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        List<Point> path = findShortestPath(grid, 0, 0, 4, 4);
        System.out.println("Shortest Path:");
        for (Point p : path) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
