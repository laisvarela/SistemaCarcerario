package classes;
import java.util.Set;
public class Cela implements Registro{
    private int numero, capacidade;
    private Guarda guardaDiurno, guardaNoturno;
    private Set<Prisioneiro> prisioneiros;
    private boolean lotada;

    public Cela(int numero, int capacidade, Guarda guardaDiurno, Guarda guardaNoturno, Set<Prisioneiro> prisioneiros, boolean lotada) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.guardaDiurno = guardaDiurno;
        this.guardaNoturno = guardaNoturno;
        this.prisioneiros = prisioneiros;
        this.lotada = lotada;
    }

    public boolean isLotada() {
        return lotada;
    }

    public void setLotada(boolean lotada) {
        this.lotada = lotada;
    }

    // getters e setters
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
        String relatorio = "\nCela n° "+this.numero+"\nCapacidade: "+
        this.capacidade+"\n-----\nGuarda diurno: \n"+getGuardaDiurno().gerarRelatorio()
        +"\n-----\nGuarda norturno: \n"+getGuardaNoturno().gerarRelatorio()+"\n-----\nPrisioneiros: \n";
        if (prisioneiros.isEmpty()) {
            relatorio = "Nenhum prisioneiro na cela.";
        }
        for (Prisioneiro prisioneiro : prisioneiros) {
            relatorio += prisioneiro.gerarRelatorio()+"Tempo Restante: "+prisioneiro.getTempoRestante()+"\n";
        }
        return relatorio;
    }

}