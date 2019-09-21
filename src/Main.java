import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: coding_for_offer
 * @description: test
 * @author: Mr.Ju
 * @create: 2019-09-19 17:23
 **/
public class Main {
  public static void main (String[] args) {
    Main method = new Main();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String[] strOne = sc.nextLine().trim().split("");
      int numTrip = Integer.valueOf(strOne[0]);
      int numRoad = Integer.valueOf(strOne[1]);
      boolean[] sence = new boolean[numTrip + 1];
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int i = 0; i < numRoad; i++) {
        String[] strTemp = sc.nextLine().trim().split("");
        map.put(Integer.valueOf(strTemp[0]), Integer.valueOf(strTemp[1]));
      }
      String[] startEnd = sc.nextLine().trim().split("");
      method.getUnTrip(map, sence, Integer.valueOf(startEnd[0]), Integer.valueOf(startEnd[0]));

    }

  }

  public void getUnTrip (Map<Integer, Integer> map, boolean[] sence, int start, int end) {
    if (start < sence.length) {
      sence[start] = true;
    }
    while (map.containsKey(start)) {
      int tempVal = map.get(start);
      if (0 <= tempVal && tempVal < sence.length && !sence[tempVal]) {
        start = tempVal;
        sence[start] = true;
      }
    }
    for (int i = 1; i < sence.length; i++) {
      if (!sence[i]) {
        System.out.println(i + " ");
      }
    }
  }

}
