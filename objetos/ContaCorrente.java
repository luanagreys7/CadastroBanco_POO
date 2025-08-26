package objetos;

public class ContaCorrente extends Conta {

    public ContaCorrente(String agencia, String numero, Cliente cliente) {
        super(agencia, numero, cliente);
    }

    // Métodos abstratos
    @Override
    public String getTipo() {
        return "corrente";
    }
    
    
}
