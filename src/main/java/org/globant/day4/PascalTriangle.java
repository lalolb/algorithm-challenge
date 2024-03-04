package org.globant.day4;

import java.util.Arrays;

/**
 * Challenge name: Pascal’s Triangle
 * Description: Given numRows, generate the first numRows of Pascal’s triangle. For example, given numRows = 5, the result should be:
 *      [1]
 *     [1, 1]
 *    [1, 2, 1]
 *   [1, 3, 3, 1]
 *  [1, 4, 6, 4, 1]
 */
public class PascalTriangle {

    public int[][] generate(int numberOfRows) {
        int[][] triangleArr = new int[numberOfRows][];
        triangleArr[0] = new int[]{1};

        for(int i = 1; i < numberOfRows; i++) {
            int[] row = new int[i+1];
            for(int j = 0; j < row.length; j++) {
                row[j] = sumFromPreviousRow(triangleArr[i-1], j);
            }
            triangleArr[i] = row;
        }

        print(triangleArr);

        return triangleArr;
    }

    private int sumFromPreviousRow(int[] previousRow, int position) {
        if(position == 0 || position == previousRow.length) {
            return 1;
        } else {
            int aboveNumberLeft = previousRow[position-1];
            int aboveNumberRight = previousRow[position];
            return aboveNumberLeft + aboveNumberRight;
        }
    }

    private void print(int[][] triangleArr) {
        for (int i = 0; i < triangleArr.length; i++) {
            String spaces = " ".repeat(triangleArr.length - i);
            System.out.println(spaces + Arrays.toString(triangleArr[i]));
        }
        System.out.println();
    }

}
