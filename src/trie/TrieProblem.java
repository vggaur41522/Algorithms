package trie;

import java.util.*;

public class TrieProblem {
  private TrieNode root;
  public static void main(String[] args) {
    TrieProblem tProb = new TrieProblem();
    TrieNode root = new TrieNode('#');
    String[] words = {"oath","pea","eat","rain"};
    root = tProb.createTrie(root, words);
    tProb.printTrie(root, new ArrayList<String>());
    tProb.startWith(root, "oa");
    char[][] board = {
        {'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}  
    };
    tProb.findWords(board, words);
  }
  
  private void findWords(char[][] board, String[] words) {
    TrieNode node = new TrieNode('#');
    Set<String> res = new HashSet<>();
    root = createTrie(node, words);
    int rows = board.length;
    int cols = board[0].length;
    
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        dfsUtil(root, board, i, j, rows, cols, res);
      }
    }
    System.out.println(res);
  }

  private void dfsUtil(TrieNode node, char[][] board, int i, int j, int rows, int cols, Set<String> res) {
    char c = board[i][j];
    if(c == '#' || !node.getChild().containsKey(c)) return;
    node = node.getChild().get(c);
    if(node.getFullWord() != null){
      res.add(node.getFullWord());
    }
    board[i][j] = '#';
    if (i > 0) dfsUtil(node, board, i - 1, j, rows, cols, res); 
    if (j > 0) dfsUtil(node, board, i, j-1, rows, cols, res); 
    if (i < board.length - 1) dfsUtil(node, board, i + 1, j, rows, cols, res); 
    if (j < board[0].length - 1) dfsUtil(node, board, i, j+1, rows, cols, res);
    
    board[i][j] = c;
  }

  private void printTrie(TrieNode root, List<String> resultArray){
    Queue<TrieNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      TrieNode currNode = queue.poll();
      System.out.println(currNode.getItem());
      if(currNode.getFullWord() != null ){
        System.out.println("--->"+currNode.getFullWord());
        resultArray.add(currNode.getFullWord());
      }
      for(TrieNode childNode: currNode.getChild().values()){
        queue.offer(childNode);
      }
    }
  }
  
  private List<String> startWith(TrieNode root, String prefix){
    List<String> result = new ArrayList<>();
    TrieNode currNode = root;
    for(char c: prefix.toCharArray()){
      if(!currNode.getChild().containsKey(c)){
        return result;
      }
      currNode = currNode.getChild().get(c);
    }
    printTrie(currNode, result);
    System.out.println(result);
    return result;
  }
  
  private TrieNode createTrie(TrieNode root, String[] words) {
//    root = new TrieNode('#');
    for(String word: words){
      TrieNode currRoot = root;
      for(char c: word.toCharArray()){
        if(currRoot.getChild().containsKey(c)){
          currRoot = currRoot.getChild().get(c);
        }
        else{
          TrieNode t = new TrieNode(c);
          currRoot.getChild().put(c, t);
          currRoot = t;
        }
      }
      currRoot.setFullWord(word);
    }
    return root;
  }
}
