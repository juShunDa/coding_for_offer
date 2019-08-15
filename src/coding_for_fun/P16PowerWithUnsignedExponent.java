package coding_for_fun;

/**
 * @program: coding_for_offer
 * @description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author: Mr.Ju
 * @create: 2019-08-15 22:18
 **/
public class P16PowerWithUnsignedExponent {
  public static double power (double base, int exponent) {
    /**
     * @Description: 递归， 判断各种情况
     * @return: double
     * @Param:  * @param base
     * @param exponent
     * @Author: juideal
     * @Date: 2019/8/15 下午10:39
     */
    if (base == 0 && exponent == 0) {
      throw new RuntimeException("invalid input. base and exponent both are zero");
    }
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    boolean isNagtive = false;
    if (exponent < 0) {
      exponent = -exponent;
      isNagtive = true;
    }
    double pow = power(base * base, exponent / 2);
    if (exponent % 2 != 0) {
      pow = pow * base;
    }
    return isNagtive ? 1 / pow : pow;
  }

  public static void main (String[] args) {
    System.out.println(power(2, -4));
    System.out.println(power(2, 4));
    System.out.println(power(2, 0));
    System.out.println(power(0.00000000000000000000000000001, -1));
    System.out.println(power(0.00000000000000000000000000001, 1));
    System.out.println(power(0.00000000000000000000000000001, 0));
    System.out.println(power(0.00000000000000000000000000000, 0));
  }
}
