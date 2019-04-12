package dependentclass;


/**
 * @program: coding_for_offer
 * @description: implement of binary tree node
 * @author: Mr.Ju
 * @create: 2019-04-11 16:04
 **/
public class TreeNode<T> {
  public T val;
  public TreeNode<T> left;
  public TreeNode<T> right;
  public TreeNode(T val){
    this.val = val;
    this.left = null;
    this.right = null;
  }
}
