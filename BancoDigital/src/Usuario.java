public class Usuario {
    String nome;
    String cpf;
    private int numero;
    private double saldo;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }
    public String getCpf(){
        return cpf;
    }

    public void setNome(String nome)   {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getNumero (){
        return numero;
    }

    public void setNumero(){
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(){
        this.saldo = saldo;
    }

}