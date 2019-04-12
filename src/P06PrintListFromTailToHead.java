import dependentclass.ListNode;
import java.util.ArrayList;

/**
 * @program: coding_for_offer
 * @description: print list from tail to head
 * @author: Mr.Ju
 * @create: 2019-04-07 16:33
 **/


public class P06PrintListFromTailToHead {
  public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> ret = new ArrayList<>();
    if (listNode != null) {
      ret.addAll(printListFromTailToHead(listNode.getNext()));
      ret.add(listNode.getData());
    }
    return ret;
  }

  public  ArrayList<Integer> printListFromTailToHeadTwo (ListNode listNode) {
    // 头插法构建逆序链表
    ListNode headNode = new ListNode(-1);
    while (listNode != null) {
      ListNode memo = listNode.getNext();
      listNode.setNext(headNode);
      headNode.setNext(listNode);
      listNode = memo;
    }
    // 构建 ArrayList
    ArrayList<Integer> ret = new ArrayList<>();
    headNode = headNode.getNext();
    while (headNode != null) {
      ret.add(headNode.getData());
      headNode = headNode.getNext();
    }
    return ret;
  }

  public ListNode reverseList(ListNode head) {
    ListNode next = null;
    ListNode pre = null;
    while (head != null) {
      // head 指向第一个节点，也指向当前节点--要反转到头部的那个节点
      // 保存当前节点之后的信息
      next.setNext(head.getNext());
      // 要反转的那个节点指向已经反转的上一个节点
      head.setNext(pre);
      //上一个已经反转到头部的节点
      pre = head;
      // 当前节点后移，指向下一个节点，继续处理
      head = next.getNext();
    }
    return pre;
  }

  public static void main(String[] args) {

    ListNode headNode = null;
    int i = 0;
    for (; i < 10; i++) {
      ListNode newNode = new ListNode(i);
      newNode.setNext(headNode);
      headNode = newNode;
    }

    ListNode pointNode = headNode;
    int n = 0;
    for (; n < 10; n++) {
      System.out.print(pointNode.getData() + " ");
      pointNode = pointNode.getNext();
    }
    System.out.println();

    P06PrintListFromTailToHead p = new P06PrintListFromTailToHead();
    p.printListFromTailToHeadTwo(headNode);
  }
}


