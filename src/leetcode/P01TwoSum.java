package leetcode;

import java.util.HashMap;

/**
 * @program: coding_for_offer
 * @description: two sum
 * @author: Mr.Ju
 * @create: 2019-07-27 15:46
 **/
public class P01TwoSum {
  private static int[] twoSum (int[] nums, int target) {
    HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
    int[] res = new int[2];
    for (int i = 0; i < nums.length; ++i) {
      m.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; ++i) {
      int t = target - nums[i];
      if (m.containsKey(t) && m.get(t) != i) {
        res[0] = i;
        res[1] = m.get(t);
        break;
      }
    }
    return res;
  }

  public static void main (String[] args) {
    int[] a = {2, 3, 4, 5, 9, 10};
    System.out.println("test");
    final int[] ints = twoSum(a, 7);
    System.out.println(ints[0]);
  }
}
