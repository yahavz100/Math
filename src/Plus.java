import java.util.List;
import java.util.Map;

/**
 * The type Plus.
 */
public class Plus extends BinaryExpression implements Expression {

    /**
     * Instantiates a new Plus.
     *
     * @param exp1 the first expression
     * @param exp2 the second expression
     */
    public Plus(Expression exp1, Expression exp2) {
        super(exp1, exp2);
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
            return getExp1().evaluate(assignment) + getExp2().evaluate(assignment);
    }

    /**
     * Evaluate double.
     *
     * @return the double
     * @throws Exception the exception
     */
    @Override
    public double evaluate() throws Exception {
            return getExp1().evaluate() + getExp2().evaluate();
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
        return ("(" + getExp1() + " + " + getExp2() + ")");
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
        Expression left = getExp1().assign(var, expression);
        Expression right = getExp2().assign(var, expression);
        Expression result = new Plus(left, right);
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
        Expression left = getExp1().differentiate(var);
        Expression right = getExp2().differentiate(var);
        Expression result = new Plus(left, right);
        return result;
    }

    /**
     * Simplify expression,returns a simplified version of the current expression.
     *
     * @return the expression
     */
    @Override
    public Expression simplify() {
        boolean leftZero = getExp1().simplify().toString().equals("0.0");
        boolean rightZero = getExp2().simplify().toString().equals("0.0");
        boolean negLeftZero = getExp1().simplify().toString().equals("-0.0");
        boolean negRightZero = getExp2().simplify().toString().equals("-0.0");
        try {
            return new Num(this.evaluate());
        } catch (Exception exception) {
            if (leftZero || negLeftZero) {
                return getExp2().simplify();
            } else if (rightZero || negRightZero) {
                return  getExp1().simplify();
            }
        }
        return new Plus(getExp1().simplify(), getExp2().simplify());
    }
}
