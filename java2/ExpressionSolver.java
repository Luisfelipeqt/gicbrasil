package java2;

import java.util.*;

import static java.util.regex.Pattern.quote;

public class ExpressionSolver {

    static int precedencia(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }

    static double aplicar(char op, double a, double b) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '^' -> Math.pow(a, b);
            default  -> throw new IllegalArgumentException("Operador inválido: " + op);
        };
    }

    static String formatNum(double v) {
        return (v == Math.floor(v) && !Double.isInfinite(v))
            ? String.valueOf((long) v)
            : String.valueOf(v);
    }

    static String substituir(String expr, double a, char op, double b, double res) {
        String padrao    = formatNum(a) + op + formatNum(b);
        String comParens = "(" + padrao + ")";
        if (expr.contains(comParens))
            return expr.replaceFirst(quote(comParens), formatNum(res));
        return expr.replaceFirst(quote(padrao), formatNum(res));
    }

    static void resolver(String expressao) {
        System.out.println("Expressão: " + expressao);
        System.out.println("─".repeat(40));

        String[] expr = { expressao.replaceAll("\\s+", "") };
        System.out.println(expr[0]);

        Deque<Double>    nums = new ArrayDeque<>();
        Deque<Character> ops  = new ArrayDeque<>();

        Runnable executar = () -> {
            double b   = nums.pop();
            double a   = nums.pop();
            char   op  = ops.pop();
            double res = aplicar(op, a, b);
            expr[0] = substituir(expr[0], a, op, b, res);
            System.out.println(expr[0]);
            nums.push(res);
        };

        String e = expr[0];
        int i = 0;

        while (i < e.length()) {
            char c = e.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < e.length() && (Character.isDigit(e.charAt(i)) || e.charAt(i) == '.'))
                    sb.append(e.charAt(i++));
                nums.push(Double.parseDouble(sb.toString()));
                continue;
            }

            switch (c) {
                case '(' -> ops.push(c);

                case ')' -> {
                    while (ops.peek() != '(') executar.run();
                    ops.pop();
                    expr[0] = expr[0].replaceFirst(
                        "\\(" + quote(formatNum(nums.peek())) + "\\)",
                        formatNum(nums.peek())
                    );
                }

                default -> {
                    while (!ops.isEmpty() && ops.peek() != '(' &&
                           (c == '^' ? precedencia(ops.peek()) > precedencia(c)
                                     : precedencia(ops.peek()) >= precedencia(c)))
                        executar.run();
                    ops.push(c);
                }
            }
            i++;
        }

        while (!ops.isEmpty()) executar.run();

        System.out.println();
    }
}