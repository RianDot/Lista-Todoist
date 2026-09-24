import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa extends Adicionar {
    private DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    protected LocalDateTime prazo;

    public Tarefa(String nome, String mensagem, LocalDateTime prazo) {
        super(nome, mensagem);
        this.prazo = prazo;
    }

    public String getTempoRestante() {
        LocalDateTime agora = LocalDateTime.now();

        if (prazo.isBefore(agora)) {
            return "Prazo expirado!";
        }

        Duration duracao = Duration.between(agora, prazo);
        long dias = duracao.toDays();
        long horas = duracao.toHoursPart();
        long minutos = duracao.toMinutesPart();

        if (dias > 0) {
            return String.format("Voce tem %dd, %dh e %dmin ate %s",
                    dias, horas, minutos, prazo.format(formatoData));
        }

        return String.format("Voce tem %dh e %dmin ate %s",
                horas, minutos, prazo.format(formatoData));
    }

    @Override
    public String toString() {
        return super.toString() + " | Prazo: " + prazo.format(formatoData) + " | " + getTempoRestante();
    }
}
