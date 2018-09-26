package tree;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class ComNode{
  public TreeNode node;
  public boolean isLeftProcessed;
  public boolean isRightProcessed;

  public ComNode(TreeNode node, boolean isLeftProcessed, boolean isRightProcessed){
    this.node = node;
    this.isLeftProcessed = isLeftProcessed;
    this.isRightProcessed = isRightProcessed;
  }
}

class TreeNode{
  public TreeNode left;
  public TreeNode right;
  public int data;
  public TreeNode(int data){
    this.data = data;
  }
}
class TreeProblem {
  private TreeNode root = null;

  public static void main(String[] args) {
    TreeProblem sol = new TreeProblem();
    TreeNode root = sol.createTree();
    sol.inorder(root);
    sol.levelOrder(root);
    sol.levelOrderQueue(root);
    sol.inorderIterative(root);
    sol.preOrderIterative(root);
    sol.postOrderIterative(root);
    int predecessor = sol.inOrderPredecessor(root, 7);
    int successor = sol.inOrderSuccesor(root, 7);
    int dia = sol.diameter(root);
    int diaEff = sol.diameterOn(root);
    String serializeStr = sol.serialize(root);
    TreeNode newRoot = sol.deSerialize(serializeStr);
    sol.inorder(newRoot);

    System.out.println("\nDiameter -->"+dia);
  }

  private TreeNode deSerialize(String str){
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(str.split(VAL_DELIMITER)));
    return parseString(queue);
  }

  private TreeNode parseString(Queue<String> nodes){
    String val = nodes.remove();
    if(val.equals(NULL_DELIMITER))
      return null;

    TreeNode root = new TreeNode(Integer.valueOf(val));
    root.left = parseString(nodes);
    root.right = parseString(nodes);

    return root;
  }

  private int inOrderSuccesor(TreeNode root, int target){
    if(root == null) return -1;
    int result = -1;
    while(root != null){
      if(root.data < target)
      {
        root = root.right;
      }
      else if(root.data > target){
        result = root.data;
        root = root.left;
      }
      else{
        root = root.right;
      }
    }
    System.out.println("\nSuccessor-->"+result);
    return result;
  }

  private void levelOrderQueue(TreeNode root){
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    System.out.println("***********\n");
    while(!queue.isEmpty()){
      TreeNode current = queue.poll();
      System.out.print(current.data + " ");

      if(current.right != null)
        queue.offer(current.right);
      if(current.left != null)
        queue.offer(current.left);
    }
  }

  private int inOrderPredecessor(TreeNode root, int target){
    if(root == null) return -1;
    int result = -1;
    while(root != null){
      if(root.data < target)
      {
        result = root.data;
        root = root.right;
      }
      else if(root.data > target){
        root = root.left;
      }
      else{
        root = root.left;
      }
    }
    System.out.println("\nPredecessor-->"+result);
    return result;
  }

  private void preOrderIterative(TreeNode root){
    // Same as level Order Just Replace Queue with Stack and change the order
    System.out.print("\nPreorder Traversal Iterative -->");
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while(!stack.isEmpty()){
      TreeNode current = stack.pop();
      System.out.print(current.data+ " ");
      if(current.right != null)
        stack.push(current.right);
      if(current.left != null)
        stack.push(current.left);
    }
  }

  private void postOrderIterative(TreeNode root){
    System.out.print("\nPostorder Traversal Iterative -->");
    Deque<ComNode> stack = new ArrayDeque<>();
    stack.push(new ComNode(root, root.left == null, root.right == null));

    while(!stack.isEmpty()){
      ComNode current = stack.peek();
      // If Root, then Print
      if(current.isRightProcessed && current.isLeftProcessed){
        System.out.print(current.node.data + " ");
        stack.pop();
      }
      else{
        if(current.node.right != null && !current.isRightProcessed){
          stack.push(new ComNode(current.node.right, current.node.right.left == null, current.node.right.right== null));
          current.isRightProcessed = true;
        }

        if(current.node.left != null && !current.isLeftProcessed){
          stack.push(new ComNode(current.node.left, current.node.left.left == null,   current.node.left.right == null));
          current.isLeftProcessed = true;
        }
      }
    }
  }

  private void inorderIterative(TreeNode root){
    System.out.print("\nInorder Traversal Iterative -->");
    Deque<TreeNode> stack = new ArrayDeque<>();
    //Fill Stack
    while(root != null){
      stack.push(root);
      root = root.left;
    }

    while(!stack.isEmpty()){
      TreeNode current = stack.pop();
      System.out.print(current.data + " ");
      TreeNode rNode = current.right;
      while(rNode != null){
        stack.push(rNode);
        rNode = rNode.left;
      }
    }
  }

  private void levelOrder(TreeNode root){
    int height = heightOfTree(root);
    System.out.print("\nheight of tree: "+height+"\n");
    for(int i=1;i<=height;i++){
      // for(int i=height;i>0;i--){
      printLevel(root,i);
      System.out.println("");
    }
  }

  private void printLevel(TreeNode root, int level){
    if(root == null) return;
    if(level == 1)
      System.out.print(root.data + " ");
    else{
      printLevel(root.left, level -1);
      printLevel(root.right, level -1);
    }
  }

  private int heightOfTree(TreeNode root){
    if(root == null) return 0;

    return 1+ Math.max(heightOfTree(root.left), heightOfTree(root.right));
  }
  private void inorder(TreeNode root){
    if(root == null) return;
    inorder(root.left);
    System.out.print(root.data + " ");
    inorder(root.right);
  }

  public TreeNode createTree(){
    root = new TreeNode(7);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(11);
    root.right.left.left = new TreeNode(9);
    // root.right.left.left.left = new TreeNode(8);
    // root.right.left.left.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(13);
    root.right.left.right.left = new TreeNode(12);
    // root.right.left.right.left.right = new TreeNode(13);
    return root;
  }

  private int diameter(TreeNode root){
    if(root == null) return 0;

    int lHeight = heightOfTree(root.left);
    int rHeight = heightOfTree(root.right);

    int lDia = diameter(root.left);
    int rDia = diameter(root.right);

    return Math.max((lHeight + rHeight + 1), 
        Math.max(lDia, rDia));
  }

  private int ans = Integer.MIN_VALUE;

  private int diameterOn(TreeNode root){
    if(root == null)
      return 0;
    int height = heightForDia(root);
    System.out.println("\nDia with O(n) is -->"+ans);
    return ans;

  }


  private int heightForDia(TreeNode root){
    if(root == null)
      return 0;

    int lHeight = heightForDia(root.left);
    int rHeight = heightForDia(root.right);

    ans = Math.max(ans, lHeight + rHeight + 1);
    return 1 + Math.max(heightForDia(root.left), heightForDia(root.right));

  }
  private static final String NULL_DELIMITER = "#";
  private static final String VAL_DELIMITER = ",";

  private String serialize(TreeNode root){
    StringBuilder sBuf = new StringBuilder();
    buildString(root, sBuf);
    System.out.println("\nSerialize -->"+sBuf.toString());
    return sBuf.toString();
  }

  private void buildString(TreeNode root, StringBuilder sb){
    if(root == null){
      sb.append(NULL_DELIMITER).append(VAL_DELIMITER);
      return ;
    }

    sb.append(root.data).append(VAL_DELIMITER);
    buildString(root.left, sb);
    buildString(root.right, sb);

  }
}

// To Be done 
// 1. Build tree from Ll 
// 2. Build tree from two traversal
// 3. Serialize and deSerialize