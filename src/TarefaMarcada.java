import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TarefaMarcada extends Adicionar {
    private DateTimeFormatter formatoDia = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected LocalDate diaMarcado;

    public TarefaMarcada(String nome, String mensagem, LocalDate diaMarcado) {
        super(nome, mensagem);
        this.diaMarcado = diaMarcado;
    }

    public String getDiasRestante() {
        LocalDate diaDeHoje = LocalDate.now();

        if (diaMarcado.isBefore(diaDeHoje)) {
            return "Prazo expirado!";
        }

        Duration diaDoCompromisso = Duration.between(diaDeHoje, diaMarcado);
        long dias = diaDoCompromisso.toDays();
        long horas = diaDoCompromisso.toHoursPart();

        if (dias > 0) {
            return String.format("Voce tem %dd, %dh ate %s",
                    dias, horas, diaMarcado.format(formatoDia));
        }

        return String.format("Voce tem %dh ate %s",
                horas, diaMarcado.format(formatoDia));
    }
    @Override
    public String toString() {
        return super.toString() + " | Dias até o compromisso: " + diaMarcado.format(formatoDia) + " | " + getDiasRestante();
    }
}
