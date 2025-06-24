package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Prisioneiro;

public class PrisioneiroController {

    public void cadastrarPrisioneiro(Prisioneiro prisioneiro) {
        Prisioneiro p = new Prisioneiro(null, null, null);
        if (prisioneiro != null) {
            p.cadastrarPrisioneiro(prisioneiro);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o prisioneiro.");
        }
    }

    public void editarPrisioneiro(Prisioneiro prisioneiroNovo) {
        Prisioneiro p = new Prisioneiro(null, null, null);
        if (prisioneiroNovo != null) {
            p.editarPrisioneiro(prisioneiroNovo);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o prisioneiro.");
        }
    }

    public ArrayList<Prisioneiro> listarPrisioneiros() {
        return new Prisioneiro(null, null, null).listaPrisioneiros();
    }

    public String buscarPrisioneiro(String numRegistro) {
        if (new Prisioneiro(null, null, null).buscaPrisioneiros(numRegistro).isBlank()) {
            JOptionPane.showMessageDialog(null, "Nenhum prisioneiro com esta matrícula foi encontrado.");
            return "";
        } else {
            return new Prisioneiro(null, null, null).buscaPrisioneiros(numRegistro);
        }
    }

    public void remover(int numRegistro) {
        new Prisioneiro(null, null, null).removerPrisioneiro(numRegistro);
    }
    
    public boolean existePrisioneiroNaCela(int numeroCela){
       return new Prisioneiro(null, null, null).existePrisioneiroNaCela(numeroCela);
    }
}
