package practice;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LRUTester {

  @InjectMocks
  LRUCache lru;
  
  @Before
  public void setUp() throws Exception {}

  @Test
  public void test_setNode_HappyPath() {
    // 4 5 1 4 2 6 7 1 5 8 9
    List<Integer> items = Arrays.asList(4, 5, 1, 4, 2, 6, 7, 1, 5, 8, 9);
    items.forEach(i -> {
      lru.setNode(i); 
      lru.printCache();
    });
  }

}
