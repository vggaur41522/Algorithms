package programcreek;

import java.util.HashMap;
import java.util.Map;

public class LongestSequenceProblems {
  public static void main(String...strings){
    LongestSequenceProblems lProb = new LongestSequenceProblems();
    lProb.longestNonRecurringSubstring("abdedkalenl");
    lProb.longestTwoCharSubstring("bbbbabaccaab");
  }

  private int longestTwoCharSubstring(String string) {
    int end = 0 , start = 0;
    Map<Character,Integer> countMap = new HashMap<>();
    int len = string.length();
    int MAXLEN = Integer.MIN_VALUE;
    String subStr = "";
    while(end < len){
      char currChar = string.charAt(end);
      countMap.put(currChar, countMap.getOrDefault(currChar, 0)+1);
      if(countMap.size() > 2){
        if(MAXLEN < end - start){
          MAXLEN = end - start;
          subStr = string.substring(start, end);
        }
        while(countMap.size() > 2 && start < end){
          char startChar = string.charAt(start);
          countMap.put(startChar, countMap.get(startChar)-1);
          if(countMap.get(startChar) <= 0) countMap.remove(startChar);
          start++;
        }
      }
      end++;
    }
    if(MAXLEN < end - start){
      MAXLEN = end - start;
      subStr = string.substring(start, end);
    }
    System.out.print(String.format("Longest Substring is [%s] of len [%d]", subStr, MAXLEN));
    return MAXLEN;
  }

  private int longestNonRecurringSubstring(String string) {
    int end =0, start =0;
    Map<Character,Integer> countMap = new HashMap<>();
    int MAXLEN = Integer.MIN_VALUE;
    String subStr = "";
    while(end < string.length()){
      char currChar = string.charAt(end);
      if(!countMap.containsKey(currChar)){
        countMap.put(currChar, 1);
      }
      else{
        if(MAXLEN < end -start){
          MAXLEN = end - start;
          subStr = string.substring(start, end);
        }
        //Update start
        while(string.charAt(start) != currChar && start < end){
          countMap.remove(string.charAt(start));
          start++;
        }
        countMap.remove(string.charAt(start));
        start++;
      }
      end++;
    }
    if(MAXLEN < end -start){
      MAXLEN = end - start;
      subStr = string.substring(start, end);
    }
    System.out.print(String.format("Longest Substring is [%s] of len [%d]", subStr, MAXLEN));
    return MAXLEN;
  }
}
