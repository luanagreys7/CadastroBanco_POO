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
    public String criarCliente(Cliente c) {
        String nome = c.getNome();
        String cpf = c.getCpf();
        String telefone = c.getTelefone();
        String endereco = c.getEndereco();

        // Validação de campos obrigatórios
        if (nome == null || nome.isBlank() ||
            cpf == null || cpf.isBlank() ||
            telefone == null || telefone.isBlank() ||
            endereco == null || endereco.isBlank()) {
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

        clientes.add(c);
        return "Cliente cadastrado com sucesso!";
    }

    // Criar conta
    public String criarConta(String tipo, String agencia, String numero, Cliente cliente) {

        // Validação básica
        if (agencia == null || agencia.isBlank() || numero == null || numero.isBlank()) {
            return "Erro: Agência e número da conta devem ser preenchidos.";
        }
        if (cliente == null) {
            return "Erro: Selecione/informe um cliente válido para a conta.";
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
                if ((c instanceof ContaCorrente && "corrente".equals(tipo)) ||
                    (c instanceof ContaPoupanca && "poupanca".equals(tipo))) {
                    return "Erro: Cliente já possui conta " + tipo + ".";
                }
            }
        }

        Conta conta = "corrente".equals(tipo)
            ? new ContaCorrente(agencia, numero, cliente)
            : new ContaPoupanca(agencia, numero, cliente);

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
        if (cliente == null) return "Erro: Nenhum cliente selecionado.";
        if (nome == null || nome.isBlank() ||
            telefone == null || telefone.isBlank() ||
            endereco == null || endereco.isBlank()) {
            return "Erro: Nome, telefone e endereço são obrigatórios.";
        }
        // Telefone duplicado (ignora o próprio cliente)
        for (Cliente c : clientes) {
            if (c != cliente && c.getTelefone().equals(telefone)) {
                return "Erro: Já existe cliente com esse telefone.";
            }
        }
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        return "Dados do cliente atualizados com sucesso!";
    }
    
    
}
