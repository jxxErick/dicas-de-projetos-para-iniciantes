import Projetos.jogoDaForca.JogoDaForca;
import Projetos.jogoDaVelha.JogoDaVelha;
import Projetos.listaDeTarefa.ListaDeTarefa;

public class Main {
    public static void main(String[] args) {
        //para chamar qualquer projeto apenas retire as barras dele


        /*Calculadora*/
       // Calculadora calculadora = new Calculadora();
        // calculadora.CalculadoraApp();

        /*Lista de tarefa*/
        //ListaDeTarefa listaDeTarefa = new ListaDeTarefa();
        //listaDeTarefa.executar();

        /*Jogo da Velha*/
        //JogoDaVelha jogo = new JogoDaVelha();
        // jogo.jogar();

        /*Jogo da forca*/
        JogoDaForca jogo = new JogoDaForca();
        jogo.jogar();
    }
}
