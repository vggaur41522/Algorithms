package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Triplet<E>
{
  E a;
  E b;
  E c;
  Triplet(E a, E b, E c){
    this.a = a;
    this.b = b;
    this.c = c;
  }
  public String toString(){
    return a +"|" + b +"|" + c;
  }
}

public class ThreeSum{


  public static void main(String...args){
    int[] arr = new int[]{6,2,2,2,2,2,1,1,5,5,5,5,7,11,6,6};
    threeSum(arr, 14);
  }

  private static List<Triplet<Integer>> threeSum(int[] arr, int target) {
    System.out.println("Processing 3 Sum");
    int len = arr.length;
    if(arr == null || len == 0)
      return null;
    List<Triplet<Integer>> result = new ArrayList<>();

    int k = len-1;
    Arrays.sort(arr);
    for(int i=0; i<len; i++){
      if(i==0 || arr[i] > arr[i-1]){
        int j = i+1;
        while(j<k){
          int sum = arr[i] + arr[j] + arr[k];
          if(target > sum){
            j++;
          }
          else if (target == sum){
            result.add(new Triplet<Integer>(arr[i], arr[j], arr[k]));
            j++;
            k--;
            while(j<k && arr[j-1]==arr[j])
              j++;
            while(k>j && arr[k+1]==arr[k])
              k--;
          }
          else{
            k--;
          }
        }
      }
    }
    System.out.println(result);
    return result;
  }
}
