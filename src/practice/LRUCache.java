package practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private final int capacity;
  private static LLNode head = null;
  private static LLNode tail = null;
  private Map<Integer, LLNode> map = new HashMap<>();

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public void setNode(int key){
    if(map.containsKey(key)){
      //getNode from Map
      LLNode fetchedNode = map.get(key);
      //removeNode(fetchedNode)
      removeNode(fetchedNode);
      //setHead(fetchedNode)
      setHead(fetchedNode);
    }
    else{
      //createNewNode
      LLNode newNode = new LLNode(key);
      if(map.size() >= this.capacity){
        map.remove(tail.key);
        //removeNodeTail
        removeNode(tail);
        
      }
      setHead(newNode);
      map.put(key, newNode);
    }
  }

  public Integer getNode(int key){
    if(map.containsKey(key)){
      LLNode getNode = map.get(key);
      removeNode(getNode);
      setHead(getNode);
      return key;
    }
    return null;
  }

  private void removeNode(LLNode node){
    if(node.prev != null)
      node.prev.next = node.next;
    else
      head = node.next;

    if(node.next == null)
      tail = node.prev;
    else
      node.next.prev = node.prev;

  }

  public void setHead(LLNode n){
    n.next = head;
    n.prev = null;

    if(head!=null)
      head.prev = n;

    head = n;

    if(tail ==null)
      tail = head;
  }

  public void printCache() {
    LLNode currNode = head;
    while(currNode != null){
      System.out.print(currNode.key+ " ");
      currNode = currNode.next;
    }
    System.out.println("\t\t | Map is->"+map.keySet());
  }

}