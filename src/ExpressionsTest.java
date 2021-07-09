import java.util.Map;
import java.util.TreeMap;

/**
 * The type Expressions test.
 */
public class ExpressionsTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Expression e = new Plus(new Plus(new Mult(new Num(2), new Var("x")),
                new Sin(new Mult(new Num(4), new Var("y")))),
                new Pow(new Var("e"), new Var("x")));
        Map<String, Double> assignment = new TreeMap<String, Double>();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        System.out.println(e.toString());
        Expression test = e.assign("x", new Num(2)).assign("y",
                new Num(0.25)).assign("e", new Num(2.71));
        try {
            System.out.println(test.evaluate());
            System.out.println(e.differentiate("x"));
            System.out.println(e.differentiate("x").evaluate(assignment));
            System.out.println(e.differentiate("x").simplify());
        } catch (Exception exception) {
            System.out.println("Error");
        }
    }
}
