package dependentclass;

import java.util.*;

/**
 * @author juideal
 */
public class TraversalOfBinaryTree {
  //前序遍历递归版
  public static List<Integer> preorderRecursively(TreeNode<Integer> node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) {
      return list;
    }
    list.add(node.val);
    list.addAll(preorderRecursively(node.left));
    list.addAll(preorderRecursively(node.getRight()));
    return list;
  }

  public static List<Integer> inorderRecursively(TreeNode<Integer> node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) {
      return list;
    }
    list.addAll(inorderRecursively(node.left));
    list.add(node.val);
    list.addAll(inorderRecursively(node.getRight()));
    return list;
  }

  //后序遍历递归版
  public static List<Integer> postorderRecursively(TreeNode<Integer> node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) {
      return list;
    }
    list.addAll(postorderRecursively(node.left));
    list.addAll(postorderRecursively(node.getRight()));
    list.add(node.val);
    return list;
  }

  //前序遍历非递归版
  public static List<Integer> preorderIteratively(TreeNode<Integer> node) {
    Stack<TreeNode<Integer>> stack = new Stack<>();
    TreeNode<Integer> cur = node;
    List<Integer> list = new LinkedList<>();
    if (node == null) {
      return list;
    }
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        list.add(cur.val);
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.pop().getRight();
      }
    }
    return list;
  }

  public static List<Integer> inorderIteratively(TreeNode<Integer> node) {
    Stack<TreeNode<Integer>> stack = new Stack<>();
    TreeNode<Integer> cur = node;
    List<Integer> list = new LinkedList<>();
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        list.add(stack.peek().val);
        cur = stack.pop().getRight();
      }
    }
    return list;
  }

  //后序遍历非递归版
  public static List<Integer> postorderIteratively(TreeNode<Integer> node) {
    //stack栈顶元素永远为cur的父节点
    //prevVisted用于区分是从左子树还是右子树返回的
    Stack<TreeNode<Integer>> stack = new Stack<>();
    TreeNode<Integer> cur = node;
    TreeNode<Integer> prevVisted = null;
    List<Integer> list = new LinkedList<>();
    // || 与 有一个为真就为真
    while(cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.peek().getRight();
        if (cur != null && cur != prevVisted) {
          stack.push(cur);
          cur = cur.left;
        } else {
          prevVisted = stack.pop();
          list.add(prevVisted.val);
          cur = null;
        }
      }
    }
    return list;
  }

  // 层次遍历
  public static List<Integer> levelorder(TreeNode<Integer> node) {
    Queue<TreeNode<Integer>> queue = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    TreeNode<Integer> temp = null;
    if (node == null) {
      return list;
    }
    queue.add(node);
    while (!queue.isEmpty()) {
      temp = queue.poll();
      list.add(temp.val);

      if (temp.left != null) {
        queue.offer(temp.left);
      }
      if (temp.getRight() != null) {
      queue.offer(temp.getRight());
      }
    }
    return list;
  }

}

