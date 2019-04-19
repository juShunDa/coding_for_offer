/**
 * @program: coding_for_offer
 * @description: 递归法求斐波那契数
 * @author: Mr.Ju
 * @create: 2019-04-18 17:56
 **/
public class P10Fibonacci {
  private int fibonacci_one (int n) {
    if (n <= 0) {
      return n;
    }
    if (n == 1) {
      return n;
    }
    return fibonacci_one(n - 1) + fibonacci_one(n - 2);
  }

  private int fibonacci_two (int n) {
    if (n <= 0) {
      return n;
    }
    if (n == 1) {
      return n;
    }
    int pre2 = 0;
    int pre1 = 1;
    int fib = 0;
    for (int i = 2; i <= n; i++) {
      fib = pre1 + pre2;
      pre2 = pre1;
      pre1 = fib;
    }
    return fib;
  }
}
