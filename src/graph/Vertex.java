package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
  private int id;
  private T data;
  private List<Vertex<T>> adjVertices;
  
  public Vertex(int id){
    this.id = id;
    adjVertices = new ArrayList<>();
  }
  
  public void setData(T data){
    this.data = data;
  }
  
  public T getData(){
    return this.data;
  }
  
  public void addAdjancentVertex(Vertex<T> v2){
    this.adjVertices.add(v2);
  }
  
  public List<Vertex<T>> getAdjVertex(){
    return this.adjVertices;
  }
  
  public int getId(){
    return this.id;
  }
  
  public String toString(){
    return Integer.toString(this.id);
  }
}
