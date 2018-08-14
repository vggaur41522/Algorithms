package oca;
// Most Frequently used words (after excluding common words)
//
// Amazon is partnering with the linguistics department at a local university to analyze important
// works of English literature and identify patterns in word usage across different eras. To ensure
// a cleaner output. the linguistics department has provided a list of commonly used words (e.g.,
// "an", "the". etc.) to exclude from the analysis. In the context of this search, a word is an
// alphabetic sequence of characters having no whitespace or punctuation.
//
// Write an algorithm to find the most frequently used word in the text excluding the commonly used
// words.
//
// Input:
// The input to the function/method consists of two arguments -
// literatureText: a string representing the block of text,
// wordsToExclude: a list of strings representing the commonly used words to be excluded while
// analyzing the word frequency.
//
// Output:
// Return a list of strings representing the most frequently used word in the text or in case of a
// tie, all of the most frequently used words in the text.
//
// Note:
// Words that have a different case are counted as the same word. The order of words does not matter
// in the output list. All words in the 'wordsToExclude' list are unique. Punctuation should be
// treated as white space.
//
// Example
//
// Input:
// literature Text = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and
// Jill's favorite food."
// wordsToExclude = ["and", "he", "the", "to", "is". "Jack", "Jill"]
//
// Output: ["cheese", "s"]
//
// Explanation: The word `and" has a maximum of three frequency but this word should be excluded
// while analyzing the word frequency. The words "Jack'. 'Jill", "s", "to" and "cheese" have the
// next maximum frequency(two) in the given text but the words "Jack", "to" and "Jill' should be
// excluded as these are commonly used words which you are not interested to include.
//
// So the output is ["cheese", `s"] or ["s", "cheese"] as the order of words does not matter.

/*********************************************/

// Reorder Data in log file
//
// You have been given a task of reordering some data from a log file. Every line in the log file is
// a space delimited list of strings and all lines begin with an identifier that is alphanumeric.
// After the identifier, a line will consist of either a list of words using only English letters or
// only a list of integers. There will be no lines that consist of only an identifier.
//
// Your task is to reorder the data from the log file such that all the lines with words are at the
// top in the log file. in lexicographical order. Words are ordered lexicographically ignoring the
// identifier except in the case of ties. In the case of ties (if there are two lines that are
// identical except for the identifier), the identifier is used to order lexicographically.
// Alphanumerics should be sorted in ASCII order (numbers come before letters). The identifiers must
// still be part of the lines in the output Strings. Lines with integers do not need to be sorted
// relative to other lines with integers.
//
// Write an algorithm to reorder the data in the log file.
//
// The input to the function/method consists of two arguments -
//
// logFileSize: an integer representing the number of lines in the log file,
// logLines: a list of strings representing the log file.
//
// Output:
// Return a list of strings representing the reordered log file data.
//
// Note:
// Identifier consists of only English letters and numbers. The lines with words are not required to
// match case and the sort needs to be case insensitive.
//
// Example:
// Input:
// logFileSize = 5
// logLines =
// ("al 9 2 3 1",
// "g1 Act car",
// "zo4 4 7",
// "abl off KEY dog",
// "a8 act zoo")
//
// Output:
// [gl Act car]
// [a8 act zoo]
// [ab1 off KEY dog]
// [al 9 2 3 1]
// [zo4 4 7]
//
// Explanation:
// Second, fourth. and fifth lines are the lines with words. According to the lexicographical order,
// the second line will be reordered first in the log file, then fifth, and the fourth comes in the
// log file. Next, the lines with numbers come in the order in which these lines were in the input.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Chapter3 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    List<String> logFile =
        Arrays.asList(
            "al  9 2 3 1", 
            "g1 Act car", 
            "zo4 4 7", 
            "abl off KEY dog", 
            "a8 act zoo",
            "abc off KEY dog",
            "aba OFF KEY dog");
    int size = 5;
    System.out.println("Varun -->\t"+sortLogFileVarun(logFile, size));
    System.out.println("Career Cup-->\t"+logProcessor(logFile));

    // Expected: "cheese", "s"
    String inputStr = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";
    List<String> commonWords = Arrays.asList("And", "he", "the", "to", "is", "Jack", "Jill");
    mostFrequentlyUsedWord(inputStr, commonWords);
    //5, 5, 5, 10, 20 -> true,
    //5, 5, 10 -> true, 5 5 10 5 5 5 20 20
    int[] customers = {5, 5, 10, 5, 5, 5, 20, 20};
    System.out.println(sellIceCream(customers));
    System.out.println(testGenerator("ab", "aabbaababaabb"));
  }

  private static List<String> sortLogFileVarun(List<String> logFile, int size) {
    Map<String, List<String>> sortedMap = new TreeMap<>();
    List<String> numberList = new ArrayList<>();
    for (String s : logFile) {
      List<String> valueList;
      String secondStr = s.split("\\s",2)[1];
      secondStr = secondStr.toLowerCase().replaceAll("\\s", "");
      try{
        Long.parseLong(secondStr); // No need to Assign as It is numbers
        numberList.add(s);  // This will have all the numbers and follow the insertion order 
        continue;
      }
      catch(Exception e){
        if (sortedMap.containsKey(secondStr)) {
          valueList = sortedMap.get(secondStr);
        } else {
          valueList = new ArrayList<>();
        }
        valueList.add(s);
        sortedMap.put(secondStr, valueList);
      }
    }
    List<String> output = new ArrayList<>();
    for (Map.Entry<String, List<String>> e : sortedMap.entrySet()) {
      if(e.getValue().size() > 1){
        //Sort values when there is a Tie
        Collections.sort(e.getValue(), new Comparator<String>(){
          @Override
          public int compare(String o1, String o2) {
            return o1.split("\\s")[0].compareTo(o2.split("\\s")[0]);
          }
        });
      }
      output.addAll(e.getValue());
    }
    output.addAll(numberList);
    return output;
  }

  public static List<String> logProcessor (List<String> list){
    List<String> strAlp = new ArrayList<String>();
    List<String> strNum = new ArrayList<String>();
    List<String> AlpNum = new ArrayList<String>();

    for( String sl :  list){
      String[] slPart = sl.split(" ", 2);
      if(Character.isDigit(slPart[1].charAt(0))){
        strNum.add(sl);
      }
      else {
        strAlp.add(slPart[1].concat(" " + slPart[0]));
      }
    }
    Collections.sort(strAlp);
    for(String sl2 : strAlp){
      String[] part = {sl2.substring(0,sl2.lastIndexOf(" ")), sl2.substring(sl2.lastIndexOf(" ") + 1)};
      AlpNum.add(part[1].concat(" " + part[0]));
    }
    AlpNum.addAll(strNum);
    return AlpNum;
  }

  public static List<String> mostFrequentlyUsedWord(String inputStr, List<String> excludeList){
    Set<String> excludeSet = excludeList.stream().map(p -> p.toLowerCase()).collect(Collectors.toSet());

    Map<String, Integer> countMap = new HashMap<String, Integer>();
    List<String> result = new ArrayList<>();
    AtomicLong max= new AtomicLong(0);
    Arrays.stream(inputStr.split("[^a-zA-Z0-9]+"))
    .parallel()
    .map(word -> word.toLowerCase())
    .filter(word -> !excludeSet.contains(word))
    .forEach(word -> {
      if(countMap.containsKey(word)){
        countMap.put(word, countMap.get(word) + 1);
        if(countMap.get(word) == max.get()){
          result.add(word);
        }
        else if(countMap.get(word) > max.get()){
          result.clear();
          result.add(word);
        }
        max.set(Math.max(countMap.get(word),max.get()));
      }
      else if(!countMap.containsKey(word)){ 
        countMap.put(word, 1); 
        if(max.get()<=1){
          result.add(word);
          max.set(1L);
        }
      }
    });
    System.out.println(result);
    return result;
  }
  //A queue of people are waiting to buy ice cream from you.
  //Each person buys one ice cream, which sells for $5.
  //Each customer is holding a bill of $5, $10 or $20.
  //Your initial balance is 0.
  //Find whether you will be able to make change for every customer in the queue. You must serve
  //customers in the order they come in.
  //
  //For example
  //5, 5, 5, 10, 20 -> true,
  //5, 5, 10 -> true, 5 5 10 5 5 5 20 20
  //10, 10 -> false
  static boolean sellIceCream(int[] bills){    
    int[] a = new int[3];    
    for(int m : bills){
      switch(m){
        case 5:
          a[0]++;        
          break;
        case 10:
          if( a[0] < 1) {                
            return false;            
          }            
          a[0]--;
          a[1]++;        
          break;          
        case 20:  
          if(a[1] > 0 && a[0] > 0){                
            a[1]--;                
            a[0]--;                
          }                
          else if(a[0] > 3) {                    
            a[0] -= 3;               
          }                
          else {                    
            return false;                
          }    
          a[2]++;
          break;
      }
    }    
    return true;
  }
  // You have been given a generator string ab from which any number of strings can be generated
  // recursively by inserting ‘ab’ at any location. You have been given an input string to check if
  // that given string is valid or not.(i.e. generated by given with given string.)
  //
  // eg.
  // Input: aabbab
  // Output: valid
  // Input: abbaab
  // Output: Invalid
  //
  // I could not come up with a algorithm less than O(N*N)
  public static boolean testGenerator(final String pattern, final String input){
    List<Node> nodeArr = new ArrayList<>();
    char[] patternArr = pattern.toCharArray();
    for(char c: patternArr)
      nodeArr.add(new Node(c,0));
    for(int j=0;j<input.length();j++){
      char inputChar = input.charAt(j);
        for(int i=patternArr.length-1;i>=0;i--){
          if(i==0 && inputChar == patternArr[0]) {
            nodeArr.get(0).count++;
            continue;
          }
          if(inputChar == patternArr[i]){
            Node prevNode = nodeArr.get(i-1);
            if(prevNode.count<=0) 
              return false;
            else
              prevNode.count--;
            if(patternArr.length-1 != i)
            {
              Node currNode = nodeArr.get(i);
              currNode.count++;
            }
            continue;
          }
        }
    }
    System.out.println(nodeArr);
    return !nodeArr.stream().filter(node -> node.count > 0).findFirst().isPresent();
  }
}
class Node{
  char c;
  int count;
  public Node(char c, int count){
    this.c = c;
    this.count = count;
  }
  public String toString(){
    return "["+c+": "+count+"]";
  }
}
