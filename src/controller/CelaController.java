package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cela;

public class CelaController {
    
    public void cadastrarCela(Cela cela) {
        Cela c = new Cela();
        if (cela != null) {
            c.cadastrarCela(cela);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o cela.");
        }
    }

    public void editarCela(Cela celaNovo) {
        Cela c = new Cela();
        if (celaNovo != null) {
            c.editarCela(celaNovo);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o cela.");
        }
    }

    public ArrayList<Cela> listarCelas() {
        return new Cela().listaCelas();
    }

    public String buscarCela(String numero) {
        if (new Cela().buscaCela(numero).isBlank()) {
            JOptionPane.showMessageDialog(null, "Nenhum cela com esta matrícula foi encontrado.");
            return "";
        } else {
            return new Cela().buscaCela(numero);
        }
    }

    public void remover(int numero) {
        new Cela().removerCela(numero);
    }
}
