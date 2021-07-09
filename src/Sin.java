import java.util.List;
import java.util.Map;

/**
 * The type Sin.
 */
public class Sin extends UnaryExpression implements Expression {

    /**
     * Instantiates a new Sin.
     *
     * @param exp1 the expression
     */
    public Sin(Expression exp1) {
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
        return Math.sin(Math.toRadians(getExp1().evaluate(assignment)));
    }

    /**
     * Evaluate double.
     *
     * @return the double
     * @throws Exception the exception
     */
    @Override
    public double evaluate() throws Exception {
        return Math.sin(Math.toRadians(getExp1().evaluate()));
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variables list
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
        return ("sin(" + getExp1() + ")");
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
        Expression result = new Sin(getExp1().assign(var, expression));
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
        Expression result = new Cos(getExp1());
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
        return new Sin(this.getExp1().simplify());
    }
}
