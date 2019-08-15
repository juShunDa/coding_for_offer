package coding_for_fun;

import java.util.LinkedList;
import java.util.Queue;
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


class QueueSimulateStack<T> {
  private Queue<T> queue1 = new LinkedList<>();
  private Queue<T> queue2 = new LinkedList<>();

  public void push (T data) {
    if (!queue2.isEmpty()) {
      queue2.offer(data);
    } else {
      queue1.offer(data);
    }
  }

  public T pop () {
    if (!queue2.isEmpty()) {
      int size = queue2.size();
      for (int i = 0; i < size - 1; i++) {
        queue1.offer(queue2.poll());
      }
      return queue2.poll();
    } else if (!queue1.isEmpty()) {
      int size = queue1.size();
      for (int i = 0; i < size - 1; i++) {
        queue2.offer(queue1.poll());
      }
      return queue1.poll();
    } else {
      return null;
    }
  }
}