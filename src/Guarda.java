package src;
import java.time.LocalDate;

public class Guarda extends Pessoa implements Registro{
    private String matricula;
    private Turno turno;

    public Guarda(String nome, String cpf, LocalDate dataNascimento, String matricula, Turno turno) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
        this.turno = turno;
    }
    // getters e setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    // implementação do método da interface Registro
    @Override
    public String gerarRelatorio() {
        return "Guarda: " + getNome() + "\n" +
               "Matrícula: " + matricula + "\n" +
               "Turno: " + turno;
    }
}
