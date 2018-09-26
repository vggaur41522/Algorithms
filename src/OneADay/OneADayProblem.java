package OneADay;

import java.util.ArrayDeque;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OneADayProblem {

  public static void main(String[] args) {
    int[][] mat = new int[][]{
      {1,2,3},
      {4,5,6},
      {7,8,9}
    };
    OneADayProblem oneProb = new OneADayProblem();
    oneProb.rotateMatrix(mat,"L");
    String[] crypt = {"SEND","MORE","MONEY"};
    char[][] solution = new char[][]{
      {'O', '0'},
      {'M', '1'},
      {'Y', '2'},
      {'E', '5'},
      {'N', '6'},
      {'D', '7'},
      {'R', '8'},
      {'S', '9'}
    };
    System.out.println(oneProb.isCryptSolution(crypt, solution));
    oneProb.constructSubmatrix(mat, new int[]{1}, new int[]{0,2});
    String str = "2[b3[a]]";
    oneProb.decodeStr(str);
  }

  private String decodeStr(String str) {
    if(str == null || str.length() == 0) return "";
    StringBuilder result = new StringBuilder();
    ArrayDeque<String> stack = new ArrayDeque<>();
    int i = str.length()-1;
    while(i>=0){
      char c = str.charAt(i);
      if(Character.isLowerCase(c) || c == ']'){
        stack.push(String.valueOf(c));
      }
      // When Closing Bracket Encounter. Pop till Closing Bracker and push again in stack
      if(c == '['){
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && !stack.peek().equals("]") ){
          sb.append(stack.pop());
        }
        if(stack.peek().equals("]"))
          stack.pop();
        stack.push(sb.toString());
      }
      if(Character.isDigit(c)){
        StringBuilder numSb = new StringBuilder();
        
        while(Character.isDigit(c) && i >= 0){
          numSb.append(c);
          i--;
          if(i >= 0)
            c = str.charAt(i);
        }
        
        String lastStr = stack.pop();
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(numSb.reverse().toString());
        while(count > 0){
          sb.append(lastStr);
          count--;
        }
        stack.push(sb.toString());
      }
      else
        i--;
    }
    while(!stack.isEmpty()){
      result.append(stack.pop());
    }
    System.out.println(result);
    return result.toString();
  }

  int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
    Set<Integer> rowSet = IntStream.of(rowsToDelete).boxed().collect(Collectors.toSet());
    Set<Integer> colSet = IntStream.of(columnsToDelete).boxed().collect(Collectors.toSet());
    int orgRows = matrix.length;
    int orgCols = matrix[0].length;

    int[][] newArr = new int[orgRows-rowSet.size()][orgCols-colSet.size()];
    int newI = 0, newJ = 0;

    for(int i=0; i<orgRows; i++){
      if(rowSet.contains(i)) continue;
      for(int j=0; j<orgCols; j++){
        if(colSet.contains(j)) continue;
        newArr[newI][newJ++] = matrix[i][j];
      }
      newJ = 0;
      newI++;
    }
    printMatrix(newArr);
    return newArr;
  }


  private void rotateMatrix(int[][] mat, String direction) {
    int rows = mat.length;
    int cols = mat[0].length;
    //If left , reverse Columns
    for(int i=0;i<rows/2;i++){
      for(int j=0;j<cols;j++){
        //        i, j >> n-1-, j
        int temp = mat[i][j];
        mat[i][j] = mat[rows-1-i][j];
        mat[rows-1-i][j] = temp;
      }
    }

    //if Right reverse Rows
    printMatrix(mat);
    // Transpose 
    for(int i=0;i<rows;i++){
      for(int j=i+1;j<cols;j++){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }

    printMatrix(mat);

  }

  private void printMatrix(int[][] m){
    int rows = m.length;
    int cols = m[0].length;
    //If left , reverse Columns
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        System.out.print(m[i][j]+ " ");
      }
      System.out.println("");
    }

  }


  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n-1-j][i];
        matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        matrix[j][n-1-i] = temp;
      }
    }
  }
  
  boolean isCryptSolution(String[] crypt, char[][] solution) {
    int left = findNumber(crypt[0], solution);
    int right = findNumber(crypt[1], solution);
    int sum = findNumber(crypt[2], solution);
    System.out.println(left + " + " +right+ " = "+sum);
    if(left == -1 || right == -1 || sum == -1)
      return false;
    if(sum == left+right)
      return true;
    return false;
  }

  private int findNumber(String word, char[][] solution){
    StringBuilder sbuf = new StringBuilder();
    for(char c: word.toCharArray()){
      int num = 0;
      for(char[] solArr: solution){
        if(solArr[0] == c){
          num = (int) (solArr[1] - '0');
        }
      }
      sbuf.append(num);
    }
    if(sbuf.charAt(0) == '0')
      return -1;
    return Integer.parseInt(sbuf.toString());
  }

}
