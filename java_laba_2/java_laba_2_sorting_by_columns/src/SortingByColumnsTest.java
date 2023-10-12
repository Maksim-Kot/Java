import static org.junit.jupiter.api.Assertions.*;

class NormOfMatrixTest {

    @org.junit.jupiter.api.Test
    void calculate1() {
        int [][] m = {{8, 8}, {3, -2}, {8, -8}};
        SortingByColumns a = new SortingByColumns(3, 2, m);
        int [][] result = {{8, 8}, {-2, 3}, {-8, 8}};
        assertArrayEquals(result, a.Calculate());
    }

    @org.junit.jupiter.api.Test
    void calculate2() {
        int [][] m = {{9, 6, 2}, {4, 4, 7}, {5, 3, 8}};
        SortingByColumns a = new SortingByColumns(3, 3, m);
        int [][] result = {{2, 6, 9}, {7, 4, 4}, {8, 3, 5}};
        assertArrayEquals(result, a.Calculate());
    }

    @org.junit.jupiter.api.Test
    void calculate3() {
        int [][] m = {{2, 6, 9}, {7, 4, 4}, {8, 3, 5}};
        SortingByColumns a = new SortingByColumns(3, 3, m);
        assertArrayEquals(m, a.Calculate());
    }
}