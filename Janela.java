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