package objetos;

import funcoes.ControleCadastro;

public class Cliente extends Pessoa {

    public Cliente(String nome, String endereco, String telefone, String cpf ) {
        super(nome, endereco, telefone, cpf);
    }

    @Override
    public String criar(ControleCadastro controle) {
        return controle.criarCliente(this);
    }

}
