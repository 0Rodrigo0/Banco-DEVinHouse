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

    public abstract void saqueCorrente(double valor);

    public abstract void depositoCorrente(double valor);

    public abstract double saldoCorrente();

    // método saque
    public void saque(double valor) {
        // saque poupança
        if (getTipo().equals("P")) {
            if (getSaldo() >= valor) {
                setSaldo(getSaldo() - valor);
                System.out.println("");
                System.out.println("Você sacou " + valor + " e seu saldo é " + " R$ " + getSaldo() + ".");
            } else {
                System.out.println("Não foi possível processar seu pedido!");
                System.out.println("Seu saldo é " + getSaldo() + " Você precisa fazer um depósito!");
                System.out.println("Sua conta não possui cheque especial.");
            }
        }
        // saque corrente
        if (getTipo().equals("C")) {
            saqueCorrente(valor);
        }
        // saque investimento
        if (getTipo().equals("I")) {
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

    }

    // método deposito
    public void deposito(double valor) {
        if (getTipo() != "C") {
            if (valor > 0) {
                setSaldo(getSaldo() + valor);
                System.out.println("Depositado/estornado: " + "R$" + valor + " Saldo: " + " R$ " + getSaldo() + ".");
            }
        } else {
            depositoCorrente(valor);
        }
    }

    // metodo saldo
    public void saldo(String conta) {
        if (getNumeroConta().equals(conta)) {
            System.out.println("");
            System.out.println(getNome() + " voce tem " + " R$ " + getSaldo() + " até o momento.");
        }
    }

    // metodo valida conta
    public boolean validaConta(String conta) {

        if (getNumeroConta().equals(conta)) {
            return true;
        } else {
            return false;
        }
    }

    // metodo trasnfere
    public void transferir(double valor) {
        if (getTipo() != "C") {
            if (valor > 0) {
                setSaldo(getSaldo() + valor);
                System.out.println("");
                System.out.println(getNome() + " recebeu a transferencia. Saldo " + " R$ " + getSaldo() + ".");
            }
        }

    }

}
