public class P05ReplaceSpace {
  public static void replaceSpace(char[] charArray,int length) {
    if (charArray == null || length <= 0) {
      return;
    }
    int numberOfBlanks = 0;
    for (char c : charArray) {
      if (c == ' ') {
        ++numberOfBlanks;
      }
    }
    System.out.println("nuber Of blanks:" + numberOfBlanks);
    int newLength = charArray.length + (numberOfBlanks * 2);
    if (newLength > length) {
      return;
    }

    int indexOfOrigin = charArray.length - 1;
    int indexOfNew = newLength - 1;

    char[] newArray = new char[newLength];
    /*
    while (indexOfOrigin >= 0 && indexOfNew > indexOfOrigin) {
      if (charArray[indexOfOrigin] == ' ') {
        //attention the difference of "" and ''
        newArray[indexOfNew--] = '0';
        newArray[indexOfNew--] = '2';
        newArray[indexOfNew--] = '%';
      } else {
        newArray[indexOfNew--] = charArray[indexOfOrigin];
      }
      System.out.println(charArray[--indexOfOrigin]);
    }
    */
    for (; indexOfNew >= 0; indexOfNew--, indexOfOrigin--) {
      if (charArray[indexOfOrigin] == ' ') {
        //attention the difference of "" and ''
        newArray[indexOfNew--] = '0';
        newArray[indexOfNew--] = '2';
        newArray[indexOfNew] = '%';
      } else {
        newArray[indexOfNew] = charArray[indexOfOrigin];
      }
    }
    System.out.println(newArray);
  }

  public static String replaceSpaceTwo(StringBuffer str) {
    int indexOfOrigin = str.length() - 1;
    for (int i = 0; i <= indexOfOrigin; i++) {
      if (str.charAt(i) == ' ') {
        str.append("  ");
      }
    }
    int indexOfNew = str.length() - 1;
    while (indexOfOrigin >= 0 && indexOfNew > indexOfOrigin) {
      char c = str.charAt(indexOfOrigin--);
      if (c == ' ') {
        str.setCharAt(indexOfNew--, '0');
        str.setCharAt(indexOfNew--, '2');
        str.setCharAt(indexOfNew--, '%');
      } else {
        str.setCharAt(indexOfNew--, c);
      }
    }
    return str.toString();
  }


  public static void main(String[] args) {
    char[] preArray = " we are happy.".toCharArray();
    System.out.println(preArray);
    replaceSpace(preArray, 200);
    StringBuffer str = new StringBuffer("we are happy.");
    System.out.println(str);
    System.out.println(replaceSpaceTwo(str));
  }
}
