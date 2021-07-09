import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Expression e = new Log(new Mult(new Num(9), new Var("x")), new Num(5));
        Expression de = e.differentiate("x");
//        Map<String, Double> assignment = new TreeMap<String, Double>();
//        assignment.put("x", 5.0);
//        double value = 0;
//        try {
//            value = e.evaluate(assignment);
//        } catch (
//                Exception ex) {
//            ex.printStackTrace();
//        }
//        System.out.println("RETURNED: " + value);
//        Expression e2 = new Pow(new Plus(new Var("x"), new Var("y")), new Num(2));
//        List<String> vars = e2.getVariables();
//        for (String v : vars) {
//            System.out.println(v);
//        }
        System.out.println(de.toString());
        System.out.println(de);
    }
}
