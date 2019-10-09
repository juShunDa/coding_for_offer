/**
 * @program: coding_for_offer
 * @description: test
 * @author: Mr.Ju
 * @create: 2019-10-09 18:33
 **/

import java.util.*;

public class MainSolution {
  public ArrayList<String> permutation (String str) {
    ArrayList<String> list = new ArrayList<String>();
    if (str == null || str.length() == 0) {
      return list;
    }
    list.add(str);
    getList(0, str, list);
    Collections.sort(list);    //按字母顺序进行排序
    return list;
  }

  public static void getList (int start, String str, ArrayList<String> list) {
    if (start >= str.length() - 1) {
      return;
    }

    String strBackup = str;
    StringBuffer sb = new StringBuffer(strBackup);
    for (int i = start; i < str.length() - 1; i++) {
      for (int j = i + 1; j < str.length(); j++) {
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
        //去重
        if (!list.contains(sb.toString())) {
          list.add(sb.toString());
        }
        getList(start + 1, sb.toString(), list);
        sb = new StringBuffer(strBackup);
      }
    }
  }
}

