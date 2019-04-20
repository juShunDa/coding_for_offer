import java.util.Arrays;

import static java.lang.Math.pow;

/**
 * @program: coding_for_offer
 * @description: 斐波那契数列
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 * @author: Mr.Ju
 * @create: 2019-04-19 22:44
 **/
public class P10JumpFloorTwo {
  /**
   * @Description: 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
   * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
   * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
   * f(n) = f(n-1) + f(n-2) + ... + f(0)
   * 综上可得
   * f(n) - f(n-1) = f(n-1)
   * 即
   * f(n) = 2*f(n-1)
   * 所以 f(n) 是一个等比数列
   * @return: int
   * @Param: * @param n
   * @Author: juideal
   * @Date: 19-4-19 下午10:49
   */
  public static int jumpFloorTwo (int target) {
    return (int) pow(2, target - 1);
  }

  public static int jumpFloorTwoDanymic (int target) {
    int[] dp = new int[target];
    Arrays.fill(dp, 1);
    for (int i = 1; i <= target; i++) {
      for (int j = i; j <= i; i++) {
        dp[i] += dp[j];
      }
    }
    return dp[target - 1];
  }
}
