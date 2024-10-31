import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Empresa empresa;

    public static void main(String[] args) {
        empresa = new Empresa();
        
        JFrame frame = new JFrame("Gerenciamento de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        
        JButton adicionarButton = new JButton("Adicionar Cliente");
        JButton exibirButton = new JButton("Exibir Clientes");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                if (empresa.adicionarCliente(nome, email)) {
                    JOptionPane.showMessageDialog(frame, "Cliente adicionado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Limite de clientes atingido!");
                }
                nomeField.setText("");
                emailField.setText("");
            }
        });
        
        exibirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(empresa.exibirClientes());
            }
        });

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(adicionarButton);
        panel.add(exibirButton);
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
