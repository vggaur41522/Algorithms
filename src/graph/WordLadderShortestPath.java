package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Ladder{
  public String word;
  public List<String> path;
  public int len;
  
  public Ladder(String word, List<String> path, int len){
    this.word = word;
    this.path = path;
    this.len = len;
  }
  
  public Ladder(List<String> path) {
    this.path=path;
   }
   
   public Ladder(List<String> path, int length, String word) {
    this.path=path;
    this.len=length;
    this.word=word;
   }
  
  public String toString(){
    return this.word + ":" + this.path + ":" + this.len ;
  }
}


public class WordLadderShortestPath {

  public static void main(String[] args) {
    WordLadderShortestPath wProb = new WordLadderShortestPath();  
    Set<String> dictionary = new HashSet<String>();
    dictionary.add("CAT");
    dictionary.add("BAT");
    dictionary.add("COT");
    dictionary.add("COG");
    dictionary.add("COW");
    dictionary.add("RAT");
    dictionary.add("BUT");
    dictionary.add("CUT");
    dictionary.add("DOG");
    dictionary.add("WEB");

    String startWord = "CAT";
    String endWord = "DOG";

//    Ladder result = wProb.wordLadderBfs(startWord, endWord, dictionary);
     Ladder result = wProb.getShortestTransformationRecursive(startWord, endWord, dictionary);

    if (result != null) {
      System.out.println("Length is " + result.len + " and path is :" + result.path);
    } else {
      System.out.println("No Path Found");
    }

  }

  public Ladder wordLadderBfs(String start, String end, Set<String> dict){
    Queue<Ladder> queue = new LinkedList<>();
    List<String> startPath = new ArrayList<>();
    startPath.add(start);
    queue.offer(new Ladder(start, startPath, 1));
    dict.remove(start);
    dict.add(end);
  
    while(!queue.isEmpty()){
      Ladder currentLadder = queue.poll();
      if(end.equalsIgnoreCase(currentLadder.word)){
        return currentLadder;
      }
      Iterator<String> it = dict.iterator();
      
      while(it.hasNext()){
        String dictWord = it.next();
        if(differByOne(dictWord, currentLadder.word)){
          List<String> currPath = new ArrayList<>(currentLadder.path);
          currPath.add(dictWord);
          queue.offer(new Ladder(dictWord, currPath, currentLadder.len+1));
          it.remove();
        }
      }
    }
    return null;
  }
  
  public boolean differByOne(String dWord, String lWord){
    if(dWord.length() != lWord.length())
      return false;
    int differenceFound = 0;
    for(int i=0;i<dWord.length();i++){
      if(dWord.charAt(i) != lWord.charAt(i)){
        if(differenceFound >= 1){
          return false;
        }
        differenceFound++;
      }
    }
    if(differenceFound == 1) 
      return true;
    else
      return false;
  }
  
  private Ladder getShortestTransformationRecursive(String startWord, String endWord,
      Set<String> dictionary) {

    // All Paths from startWord to endWord will be stored in "allPath"
    LinkedList<Ladder> allPath = new LinkedList<Ladder>();

    // Shortest path will be stored in "shortestPath"
    Ladder shortestPath = new Ladder(null);

    List<String> path = new LinkedList<String>();
    path.add(startWord);

    recursiveHelperShortest(startWord, endWord, dictionary, new Ladder(path, 1, startWord), allPath,
        shortestPath);

    return shortestPath;
  }

  private void recursiveHelperShortest(String startWord, String endWord,
      Set<String> dictionary, Ladder ladder, LinkedList<Ladder> allPath, Ladder shortestPath) {
    if (ladder.word.equals(endWord)) {

      // For storing all paths
      allPath.add(new Ladder(new LinkedList<String>(ladder.path)));

      // For storing the shortest path from among all paths available
      if (shortestPath.path == null
          || shortestPath.path.size() > ladder.path.size()) {
        shortestPath.path = new LinkedList<String>(ladder.path);
        shortestPath.len = ladder.path.size();
      }
      return;
    }

    Iterator<String> i = dictionary.iterator();
    while (i.hasNext()) {
      String string = i.next();

      if (differByOne(string, ladder.word) && !ladder.path.contains(string)) {

        List<String> path = ladder.path;
        path.add(string);

        // We found the new word in intermediate path, Start exploring new word from scratch again.
        recursiveHelperShortest(startWord, endWord, dictionary,
            new Ladder(path, ladder.len + 1, string), allPath, shortestPath);

        // After exploring new word, remove it from intermediate path.
        path.remove(path.size() - 1);
      }
    }
  }

}
