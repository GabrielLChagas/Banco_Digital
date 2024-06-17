public class Conta implements FucoesConta {

    public static int sequncia = 1;

    protected int numero;
    protected double saldo;
    protected Usuario cliente;
    protected Usuario cpf;

    public Conta(Usuario cliente){
        this.numero = sequncia++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    @Override
    public boolean sacar(Double valor) {
        if (valor > 0 && saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
            return false;
        }
    }

    @Override
    public void depositar(Double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    @Override
    public boolean transferir(Double valor, FucoesConta contaDestinada) {
        if (this.sacar(valor)) {
            contaDestinada.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    protected void imprimirInformacoes() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
