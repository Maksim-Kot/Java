public class LocalMinOfMatrix {
    private int n, m;
    private int[][] matrix;

    public LocalMinOfMatrix(int n, int m, int[][] matrix) {
        this.n = n;
        this.m = m;
        this.matrix = matrix;
    }

    public Integer Calculate(){
        int amountOfMin = 0;
        int[][] matrix_ = new int[n+2][m+2];
        for (int i = 0; i < n+2; i++)
        {
            for (int j = 0; j < m+2; j++)
            {
                if(i == 0 || i == n+1 || j == 0 || j == m+1) matrix_[i][j] = Integer.MAX_VALUE;
                else matrix_[i][j] = matrix[i-1][j-1];
            }
        }


        for (int i = 1; i < n+1; i++)
        {
            for (int j = 1; j < m+1; j++)
            {
                if(matrix_[i-1][j] > matrix_[i][j] &&
                        matrix_[i+1][j] > matrix_[i][j] &&
                        matrix_[i][j-1] > matrix_[i][j] &&
                        matrix_[i][j+1] > matrix_[i][j]) amountOfMin++;
            }
        }
        return amountOfMin;

    }
}
