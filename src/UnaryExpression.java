import java.util.List;

/**
 * The type Unary expression.
 */
public abstract class UnaryExpression {
    private Expression exp1;

    /**
     * Instantiates a new Unary expression.
     *
     * @param exp1 the exp 1
     */
    public UnaryExpression(Expression exp1) {
        this.exp1 = exp1;
    }


    /**
     * Returns expression 1.
     *
     * @return the exp 1
     */
    public Expression getExp1() {
        return exp1;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variables list
     */
    public List<String> getVariables() {
        List<String> unarList = this.exp1.getVariables();
        return unarList;
    }
}
