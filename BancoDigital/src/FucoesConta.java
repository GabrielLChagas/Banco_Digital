public interface FucoesConta {
    boolean sacar (Double valor);

    void depositar(Double valor);

    boolean transferir (Double valor, FucoesConta contaDestinada);

}
