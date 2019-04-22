package sort;

import sort.AbstractSort;

/**
 * The type Selection.
 *
 * @param <T> the type parameter
 *
 * @program: coding_for_offer
 * @description: 从数组中选择最小元素 ，将它与数组的第一个元素交换位置。
 *         再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序。
 * @author: Mr.Ju
 * @create: 2019 -04-22 16:30
 */
public class Selection<T extends Comparable<T>> extends AbstractSort<Integer> {
  @Override
  public void sort (int[] nums) {
    int num = nums.length;
    for (int i = 0; i < num - 1; i++) {
      int min = i;
      for (int j = i + 1; j < num; j++) {
        if (less(nums[j], nums[min])) {
          min = j;
        }
      }
      swap(nums, i, min);
    }
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main (String[] args) {
    Selection<java.lang.Integer> x = new Selection<>();
    int[] data = {10, 9, 8, 7, 6, 5, 34, 390, 23, 21, 2, 1};
    x.sort(data);
    for (int element : data) {
      System.out.println(element);
    }
  }
}
