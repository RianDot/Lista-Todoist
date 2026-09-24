import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaPrincipal {
    static void main(String[] args) {
        ArrayList<Tarefa> tarefasArrayList = new ArrayList<>();
        Adicionar novaTarefa;
        novaTarefa = new Tarefa("Entregar Trabalho de Historia",
                "Sobre a USSR durante a Guerra Fria", LocalDateTime.of(2026,9,28,14,0));
        novaTarefa.addTarefa();
        novaTarefa.tarefaPendente();
        novaTarefa.tarefaConcluida();
    }
}
