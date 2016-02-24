/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
public class Solution {
    public void rotate(int[][] matrix) {
        // input validation
        if(matrix == null || matrix.length == 0) {
            return;
        }
        int max = matrix.length - 1;
        for(int min = 0; min < max; min++, max--) {
            for(int j = 0; j< max - min; j++) {
                int temp = matrix[min][min+j];
                matrix[min][min+j] = matrix[max - j][min];
                matrix[max - j][min] = matrix[max][max - j];
                matrix[max][max - j] = matrix[min + j][max];
                matrix[min + j][max] = temp;
            }
        }
    }
}
