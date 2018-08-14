package unionFindDisjointSet;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class DisjointSetUnionFindProblem {

  public static void main(String[] args) {
    DisjointSetUnionFindProblem dProb = new DisjointSetUnionFindProblem();
    boolean isCycle = dProb.checkCycle();
    System.out.println(isCycle);
  }

  private boolean checkCycle() {
    DisjointSet dSet = new DisjointSet();
    IntStream.range(0, 6).forEach(i -> {
      dSet.makeSet(i);
    });
    Integer[][] sets = new Integer[][]{
      {0, 1},
      {1, 2},
      {0, 3},
      {3, 4},
      {4, 5},
      {5, 1}
    };
    AtomicBoolean isCycle = new AtomicBoolean(false);
    Arrays.stream(sets).forEach(pair -> {
      isCycle.set(dSet.union(pair[0], pair[1]));
    });
    return isCycle.get();
  }

}
