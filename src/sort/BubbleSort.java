package sort;

/**
 * @program: coding_for_offer
 * @description: 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 * @author: Mr.Ju
 * @create: 2019-04-22 17:16
 **/
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<Integer> {
  @Override
  public void sort (int[] nums) {
    int N = nums.length;
    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j < N - 1 - i; j++) {
        if (less(nums[j + 1], nums[j])) {
          swap(nums, j + 1, j);
        }
      }
    }
  }

  private void sortTwo (int[] nums) {
    int N = nums.length;
    boolean isSorted = false;
    for (int i = N - 1; i > 0 && !isSorted; i--) {
      isSorted = true;
      for (int j = 0; j < i; j++) {
        if (less(nums[j + 1], nums[j])) {
          isSorted = false;
          swap(nums, j, j + 1);
        }
      }
    }
  }

  private void showArray (int[] nums) {
    for (int element : nums) {
      System.out.print(element + " ");
    }
  }

  public static void main (String[] args) {
    int[] array = new int[]{34, 23, 12, 45, 87, 34, 24, 90};
    BubbleSort sorter = new BubbleSort();
    sorter.sort(array);
    int[] data = {10, 9, 8, 7, 6, 5, 34, 390, 23, 21, 2, 1};
    sorter.sortTwo(data);
    sorter.showArray(data);
    System.out.println();
    sorter.showArray(array);
  }

}
