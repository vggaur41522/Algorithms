package programcreek;

import java.util.*;
import java.util.stream.*;

public class MedianOfStream {

  private PriorityQueue<Integer> minHeapForHigherHalf = new PriorityQueue<>();
  private PriorityQueue<Integer> maxHeapForLowerHalf = new PriorityQueue<>(Collections.reverseOrder());
  
  public static void main(String[] args) {
    MedianOfStream streamMedian = new MedianOfStream();
    int[] intArr = new int[]{7,1,4,6,5,2,3,8};
    streamMedian.addNum(intArr);
  }

  public void addNum(int[] intArr){
    IntStream.range(0, intArr.length).forEach(index -> {
      System.out.print(intArr[index] + " ");
      int num = intArr[index];
      maxHeapForLowerHalf.offer(num);
      minHeapForHigherHalf.offer(maxHeapForLowerHalf.poll());
      
      if(maxHeapForLowerHalf.size() < minHeapForHigherHalf.size()){
        maxHeapForLowerHalf.offer(minHeapForHigherHalf.poll());
      }
      // Shows median of Stream
      findMedian(num);
      
    });
  }
  
  public  void  findMedian(int num){
    if(minHeapForHigherHalf.size() == maxHeapForLowerHalf.size()){
      int sum = minHeapForHigherHalf.peek() + maxHeapForLowerHalf.peek();
      System.out.println(String.format("[%d] Median is [%f]",num,(sum/2.0)));
    }
    else{
      System.out.println(String.format("[%d] Median is [%d]",num, maxHeapForLowerHalf.peek()));
    }
  }
}
