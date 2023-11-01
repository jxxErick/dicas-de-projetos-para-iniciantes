package Projetos.listaDeTarefa;

import java.util.Scanner;
import java.util.List;
public class ListaDeTarefa {
    public static void executar() {
        FuncoesDaListaDeTarefa listaDeTarefas = new FuncoesDaListaDeTarefa();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Lista de Tarefas =====");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Marcar Tarefa como Concluída");
            System.out.println("3. Listar Tarefas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    listaDeTarefas.adicionarTarefa(descricao);
                    break;

                case 2:
                    System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
                    int indice = scanner.nextInt();
                    listaDeTarefas.marcarComoConcluida(indice);
                    break;

                case 3:
                    List<Tarefa> tarefas = listaDeTarefas.listarTarefas();
                    int i = 0;
                    for (Tarefa tarefa : tarefas) {
                        System.out.println(i + ". " + tarefa);
                        i++;
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}