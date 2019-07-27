package coding_for_fun;

/**
 * FindDuplicate
 *
 * @author juideal
 * @date 2016/10/31
 */
public class P03FindDuplicate {
  /**
   * 推荐的做法，通过交换元素，将值i保存到numbers[i]
   * 在numbers[i]不和i相等时，如果numbers[i]和numbers[numbers[i]]相等就说明重复元素；
   * 否则就交换这两个元素，这个过程相当于排序。举个例子，通过交换将2放入numbers[2]。
   * @param num 待查找的数组
   * @return 如果在数组中有重复元素
   */
  public static int duplicationOne(int[] num) {
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

  public static int duplicationTwo(int[] num) {
    if (num == null || num.length <= 0) {
      return -1;
    }
    int start = 1;
    int end = num.length - 1;
    while (end >= start) {
      //int niddle = ((end - start)/2 + start);
      int middle = ((end - start) >> 1) + start;
      int count = countRange(num, start, middle);
      if (end == start) {
        if (count > 1) {
          return start;
        } else {
          break;
        }
      }
      if (count > (middle - start + 1)) {
        end = middle;
      } else {
        start = middle + 1;
      }
    }
    return -1;
  }

  public static int countRange(int[] num, int start, int end) {
    if (num.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < num.length; i++) {
      if (num[i] >= start && num[i] <= end) {
        ++count;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] data = {4, 3, 1, 0, 2, 5, 3};
    System.out.println(duplicationTwo(data));
    System.out.println(duplicationOne(data));
  }
}

