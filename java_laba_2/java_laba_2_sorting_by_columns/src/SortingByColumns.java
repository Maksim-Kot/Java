public class SortingByColumns {
    private int n, m;
    private int[][] matrix;

    public SortingByColumns(int n, int m, int[][] matrix) {
        this.n = n;
        this.m = m;
        this.matrix = matrix;
    }

    public int[][] Calculate(){
        int[][] matrix_ = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                matrix_[i][j] = matrix[i][j];
            }
        }

        int[] minValues = new int[m];
        int i, j, min, tmp;

        for(j=0;j<m;j++)
        {
            minValues[j]=matrix_[0][j];
            for(i=1;i<n;i++)
                if(matrix_[i][j]<minValues[j])
                    minValues[j]=matrix_[i][j];
        }
        for(i=0; i<m-1; i++)
        {
            min=i;
            for(j=i+1; j<m; j++)
                if(minValues[j]<minValues[min])
                    min=j;
            for(j=0; j<n; j++)
            {
                tmp=matrix_[j][i];
                matrix_[j][i]=matrix_[j][min];
                matrix_[j][min]=tmp;
            }
            tmp=minValues[i];
            minValues[i]=minValues[min];
            minValues[min]=tmp;
        }
        return matrix_;
    }
}
