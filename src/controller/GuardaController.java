package controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Guarda;

public class GuardaController {

    public void cadastrarGuarda(Guarda guarda) {
        Guarda g = new Guarda(null, null, null);
        if (guarda != null) {
            g.cadastrarGuarda(guarda);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o guarda.");
        }
    }

    public void editarGuarda(Guarda guardaNovo) {
        new Guarda(null, null, null).editarGuarda(guardaNovo);
    }

    public ArrayList<Guarda> listarGuardas() {
        return new Guarda(null, null, null).listaGuardas();
    }

    public String buscarGuarda(String matricula) {
        if (new Guarda(null, null, null).buscaGuardas(matricula).isBlank()) {
            JOptionPane.showMessageDialog(null, "Nenhum guarda com esta matrícula foi encontrado.");
            return "";
        } else {
            return new Guarda(null, null, null).buscaGuardas(matricula);
        }
    }

    public void remover(String matricula) {
        new Guarda(null, null, null).removerGuarda(matricula);
    }
}
