package model;

import dao.PrisioneiroDAO;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prisioneiro extends Pessoa implements Registro {

    private int numRegistro;
    private LocalDate dataPrisao;
    private int pena;
    private int num_cela;

    public Prisioneiro(int numRegistro, LocalDate dataPrisao, int pena, Cela cela, String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.numRegistro = numRegistro;
        this.dataPrisao = dataPrisao;
        this.pena = pena;
        this.num_cela = cela.getNumero();
    }

    public Prisioneiro(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
    }

    // getters e setters
    public Integer getCela() {
        return num_cela;
    }

    public void setCela(Cela cela) {
        this.num_cela = cela.getNumero();
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
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
        return "Prisioneiro: " + getNome() + "\n"
                + "Registro: " + numRegistro + "\n"
                + "Data de Prisão: " + dataPrisao + "\n"
                + "Pena: " + pena + " anos\n"
                + "Cela: " + num_cela;
    }

    // método para calcular o tempo restante de pena
    public int getTempoRestante() {
        LocalDate dataAtual = LocalDate.now();
        int anosRestantes = pena - (int) (dataAtual.getYear() - dataPrisao.getYear());
        return anosRestantes > 0 ? anosRestantes : 0;
    }

    public void cadastrarPrisioneiro(Prisioneiro prisioneiro) {
        new PrisioneiroDAO().inserirPrisioneiro(prisioneiro);
    }

    public ArrayList<Prisioneiro> listaPrisioneiros() {
        return new PrisioneiroDAO().listarPrisioneiros();
    }

    public String buscaPrisioneiros(String matricula) {
        return new PrisioneiroDAO().buscarPrisioneiro(matricula);
    }

    public void editarPrisioneiro(Prisioneiro prisioneiroNovo) {
        new PrisioneiroDAO().editarPrisioneiro(prisioneiroNovo);
    }

    public void removerPrisioneiro(int matricula) {
        new PrisioneiroDAO().removerPrisioneiro(numRegistro);
    }
    
    public boolean existePrisioneiroNaCela(int numeroCela){
        return new PrisioneiroDAO().existePrisioneiroNaCela(numeroCela);
    }
}
