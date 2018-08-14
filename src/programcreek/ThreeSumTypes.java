package programcreek;

import java.util.Arrays;

public class ThreeSumTypes {

  public static void main(String[] args) {
    int[] intArr = new int[]{7,1,4,6,5,2,3,8,8,9};
    int[] result = threeSumClosest(intArr, 130);
    System.out.println(String.format("3 Closest Sum: [%d][%d][%d]",result[0],result[1],result[2]));
  }
  
  public static int[] threeSumClosest(int[] intArr, int target) {
    if (intArr == null || intArr.length < 2)
      return new int[] {0, 0, 0};
    Arrays.sort(intArr);
    int len = intArr.length;
    int i = 0;
    int MIN = Integer.MAX_VALUE;
    int[] result = new int[3];
    while (i < len) {
      int j = i + 1;
      int k = len - 1;
      while (j < k) {
        int sum = intArr[i] + intArr[j] + intArr[k];
        int diff = Math.abs(sum - target);
        if (diff == 0)
          return new int[] {intArr[i], intArr[j], intArr[k]};
        if (MIN > diff) {
          MIN = diff;
          result[0] = intArr[i];
          result[1] = intArr[j];
          result[2] = intArr[k];
        }
        if (sum <= target) {
          j++;
        } else {
          k--;
        }
      }
      i++;
    }
    return result;
  }
}
