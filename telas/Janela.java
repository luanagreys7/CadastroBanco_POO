package telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.event.KeyEvent;
import java.text.ParseException;


public class Janela extends JFrame {

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


    }

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

    public static void main(String args[]) {
        Janela janela = new Janela();
        janela.setVisible(true);
    }


}