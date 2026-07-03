package nl.acme.ocp.democode.astar;
import java.util.*;

public class AStar {

    static class Node implements Comparable<Node> {
        int row, col;
        double g; // cost from start
        double h; // heuristic to goal
        Node parent;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        double f() {
            return g + h;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.f(), other.f());
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return row == n.row && col == n.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    // 0 = walkable, 1 = wall
    static int[][] grid;
    static int rows, cols;

    // 4-directional movement (up, down, left, right)
    static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};

    public static List<Node> findPath(int[][] map, int startRow, int startCol, int goalRow, int goalCol) {
        grid = map;
        rows = grid.length;
        cols = grid[0].length;

        Node start = new Node(startRow, startCol);
        Node goal = new Node(goalRow, goalCol);
        start.g = 0;
        start.h = heuristic(start, goal);

        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Map<Node, Node> allNodes = new HashMap<>(); // tracks best-known nodes
        Set<Node> closedSet = new HashSet<>();

        openSet.add(start);
        allNodes.put(start, start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(goal)) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (int[] dir : DIRECTIONS) {
                int nr = current.row + dir[0];
                int nc = current.col + dir[1];

                if (!isValid(nr, nc)) continue;

                Node neighbor = new Node(nr, nc);
                if (closedSet.contains(neighbor)) continue;

                double tentativeG = current.g + 1; // cost of 1 per step

                Node existing = allNodes.get(neighbor);
                if (existing == null || tentativeG < existing.g) {
                    neighbor.g = tentativeG;
                    neighbor.h = heuristic(neighbor, goal);
                    neighbor.parent = current;

                    allNodes.put(neighbor, neighbor);
                    openSet.add(neighbor);
                }
            }
        }

        return null; // no path found
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 0;
    }

    // Manhattan distance (good for 4-directional grids)
    static double heuristic(Node a, Node b) {
        return Math.abs(a.row - b.row) + Math.abs(a.col - b.col);
    }

    static List<Node> reconstructPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] map = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };

        List<Node> path = findPath(map, 0, 0, 4, 4);

        if (path == null) {
            System.out.println("No path found.");
        } else {
            System.out.println("Path found:");
            for (Node n : path) {
                System.out.println("(" + n.row + ", " + n.col + ")");
            }
            visualize(map, path);
        }
    }

    static void visualize(int[][] map, List<Node> path) {
        char[][] display = new char[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                display[r][c] = (map[r][c] == 1) ? '#' : '.';

        for (Node n : path) display[n.row][n.col] = '*';

        System.out.println("\nVisualized path:");
        for (char[] row : display) {
            System.out.println(new String(row));
        }
    }
}