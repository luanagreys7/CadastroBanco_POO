package objetos;

import funcoes.ControleCadastro;

public abstract class Conta implements Cadastravel {
    private String agencia;
    private String numero;
    private Cliente cliente;

    public Conta(String agencia, String numero, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
    }

    // Getters e Setters
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public abstract String getTipo();
    
    @Override
    public abstract String criar(ControleCadastro controle) {
        return controle.criarConta(getTipo(), agencia, numero, cliente);
    }
}
