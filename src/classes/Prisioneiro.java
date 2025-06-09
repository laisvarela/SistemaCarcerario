package classes;
import java.time.LocalDate;

public class Prisioneiro extends Pessoa implements Registro, Entidade{
    private String numRegistro;
    private LocalDate dataPrisao;
    private int pena;

    public Prisioneiro(String nome, String cpf, LocalDate dataNascimento, String numRegistro, LocalDate dataPrisao, int pena) {
        super(nome, cpf, dataNascimento);
        this.numRegistro = numRegistro;
        this.dataPrisao = dataPrisao;
        this.pena = pena;
    }

    public Prisioneiro(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
    }
    
    // getters e setters
    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public LocalDate getDataPrisao() {
        return dataPrisao;
    }

    public void setDataPrisao(LocalDate dataPrisao) {
        this.dataPrisao = dataPrisao;
    }

    public int getPena() {
        return pena;
    }

    public void setPena(int pena) {
        this.pena = pena;
    }
    // implementação do método da interface Registro
    @Override
    public String gerarRelatorio() {
        return "Prisioneiro: " + getNome() + "\n" +
               "Registro: " + numRegistro + "\n" +
               "Data de Prisão: " + dataPrisao + "\n" +
               "Pena: " + pena + " anos\n";
    }
    
    // método para calcular o tempo restante de pena
    public int getTempoRestante() {
        LocalDate dataAtual = LocalDate.now();
        int anosRestantes = pena - (int) (dataAtual.getYear() - dataPrisao.getYear());
        return anosRestantes > 0 ? anosRestantes : 0;
    }

    @Override
    public String getId() {
        return this.getNumRegistro();
    }
}
