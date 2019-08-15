package coding_for_fun;

/**
 * @author juideal
 */
public class P10RectCover {
  /**
   * target = n 分为两步考虑：
   * 第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
   * 第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)
   * 因为，摆放了一块1*2的小矩阵（用√√表示），对应下方的1*2（用××表示）摆放方法就确定了，所以为f(target-2)
   *
   * @param target 给定多少个小矩形
   * @return 返回可能的拼法
   */
  private int rectCover (int target) {
    if (target <= 2) {
      return target;
    }
    int pre1 = 2, pre2 = 1;
    int result = 0;
    for (int i = 3; i <= target; i++) {
      result = pre1 + pre2;
      pre2 = pre1;
      pre1 = result;
    }
    return result;
  }

  public static void main (String[] args) {
    P10RectCover test = new P10RectCover();
    System.out.println(test.rectCover(3));
  }


}
