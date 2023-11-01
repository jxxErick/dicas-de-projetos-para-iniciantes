package Projetos.jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
    private static final int TAMANHO_TABULEIRO = 3;
    private char[][] tabuleiro;
    private char jogadorAtual;

    public JogoDaVelha() {
        tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        jogadorAtual = 'X'; // Começa com o jogador 'X'
        inicializarTabuleiro();
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirTabuleiro();
            System.out.print("Jogador " + jogadorAtual + ", insira a linha e a coluna (ex: 1 2): ");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (validarJogada(linha, coluna)) {
                tabuleiro[linha - 1][coluna - 1] = jogadorAtual;
                if (verificarVitoria()) {
                    exibirTabuleiro();
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    break;
                } else if (verificarEmpate()) {
                    exibirTabuleiro();
                    System.out.println("O jogo empatou!");
                    break;
                }
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private void exibirTabuleiro() {
        System.out.println("  1 2 3");
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean validarJogada(int linha, int coluna) {
        return linha >= 1 && linha <= TAMANHO_TABULEIRO && coluna >= 1 && coluna <= TAMANHO_TABULEIRO
                && tabuleiro[linha - 1][coluna - 1] == ' ';
    }

    private boolean verificarVitoria() {
        // Verificar linhas, colunas e diagonais
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual
                    || tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)
                return true;
        }
        return (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual
                || tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual);
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                if (tabuleiro[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}