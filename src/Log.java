import java.util.List;
import java.util.Map;

/**
 * The type Log.
 */
public class Log extends BinaryExpression implements Expression {

    /**
     * Instantiates a new Log.
     *
     * @param exp1 the first expression
     * @param exp2 the second expression
     */
    public Log(Expression exp1, Expression exp2) {
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
        return (Math.log10(getExp2().evaluate(assignment)) / Math.log10(getExp1().evaluate(assignment)));
    }

    /**
     * Evaluate double.
     *
     * @return the double
     * @throws Exception the exception
     */
    @Override
    public double evaluate() throws Exception {
        return (Math.log10(getExp2().evaluate()) / Math.log10(getExp1().evaluate()));
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
        return ("log(" + getExp1() + ", " + getExp2() + ")");
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
        Expression result = new Minus(left, right);
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
        return new Div(getExp2().differentiate(var), new Mult(new Log(new Var("e"), getExp1()), getExp2()));
    }

    /**
     * Simplify expression,returns a simplified version of the current expression.
     *
     * @return the expression
     */
    @Override
    public Expression simplify() {
        boolean sameExpressions = getExp1().simplify().toString().equals(getExp2().simplify().toString());
        try {
            return new Num(this.evaluate());
        } catch (Exception exception) {
            if (sameExpressions) {
                return new Num(1);
            }
        }
        return new Log(getExp1().simplify(), getExp2().simplify());
    }
}
