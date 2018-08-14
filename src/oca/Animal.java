package oca;

public interface Animal{
  public default String getName(){
    return "It happens ANimal";
  }
}

interface Mamal{
  public default String getName(){
    return "It happens Mamal";
  }
}

abstract class Otter  implements Animal, Mamal{
  public abstract String getName();
}

class testClass extends Otter{
  @Override
  public  String getName(){
    return "It happens Test";
  }
  static int test  = 9;
  /**
   * @param args
   */
  public static void main( String[] args){
    int  a = 100;
    float b  = a;
    double c = 130.9919281928192819829;
    int n = (byte)c;
    System.out.println(n + ", "+ b + ", "+ c);
    final short s ;
    s=100;
    final long l = 100;
    switch(s){
      case (int)l:
        System.out.println("TEST");
    }
  }

  private static void processSwitch(String a, final String b) {
  }
}