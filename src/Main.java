package src;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SistemaCarcerario sistema = new SistemaCarcerario();
        try {
            
            Guarda g1 = new Guarda("Carlos", "987654321", LocalDate.of(1985, 5, 5), "G001", Turno.DIURNO);
            Guarda g2 = new Guarda("Ana", "932154321", LocalDate.of(1990, 10, 10), "G002", Turno.NOTURNO);
            
            Prisioneiro p1 = new Prisioneiro("João", "123456789", LocalDate.of(1990, 1, 1), "001", LocalDateTime.of(2004, 04, 06, 0, 21, 05, 00), 45);
            Prisioneiro p2 = new Prisioneiro("Maria", "183446789", LocalDate.of(1992, 2, 2), "002", LocalDateTime.of(2005, 05, 06, 0, 21, 05, 00), 3);
            
            Cela c1 = new Cela(1, 2);
            sistema.adicionarGuarda(g1, c1);
            sistema.adicionarGuarda(g2, c1);
            sistema.adicionarPrisioneiro(p1, c1);
            sistema.adicionarPrisioneiro(p2, c1);

            //teste de CPF duplicado
            //Prisioneiro p1 = new Prisioneiro("João", "987654321", LocalDate.of(1990, 1, 1), "001", LocalDateTime.of(2004, 04, 06, 0, 21, 05, 00), 45);
            //sistema.adicionarPrisioneiro(p1, c1);

            //teste cela lotada
            //Prisioneiro p3 = new Prisioneiro("Pedro", "123446789", LocalDate.of(1992, 2, 2), "003", LocalDateTime.of(2012, 07, 21, 0, 13, 05, 00), 15);
            //sistema.adicionarPrisioneiro(p3, c1);

            //teste turno inválido
            //Guarda g3 = new Guarda("Pedro", "123456789", LocalDate.of(1992, 2, 2), "G003", Turno.DIURNO);
            //sistema.adicionarGuarda(g3, c1);

            //teste de guarda não encontrado
            //sistema.removerGuarda(c1, g1.getTurno());
            sistema.removerGuarda(c1, g1.getTurno());          
            
        } catch (RegistroDuplicadoException | TurnoInvalidoException | CelaLotadaException | GuardaNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
