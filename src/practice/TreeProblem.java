package practice;

import java.util.*;

public class TreeProblem {

  private TreeNode root = null;
  
  public static void main(String...strings){
    TreeProblem prob = new TreeProblem();
    prob.insertData();
    prob.inorder(prob.root);
    System.out.println("");
    prob.levelOrder(prob.root);
  }
  
  private void inorder(TreeNode root) {
    if(root == null)
      return;
    
    inorder(root.left);
    System.out.print(root.data+ " ");
    inorder(root.right);
  }
  private void levelOrder(TreeNode root) {
    if(root == null)
      return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      TreeNode currNode = queue.poll();
      System.out.print(currNode.data + " ");
      if(currNode.left != null)
        queue.offer(currNode.left);
      if(currNode.right != null)
        queue.offer(currNode.right);
    }
  }

  private void insertData() {
    root = new TreeNode(8);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(7);
    root.right = new TreeNode(11);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(18);
  }
}
