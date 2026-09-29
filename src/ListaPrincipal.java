import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaPrincipal {
    static void main(String[] args) {
        Adicionar novaT1;
        novaT1 = new Tarefa("Entregar Trabalho de Historia",
                "Sobre a USSR durante a Guerra Fria",LocalDateTime.of(2026, 10, 12, 14, 0));

        System.out.println(novaT1);

        TarefaMarcada t1 = new TarefaMarcada("Reuniao com o time", "Alinhar sprint", LocalDate.now().plusDays(5));
        TarefaMarcada t2 = new TarefaMarcada("Entrega do projeto", "Enviar relatorio final", LocalDate.now().minusDays(2));
        TarefaMarcada t3 = new TarefaMarcada("Prova final", "Estudar capitulos 1 a 5", LocalDate.now());

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
