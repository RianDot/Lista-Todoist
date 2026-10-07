import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TarefaMarcada extends Adicionar implements Cronometravel {
    private DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected LocalDate diaMarcado;

    public TarefaMarcada(String nome, String mensagem, LocalDate diaMarcado) {
        super(nome, mensagem);
        this.diaMarcado = diaMarcado;
    }

    @Override
    public boolean estaPendente() {
        return !diaMarcado.isBefore(LocalDate.now());
    }
    public String getDiasRestante() {
        LocalDate diaDeHoje = LocalDate.now();

        if (diaMarcado.isBefore(diaDeHoje)) {
            return "Prazo expirado!";
        }

        long dias = ChronoUnit.DAYS.between(diaDeHoje, diaMarcado);

        return String.format("Voce tem %dd ate %s", dias, diaMarcado.format(formatoDia));
    }

    @Override
    public String toString() {
        return super.toString() + " | Dia do compromisso: " + diaMarcado.format(formatoDia)
                + " | " + getDiasRestante();
    }
}