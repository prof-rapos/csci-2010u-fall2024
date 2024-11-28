import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {

  private class Edge {
    String target;
    int weight;

    private Edge(String target, int weight) {
      this.target = target;
      this.weight = weight;
    }

    public String toString(){
      return this.target + "(" + this.weight + ")";
    }

  }

  HashMap<String, ArrayList<Edge>> adjacencyList;

  public Graph(){
    adjacencyList = new HashMap<String, ArrayList<Edge>>();
  }

  public void addVertex(String vertex) {
    adjacencyList.putIfAbsent(vertex, new ArrayList<Edge>());
  }

  public void addEdge(String from, String to, int weight) {
    adjacencyList.get(from).add(new Edge(to, weight));
  }

  public void print() {
    for(String vertex : adjacencyList.keySet()) {
      System.out.println(vertex + " -> " + adjacencyList.get(vertex));
    }
  }
  public Map<String, Integer> dijkstra(String start) {
    Map<String, Integer> distances = new HashMap<>(); // distances from start
    ArrayList<String> visited = new ArrayList<>(); // vertices visited
    Map<String, ArrayList<Edge>> graph = adjacencyList; // the graph

    for (String node : graph.keySet()) {
      distances.put(node, Integer.MAX_VALUE);		//initialize the distances
    }
    distances.put(start, 0);

    while (visited.size() < graph.size()) {		//while there are vertices left to visit
      String closestNode = null;
      int smallest = Integer.MAX_VALUE;
      for (String node : distances.keySet()) {	// find the closest unvisited vertex, initially start
        if (!visited.contains(node) && distances.get(node) < smallest) {
          closestNode = node;
          smallest = distances.get(node);
        }
      }
      if (closestNode == null) break;
      visited.add(closestNode);				// mark vertex as visited
      for (Edge neighbor : graph.getOrDefault(closestNode, new ArrayList<>())) { 	// for each neighbour
        if (!visited.contains(neighbor.target)) {						// if not visited
          int newDist = distances.get(closestNode) + neighbor.weight;		// update distances
          if (newDist < distances.get(neighbor.target)) {
            distances.put(neighbor.target, newDist);
          }
        }
      }
    }
    return distances;
  }

  public void shortestPaths(String start) {
    Map<String, Integer> paths = dijkstra(start);
    System.out.println("The shortest paths from " + start + " to:");
    for(String vertex : paths.keySet()) {
      System.out.println("\t" + vertex + ": " + paths.get(vertex));
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph();

    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addVertex("E");
    graph.addVertex("F");
    graph.addVertex("G");

    graph.addEdge("A", "B", 1);
    graph.addEdge("A", "F", 1);
    graph.addEdge("B", "C", 4);
    graph.addEdge("C", "A", 1);
    graph.addEdge("C", "E", 2);
    graph.addEdge("C", "D", 3);
    graph.addEdge("D", "E", 1);
    graph.addEdge("D", "F", 3);
    graph.addEdge("D", "G", 1);
    graph.addEdge("E", "F", 1);
    graph.addEdge("F", "D", 1);

    graph.shortestPaths("A");

  }












}