import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPrincipal {

    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    static void main(String[] args) {
        Scanner entarada = new Scanner(System.in);
        List<Adicionar> tarefas = new ArrayList<>();

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao(entarada);

            switch (opcao) {
                case 1:
                    adicionarNovaTarefa(entarada, tarefas);
                    break;
                case 2:
                    marcarTarefa(entarada, tarefas);
                    break;
                case 3:
                    verTarefasPendentes(tarefas);
                case 4:
                    System.out.println("Saindo... até mais!");
                    break;
                default:
                    System.out.println("Opção invalida! Tente novamente");
            }
        } while (opcao != 4);
        entarada.close();
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("==== MENU ====");
        System.out.println("1 - Adicionar nova tarefa");
        System.out.println("2 - Marcar uma tarefa");
        System.out.println("3 - Ver tarefas pendentes");
        System.out.println("4 - Sair");
        System.out.println("Escolha uma opção");
    }

    private static int lerOpcao(Scanner lerEntrada) {
        while (!lerEntrada.hasNextInt()) {
            System.out.println("Digite um número válido: ");
            lerEntrada.next();
        }
        int opcao = lerEntrada.nextInt();
        lerEntrada.nextLine();
        return opcao;
    }

    private static void adicionarNovaTarefa(Scanner lerTarefa, List<Adicionar> tarefas) {
        System.out.println("Nome da tarefa: ");
        String nome = lerTarefa.nextLine();

        System.out.println("Mensagem/Descrição: ");
        String mensagem = lerTarefa.nextLine();

        LocalDateTime prazo = lerDataHora(lerTarefa, "Prazo (dd/MM/yyyy HH:mm): ");

        tarefas.add(new Tarefa(nome, mensagem, prazo));
        System.out.println("Tarefa adicionada com sucesso");
    }

    private static LocalDateTime lerDataHora(Scanner lerTarefa, String rotulo) {
        while (true){
            System.out.println(rotulo);
            String texto = lerTarefa.nextLine();
            try {
                return LocalDateTime.parse(texto, FORMATO_DATA_HORA);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inavalido! Use dd/MM/yyy HH:mm (ex: 25/12/2026 18:00).");
            }
        }
    }


    private static void marcarTarefa(Scanner scanner, List<Adicionar> tarefas) {
        System.out.println("Nome da tarefa: ");
        String nome = scanner.nextLine();

        System.out.println("Mensagem/Descrição: ");
        String mensagem = scanner.nextLine();

        LocalDate dia = lerData(scanner, "Dia do compromisso (dd/MM/yyyy): ");

        tarefas.add(new TarefaMarcada(nome, mensagem, dia));
        System.out.println("Tarefa marcada adicionada com sucesso!");
    }

    private static LocalDate lerData(Scanner scanner, String rotulo) {
        while (true) {
            System.out.println(rotulo);
            String texto = scanner.nextLine(); {
                try {
                    return LocalDate.parse(texto, FORMATO_DATA);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato invalido! Use dd/MM/yyyy (ex: 25/12/2026).");
                }
            }
        }
    }

    private static void verTarefasPendentes(List<Adicionar> tarefas) {
        System.out.println();
        System.out.println("----- Tarefas pendentes -----");

        boolean existePendente = false;
        for (Adicionar tarefa : tarefas) {
            if (tarefa instanceof Cronometravel cronometravel && cronometravel.estaPendente()) {
                System.out.println(tarefa);
                existePendente = true;
            }

        }
        if (!existePendente) {
            System.out.println("Nenhuma tarefa pendente no momento");
        }
    }
}