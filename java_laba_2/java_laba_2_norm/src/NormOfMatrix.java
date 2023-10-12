import java.util.Arrays;

public class NormOfMatrix {
    private int n, m;
    private int[][] matrix;

    public NormOfMatrix(int n, int m, int[][] matrix) {
        this.n = n;
        this.m = m;
        this.matrix = matrix;
    }

    public Integer Calculate() {
        int [] sum_in_line = new int[n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                sum_in_line[i] += Math.abs(matrix[i][j]);
            }
        }
        int norm = Arrays.stream(sum_in_line).max().getAsInt();
        return norm;
    }


}
