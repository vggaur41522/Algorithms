package trie;

import java.util.*;

public class TrieNode {
  private char item;
  private Map<Character, TrieNode> child ;
  private String fullWord;
  
  public TrieNode(char c){
    this.item = c;
    child = new HashMap<>();
  }

  public char getItem() {
    return item;
  }

  public void setItem(char item) {
    this.item = item;
  }

  public Map<Character, TrieNode> getChild() {
    return child;
  }

  public void setChild(Map<Character, TrieNode> child) {
    this.child = child;
  }

  public String getFullWord() {
    return fullWord;
  }

  public void setFullWord(String fullWord) {
    this.fullWord = fullWord;
  }
  
}