import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathEquationTest {

    @org.junit.jupiter.api.Test
    void calculate1() {
        MathEquation test = new MathEquation(1, 4);
        double eps = Math.pow(10, -4);
        assertTrue (Math.abs(Math.log(2) - test.Calculate()) < eps);
    }

    @org.junit.jupiter.api.Test
    void calculate2() {
        MathEquation test = new MathEquation(0.23, 4);
        double eps = Math.pow(10, -4);
        assertTrue (Math.abs(Math.log(1.23) - test.Calculate()) < eps);
    }

    @Test
    void range1() {
        MathEquation test = new MathEquation(1, 4);
        assertTrue(test.Range());
    }

    @Test
    void range2() {
        MathEquation test = new MathEquation(-0.8, 4);
        assertTrue(test.Range());
    }

    @Test
    void range3() {
        MathEquation test = new MathEquation(0.9, 4);
        assertTrue(test.Range());
    }

    @Test
    void range4() {
        MathEquation test = new MathEquation(-1.5, 4);
        assertFalse(test.Range());
    }

    @Test
    void range5() {
        MathEquation test = new MathEquation(-1, 4);
        assertFalse(test.Range());
    }

    @Test
    void range6() {
        MathEquation test = new MathEquation(6, 4);
        assertFalse(test.Range());
    }

    @Test
    void range7() {
        MathEquation test = new MathEquation(1.1, 4);
        assertFalse(test.Range());
    }
}