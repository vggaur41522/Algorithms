package practice;

public class LLNode{
  public int key;
  public LLNode next;
  public LLNode prev;
  
  public LLNode(int key) {
    this.key = key;
    this.next = null;
    this.prev = null;
  }
}