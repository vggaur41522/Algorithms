package oca;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

class P {
  int x = 10;
  int y =19;
  {
    System.out.println("Second Ini block: "+x);
  }
  public P(){
    System.out.println("INCOn:"+x);
    x =20;
  }
  
  /**
   * @param args
   */
  public static void main (String[]  args){
    String s = new String("sss");
    System.out.println("MAIN");
    System.out.println(new P().x);
    int[] arr  = new int[]{12,4,6,7,9,11};
    String[] ans = new String[]{"A","B","C"};
    System.out.println(Arrays.binarySearch(arr, 12));
    List<Integer> arLst = Arrays.asList(1,2,3);
    
    List<String> strList = Arrays.asList(ans);
    if(arLst.size() >=                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    3 || strList.size()>4){
      System.out.println("Test 1");
    }

    // Date  in Java 8 [ LocalDate, LocalDateTime, LocalTime. Instant ]
    LocalDateTime dateTime = LocalDateTime.now();
    LocalTime time = LocalTime.now();
    LocalDate date = LocalDate.of(1986, Month.NOVEMBER, 1);
    System.out.println(date.format(DateTimeFormatter.ofPattern("uuuu-dd-MMM")));
    System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
    System.out.println(time.getNano());
    
    double x = 3402823470000000000000000000000000000001d;
    System.out.println(x);
    
  }
  {
    System.out.println("Iniatialize:"+x);
    x =15;
  }
}