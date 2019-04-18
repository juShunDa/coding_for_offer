import java.util.Stack;

/**
 * @program: coding_for_offer
 * @description: 用两个栈模拟队列
 * @author: Mr.Ju
 * @create: 2019-04-18 16:37
 **/
public class P09StacksSimulateQueue {
  Stack<Integer> in = new Stack<>();
  Stack<Integer> out = new Stack<>();

  public void push(int node) {
    in.push(node);
  }

  public int pop() throws Exception {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }
    if (out.isEmpty()) {
      throw new Exception("queue is empty");
    }
    return out.pop();
  }
}
