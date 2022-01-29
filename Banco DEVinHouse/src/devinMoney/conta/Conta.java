package devinMoney.conta;

public abstract class Conta {

    private String tipo;
    private String nome;
    private String cpf;
    private double renda;
    private String numeroConta;
    private Agencia agencia;
    private double saldo;

    public Conta(String tipo, String nome, String cpf, double renda, String numeroConta, Agencia agencia,
            double saldo) {
        this.tipo = tipo;
        this.nome = nome;
        this.cpf = cpf;
        this.renda = renda;
        this.numeroConta = numeroConta;
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

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
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

    public void saque(double valor) {

        if (getTipo().equals("P")) {
            if (getSaldo() != 0 && getSaldo() >= valor) {
                setSaldo(getSaldo() - valor);
                System.out.println("");
                System.out.println("Você sacou " + valor + " e seu saldo é " + " R$ " + getSaldo() + ".");
            } else {
                System.out.println("Não foi possível processar seu pedido!");
                System.out.println("Seu saldo é " + getSaldo() + " Você precisa fazer um depósito!");
                System.out.println("Sua conta não possui cheque especial.");
            }
        }
        if (getTipo().equals("C")) {
            saquecorrente(valor);
        }
    }

    public abstract void saquecorrente(double valor);

    public void deposito(double valor) {

        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("");
            System.out.println("Desposito de  " + "R$" + valor + " efetivado. Saldo: " + " R$ " + getSaldo() + ".");
        }
    }

    public void saldo(String conta) {
        if (getNumeroConta().equals(conta)) {
            System.out.println("");
            System.out.println(getNome() + " voce tem " + " R$ " + getSaldo() + " até o momento.");
        }
    }

    public boolean validaConta(String conta) {

        if (getNumeroConta().equals(conta)) {
            return true;
        } else {
            return false;
        }
    }

    public void transferir(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("");
            System.out.println(getNome() + " recebeu a transferencia. Saldo " + " R$ " + getSaldo() + ".");
        }
    }

}
