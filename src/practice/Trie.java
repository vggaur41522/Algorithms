package practice;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.Function;
import java.util.stream.*;
import org.apache.commons.lang3.StringUtils;

class TrieNode {
  private char item;
  private Set<TrieNode> childNodes  = new HashSet<>();
  private Set<String> leafList = new HashSet<>();
  private boolean isEnd ;

  public TrieNode(char item, Set<TrieNode> childNodes, Set<String> leafList, boolean isEnd) {
    this.item = item;
    this.childNodes = childNodes;
    this.leafList = leafList;
    this.isEnd = isEnd;
  }
}
public class Trie{
  private static TrieNode root = null;
  private static Map<String,List<String>> wordMap = new HashMap<>();

  public static void main (String[] args){
    List<String> wordList = Arrays.asList("cat","dog","act","ogd","tac");
    wordList.forEach(word -> {
      char[] wordArr = word.toCharArray();
      Arrays.sort(wordArr);
      String newWord = String.valueOf(wordArr);
      List<String> value = wordMap.getOrDefault(newWord, new ArrayList<>());
      value.add(word);
      wordMap.put(newWord, value);
    });
    System.out.println(wordMap);
    StringBuilder sbuf = new StringBuilder()
        .append("India")
        .insert(5,1234)
        .delete(2, 4)
        .insert(2, "*DI*")
        .reverse();

    System.out.println(sbuf.substring(4).toString());
  }
}

