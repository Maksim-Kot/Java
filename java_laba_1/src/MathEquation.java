public class MathEquation {

    private int k;
    private double x;

    public MathEquation(double x, int k) {
        this.x = x;
        this.k = k + 4;
    }

    public boolean Range(){
        return x > -1 && x <= 1;
    }

    public double Calculate (){
        int n = 2; double sum = 0, prev, next, st;
        k = (-k);
        st = Math.pow(10,k);
        prev = x;
        do {
            sum += prev;
            next = (-1) * prev * (n-1) * x / n;
            prev = next;
            n++;
        } while (Math.abs(next) > st);
        return sum;
    }
}
