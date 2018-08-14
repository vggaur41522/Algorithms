package oca;

import java.util.ArrayList;
import java.util.List;

public class BonusTest2 {
  public static void main(String ...strings){
    BonusTest2 test2= new BonusTest2();
    Secret s ; 
    s(()-> 5);
  }

  interface Secret {
    int number();
  }

  class MySecret implements Secret {
    public int number() {
      return 5;
    }
  }
}
