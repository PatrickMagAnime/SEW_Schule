import java.util.*;

class ShortestFloodPathfinder {

    static class Point {
        int x, y, distance;

        Point(int x, int y, int distance) {
            //definition of y and x-axis + distance
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
//list with object called Point(current class) saves a 2D array
    public static List<Point> findShortestPath(int[][] grid, int startX, int startY, int goalX, int goalY) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Directions: Down, Up, Right, Left
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Distance array to track the shortest path
        int[][] distance = new int[rows][cols];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

        // Parent map to reconstruct the path
        Map<String, Point> parentMap = new HashMap<>();

        //queue: you can add things and use them later
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 0));
        distance[startX][startY] = 0;

        while (!queue.isEmpty()) { //while loop if queue is full
            Point current = queue.poll(); //poll is the output of sth
            int x = current.x, y = current.y, dist = current.distance;

            // Stop if goal is reached
            if (x == goalX && y == goalY) break;

            for (int[] dir : directions) { //goes through the array and changes directions + -
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValid(newX, newY, rows, cols, grid, distance, dist + 1)) {
                    queue.add(new Point(newX, newY, dist + 1));
                    distance[newX][newY] = dist + 1;
                    parentMap.put(newX + "," + newY, new Point(x, y, dist)); // Store the previous step
                }
            }
        }

        // Reconstruct the shortest path
        List<Point> path = new ArrayList<>();
        Point current = new Point(goalX, goalY, 0);
        while (current != null) {
            path.add(current);
            current = parentMap.get(current.x + "," + current.y); //output to console
        }

        Collections.reverse(path);
        return path; //output for reading
    }

    private static boolean isValid(int x, int y, int rows, int cols, int[][] grid, int[][] distance, int newDist) {
        return x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 0 && newDist < distance[x][y];
    } // this method checks if any obstacles are in the grid

    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print((cell == Integer.MAX_VALUE ? "X" : cell) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows = 5, cols = 5;
        //grid
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int startX = 0, startY = 0;
        int goalX = 4, goalY = 4;

        List<Point> path = findShortestPath(grid, startX, startY, goalX, goalY);

        // Print the shortest path
        System.out.println("Shortest Path:");
        for (Point p : path) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
