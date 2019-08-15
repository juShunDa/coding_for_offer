package coding_for_fun;

/**
 * @program: coding_for_offer
 * @description: 跳台阶, 递归, 斐波那契数列
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @author: Mr.Ju
 * @create: 2019-04-19 22:36
 **/
public class P10JumpFloor {
  /**
   * @Description: a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
   *         <p>
   *         b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
   *         <p>
   *         c.由a\b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
   *         <p>
   *         d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
   *         <p>
   *         e.可以发现最终得出的是一个斐波那契数列：
   * @return: int
   * @Param: * @param n
   * @Author: juideal
   * @Date: 19-4-19 下午10:37
   */

  public int jumpFloor (int n) {
    if (n <= 2) {
      /* 不允许任何魔法值（即未经定义的常量）直接出现在代码中。 */
      return n;
    }
    int pre2 = 1;
    int pre1 = 2;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = pre1 + pre2;
      pre2 = pre1;
      pre1 = result;
    }
    return result;
  }
}
