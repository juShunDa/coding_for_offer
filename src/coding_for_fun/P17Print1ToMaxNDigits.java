package coding_for_fun;

import sun.awt.X11.XWMHints;

/**
 * @program: coding_for_offer
 * @description: 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * @author: Mr.Ju
 * @create: 2019-08-15 23:09
 **/
public class P17Print1ToMaxNDigits {
  public void printOneToMaxNDigits (int n) {
    if (n < 0) {
      return;
    }
    char[] number = new char[n];
    printOneToMaxNDigits(number, 0);

  }

  private void printOneToMaxNDigits (char[] number, int digit) {
    if (digit == number.length) {
      printNumber(number);
      return;
    }
    for (int i = 0; i < 10; i++) {
      number[digit] = (char) (i + '0');
      printOneToMaxNDigits(number, digit + 1);
    }

  }

  private void printNumber (char[] number) {
    int index = 0;
    while (index < number.length && number[index] == '0') {
      index++;
    }
    while (index < number.length) {
      System.out.print(number[index++]);
    }
    System.out.println();
  }

  public static void main (String[] args) {
    P17Print1ToMaxNDigits solution = new P17Print1ToMaxNDigits();
    solution.printOneToMaxNDigits(2);
  }
}
