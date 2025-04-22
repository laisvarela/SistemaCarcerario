package src;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Prisioneiro extends Pessoa implements Registro {
    private String numRegistro;
    private LocalDateTime dataPrisao;
    private int pena;

    public Prisioneiro(String nome, String cpf, LocalDate dataNascimento, String numRegistro, LocalDateTime dataPrisao, int pena) {
        super(nome, cpf, dataNascimento);
        this.numRegistro = numRegistro;
        this.dataPrisao = dataPrisao;
        this.pena = pena;
    }
    // getters e setters
    public String getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    public LocalDateTime getDataPrisao() {
        return dataPrisao;
    }

    public void setDataPrisao(LocalDateTime dataPrisao) {
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
        LocalDateTime dataAtual = LocalDateTime.now();
        int anosRestantes = pena - (int) (dataAtual.getYear() - dataPrisao.getYear());
        return anosRestantes > 0 ? anosRestantes : 0;
    }
}
