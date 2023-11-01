package Projetos.listaDeTarefa;

import java.util.ArrayList;
import java.util.List;

public class FuncoesDaListaDeTarefa {

    //Funções básicas de uma lista de tarefa
    private List<Tarefa> tarefas;

    public FuncoesDaListaDeTarefa() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        tarefas.add(tarefa);
    }

    public void marcarComoConcluida(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice);
            tarefa.marcarComoConcluida();
        }
    }

    public List<Tarefa> listarTarefas() {
        return tarefas;
    }
}