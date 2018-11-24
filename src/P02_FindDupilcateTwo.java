/**
 * FindDuplicate
 *
 * @author juideal
 * @date 2016/10/31
 */
public class P02_FindDupilcateTwo {
  /**
   * 推荐的做法，通过交换元素，将值i保存到numbers[i]
   * 在numbers[i]不和i相等时，如果numbers[i]和numbers[numbers[i]]相等就说明重复元素；
   * 否则就交换这两个元素，这个过程相当于排序。举个例子，通过交换将2放入numbers[2]。

   * @param num 待查找的数组
   * @param length 数组的长度，其实就是numbers.length
   * @param duplication 用于保存重复数字，第一个被找到的重复数字存放在duplication[0]中
   * @return 如果在数组中有重复元素
   */
  public static boolean duplication(int[] num, int length, int[] duplication) {
    if (num == null || length <= 0) {
      return false;
    }
    for (int i = 0; i <= length - 1; i++) {
      if (num[i] < 0 || num[i] >= length) {
        return false;
      }
    }

    for (int i = 0; i < num.length; i++) {
      while (num[i] != i) {
        if (num[i] == num[num[i]]) {
          duplication[0] = num[i];
          return true;
        }
        swap(num, i, num[i]);
      }
    }
    return false;
  }

  private static void swap(int[] num, int p, int q) {//注意参数传递问题
    int temp = num[p];
    num[p] = num[q];
    num[q] = temp;
  }

  public static void main(String[] args) {
    int[] data = {2, 3, 1, 0, 2, 5, 3};
    int[] duplication = new int[1];
    System.out.println(duplication(data, data.length, duplication));
    System.out.println(duplication[0]);
  }
}

