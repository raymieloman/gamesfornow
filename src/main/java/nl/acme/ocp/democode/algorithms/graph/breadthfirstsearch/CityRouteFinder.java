package nl.acme.ocp.democode.algorithms.graph.breadthfirstsearch;


import java.util.*;

public class CityRouteFinder {

    // Adjacency list: each city maps to a list of directly connected cities
    private Map<String, List<String>> graph = new HashMap<>();

    // Add a city to the graph (optional, since addRoute does this automatically)
    public void addCity(String city) {
        graph.putIfAbsent(city, new ArrayList<>());
    }

    // Add a bidirectional route between two cities
    public void addRoute(String cityA, String cityB) {
        graph.putIfAbsent(cityA, new ArrayList<>());
        graph.putIfAbsent(cityB, new ArrayList<>());
        graph.get(cityA).add(cityB);
        graph.get(cityB).add(cityA); // remove this line if routes should be one-way
    }

    /**
     * Breadth-First Search to find the shortest path (by number of hops)
     * between a start city and a destination city.
     */
    public List<String> findShortestRoute(String start, String destination) {
        if (!graph.containsKey(start) || !graph.containsKey(destination)) {
            return null; // one of the cities doesn't exist in the graph
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, String> cameFrom = new HashMap<>(); // tracks path back to start
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(destination)) {
                return reconstructPath(cameFrom, start, destination);
            }

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    cameFrom.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return null; // no path found
    }

    // Rebuilds the path from the cameFrom map by walking backwards from destination to start
    private List<String> reconstructPath(Map<String, String> cameFrom, String start, String destination) {
        LinkedList<String> path = new LinkedList<>();
        String current = destination;

        while (!current.equals(start)) {
            path.addFirst(current);
            current = cameFrom.get(current);
        }
        path.addFirst(start);

        return path;
    }

    // Prints all direct connections for every city (useful for debugging)
    public void printGraph() {
        for (String city : graph.keySet()) {
            System.out.println(city + " -> " + graph.get(city));
        }
    }

    public static void main(String[] args) {
        CityRouteFinder network = new CityRouteFinder();

        // Build a small map of cities and direct routes between them
        network.addRoute("Amsterdam", "Rotterdam");
        network.addRoute("Amsterdam", "Utrecht");
        network.addRoute("Rotterdam", "The Hague");
        network.addRoute("Utrecht", "Eindhoven");
        network.addRoute("The Hague", "Eindhoven");
        network.addRoute("Eindhoven", "Maastricht");
        network.addRoute("Utrecht", "Arnhem");
        network.addRoute("Arnhem", "Nijmegen");
        network.addRoute("Nijmegen", "Maastricht");

        System.out.println("City network:");
        network.printGraph();

        String from = "Amsterdam";
        String to = "Maastricht";

        List<String> route = network.findShortestRoute(from, to);

        System.out.println("\nShortest route from " + from + " to " + to + ":");
        if (route != null) {
            System.out.println(String.join(" -> ", route));
            System.out.println("Number of stops: " + (route.size() - 1));
        } else {
            System.out.println("No route found.");
        }

        // Try a route that doesn't exist to show the "no path" case
        network.addCity("Groningen"); // isolated city, no routes added
        List<String> isolatedRoute = network.findShortestRoute("Amsterdam", "Groningen");
        System.out.println("\nRoute from Amsterdam to Groningen:");
        System.out.println(isolatedRoute == null ? "No route found (Groningen is isolated)." : String.join(" -> ", isolatedRoute));
    }
}