import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Num.
 */
public class Num implements Expression {
    private double num;

    /**
     * Instantiates a new Num.
     *
     * @param num the number
     */
    public Num(double num) {
        this.num = num;
    }
    /**
     * Evaluate the expression using the variable values provided.
     *
     * @param assignment need to be evaluated
     * @return the result
     * @throws Exception if variable not in the assignment
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }

    /**
     * Evaluate double.
     *
     * @return the double
     * @throws Exception the exception
     */
    @Override
    public double evaluate() throws Exception {
        return this.num;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variables
     */
    @Override
    public List<String> getVariables() {
        List<String> numList = new ArrayList<>();
        return numList;
    }

    /**
     * Returns a string representation of the expression.
     *
     * @return the expression print
     */
    public String toString() {
        String strNum = Double.toString(this.num);
        return (strNum);
    }

    /**
     * Assign expression.
     *
     * @param var        the var
     * @param expression the expression
     * @return the expression
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression.
     *
     * @param var the variable
     * @return the new expression
     */
    @Override
    public Expression differentiate(String var) {
        return new Num(0);
    }

    /**
     * Simplify expression,returns a simplified version of the current expression.
     *
     * @return the expression
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
