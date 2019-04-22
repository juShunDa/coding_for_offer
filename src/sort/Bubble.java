package sort;

/**
 * @program: coding_for_offer
 * @description: 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 *         在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 * @author: Mr.Ju
 * @create: 2019-04-22 17:16
 **/
public class Bubble<T extends Comparable<T>> extends AbstractSort<Integer> {
  @Override
  public void sort (int[] nums) {
    int N = nums.length;
    boolean isSorted = false;
    for (int i = 0)
  }
}
