package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class AZ {
  Map<Integer, Integer> mapSum = new HashMap<>();
  LLNode head = null;
  LinkedHashMap<Integer,Integer> lMap = new LinkedHashMap<>();

  public static void main(String[] args) {
    AZ amz = new AZ();
    amz.lruCache(); // Using actual Node
    amz.twoSum();
    System.out.println("2,147,483,647 to words -->"+amz.numToWords(Integer.MAX_VALUE)+ " Only..");
    amz.createLL();
  }

  private void createLL() {
    head = new LLNode(1);
    head.next = new LLNode(2);
    head.next.next = new LLNode(3);
    head.next.next.next = new LLNode(4);
    head.next.next.next.next = new LLNode(5);
    printLL(head);
    printLL(reverseLL(head));   // Iterative 
    printLL(reverseUtil(head, null));  // Recursive
  }

  private LLNode reverseLL(LLNode node) {
    if(node == null) return node;
    LLNode curr = node;
    LLNode prev = null;
    LLNode next = curr;
    while(curr != null){
      next = curr.next;
      curr.next =  prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
  LLNode reverseUtil(LLNode curr, LLNode prev) {

    /* If last node mark it head*/
    if (curr.next == null) {
      head = curr;

      /* Update next to prev node */
      curr.next = prev;
      return null;
    }

    /* Save curr->next node for recursive call */
    LLNode next1 = curr.next;

    /* and update next ..*/
    curr.next = prev;

    reverseUtil(next1, curr);
    return head;
  }


  private void printLL(LLNode node) {
    if(node == null)
      return;
    System.out.print(node.key + " ");
    printLL(node.next);
  }

  private void lruCache() {
    LRUCache lru = new LRUCache(4);
    // 4 5 1 4 2 6 7 1 5 8 9
    List<Integer> items = Arrays.asList(4, 5, 1, 4, 2, 6, 7, 1, 5, 8, 9);
    items.forEach(i -> {
      lru.setNode(i); 
      lru.printCache();
    });
  }

  private void twoSum() {
    int target = 10;
    int[] arr = new int[]{1,2,7,8,3};
    for(int i=0;i<arr.length;i++){
      if(mapSum.containsKey(target-arr[i])){
        System.out.println("----->"+ arr[i] + " " + (target - arr[i]));
      }
      else{
        mapSum.put(arr[i], (target - arr[i]));
      }
    }
  }

  public static void fillMap(){
    wordsMap.put(0, "Zero");
    wordsMap.put(1, "One");
    wordsMap.put(2, "Two");
    wordsMap.put(3, "Three");
    wordsMap.put(4, "Four");
    wordsMap.put(5, "Five");
    wordsMap.put(6, "Six");
    wordsMap.put(7, "Seven");
    wordsMap.put(8, "Eight");
    wordsMap.put(9, "Nine");
    wordsMap.put(10, "Ten");
    wordsMap.put(11, "Eleven");
    wordsMap.put(12, "Twelve");
    wordsMap.put(13, "Thirteen");
    wordsMap.put(14, "Fourteen");
    wordsMap.put(15, "Fifteen");
    wordsMap.put(16, "Sixteen");
    wordsMap.put(17, "Seventeen");
    wordsMap.put(18, "Eighteen");
    wordsMap.put(19, "Nineteen");
    wordsMap.put(20, "Twenty");
    wordsMap.put(30, "Thirty");
    wordsMap.put(40, "Forty");
    wordsMap.put(50, "Fifty");
    wordsMap.put(60, "Sixty");
    wordsMap.put(70, "Seventy");
    wordsMap.put(80, "Eighty");
    wordsMap.put(90, "Ninety");
  }

  static Map<Integer, String> wordsMap = new HashMap<>();
  private String numToWords(int num){
    fillMap();
    StringBuilder sb = new StringBuilder();

    if(num == 0)
      return wordsMap.get(num);
    if(num >= 1000000000){
      int extra = num/1000000000;
      sb.append(convert(extra) + " Billion");
      num = num%1000000000;
    }
    if(num >= 1000000){
      int extra = num/1000000;
      sb.append(convert(extra) + " Million");
      num = num%1000000;
    }
    if(num >= 1000){
      int extra = num/1000;
      sb.append(convert(extra) + " Thousand");
      num = num%1000;
    }
    if(num > 0)
      sb.append(convert(num));
    return sb.toString();

  }

  private String convert(int num) {
    StringBuilder sb = new StringBuilder();
    if(num>=100){
      int numHundred = num/100;
      sb.append(" " + wordsMap.get(numHundred) + " Hundred");
      num = num%100;
    }
    if(num >0 && num <=20){
      sb.append(" "+wordsMap.get(num));
    }
    else{
      //54
      int numTen = num/10;
      sb.append(" " + wordsMap.get(numTen*10));
      if(num%10 > 0){
        sb.append(" " + wordsMap.get(num%10));
      }
    }
    return sb.toString();
  }


}
