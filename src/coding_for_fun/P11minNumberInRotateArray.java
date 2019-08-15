package coding_for_fun;

/**
 * @program: coding_for_offer
 * @description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，该数组的最小值为 1。
 * @author: Mr.Ju
 * @create: 2019-04-20 21:01
 **/
public class P11minNumberInRotateArray {
  public int minNumberInRotateArray (int[] array) {
    /**
     * @Description:
     * @return: int
     * @Param:  * @param array
     * @Author: juideal
     * @Date: 19-4-20 下午9:05
     */
    if (array.length == 0) {
      return 0;
    }
    int l = 0;
    int h = array.length - 1;
    while (l < h) {
      int mid = l + (h - l) / 2;
      /*

      如果数组元素允许重复的话，那么就会出现一个特殊的情况：array[l] == array[m] == array[h]，
      那么此时无法确定解在哪个区间，需要切换到顺序查找。例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，
      此时无法知道最小数字 0 在哪个区间。

      */
      if (array[l] == array[mid] && array[mid] == array[h]) {
        return minNumber(array, l, h);
      } else if (array[mid] <= array[h]) {
        h = mid;
      } else {
        l = mid + 1;
      }
    }
    return array[l];
  }

  private int minNumber (int[] array, int l, int h) {
    /**
     * @Description:
     * @return: int
     * @Param:  * @param array 非递减排序的数组
     * @param l 数组最左指针
     * @param h 数组最右指针
     * @Author: juideal
     * @Date: 19-4-20 下午9:15
     */
    for (int i = l; i < h; i++) {
      if (array[i] > array[i + 1]) {
        return array[i + 1];
      }
    }
    return array[l];
  }
}
