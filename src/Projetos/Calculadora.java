package Projetos;

import java.util.Scanner;

public class Calculadora {

    public void CalculadoraApp() {
        System.out.println("Bem-vindo à Calculadora");
        //pede o primeiro numero
        double num1 = getNumero("Digite o primeiro número: ");
        //abre a possibilidade de operações
        int escolha = getMenu();

        double resultado = 0.0;
        //faz as operações de acordo com a escolha do usuario
        if (escolha == 1) {
            double num2 = getNumero("Digite o número que deseja somar: ");
            resultado = num1 + num2;
        } else if (escolha == 2) {
            double num2 = getNumero("Digite o número que deseja subtrair: ");
            resultado = num1 - num2;
        } else if (escolha == 3) {
            double num2 = getNumero("Digite o número que deseja multiplicar: ");
            resultado = num1 * num2;
        } else if (escolha == 4) {
            double num2 = getNumero("Digite o número pelo qual deseja dividir: ");
            if (num2 != 0) {
                resultado = num1 / num2;
            } else {
                System.out.println("Erro! Divisão por zero.");
                System.exit(0);
            }
        } else if (escolha == 5) {
            double num2 = getNumero("Digite o número ao qual deseja elevar: ");
            resultado = Math.pow(num1, num2);
        } else if (escolha == 6) {
            resultado = Math.sqrt(num1);
        } else {
            System.out.println("Opção inválida.");
            System.exit(0);
        }
        //imprime o resultado
        System.out.println("Resultado: " + resultado);
    }
    //Lê os numeros do usuario
    public static double getNumero(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    //Pede ao usuário qual operação desejada
    public static int getMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma operação:");
        System.out.println("1. Adição");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Potência");
        System.out.println("6. Raiz Quadrada");
        System.out.print("Digite o número da operação desejada: ");
        return scanner.nextInt();
    }
}
