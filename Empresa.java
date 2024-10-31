import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Cliente> clientes;

    public Empresa() {
        clientes = new ArrayList<>();
    }

    public boolean adicionarCliente(String nome, String email) {
        if (clientes.size() < 5) {
            Cliente novoCliente = new Cliente(nome, email);
            clientes.add(novoCliente);
            return true;
        }
        return false; // Não pode adicionar mais de 5 clientes
    }

    public String exibirClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes) {
            sb.append("Nome: ").append(cliente.getNome()).append(", Email: ").append(cliente.getEmail()).append("\n");
        }
        return sb.toString();
    }
}
