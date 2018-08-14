package island;

public class Island {

  private static int ROWS = 3;
  private static int COLS = 3;
  public static void main(String[] args) {
    int[][] island = new int[][]{
      {1,0,1,0,1},
      {0,1,0,0,1},
      {1,0,1,0,1},
      {1,1,1,0,1}
    };
    Island islandProblem = new Island();
    int count = islandProblem.countClosingIslands(island);
    System.out.println("Island Count: "+count);
  }

  private int countClosingIslands(int[][] island) {
    int rows = island.length;
    int cols = island[0].length;
    ROWS = rows;
    COLS = cols;
    boolean[][] visited = new boolean[rows][cols];
    int count = 0;
    for(int i=0;i< rows; i++){
      for(int j=0;j< cols; j++){
        if(island[i][j] == 1 && !visited[i][j]){
          DFS(island, i, j, visited);
          count++;
        }
      }
    }
    return count;
  }

  private void DFS(int[][] island, int i, int j, boolean[][] visited) {
    visited[i][j] = true;
    if(isSafe(island, i+1, j, visited))
      DFS(island, i+1, j, visited);
    
    if(isSafe(island, i-1, j, visited))
      DFS(island, i-1, j, visited);
    
    if(isSafe(island, i, j-1, visited))
      DFS(island, i, j-1, visited);
    
    if(isSafe(island, i, j+1, visited))
      DFS(island, i, j+1, visited);
    
  }

  private boolean isSafe(int[][] island, int i, int j, boolean[][] visited) {
    if(i >= 0 && j>=0 && i< ROWS && j < COLS && island[i][j] == 1 && visited[i][j] == false){
      return true;
    }
    return false;
  }

}
