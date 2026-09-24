public class Adicionar {
    private static String nome;
    private static String mensagem;

    public static String getNome() {
        return nome;
    }

    public static String getMensagem() {
        return mensagem;
    }

    public Adicionar(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }

    void addTarefa() {
        System.out.println("Tarefa: " + Tarefa.getNome() + " | " + Tarefa.getMensagem());
    }

    void tarefaConcluida() {
        System.out.println("Tarefa Concluída: " + Tarefa.getNome() + " | " + Tarefa.getMensagem());
    }

    void tarefaPendente() {
        System.out.println("Tarefa pendente: " + Tarefa.getNome() + " | " + Tarefa.getMensagem());
    }
}