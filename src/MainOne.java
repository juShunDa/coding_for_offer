import java.util.Arrays;
import java.util.Scanner;

public class MainOne {

  public static int inversePairs (int[] data) {
    if (data == null || data.length < 1) {
      throw new IllegalArgumentException("Array arg should contain at least a value");
    }

    int[] copy = new int[data.length];
    System.arraycopy(data, 0, copy, 0, data.length);

    return inversePairsCore(data, copy, 0, data.length - 1);
  }

  private static int inversePairsCore (int[] data, int[] copy, int start, int end) {

    if (start == end) {
      copy[start] = data[start];
      return 0;
    }

    int length = (end - start) / 2;
    int left = inversePairsCore(copy, data, start, start + length);
    int right = inversePairsCore(copy, data, start + length + 1, end);

    // 前半段的最后一个数字的下标
    int i = start + length;
    // 后半段最后一个数字的下标
    int j = end;
    // 开始拷贝的位置
    int indexCopy = end;
    // 逆序数
    int count = 0;

    while (i >= start && j >= start + length + 1) {
      if (data[i] > data[j]) {
        copy[indexCopy] = data[i];
        indexCopy--;
        i--;
        count += j - (start + length); // 对应的逆序数
      } else {
        copy[indexCopy] = data[j];
        indexCopy--;
        j--;
      }
    }

    for (; i >= start; ) {
      copy[indexCopy] = data[i];
      indexCopy--;
      i--;
    }

    for (; j >= start + length + 1; ) {
      copy[indexCopy] = data[j];
      indexCopy--;
      j--;
    }
    return count + left + right;
  }

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int[] numList = new int[m];
    for (int i = 0; i < m; i++) {
      numList[i] = sc.nextInt();
    }

    System.out.println(inversePairs(numList));
  }
}
