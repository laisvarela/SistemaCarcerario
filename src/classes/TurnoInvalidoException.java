package classes;
public class TurnoInvalidoException extends Exception {
    String msg = "Este guarda já está atribuído a uma cela! Impossível alterar turno. Remova-o da cela primeiro.";
    public TurnoInvalidoException(String msg) {
        super(msg);
    }

    public TurnoInvalidoException() {
    }

    public String getMsg() {
        return msg;
    }
    
}
