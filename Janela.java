import java.awt.*;
import javax.swing.*;


public class Janela extends JFrame {

    private JLabel jlAgencia;
    private JTextField jtfAgencia;

    private JLabel jlConta;
    private JTextField jtfConta;

    private JSeparator jSeparator01;

    private JLabel jlNome;
    private JTextField jtfNome;

    private JLabel jlEndereco;
    private JTextField jtfEndereco;

    private JLabel jlTelefone;
    private JTextField jtfTelefone;

    private JLabel jlCpf;
    private JTextField jtfCpf;

    private JRadioButton jrbCorrente;
    private JRadioButton jrbPoupanca;
    private ButtonGroup bgContas;

    private JSeparator jSeparator02;

    private JButton jbConsultar;
    private JButton jbAtualizar;
    private JButton jbFechar;

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

        jtfAgencia = new JTextField();
        jtfAgencia.setBounds(125, 10, 50, 20);

        getContentPane().add(jtfAgencia);

        jlConta = new JLabel();
        jlConta.setText("Número da Conta");
        jlConta.setBounds(205, 10, 105, 18);

        getContentPane().add(jlConta);

        jtfConta = new JTextField();
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