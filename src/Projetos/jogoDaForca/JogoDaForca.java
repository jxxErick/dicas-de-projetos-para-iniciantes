package Projetos.jogoDaForca;

import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    private static final String[] PALAVRAS = { "banana", "abacaxi", "morango", "laranja", "uva" };
    private String palavraSecreta;
    private StringBuilder palavraAtual;
    private int tentativasRestantes;
    private String letrasUtilizadas;
    private String dica;

    public JogoDaForca() {
        palavraSecreta = selecionarPalavraAleatoria();
        palavraAtual = new StringBuilder("_".repeat(palavraSecreta.length()));
        tentativasRestantes = 6;
        letrasUtilizadas = "";
        dica = selecionarDica();
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (tentativasRestantes > 0) {
            exibirForca();
            System.out.println("Dica: " + dica);
            System.out.println("Palavra: " + palavraAtual);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.println("Letras utilizadas: " + letrasUtilizadas);

            System.out.print("Digite uma letra: ");
            String letra = scanner.next().toLowerCase();

            if (letra.length() == 1 && Character.isLetter(letra.charAt(0))) {
                if (letrasUtilizadas.contains(letra)) {
                    System.out.println("Você já tentou essa letra. Tente outra.");
                    continue;
                }

                letrasUtilizadas += letra;
                if (palavraSecreta.contains(letra)) {
                    atualizarPalavraAtual(letra);
                    if (palavraAtual.indexOf("_") == -1) {
                        exibirForca();
                        System.out.println("Parabéns! Você venceu. A palavra era: " + palavraSecreta);
                        break;
                    }
                } else {
                    tentativasRestantes--;
                }
            } else {
                System.out.println("Entrada inválida. Digite uma única letra.");
            }
        }

        if (tentativasRestantes == 0) {
            exibirForca();
            System.out.println("Você perdeu! A palavra secreta era: " + palavraSecreta);
        }
    }

    private String selecionarPalavraAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(PALAVRAS.length);
        return PALAVRAS[indice];
    }

    private String selecionarDica() {
        Random random = new Random();
        int indice = random.nextInt(PALAVRAS.length);
        return "Dica: Fruta com " + PALAVRAS[indice].length() + " letras.";
    }

    private void atualizarPalavraAtual(String letra) {
        for (int i = 0; i < palavraSecreta.length(); i++) {
            if (palavraSecreta.charAt(i) == letra.charAt(0)) {
                palavraAtual.setCharAt(i, letra.charAt(0));
            }
        }
    }

    private void exibirForca() {
        System.out.println("Tentativas restantes: " + tentativasRestantes);
        switch (tentativasRestantes) {
            case 6:
                System.out.println("  _________");
                System.out.println("  |       |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                break;
            case 5:
                System.out.println("  _________");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println("          |");
                System.out.println("          |");
                System.out.println("          |");
                break;
            case 4:
                System.out.println("  _________");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println("  |       |");
                System.out.println("          |");
                System.out.println("          |");
                break;
            case 3:
                System.out.println("  _________");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println(" /|       |");
                System.out.println("          |");
                System.out.println("          |");
                break;
            case 2:
                System.out.println("  _________");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println(" /|\\      |");
                System.out.println("          |");
                System.out.println("          |");
                break;
            case 1:
                System.out.println("  _________");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println(" /|\\      |");
                System.out.println(" /        |");
                System.out.println("          |");
                break;
            case 0:
                System.out.println("  _________");
                System.out.println("  |       |");
                System.out.println("  O       |");
                System.out.println(" /|\\      |");
                System.out.println(" / \\      |");
                System.out.println("          |");
                break;
        }
    }
}