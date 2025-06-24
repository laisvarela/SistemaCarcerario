package model;

import dao.CelaDAO;
import java.util.ArrayList;
import java.util.Set;

public class Cela implements Registro, Entidade {

    private int numero, capacidade;
    private Guarda guardaDiurno, guardaNoturno;
    private Set<Prisioneiro> prisioneiros;
    private boolean lotado;

    public Cela(int numero, int capacidade, Guarda guardaDiurno, Guarda guardaNoturno, Set<Prisioneiro> prisioneiros, boolean lotado) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.guardaDiurno = guardaDiurno;
        this.guardaNoturno = guardaNoturno;
        this.prisioneiros = prisioneiros;
        this.lotado = lotado;
    }

    public Cela() {
    }

    // getters e setters
    public boolean isLotado() {
        return lotado;
    }

    public void setLotado(boolean lotado) {
        this.lotado = lotado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Guarda getGuardaDiurno() {
        return guardaDiurno;
    }

    public void setGuardaDiurno(Guarda guardaDiurno) {
        this.guardaDiurno = guardaDiurno;
    }

    public Guarda getGuardaNoturno() {
        return guardaNoturno;
    }

    public void setGuardaNoturno(Guarda guardaNoturno) {
        this.guardaNoturno = guardaNoturno;
    }

    public Set<Prisioneiro> getPrisioneiros() {
        return prisioneiros;
    }

    public void setPrisioneiros(Set<Prisioneiro> prisioneiros) {
        this.prisioneiros = prisioneiros;
    }

    // método para adicionar prisioneiros
    public void addPrisioneiro(Prisioneiro prisioneiro) {
        this.prisioneiros.add(prisioneiro);
    }

    // método para remover prisioneiro
    public void removePrisioneiro(Prisioneiro prisioneiro) {
        this.prisioneiros.remove(prisioneiro);
    }

    @Override
    public String gerarRelatorio() {
        String relatorio = "\nCela n° " + this.numero + "\nCapacidade: "
                + this.capacidade + "\n-----\nGuarda diurno: \n" + getGuardaDiurno().gerarRelatorio()
                + "\n-----\nGuarda norturno: \n" + getGuardaNoturno().gerarRelatorio() + "\n-----\nPrisioneiros: \n";
        if (prisioneiros.isEmpty()) {
            relatorio = "Nenhum prisioneiro na cela.";
        }
        for (Prisioneiro prisioneiro : prisioneiros) {
            relatorio += prisioneiro.gerarRelatorio() + "Tempo Restante: " + prisioneiro.getTempoRestante() + "\n";
        }
        return relatorio;
    }

    @Override
    public String getId() {
        return String.valueOf(this.getNumero());
    }

    public void cadastrarCela(Cela cela) {
        CelaDAO c = new CelaDAO();
        c.inserirCela(cela);
    }

    public ArrayList<Cela> listaCelas() {
        return new CelaDAO().listarCelas();
    }

    public String buscaCela(String numero) {
        return new CelaDAO().buscarCela(numero);
    }

    public void editarCela(Cela celaNovo) {
        CelaDAO c = new CelaDAO();
        c.editarCela(celaNovo);
    }

    public void removerCela(int numero) {
        CelaDAO c = new CelaDAO();
        c.removerCela(numero);
    }
}
