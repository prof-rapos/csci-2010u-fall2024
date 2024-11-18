import java.lang.reflect.Array;
import java.util.*;

public class Graph {

  HashMap<String, ArrayList<String>> adjacencyList;

  public Graph() {
    adjacencyList = new HashMap<String, ArrayList<String>>();
  }

  public void addVertex(String value) {
    adjacencyList.putIfAbsent(value, new ArrayList<String>());
  }

  public void addEdge(String v1, String v2) {
    adjacencyList.get(v1).add(v2);
    adjacencyList.get(v2).add(v1);
  }

  public void bfs(String start) {
    Queue<String> queue = new LinkedList<String>();
    ArrayList<String> visited = new ArrayList<String>();

    queue.offer(start);
    visited.add(start);

    while(!queue.isEmpty()) {
      String current = queue.poll();
      System.out.println(current);

      for(String neighbour : adjacencyList.get(current)) {
        if(!visited.contains(neighbour)) {
          queue.offer(neighbour);
          visited.add(neighbour);
        }
      }
    }

  }

  public void dfs(String start, ArrayList<String> visited) {
    if(visited.contains(start)) {
      return;
    }
    System.out.println(start);
    visited.add(start);

    for(String neighbour : adjacencyList.get(start)){
      dfs(neighbour, visited);
    }

  }

  public void print() {
    for(String key : adjacencyList.keySet()) {
      System.out.println(key + " -> " + adjacencyList.get(key));
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

    graph.dfs("A", new ArrayList<String>());

  }













}