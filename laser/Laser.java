package laser;

import java.util.Scanner;

public class Laser {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNextInt()) {
            int altura = leitor.nextInt();       // A: altura do bloco
            int comprimento = leitor.nextInt();  // C: quantas colunas tem

            if (altura == 0 && comprimento == 0) break;

            // para cada coluna, calcula quantas camadas precisam ser removidas
            int[] cortesNecessarios = new int[comprimento];
            for (int i = 0; i < comprimento; i++) {
                int alturaFinal = leitor.nextInt();
                cortesNecessarios[i] = altura - alturaFinal;
            }

            // a primeira coluna contribui com todas as suas ligadas diretamente
            long totalLigadas = cortesNecessarios[0];

            for (int i = 1; i < comprimento; i++) {
                int diferenca = cortesNecessarios[i] - cortesNecessarios[i - 1];

                // só conta quando a coluna atual precisa de MAIS cortes que a anterior
                // pois isso significa que o laser precisou ligar de novo
                if (diferenca > 0) {
                    totalLigadas += diferenca;
                }
            }

            System.out.println(totalLigadas);
        }

        leitor.close();
    }
}