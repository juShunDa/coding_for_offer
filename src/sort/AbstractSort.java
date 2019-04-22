package sort;

/**
 * @program: coding_for_offer
 * @description: 待排序的元素需要实现 Java 的 Comparable 接口，
 *         该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系。
 *         使用辅助函数 less() 和 swap()来进行比较和交换的操作，
 *         排序算法的成本模型是比较和交换的次数。
 * @author: Mr.Ju
 * @create: 2019-04-22 16:25
 **/
public abstract class AbstractSort<T extends Comparable<Integer>> {

  public abstract void sort (int[] nums);

  boolean less (Integer v, Integer w) {
    return v.compareTo(w) < 0;
  }

  void swap (int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
