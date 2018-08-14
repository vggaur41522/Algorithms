package unionFindDisjointSet;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
  private Map<Integer, Node> map = new HashMap<>();
  
  class Node{
    int data;
    Node parent;
    int rank;
  }
  
  public void makeSet(int data){
    Node node = new Node();
    node.data = data;
    node.parent = node;
    node.rank = 0;
    map.put(data, node);
  }
  
  public int findSet(int data){
    return findSet(map.get(data)).data;
  }

  // It has compression for better access !!!!
  private Node findSet(Node node){
    Node parent = node.parent;
    if(parent == node){
      return parent;
    }
    node.parent = findSet(node.parent);
    return node.parent;
  }
  
  public boolean union(int data1, int data2){
    Node node1 = map.get(data1);
    Node node2 = map.get(data2);
    
    Node parent1 = findSet(node1);
    Node parent2 = findSet(node2);
    
    if(parent1 == parent2)
      return true;
    
    if(parent1.rank >= parent2.rank){
      parent1.rank = (parent1.rank==parent2.rank)?parent1.rank + 1: parent1.rank;
      parent2.parent = parent1;
    }
    else{
      parent1.parent = parent2;
    }
    return false;
  }
}
