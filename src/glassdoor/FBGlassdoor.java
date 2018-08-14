package glassdoor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FBGlassdoor {

  public static void main(String...strings){
    //    Count the number of words in a sentence.
    String sentence = "India is a country,of her her:diversity. It is has her man,women, and Animal!samjha. koi na";
    findWords(sentence);
    //    Count the frequency of words from the list and store the results in a hash map. 
    List<Integer> lst = Arrays.asList(1,2,3,4,5,6,7,8,2,2,8);
    Set<Integer> set = new HashSet<>(lst);
    System.out.println(set);
    countUniqueInStream();
    findUniqueWords(sentence);
    ArraySection();
    minAbsoluteDiff();
    findMax();
  }

  private static void findUniqueWords(String sentence) {
    List<String> words = findWords(sentence);
    Map<String, Long> countMap = words
        .stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(countMap);

    words.stream().distinct().forEach(p -> System.out.println(p));
  }

  private static List<String> findWords(String sentence) {
    if(sentence == null || sentence.length() == 0)
      return null;
    String[] words = sentence.split("[\\W0-9]+");
    List<String> wordList = Arrays.asList(words);
    System.out.println(wordList.size());
    return wordList;
  }

  private static void ArraySection(){
    int[] arr = new int[]{1,2,3,4,5,6,7,8,2,2,8};
    int[] arr2 = Arrays.copyOfRange(arr, 2, 5);
    Arrays.stream(arr2).forEach(p -> System.out.println(p));
  }

  private static void minAbsoluteDiff(){
    List<Integer> arrList = Arrays.asList(-7,2,-1,11,9,5,3);
    int a = arrList.get(0) , b = arrList.get(1);
    int minDiff = Integer.MAX_VALUE;
    Collections.sort(arrList);
    for(int i=1; i<arrList.size();i++){
      if(Math.abs(arrList.get(i)-arrList.get(i-1)) < minDiff){
        minDiff = Math.abs(arrList.get(i)-arrList.get(i-1));
        a = arrList.get(i-1);
        b = arrList.get(i);
      }
    }
    System.out.println(String.format("Two Numbers are: [%d] and [%d] and their Abs Diff is: [%d]",a, b, minDiff));
  }

//Playing with char ensure casting ..... 
 public static void countUniqueInStream(){
   AtomicInteger uniqueCount = new AtomicInteger(0);
   Map<Character, Integer> countMap = new HashMap<>();
   char[] cArr = "abcdbde".toCharArray();
   
   IntStream.range(0, cArr.length-1).map(index -> cArr[index]).forEach(c -> { 
     if(countMap.containsKey((char)c)){
       if(countMap.get((char)c) >= 1){
         uniqueCount.decrementAndGet();
       }
       else{
         uniqueCount.incrementAndGet();
       }
     }
     else{
       uniqueCount.incrementAndGet();
     }
     countMap.put((char)c, countMap.getOrDefault((char)c, 1)+1);
     System.out.println(String.format("For Character [%c] count is [%d]",c,uniqueCount.get()));
   });
 }
 
 public static void findMax(){
   int[] arr = new int[]{1,819,-1,400,415,89};
   int MAX = Integer.MIN_VALUE;
   for(int num: arr){
     MAX = Math.max(MAX, num);
   }
   System.out.println("MAX IS --->"+MAX);
 }

}
