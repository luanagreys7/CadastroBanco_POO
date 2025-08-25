package funcoes;

import java.util.ArrayList;
import objetos.Cliente;
import objetos.Conta;
import objetos.ContaCorrente;
import objetos.ContaPoupanca;


public class ControleCadastro {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Conta> contas = new ArrayList<>();

    // Criar cliente
    public String criarCliente(String nome, String cpf, String telefone, String endereco) {

        // Verifica duplicidade
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf) || c.getTelefone().equals(telefone)) {
                return "Erro: Cliente já existe (CPF ou telefone duplicado).";
            }
        }
        Cliente novo = new Cliente(nome, cpf, telefone, endereco);
        clientes.add(novo);
        return "Cliente cadastrado com sucesso!";
    }

    // Criar conta
    public String criarConta(String tipo, String agencia, String numero, Cliente cliente) {

        // Verifica duplicidade de conta
        for (Conta c : contas) {
            if (c.getAgencia().equals(agencia) && c.getNumero().equals(numero)) {
                return "Erro: Conta já existe.";
            }
        }

        // Verifica se já existe conta do mesmo tipo para esse cliente
        for (Conta c : contas) {
            if (c.getCliente().equals(cliente)) {
                if ((c instanceof ContaCorrente && tipo.equals("corrente")) ||
                    (c instanceof ContaPoupanca && tipo.equals("poupanca"))) {
                    return "Erro: Cliente já possui essa conta.";
                }
            }
        }

        Conta conta;
        if (tipo.equals("corrente")) {
            conta = new ContaCorrente(agencia, numero, cliente);
        } else {
            conta = new ContaPoupanca(agencia, numero, cliente);
        }
        contas.add(conta);
        return "Conta " + tipo + " criada com sucesso!";
    }

    // Consultar conta

    public Conta consultarConta(String agencia, String numero) {
        for (Conta c : contas) {
            if (c.getAgencia().equals(agencia) && c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    // Atualizar cliente
    
    public String atualizarCliente(Cliente cliente, String nome, String telefone, String endereco) {
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        return "Dados do cliente atualizados com sucesso!";
    }
    
    
}
