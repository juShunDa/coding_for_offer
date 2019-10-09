import java.util.Scanner;

/**
 * @program: coding_for_offer
 * @description: test
 * @author: Mr.Ju
 * @create: 2019-09-21 15:45
 **/
public class Main09_21 {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int[] numList = new int[m];
    for (int i = 0; i < m; i++) {
      numList[i] = sc.nextInt();
    }
    Main09_21 solution = new Main09_21();
    solution.method(numList);
  }

  public void method (int[] numList) {
    int sum = 0;
    for (int i = 0; i < numList.length; i++) {
      for (int j = i + 1; j < numList.length - 1; j++) {
        if (numList[i] > numList[j]) {
          sum = sum + j - i;
        }
      }
    }
    System.out.println(sum);
  }
}
