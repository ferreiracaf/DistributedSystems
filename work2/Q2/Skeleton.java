/**
 * Skeleton
 */
public class Skeleton {

    private Calculator calculator;

    public Skeleton() {
        try {
            calculator = new Calculator();
        } catch (Exception e) {
            System.out.println();
        }
    }
    public String add(String n1, String n2){
        String ret = null;
        double a = String.valueOf(n1);
        double b = String.valueOf(n2);
        ret = Double.toString(calculator.add(a, b));
        return ret;
    }

    public String sub(String n1, String n2){
        String ret = null;
        double a = String.valueOf(n1);
        double b = String.valueOf(n2);
        ret = Double.toString(calculator.sub(a, b));
        return ret;
    }

    public String mul(String n1, String n2){
        String ret = null;
        double a = String.valueOf(n1);
        double b = String.valueOf(n2);
        ret = Double.toString(calculator.mul(a, b));
        return ret;
    }

    public String div(String n1, String n2){
        String ret = null;
        double a = String.valueOf(n1);
        double b = String.valueOf(n2);
        ret = Double.toString(calculator.div(a, b));
        return ret;
    }
}