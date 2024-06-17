import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBem-vindo ao BancoDigital.Banco!");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Exibir saldo");
            System.out.println("6. Listar contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.next();
                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.next();
                    Usuario cliente = new Usuario();
                    Conta conta = Banco.criarConta(cliente);
                    System.out.println("Conta criada com sucesso! Número da conta: " + conta.getNumero());
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    int numeroConta = scanner.nextInt();
                    System.out.print("Valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    Conta contaDeposito = Banco.buscarConta(numeroConta);
                    if (contaDeposito != null) {
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("BancoDigital.Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Número da conta: ");
                    int numeroSaque = scanner.nextInt();
                    System.out.print("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    Conta contaSaque = Banco.buscarConta(numeroSaque);
                    if (contaSaque != null) {
                        if (contaSaque.sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso!");
                        } else {
                            System.out.println("Falha ao realizar o saque.");
                        }
                    } else {
                        System.out.println("BancoDigital.Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Número da conta de origem: ");
                    int numeroOrigem = scanner.nextInt();
                    System.out.print("Número da conta de destino: ");
                    int numeroDestino = scanner.nextInt();
                    System.out.print("Valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    Conta contaOrigem = Banco.buscarConta(numeroOrigem);
                    Conta contaDestino = Banco.buscarConta(numeroDestino);
                    if (contaOrigem != null && contaDestino != null) {
                        if (contaOrigem.transferir(valorTransferencia, contaDestino)) {
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Falha ao realizar a transferência.");
                        }
                    } else {
                        System.out.println("BancoDigital.Conta de origem ou destino não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Número da conta: ");
                    int numeroSaldo = scanner.nextInt();
                    Banco.exibirSaldo(numeroSaldo);
                    break;
                case 6:
                    Banco.listarContas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}