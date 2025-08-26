package telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.awt.event.*;
import funcoes.ControleCadastro;
import objetos.*;

public class Janela extends JFrame {

    private ControleCadastro controle = new ControleCadastro();

    // Estado de interação
    private boolean emConsulta = false;
    private boolean emEdicao = false;
    private Conta contaSelecionada = null;

    // Atributos

    private JLabel jlAgencia;

    // agência com máscara
    private JFormattedTextField jtfAgencia;

    private JLabel jlConta;

    // conta com máscara
    private JFormattedTextField jtfConta;

    private JSeparator jSeparator01;

    private JLabel jlNome;
    private JTextField jtfNome;

    private JLabel jlEndereco;
    private JTextField jtfEndereco;

    private JLabel jlTelefone;

    // telefone com máscara
    private JFormattedTextField jtfTelefone;

    private JLabel jlCpf;

    // cpf com máscara
    private JFormattedTextField jtfCpf;

    private JRadioButton jrbCorrente;
    private JRadioButton jrbPoupanca;
    private ButtonGroup bgContas;

    private JSeparator jSeparator02;

    private JButton jbCriar;
    private JButton jbConsultar;
    private JButton jbAtualizar;
    
    // Construtor
    public Janela() {
        setTitle("Java Swing - Desenvolvimento de Sistemas");
        setSize(400, 255);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        centralizar();

        jlAgencia = new JLabel();
        jlAgencia.setText("Código da Agência");
        jlAgencia.setBounds(10, 10, 110, 18);

        getContentPane().add(jlAgencia);

        // Máscara para a agência

        try {
            MaskFormatter mascaraAgencia = new MaskFormatter("####");
            mascaraAgencia.setPlaceholderCharacter('_');
            jtfAgencia = new JFormattedTextField(mascaraAgencia);
        } catch (ParseException e) {
            e.printStackTrace();
            jtfAgencia = new JFormattedTextField();
        }

        jtfAgencia.setBounds(125, 10, 50, 20);

        getContentPane().add(jtfAgencia);

        jlConta = new JLabel();
        jlConta.setText("Número da Conta");
        jlConta.setBounds(205, 10, 105, 18);

        getContentPane().add(jlConta);

        // Máscara para a conta

        try {
            MaskFormatter mascaraConta = new MaskFormatter("######-#");
            mascaraConta.setPlaceholderCharacter('_');
            jtfConta = new JFormattedTextField(mascaraConta);
        } catch (ParseException e) {
            e.printStackTrace();
            jtfConta = new JFormattedTextField();
        }

        jtfConta.setBounds(315, 10, 60, 20);

        getContentPane().add(jtfConta);

        jSeparator01 = new JSeparator();
        jSeparator01.setBounds(10, 40, 365, 10);

        getContentPane().add(jSeparator01);

        jlNome = new JLabel();
        jlNome.setText("Nome: ");
        jlNome.setBounds(10, 50, 60, 18);
        jlNome.setHorizontalAlignment(SwingConstants.RIGHT);
        
        getContentPane().add(jlNome);

        jtfNome = new JTextField();
        jtfNome.setBounds(75, 50, 300, 20);

        getContentPane().add(jtfNome);

        jlEndereco = new JLabel();
        jlEndereco.setText("Endereço: ");
        jlEndereco.setBounds(10, 75, 60, 18);
        jlEndereco.setHorizontalAlignment(SwingConstants.RIGHT);

        getContentPane().add(jlEndereco);   

        jtfEndereco = new JTextField();
        jtfEndereco.setBounds(75, 75, 300, 20);

        getContentPane().add(jtfEndereco);

        jlTelefone = new JLabel();
        jlTelefone.setText("Telefone: ");
        jlTelefone.setBounds(10, 100, 60, 18);
        jlTelefone.setHorizontalAlignment(SwingConstants.RIGHT);

        getContentPane().add(jlTelefone);

        // Máscara para o telefone

        try {
            MaskFormatter mascaraTel = new MaskFormatter("(##) #####-####");
            mascaraTel.setPlaceholderCharacter('_');
            jtfTelefone = new JFormattedTextField(mascaraTel);
        } catch (ParseException e) {
            e.printStackTrace();
            jtfTelefone = new JFormattedTextField();
        }

        jtfTelefone.setBounds(75, 100, 300, 20);
        
        getContentPane().add(jtfTelefone);

        jlCpf = new JLabel();
        jlCpf.setText("CPF: ");
        jlCpf.setBounds(10, 125, 60, 18);
        jlCpf.setHorizontalAlignment(SwingConstants.RIGHT);

        getContentPane().add(jlCpf);

        // Máscara para o CPF
        try {
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCpf.setPlaceholderCharacter('_'); // Mostra "_" nos espaços vazios
            jtfCpf = new JFormattedTextField(mascaraCpf);
        } catch (ParseException e) {
            e.printStackTrace();
            jtfCpf = new JFormattedTextField();
        }

        jtfCpf.setBounds(75, 125, 300, 20);

        getContentPane().add(jtfCpf);

        jrbCorrente = new JRadioButton("Conta Corrente");
        jrbCorrente.setBounds(100, 150, 111, 20);
        jrbCorrente.setSelected(true);
        jrbCorrente.setMnemonic(KeyEvent.VK_C); // Alt + C

        getContentPane().add(jrbCorrente);

        jrbPoupanca = new JRadioButton("Conta Poupança");
        jrbPoupanca.setBounds(225, 150, 118, 20);
        jrbPoupanca.setMnemonic(KeyEvent.VK_P); // Alt + P

        getContentPane().add(jrbPoupanca);

        bgContas = new ButtonGroup();
        bgContas.add(jrbCorrente);
        bgContas.add(jrbPoupanca);

        jSeparator02 = new JSeparator();
        jSeparator02.setBounds(10, 180, 365, 10);

        getContentPane().add(jSeparator02);

        jbCriar = new JButton("Criar");
        jbCriar.setBounds(35, 190, 100, 23); //255, 190,
        jbCriar.setMnemonic(KeyEvent.VK_R); // Alt + R

        getContentPane().add(jbCriar);

        jbAtualizar = new JButton("Atualizar");
        jbAtualizar.setBounds(145, 190, 100, 23);
        jbAtualizar.setEnabled(false);
        jbAtualizar.setMnemonic(KeyEvent.VK_A); // Alt + A
        
        getContentPane().add(jbAtualizar);

        jbConsultar = new JButton("Consultar");
        jbConsultar.setBounds(255, 190, 100, 23); //35, 190,
        jbConsultar.setMnemonic(KeyEvent.VK_S); // Alt + S

        getContentPane().add(jbConsultar);

        // Listeners dos botões
        jbCriar.addActionListener(e -> onCriar());
        jbConsultar.addActionListener(e -> onConsultar());
        jbAtualizar.addActionListener(e -> onAtualizar());


    }

    // Ações dos botões

    private void onCriar() {

        boolean clienteOk = campoTextoPreenchido(jtfNome) &&
                            campoTextoPreenchido(jtfEndereco) &&
                            campoTextoPreenchido(jtfTelefone) &&
                            campoTextoPreenchido(jtfCpf);

        boolean contaOk = campoTextoPreenchido(jtfAgencia) &&
                          campoTextoPreenchido(jtfConta);
        
        if (!clienteOk && !contaOk) {
            JOptionPane.showMessageDialog(this,
            "Preencha os dados do cliente e/ou da conta para criar.", 
            "Aviso", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder msgs = new StringBuilder();
        Cliente clienteRef = null;

        // Cliente (se informado)

        if (clienteOk) {
            String nome = jtfNome.getText().trim();
            String endereco = jtfEndereco.getText().trim();
            String telefone = jtfTelefone.getText().trim();
            String cpf = jtfCpf.getText().trim();

            Cliente cli = new Cliente(nome, endereco, telefone, cpf);
            String resCli = cli.criar(controle);
            msgs.append(resCli).append("\n");

            if (resCli.startsWith("Erro")) {
                // Tenta usar cliente existente (se for duplicidade de CPF/telefone)
                Cliente existente = controle.buscarClientePorCpf(cpf);
                if (existente == null) {
                    JOptionPane.showMessageDialog(this, resCli, "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                clienteRef = existente;
            } else {
                clienteRef = cli;
            }
        }

        // Conta (se informada)

        if (contaOk) {
            // Para criar conta precisamos de um cliente (ou recém-criado ou já existente)
            if (clienteRef == null) {
                // tenta buscar por CPF se estiver preenchido
                if (maskPreenchida(jtfCpf)) {
                    Cliente existente = controle.buscarClientePorCpf(jtfCpf.getText().trim());
                    if (existente == null) {
                        JOptionPane.showMessageDialog(this,
                            "Para criar conta, informe um cliente existente (CPF) ou preencha todos os dados do cliente.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    clienteRef = existente;
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Para criar conta, informe um cliente existente (CPF) ou preencha todos os dados do cliente.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String agencia = jtfAgencia.getText().trim();
            String numero = jtfConta.getText().trim();
            Conta conta = jrbCorrente.isSelected()
                    ? new ContaCorrente(agencia, numero, clienteRef)
                    : jrbPoupanca.isSelected()
                        ? new ContaPoupanca(agencia, numero, clienteRef)
                        : null;

            if (conta == null) {
                JOptionPane.showMessageDialog(this,
                    "Selecione o tipo de conta (Corrente ou Poupança).",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String resConta = conta.criar(controle); // polimorfismo via Conta.getTipo()
            msgs.append(resConta).append("\n");
        }

        JOptionPane.showMessageDialog(this, msgs.toString().trim(),
                "Resultado", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
        liberarCamposParaCriacao();
        jbAtualizar.setEnabled(false);
        emConsulta = false;
        emEdicao = false;
        contaSelecionada = null;
    }

    private void onConsultar() {
        if (emConsulta) {
            // Toggle: segundo clique limpa a consulta
            limparCampos();
            liberarCamposParaCriacao();
            jbAtualizar.setEnabled(false);
            emConsulta = false;
            emEdicao = false;
            contaSelecionada = null;
            return;
        }

        if (!maskPreenchida(jtfAgencia) || !maskPreenchida(jtfConta)) {
            JOptionPane.showMessageDialog(this,
                "Informe Agência e Número da Conta completos para consultar.",
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String agencia = jtfAgencia.getText().trim();
        String numero = jtfConta.getText().trim();

        Conta conta = controle.consultarConta(agencia, numero);
        if (conta == null) {
            JOptionPane.showMessageDialog(this,
                "Conta não encontrada.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Preenche e bloqueia
        contaSelecionada = conta;
        Cliente cli = conta.getCliente();

        jtfNome.setText(cli.getNome());
        jtfEndereco.setText(cli.getEndereco());
        jtfTelefone.setText(cli.getTelefone());
        jtfCpf.setText(cli.getCpf());

        if (conta instanceof ContaCorrente) {
            jrbCorrente.setSelected(true);
        } else {
            jrbPoupanca.setSelected(true);
        }

        bloquearCamposPosConsulta();
        jbAtualizar.setEnabled(true);
        emConsulta = true;
        emEdicao = false;
    }

    private void onAtualizar() {
        if (!emConsulta || contaSelecionada == null) return;

        if (!emEdicao) {
            // Primeira pressão: liberar edição de nome/telefone/endereço
            jtfNome.setEditable(true);
            jtfTelefone.setEditable(true);
            jtfEndereco.setEditable(true);

            // Não se edita CPF, Agência, Número, nem tipo
            jtfCpf.setEditable(false);
            jtfAgencia.setEditable(false);
            jtfConta.setEditable(false);
            jrbCorrente.setEnabled(false);
            jrbPoupanca.setEnabled(false);

            emEdicao = true;
            return;
        }

        // Segunda pressão: salvar alterações
        String nome = jtfNome.getText().trim();
        String telefone = jtfTelefone.getText().trim();
        String endereco = jtfEndereco.getText().trim();

        if (nome.isBlank() || !maskPreenchida(jtfTelefone) || endereco.isBlank()) {
            JOptionPane.showMessageDialog(this,
                "Preencha Nome, Telefone e Endereço para salvar.",
                "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String res = controle.atualizarCliente(contaSelecionada.getCliente(), nome, telefone, endereco);
        if (res.startsWith("Erro")) {
            JOptionPane.showMessageDialog(this, res, "Erro", JOptionPane.ERROR_MESSAGE);
            return; // continua em edição
        }

        JOptionPane.showMessageDialog(this, res, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        // Sai do modo consulta/edição
        limparCampos();
        liberarCamposParaCriacao();
        jbAtualizar.setEnabled(false);
        emConsulta = false;
        emEdicao = false;
        contaSelecionada = null;
    }

    // Metódos auxiliares

    private void centralizar() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension janela = getSize();
        if (janela.height > screen.height)
            setSize(janela.width, screen.height);
        if (janela.width > screen.width)
            setSize(screen.width, janela.height);
        setLocation((screen.width - janela.width) / 2,
                (screen.height - janela.height) / 2);
        setResizable(false);
    }

    private boolean campoTextoPreenchido(JTextField f) {
        return f.getText() != null && !f.getText().trim().isBlank();
    }

    private boolean maskPreenchida(JFormattedTextField f) {
        String t = f.getText();
        return t != null && !t.isBlank() && !t.contains("_");
    }

    private void bloquearCamposPosConsulta() {
        jtfAgencia.setEditable(false);
        jtfConta.setEditable(false);
        jtfNome.setEditable(false);
        jtfCpf.setEditable(false);
        jtfTelefone.setEditable(false);
        jtfEndereco.setEditable(false);
        jrbCorrente.setEnabled(false);
        jrbPoupanca.setEnabled(false);
    }

    private void liberarCamposParaCriacao() {
        jtfAgencia.setEditable(true);
        jtfConta.setEditable(true);
        jtfNome.setEditable(true);
        jtfCpf.setEditable(true);
        jtfTelefone.setEditable(true);
        jtfEndereco.setEditable(true);
        jrbCorrente.setEnabled(true);
        jrbPoupanca.setEnabled(true);
    }

    private void limparCampos() {
        jtfNome.setText("");
        jtfCpf.setText("");
        jtfTelefone.setText("");
        jtfEndereco.setText("");
        jtfTelefone.setText("");
        jtfCpf.setText("");
        jtfAgencia.setText("");
        jtfConta.setText("");
        bgContas.clearSelection();
    }


    public static void main(String args[]) {
        Janela janela = new Janela();
        janela.setVisible(true);
    }


}