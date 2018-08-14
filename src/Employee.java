import static com.google.common.base.Objects.equal;
import java.util.*;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Employee {
  private String name;
  private String company;
  private int id;
  
  public Employee(){};
  
  public Employee(String name, String company, int id) {
    super();
    this.name = name;
    this.company = company;
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getcompany() {
    return company;
  }
  public void setcompany(String company) {
    this.company = company;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  
  @Override
  public int hashCode() {
    return Objects.hashCode(name, company);
  }

  //Suppress sonar rule for expression complexity on auto-generated code.
  @Override
  public boolean equals(final Object obj) {
    if (obj instanceof Employee) {
      Employee that = (Employee) obj;
      return  equal(this.name, that.name) 
          && equal(this.company, that.company);
    }
    return false;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("id", id)
        .add("name", name)
        .add("company", company).toString();
  }
  
}
