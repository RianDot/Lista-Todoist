import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TarefaMarcada extends Adicionar {
    private DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected LocalDate diaMarcado;

    public TarefaMarcada(String nome, String mensagem, LocalDate diaMarcado) {
        super(nome, mensagem);
        this.diaMarcado = diaMarcado;
    }

    public String getDiasRestantes() {
        LocalDate hoje = LocalDate.now();

        if (diaMarcado.isBefore(hoje)) {
            return "Prazo expirado!";
        }
        Duration duracao = Duration.between(hoje, diaMarcado);
        long dias = duracao.toDays();
        long horas = duracao.toHoursPart();

    }
}
