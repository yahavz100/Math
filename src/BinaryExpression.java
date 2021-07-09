import java.util.ArrayList;
import java.util.List;

/**
 * The type Binary expression.
 */
public abstract class BinaryExpression {
    private Expression exp1;
    private Expression exp2;

    /**
     * Instantiates a new Binary expression.
     *
     * @param exp1 the first expression
     * @param exp2 the second expression
     */
    public BinaryExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
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
     * Returns expression 2.
     *
     * @return the exp 2
     */
    public Expression getExp2() {
        return exp2;
    }

    /**
     * Returns a list of the variables in the expression.
     *
     * @return the variables list
     */
    public List<String> getVariables() {
        List<String> leftList = this.exp1.getVariables();
        List<String> rightList = this.exp2.getVariables();
        List<String> mix = new ArrayList<>();
        mix.addAll(leftList);
        mix.addAll(rightList);
        return mix;
    }
}
