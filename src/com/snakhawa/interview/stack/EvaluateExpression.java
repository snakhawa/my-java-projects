package com.snakhawa.interview.stack;

import java.util.Stack;

public class EvaluateExpression {

    /**
     * Given an arithmetic expression with *,/,-&+ operators and single digit numbers,evaluate it and return the result
     * The expression can also contain parentheses
     * For example,
     * 1 + 2 / 1 + 3 * 2 ==> 9
     * 1  + (1 + 3) * 2 ==> 10
     * 1 + 2 / (1 + 3) * 2 ⇒ 1
     * @param expressions
     * @return
     */
    public static int evaluate(char[] expressions) {
        if(expressions == null || expressions.length == 0) return 0;
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (char c : expressions) {
            if (isOperand(c)) {
                operands.push(c - '0');
            } else if (isOperator(c)) {
                while (!operators.empty() && precedence(operators.peek()) >= precedence(c)) {
                    process(operators, operands);
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    process(operators, operands);
                }
                operators.pop();
            }
        }

        while (!operators.empty()) {
            process(operators, operands);
        }

        return operands.pop();
    }

    private static void process(Stack<Character> operators, Stack<Integer> operands) {
        int n2 = operands.pop();
        int n1 = operands.pop();
        char operator = operators.pop();
        int result = 0;
        switch (operator) {
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }

        operands.push(result);

    }

    private static boolean isOperand(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static boolean isOperator(char ch) {
        return ch == '-' || ch == '+' || ch == '/' || ch == '*';
    }

    private static int precedence(char opt) {
        int out = 0;
        switch (opt) {
            case '*':
            case '/':
                out = 2;
                break;
            case '+':
            case '-':
                out = 1;
                break;
            case '(':
            case ')':
                out = 0;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        return out;
    }
}
