public class Adicionar {
    protected String nome;
    protected String mensagem;

    public Adicionar(String nome, String mensagem) {
        this.nome = nome;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Tarefa: " + nome + " - " + mensagem;
    }
}