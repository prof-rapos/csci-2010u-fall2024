import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

  HashMap<String, ArrayList<String>> adjacencyList;

  public Graph() {
    adjacencyList = new HashMap<String, ArrayList<String>>();
  }

  public void addVertex(String key) {
    adjacencyList.putIfAbsent(key, new ArrayList<String>());
  }

  public void addEdge(String v1, String v2) {
    adjacencyList.get(v1).add(v2);
    adjacencyList.get(v2).add(v1);
  }

  public void print() {
    for(String vertex : adjacencyList.keySet()) {
      System.out.println(vertex + " -> " + adjacencyList.get(vertex));
    }
  }

  public void bfs(String start) {
    Queue<String> queue = new LinkedList<String>();
    ArrayList<String> visited = new ArrayList<String>();

    queue.offer(start);
    visited.add(start);

    while(!queue.isEmpty()) {
      String current = queue.poll();
      visited.add(current);
      System.out.println(current);

      for(String s : adjacencyList.get(current)) {
        if(!visited.contains(s)) {
          queue.offer(s);
          visited.add(s);
        }
      }
    }

  }

  public ArrayList<ArrayList<String>> dfs(String current, ArrayList<String> visited, ArrayList<ArrayList<String>> paths) {
    // Add current node to the visited path
    visited.add(current);

    // Add the current path as a valid path (you may exclude trivial paths like single-node paths if needed)
    paths.add(new ArrayList<>(visited));

    // Recur for all neighbors of the current node
    for (String neighbor : adjacencyList.get(current)) {
      if (!visited.contains(neighbor)) { // Avoid revisiting nodes to prevent cycles
        dfs(neighbor, visited, paths);
      }
    }

    // Backtrack: Remove the current node from the visited path
    visited.remove(visited.size() - 1);

    return paths;
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

    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("A", "F");
    graph.addEdge("B", "C");
    graph.addEdge("C", "D");
    graph.addEdge("C", "E");
    graph.addEdge("D", "E");
    graph.addEdge("D", "F");
    graph.addEdge("D", "G");
    graph.addEdge("E", "F");

    ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
    graph.dfs("A", new ArrayList<String>(), paths);

    for (ArrayList<String> path : paths) {
      System.out.println(path);
    }

  }
}