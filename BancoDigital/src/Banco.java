import java.util.ArrayList;
import java.util.List;

public class Banco extends Usuario {
    private static List<Conta> contas;

    public Banco() {
        super();
        contas = new ArrayList<>();
    }

    public static Conta criarConta(Usuario usuario) {
        Conta novaConta = new Conta(usuario);
        contas.add(novaConta);
        return novaConta;
    }

    public static Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public static void exibirSaldo(int numero) {
        Conta conta = buscarConta(numero);
        if (conta != null) {
            System.out.println("Saldo da conta " + numero + ": " + conta.getSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void listarContas() {
        for (Conta conta : contas) {
            System.out.println("Conta número: " + conta.getNumero() + ", BancoDigital.Cliente: " + conta.getCliente().getNome());
        }
    }
}