package oca;

class Parent_New {
  public void test(){
    System.out.println("NON-STATIC -> Parent ->"+test_static());
  }
  
  public static String test_static(){
    return "1-P";
  }
}

public class Child extends Parent_New{
  public void test(){
    System.out.println("NON-STATIC -> Child ->"+test_static());
  }
  
  public static String test_static(){
    return "0-C";
  }
  
  public static void main (String ... args){   
    Child cc = new Child();
    Parent_New pc = new Child();
    Parent_New pp = new Parent_New();
    
    cc.test();
    pc.test();
    pp.test();
  }
   
}
