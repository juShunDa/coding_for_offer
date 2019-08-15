package coding_for_fun;

/**
 * FindInMatrix class
 *
 * @author juideal
 * @date 2018/11/26
 */
public class P04FindInMatrix {
  public static boolean findInMatrix(int[][] matrix, int target) {
    int rows = matrix.length, row = 0;
    int columns = matrix[0].length, column = columns - 1;
    if (matrix == null || rows == 0 || columns == 0) {
      return false;
    }
    while (row <= rows - 1 && column >= 0) {
      if (matrix[row][column] == target) {
        /* return true; */
        System.out.println("target is in " + row + "," + column);
        System.out.printf("target is in %d, %d \n", row, column);
        return true;
      } else if (matrix[row][column] > target) {
        --column;
      } else {
        ++row;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] data = {{1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}};
    System.out.println(findInMatrix(data, 7));
  }
}
