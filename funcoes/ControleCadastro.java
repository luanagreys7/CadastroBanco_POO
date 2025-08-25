package funcoes;

import java.util.ArrayList;
import objetos.Cliente;
import objetos.Conta;
import objetos.ContaCorrente;
import objetos.ContaPoupanca;


public class ControleCadastro {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Conta> contas = new ArrayList<>();

    // Busca cliente por CPF
    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    // Criar cliente
    public String criarCliente(String nome, String cpf, String telefone, String endereco) {

        // Validação de campos obrigatórios
        if (nome.isBlank() || cpf.isBlank() || telefone.isBlank() || endereco.isBlank()) {
            return "Erro: Todos os campos do cliente devem ser preenchidos.";
        }

        // Verifica duplicidade
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return "Erro: Já existe cliente com esse CPF.";
            }
            if (c.getTelefone().equals(telefone)) {
                return "Erro: Já existe cliente com esse telefone.";
            }
        }

        Cliente novo = new Cliente(nome, cpf, telefone, endereco);
        clientes.add(novo);
        return "Cliente cadastrado com sucesso!";
    }

    // Criar conta
    public String criarConta(String tipo, String agencia, String numero, Cliente cliente) {

        // Validação básica
        if (agencia.isBlank() || numero.isBlank()) {
            return "Erro: Agência e número da conta devem ser preenchidos.";
        }
        
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
