
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;

    public Empresa() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
    }

    public boolean adicionarCliente(String nome, String email) {
        if (clientes.size() < 5) {
            Cliente novoCliente = new Cliente(nome, email);
            clientes.add(novoCliente);
            return true;
        }
        return false; // Limite de clientes atingido
    }

    public String exibirClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes) {
            sb.append("Nome: ").append(cliente.getNome()).append(", Email: ").append(cliente.getEmail()).append("\n");
        }
        return sb.toString();
    }

    public boolean adicionarFuncionario(String nome, String cargo, double salario) {
        if (funcionarios.size() < 10) {
            Funcionario novoFuncionario = new Funcionario(nome, cargo, salario);
            funcionarios.add(novoFuncionario);
            return true;
        }
        return false; // Limite de funcionários atingido
    }

    public String exibirFuncionarios() {
        StringBuilder sb = new StringBuilder();
        for (Funcionario funcionario : funcionarios) {
            sb.append("Nome: ").append(funcionario.getNome())
              .append(", Cargo: ").append(funcionario.getCargo())
              .append(", Salário: R$ ").append(funcionario.getSalario()).append("\n");
        }
        return sb.toString();
    }

    public double calcularFolhaSalarial() {
        double total = 0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.getSalario();
        }
        return total;
    }
}
