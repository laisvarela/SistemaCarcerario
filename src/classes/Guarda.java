package classes;

import java.time.LocalDate;

public class Guarda extends Pessoa implements Registro, Entidade{

    private String matricula;
    private Turno turno;
    private LocalDate dataAdmissao;

    public Guarda(String matricula, Turno turno, LocalDate dataAdmissao, String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
        this.turno = turno;
        this.dataAdmissao = dataAdmissao;
    }

    public Guarda(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
    }

    // getters e setters
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

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
        return "Guarda: " + getNome() + "\n"
                + "Matrícula: " + matricula + "\n"
                + "Turno: " + turno;
    }

    @Override
    public String getId() {
        return this.getMatricula();
    }
}
