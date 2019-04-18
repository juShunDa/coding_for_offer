import dependentclass.TreeNode;
import java.util.HashMap;
import java.util.Map;




/**
 * @program: coding_for_offer
 * @description: 剑指offer第七题
 * @author: Mr.Ju
 * @create: 2019-04-11 16:19
 **/
public class P07reConstructBinaryTree {
  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    if (pre == null || in == null || pre.length <= 0 || in.length <= 0) {
      return null;
    }
    return constructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
  }

  private TreeNode constructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
    // 原理都是一样的，也可能给的是length
    if (startPre > endPre || startIn > endIn) {
      return null;
    }
    TreeNode root = new TreeNode<>(pre[startPre]);
    for (int i = startIn; i <= endIn; i++) {
      if (in[i] == pre[startPre]) {
        // startPre + i - startIn
        root.left = constructCore(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
        // startPre + i - startIn + 1
        root.setRight(constructCore(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn));
        break;
      }
    }
    return root;
  }

  private Map<Integer, Integer> indexForInOrders = new HashMap<>();

  public TreeNode reConstructBinaryTreeTwo(int[] pre, int[] in) {
    for (int i = 0; i <= in.length; i++) {
      indexForInOrders.put(in[i], i);
    }
    return reConstructBinaryTreeTwo(pre, 0, pre.length - 1, 0);
  }

  private TreeNode reConstructBinaryTreeTwo(int[] pre, int preL, int preR, int inL) {
    /*
     *  preL --> startPre; preR --> endPre; inL --> startIn;
     */
    if (preL > preR) {
      return null;
    }
    TreeNode root = new TreeNode<>(pre[preL]);
    int inIndex = indexForInOrders.get(root.val);
    int leftTreeSize = inIndex - inL;
    root.left = reConstructBinaryTreeTwo(pre, preL + 1, preL + leftTreeSize, inL);
    root.setRight(reConstructBinaryTreeTwo(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1));
    return root;
  }

}
