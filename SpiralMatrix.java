import java.util.*;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        while (startrow <= endrow && startcol <= endcol) {

            // top
            for (int j = startcol; j <= endcol; j++) {
                ans.add(matrix[startrow][j]);
            }

            // right
            for (int i = startrow + 1; i <= endrow; i++) {
                ans.add(matrix[i][endcol]);
            }

            // bottom
            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) break;
                ans.add(matrix[endrow][j]);
            }

            // left
            for (int i = endrow - 1; i >= startrow + 1; i--) {
                if (startcol == endcol) break;
                ans.add(matrix[i][startcol]);
            }

            startrow++;
            startcol++;
            endrow--;
            endcol--;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input rows and columns
        System.out.print("Enter rows: ");
        int m = sc.nextInt();

        System.out.print("Enter cols: ");
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        // input matrix
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // call function
        List<Integer> result = spiralOrder(matrix);

        // print result
        System.out.println("Spiral Order:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}