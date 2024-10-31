import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Empresa empresa;

    public static void main(String[] args) {
        empresa = new Empresa();
        
        JFrame frame = new JFrame("Gerenciamento de Clientes e Funcionários");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        // Componentes para adicionar cliente
        JLabel nomeLabel = new JLabel("Nome Cliente:");
        JTextField nomeField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        
        JButton adicionarClienteButton = new JButton("Adicionar Cliente");
        JButton exibirClientesButton = new JButton("Exibir Clientes");
        
        // Componentes para adicionar funcionário
        JLabel nomeFuncLabel = new JLabel("Nome Funcionário:");
        JTextField nomeFuncField = new JTextField();
        JLabel cargoLabel = new JLabel("Cargo:");
        JTextField cargoField = new JTextField();
        JLabel salarioLabel = new JLabel("Salário:");
        JTextField salarioField = new JTextField();
        
        JButton adicionarFuncButton = new JButton("Adicionar Funcionário");
        JButton exibirFuncionariosButton = new JButton("Exibir Funcionários");
        JButton calcularFolhaButton = new JButton("Calcular Folha Salarial");
        
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        
        // Ação para adicionar cliente
        adicionarClienteButton.addActionListener(new ActionListener() {
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

        // Ação para exibir clientes
        exibirClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(empresa.exibirClientes());
            }
        });

        // Ação para adicionar funcionário
        adicionarFuncButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeFuncField.getText();
                String cargo = cargoField.getText();
                double salario;
                try {
                    salario = Double.parseDouble(salarioField.getText());
                    if (empresa.adicionarFuncionario(nome, cargo, salario)) {
                        JOptionPane.showMessageDialog(frame, "Funcionário adicionado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Limite de funcionários atingido!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Salário deve ser um número válido!");
                }
                nomeFuncField.setText("");
                cargoField.setText("");
                salarioField.setText("");
            }
        });

        // Ação para exibir funcionários
        exibirFuncionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText(empresa.exibirFuncionarios());
            }
        });

        // Ação para calcular folha salarial
        calcularFolhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalFolha = empresa.calcularFolhaSalarial();
                JOptionPane.showMessageDialog(frame, "Total da Folha Salarial: R$ " + totalFolha);
            }
        });

        // Adicionando componentes ao painel
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(adicionarClienteButton);
        panel.add(exibirClientesButton);

        panel.add(nomeFuncLabel);
        panel.add(nomeFuncField);
        panel.add(cargoLabel);
        panel.add(cargoField);
        panel.add(salarioLabel);
        panel.add(salarioField);
        panel.add(adicionarFuncButton);
        panel.add(exibirFuncionariosButton);
        panel.add(calcularFolhaButton);
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
