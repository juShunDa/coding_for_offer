/**
 * FindDuplicate
 *
 * @author juideal
 * @date 2016/10/31
 */
public class _02_FindDuplicate {
  /**
   * 推荐的做法，通过交换元素，将值i保存到numbers[i]
   * 在numbers[i]不和i相等时，如果numbers[i]和numbers[numbers[i]]相等就说明重复元素；
   * 否则就交换这两个元素，这个过程相当于排序。举个例子，通过交换将2放入numbers[2]。

   * @param num 待查找的数组
   * @return 如果在数组中有重复元素
   */
  public static int duplication(int[] num) {
    if (num == null || num.length <= 0) {
      return -1;
    }
    for (int i = 0; i <= num.length - 1; i++) {
      if (num[i] < 0 || num[i] >= num.length) {
        return -1;
      }
    }

    for (int i = 0; i < num.length; i++) {
      while (num[i] != i) {
        if (num[i] == num[num[i]]) {
          return num[i];
        }
        swap(num, i, num[i]);
      }
    }
    return -1;
  }

  private static void swap(int[] num, int p, int q) {
    int temp = num[p];
    num[p] = num[q];
    num[q] = temp;
  }

  public static void main(String[] args) {
    int[] data = {2, 3, 1, 0, 2, 5, 3};
    System.out.println(duplication(data));
  }
}

