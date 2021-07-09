import java.util.List;
import java.util.Map;

/**
 * The interface Expression.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided.
     *
     * @param assignment need to be evaluated
     * @return the result
     * @throws Exception if variable not in the assignment
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * Evaluate a number.
     *
     * @return the double number
     * @throws Exception if variable not in the assignment
     */
    double evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variables
     */
    List<String> getVariables();

    /**
     * Returns a string representation of the expression.
     *
     * @return the expression print
     */
    String toString();

    /**
     * Assign a new value in new expression.
     *
     * @param var        the var to be assigned
     * @param expression the expression be changed
     * @return the new expression
     */
    Expression assign(String var, Expression expression);

    /**
     * Returns the expression tree resulting from differentiating the current expression.
     *
     * @param var the variable
     * @return the new expression
     */
    Expression differentiate(String var);

    /**
     * Simplify expression,returns a simplified version of the current expression.
     *
     * @return the expression
     */
    Expression simplify();
}