import java.util.*;

public class testOne {
  public static void main(String[] args){
    testOne test = new testOne();
    test.process();
  }

  private void process() {
    Employee e1 = new Employee("Varun", "Choice", 1); 
    Employee e2 = new Employee("Divya", "Amex", 2);
    Employee e3 = new Employee("Anuj", "GE", 3);
    
    Employee e4 = new Employee("Anuj", "GE", 3);
    Employee e5 = new Employee("Divya", "Amex", 2);
    Employee e6 = new Employee("Varun", "Choice", 1);
    List<Employee> empList1 = new ArrayList<>();
    empList1.add(e1);
    empList1.add(e2);
    empList1.add(e3);
    List<Employee> empList2 = new ArrayList<>();
    empList2.add(e4);
    empList2.add(e5);
    empList2.add(e6);

    System.out.println("Before\nEmp List-1 -->"+empList1+"\nEmp List-3 -->"+empList2);
//    empList.removeIf(p -> (p.getName().equals("Anuj")));
    System.out.println(empList1.containsAll(empList2));
    
  }


}
