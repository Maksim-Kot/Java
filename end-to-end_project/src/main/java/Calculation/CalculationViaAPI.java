package Calculation;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class CalculationViaAPI {

    public static Double calculateViaAPI(String equation)
    {
        // Create a new evaluator
        DoubleEvaluator evaluator = new DoubleEvaluator();
        // Evaluate an expression
        Double result = evaluator.evaluate(equation);
        // Output the result
        return result;
    }
}
