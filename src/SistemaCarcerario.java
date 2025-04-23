package src;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SistemaCarcerario {
    private Set<String> cpfsCadastrados = new HashSet<>();
    private Set<String> matriculasCadastradas = new HashSet<>();
    private Set<String> numerosRegistroCadastrados = new HashSet<>();

    //Método para adicionar guarda: valida matricula, CPF e turno
    public void adicionarGuarda(Guarda guarda, Cela cela) throws RegistroDuplicadoException, TurnoInvalidoException {
        if (matriculasCadastradas.contains(guarda.getMatricula())) {
            throw new RegistroDuplicadoException("Matrícula já cadastrada: " + guarda.getMatricula());
        }
        if (cpfsCadastrados.contains(guarda.getCpf())) {
            throw new RegistroDuplicadoException("CPF já cadastrado: " + guarda.getCpf());
        }
        // Verifica se a cela já possui um guarda diurno ou noturno
        if (cela.getGuardaDiurno() == null && guarda.getTurno() == Turno.DIURNO) {
            cela.setGuardaDiurno(guarda);

        } else if (cela.getGuardaNoturno() == null && guarda.getTurno() == Turno.NOTURNO) {
            cela.setGuardaNoturno(guarda);

        } else if (cela.getGuardaDiurno() != null && cela.getGuardaDiurno().getTurno() == guarda.getTurno() 
            || cela.getGuardaNoturno() != null && cela.getGuardaNoturno().getTurno() == guarda.getTurno()) {
            throw new TurnoInvalidoException("Já existe guarda cadastrada para o turno " + guarda.getTurno());
        }
        matriculasCadastradas.add(guarda.getMatricula());
        cpfsCadastrados.add(guarda.getCpf());
    }

    //Método para adicionar prisioneiro (número de registro e CPF)
    public void adicionarPrisioneiro(Prisioneiro prisioneiro, Cela cela) throws RegistroDuplicadoException, CelaLotadaException {
        if (numerosRegistroCadastrados.contains(prisioneiro.getNumRegistro())) {
            throw new RegistroDuplicadoException("Número de registro já cadastrado: " + prisioneiro.getNumRegistro());
        }
        if (cpfsCadastrados.contains(prisioneiro.getCpf())) {
            throw new RegistroDuplicadoException("CPF já cadastrado: " + prisioneiro.getCpf());
        }
        if (cela.getPrisioneiros().size() >= cela.getCapacidade()) {
            throw new CelaLotadaException("Cela lotada, não é possível adicionar mais prisioneiros");
        }else{
            cela.addPrisioneiro(prisioneiro);
        }
        numerosRegistroCadastrados.add(prisioneiro.getNumRegistro());
        cpfsCadastrados.add(prisioneiro.getCpf());
    }

    //Método para remover prisioneiro caso já tenha cumprido pena
    public void removerPrisioneiro(Cela cela) {
        Iterator<Prisioneiro> iterator = cela.getPrisioneiros().iterator();
        while (iterator.hasNext()) {
            Prisioneiro prisioneiro = iterator.next();
            if (prisioneiro.getTempoRestante()<=0) {
                iterator.remove();
            }
        }
    }

    //Método para remover guarda
    public void removerGuarda(Cela cela, Turno turno) throws GuardaNaoEncontradoException {
        if(cela.getGuardaDiurno() == null && cela.getGuardaNoturno() == null){
            throw new GuardaNaoEncontradoException("Segurança da cela não pode estar vazia!");
        } else if (turno == Turno.DIURNO && cela.getGuardaDiurno() == null) {
            throw new GuardaNaoEncontradoException("Não há guarda diurno cadastrado para ser removido na cela " + cela.getNumero());
        } else if (turno == Turno.NOTURNO && cela.getGuardaNoturno() == null) {
            throw new GuardaNaoEncontradoException("Não há guarda noturno cadastrado para ser removido na cela " + cela.getNumero());
        } 
            cela.setGuardaDiurno(null);
            cela.setGuardaNoturno(null);     
        
    }
}