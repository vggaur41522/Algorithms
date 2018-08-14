package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> {

  private boolean isDirected;
  private Map<Integer, Vertex<T>> allVertices;
  
  public Collection<Vertex<T>> getAllVertices(){
    return allVertices.values();
  }
  public Graph(boolean isDirected){
    this.isDirected = isDirected;
    allVertices = new HashMap<>();
  }
  
  public void addEdge(int id1, int id2){
    addEgde(id1, id2, 0);
  }
  
  public void addEgde(int id1, int id2, int weight){
    Vertex<T> v1 = null;
    if(allVertices.containsKey(id1)){
      v1 = allVertices.get(id1);
    }
    else{
      v1 = new Vertex<T>(id1);
      allVertices.put(id1, v1);
    }
    
    Vertex<T> v2 = null;
    if(allVertices.containsKey(id2)){
      v2 = allVertices.get(id2);
    }
    else{
      v2 = new Vertex<T>(id2);
      allVertices.put(id2, v2);
    }
    v1.addAdjancentVertex(v2);
    if(!isDirected){
      v2.addAdjancentVertex(v1);
    }
  }
  
  public void setDataForVertex(int id, T data){
    if(allVertices.containsKey(id)){
      Vertex<T> v = allVertices.get(id);
      v.setData(data);
    }
  }
  
  public Vertex<T> getVertexFromPool(int id){
    return allVertices.get(id);
  }
  
}
