import java.util.List;
import java.util.Map;

/**
 * The type Cos.
 */
public class Cos extends UnaryExpression implements Expression {

    /**
     * Instantiates a new Cos.
     *
     * @param exp1 the expression
     */
    public Cos(Expression exp1) {
        super(exp1);
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
        return Math.cos(Math.toRadians(getExp1().evaluate(assignment)));
    }

    /**
     * Evaluate a number.
     *
     * @return the double number
     * @throws Exception if variable not in the assignment
     */
    @Override
    public double evaluate() throws Exception {
        return Math.cos(Math.toRadians(getExp1().evaluate()));
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variables
     */
    @Override
    public List<String> getVariables() {
        return super.getVariables();
    }

    /**
     * Returns a string representation of the expression.
     *
     * @return the expression print
     */
    public String toString() {
        return ("cos(" + getExp1() + ")");
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
        Expression result = new Cos(getExp1().assign(var, expression));
        return result;
    }

    /**
     * Returns the expression tree resulting from differentiating the current expression.
     *
     * @param var the variable
     * @return the new expression
     */
    @Override
    public Expression differentiate(String var) {
        Expression result = new Neg(new Sin(getExp1()));
        result = new Mult(result, getExp1().differentiate(var));
        return result;
    }

    /**
     * Simplify expression,returns a simplified version of the current expression.
     *
     * @return the expression
     */
    @Override
    public Expression simplify() {
        try {
            return new Num(getExp1().evaluate());
        } catch (Exception exception) {
        }
        return new Cos(getExp1().simplify());
    }
}
