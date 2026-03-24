package java2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Resolvedor de Expressões Matemáticas");
        System.out.println("Operadores: + - * / ^ e parênteses");
        System.out.println("Digite 'sair' para encerrar.\n");

        while (true) {
            System.out.print("Expressão: ");
            String entrada = scanner.nextLine().trim();
            if (entrada.equalsIgnoreCase("sair")) { System.out.println("Até mais!"); break; }
            if (entrada.isEmpty()) continue;
            try {
                ExpressionSolver.resolver(entrada);
            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage() + "\n");
            }
        }
        scanner.close();
    }
}