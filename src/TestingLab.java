import Algorithms.ReversePolishNotationCalculator;
import Graph.EdgeList;
import javafx.util.Pair;

public class TestingLab {

    public static void main(String[] args) {

        ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();
        calculator.enableLogs(true);

        String expression = "( 15 - 3 ) ^ ( 3 + 2 ) * 6 /  3 =";
        String result = calculator.convertToRPN(expression);
        System.out.println(result);


    }
}
