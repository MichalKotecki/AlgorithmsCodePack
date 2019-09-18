package Algorithms;

import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReversePolishNotationCalculator {

    private boolean logsEnabled = false;

    private static Map<Character, Integer> operatorPriorities;


    public static Map<Character, Integer> getOperatorPriorities() {
        return operatorPriorities;
    }

    private static void setOperatorPriorities() {
        ReversePolishNotationCalculator.operatorPriorities = Stream.of(new Object[][]{
                {'+', 1},
                {'-', 1},
                {'*', 2},
                {'/', 2},
                {'^', 3}
        }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]));
    }

    public void enableLogs(boolean b)
    {
        this.logsEnabled = b;
    }

    public ReversePolishNotationCalculator() {
        setOperatorPriorities();
    }


    public String convertToRPN(String expression)
    {
        Stack<Character> operatorsStack = new Stack<>();
        String output = "";

        for(int i=0; i < expression.length(); i++)
        {

            //  Behavior for numbers
            String singleNumber = "";
            if(Character.isDigit(expression.charAt(i)))
            {

                while (Character.isDigit(expression.charAt(i))) {
                    singleNumber += expression.charAt(i);
                    i++;
                }
                if (!singleNumber.isEmpty()) {
                    output += " " + singleNumber;
                }
            }
            //  Behavior for operators

            else if (operatorPriorities.containsKey(expression.charAt(i)))
            {
                //  We send all the operators from stack to output, until we find an operator of higher priority than
                //  the we are considering. The one we are considering goes on the stack.

                while(!operatorsStack.empty() && !operatorsStack.peek().equals('(') && operatorPriorities.get(operatorsStack.peek()) <= operatorPriorities.get(expression.charAt(i)))
                {
                    output += " " + operatorsStack.peek(); operatorsStack.pop();
                }
                operatorsStack.push(expression.charAt(i));
            }
            else if(expression.charAt(i) == '(')
            {
               operatorsStack.push('(');
            }
            else if(expression.charAt(i) == ')')
            {
                while(!operatorsStack.empty()  && !operatorsStack.peek().equals('('))
                {
                    output += " " + operatorsStack.peek(); operatorsStack.pop();
                }
                if(!operatorsStack.empty())
                {
                    operatorsStack.pop();
                }
            }
            else if(expression.charAt(i) == '=')
            {
                while (!operatorsStack.empty())
                {
                    output += " " + operatorsStack.peek(); operatorsStack.pop();
                }
            }


            if(logsEnabled)
            {
                //  LOGS

                System.out.print("Input: ");
                System.out.println((singleNumber.isEmpty()) ? expression.charAt(i) : singleNumber); // Prints aa number (a few characters) or a single operator.
                System.out.println("Stack: " + operatorsStack);
                System.out.println("Output: " + output);
                System.out.println(" ");
            }

        }


        return output;
    }





    public static void main(String[] args) {


        String expression = "";


    }
}
