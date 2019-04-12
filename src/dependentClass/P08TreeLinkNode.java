package dependentClass;

/**
 * @program: coding_for_offer
 * @description: 二叉树节点包含指向左右孩子节点和父节点的指针
 * @author: Mr.Ju
 * @create: 2019-04-12 20:29
 **/
public class P08TreeLinkNode {
  int val;
  P08TreeLinkNode left = null;
  P08TreeLinkNode right = null;
  P08TreeLinkNode next = null;

  P08TreeLinkNode(int val) {
    this.val = val;
  }
}
