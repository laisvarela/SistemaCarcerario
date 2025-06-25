package model;

import dao.GuardaDAO;
import java.time.LocalDate;
import java.util.ArrayList;

public class Guarda extends Pessoa implements Registro {

    private String matricula;
    private String turno;
    private boolean atribuido;

    public Guarda(String matricula, String turno,  boolean atribuido, String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
        this.turno = turno;
        this.atribuido = atribuido;
    }

    public Guarda(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
    }

    // getters e setters
    public boolean isAtribuido() {
        return atribuido;
    }

    public void setAtribuido(boolean atribuido) {
        this.atribuido = atribuido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // implementação do método da interface Registro
    @Override
    public String gerarRelatorio() {
        return "Guarda: " + getNome() + "\n"
                + "Matrícula: " + matricula + "\n"
                + "Turno: " + turno + "\n"
                + "Atribuido: " + atribuido;
    }
    
    public void cadastrarGuarda(Guarda guarda) {
        GuardaDAO g = new GuardaDAO();
        g.inserirGuarda(guarda);
    }
    
    public ArrayList<Guarda> listaGuardas(){
        return new GuardaDAO().listarGuardas();
    }
    
    public String buscaGuardas(String matricula){
        return new GuardaDAO().buscarGuarda(matricula);
    }
    
    public void editarGuarda(Guarda guardaNovo){
        GuardaDAO g = new GuardaDAO();
        g.editarGuarda(guardaNovo);
    }
    
    public void removerGuarda(String matricula){
        GuardaDAO g = new GuardaDAO();
        g.removerGuarda(matricula);
    }
}
