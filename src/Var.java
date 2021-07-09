import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Var.
 */
public class Var implements Expression {
    private String newVar;


    /**
     * Instantiates a new Var.
     *
     * @param var the variable
     */
    public Var(String var) {
        this.newVar = var;
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
        //Check if map contains this variable
        if (assignment.containsKey(this.newVar)) {
            return assignment.get(this.newVar);
        } else {
            throw new Exception("Error variable not in assignment");
        }
    }

    /**
     * Evaluate double.
     *
     * @return the double
     * @throws Exception the exception
     */
    @Override
    public double evaluate() throws Exception {
        throw new Exception("Error");
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variables
     */
    @Override
    public List<String> getVariables() {
        List<String> varList = new ArrayList<String>();
        varList.add(this.newVar);
        return varList;
    }

    /**
     * Returns a string representation of the expression.
     *
     * @return the expression print
     */
    public String toString() {
        return (this.newVar);
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
        //Check if given variable same as variable
        if (var.equals(this.newVar)) {
            return expression;
        }
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
        //Check if this variable same as given variable
        if (this.newVar.equals(var)) {
            return new Num(1);
        }
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
