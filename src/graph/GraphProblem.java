package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphProblem {

  public static void main(String[] args) {
    GraphProblem gProb = new GraphProblem();
    Graph<String> g1 = gProb.createGraph();
    
    // Graph traversal 
    // BFS for un connected graph
    System.out.println("\nBFS All vertices-->");
    gProb.bfs(g1);
    System.out.println("\nBFS starting vertex: 5-->");
    gProb.bfs(g1,5);
    // BFS for connected and accesible graph
    System.out.println("\nDFS starting vertex: 5-->");
    gProb.dfs(g1,5);
    System.out.println("\nTopological Sort-->");
    Deque<Vertex<String>> stack = gProb.topologicalSort(g1);
    while(!stack.isEmpty()){
      System.out.print(stack.pop()+ " ");
    }
  }
  
  private Deque<Vertex<String>> topologicalSort(Graph<String> g){
    Set<Integer> visited = new HashSet<>();
    Deque<Vertex<String>> stack = new ArrayDeque<>();
    for(Vertex<String> currentVertex: g.getAllVertices()){
      if(!visited.contains(currentVertex.getId())){
        topologicalSortUtil(currentVertex, stack, visited);
      }
    }
    return stack;
  }

  private void topologicalSortUtil(Vertex<String> currentVertex, Deque<Vertex<String>> stack, Set<Integer> visited) {
    visited.add(currentVertex.getId());
    for(Vertex<String> v: currentVertex.getAdjVertex()){
      if(!visited.contains(v.getId())){
        topologicalSortUtil(v, stack, visited);
      }
    }
    stack.push(currentVertex);
  }

  private void dfs(Graph<String> g, int startingVertexId) {
    Set<Integer> visited = new HashSet<>();
    DFSUtil(g.getVertexFromPool(startingVertexId), visited);
  }

  private void DFSUtil(Vertex<String> currVertex, Set<Integer> visited) {
    visited.add(currVertex.getId());
    System.out.print("|"+ currVertex.getId() + " ");
    for(Vertex<String> v: currVertex.getAdjVertex()){
      if(!visited.contains(v)){
        DFSUtil(v, visited);
      }
    }
  }

  private void bfs(Graph<String> g, int startingVertexId) {
    Set<Integer> visited = new HashSet<>();
    Queue<Vertex<String>> queue = new LinkedList<>();
    Vertex<String> startVertex = g.getVertexFromPool(startingVertexId);
    queue.offer(startVertex);
    visited.add(startingVertexId);
    while(!queue.isEmpty()){
      Vertex<String> currentVertex = queue.poll();
      System.out.println(currentVertex.getId());
        for(Vertex<String> v: currentVertex.getAdjVertex()){
          if(!visited.contains(v.getId())){
            queue.offer(v);
            visited.add(v.getId());
          }
      }
    }
  }

  private void bfs(Graph<String> g1) {
    Set<Integer> visited = new HashSet<>();
    Queue<Vertex<String>> queue = new LinkedList<>();
    for(Vertex<String> currentVertex: g1.getAllVertices()){
      if(!visited.contains(currentVertex.getId())){
        queue.offer(currentVertex);
        visited.add(currentVertex.getId());
        while(!queue.isEmpty()){
          Vertex<String> vertexFromQueue = queue.poll();
          System.out.print(vertexFromQueue.getId()+ " ");
          for(Vertex v: vertexFromQueue.getAdjVertex()){
            if(!visited.contains(v.getId())){
              queue.offer(v);
              visited.add(v.getId());
            }
          }
        }
      }
    }
  }

  private Graph<String> createGraph() {
    Graph<String> g = new Graph<>(true);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    //Setting Data for vertices
    g.setDataForVertex(0, "V-1");
    g.setDataForVertex(1, "V-2");
    g.setDataForVertex(2, "V-3");
    g.setDataForVertex(3, "V-4");
    
    
    Graph<String> g2 = new Graph<>(true);
    g2.addEdge(5, 0);
    g2.addEdge(5, 2);
    g2.addEdge(2, 3);
    g2.addEdge(3, 1);
    g2.addEdge(4, 0);
    g2.addEdge(4, 1);

    return g2;
  }

}
