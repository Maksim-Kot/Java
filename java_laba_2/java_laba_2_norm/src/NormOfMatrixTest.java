import static org.junit.jupiter.api.Assertions.*;

class NormOfMatrixTest {

    @org.junit.jupiter.api.Test
    void calculate1() {
        int [][] m = {{8, 8}, {3, -2}, {8, -8}};
        NormOfMatrix a = new NormOfMatrix(3, 2, m);
        assertEquals(16, a.Calculate());
    }

    @org.junit.jupiter.api.Test
    void calculate2() {
        int [][] m = {{2, 3, 4}, {6, 8, 9}, {7, 3, 5}};
        NormOfMatrix a = new NormOfMatrix(3, 3, m);
        assertEquals(23, a.Calculate());
    }
}