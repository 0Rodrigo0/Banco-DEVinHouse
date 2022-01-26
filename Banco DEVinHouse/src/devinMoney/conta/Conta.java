package devinMoney.conta;

public class Conta {

    private String tipo;
    private String nome;
    private String cpf;
    private double renda;
    private String conta;
    private Agencia agencia;
    private double saldo;

    public Conta(String tipo, String nome, String cpf, double renda, String conta, Agencia agencia, double saldo) {
        this.tipo = tipo;
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
