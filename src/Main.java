import java.math.BigInteger;
import java.util.Scanner;

class Main {
  public static void main (String[] args) {
    BigInteger num = new BigInteger("1");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    if (a == 0 || a == 1) {
      System.out.println(1);
      return;
    }

    for (int i = 1; i <= a; i++) {
      num = num.multiply(new BigInteger(i + ""));
    }

    char[] c = num.toString().toCharArray();
    for (int b = num.toString().length() - 1; b >= 0; b--) {
      if (c[b] != '0') {
        System.out.println(c[b]);
        return;
      }
    }
  }
}