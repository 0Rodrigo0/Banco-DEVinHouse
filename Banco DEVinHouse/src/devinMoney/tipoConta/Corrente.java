package devinMoney.tipoConta;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;

public class Corrente extends Conta {

    private double especial;
    private double limiteEspecial;

    public Corrente(String tipo, String nome, String cpf, double renda, String conta, Agencia agencia, double saldo,
            double limiteEspecial) {
        super(tipo, nome, cpf, renda, conta, agencia, saldo);
        this.limiteEspecial = limiteEspecial;
    }

    public double getEspecial() {
        return especial;
    }

    public void setEspecial(double especial) {
        this.especial = especial;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Renda: " + getRenda() + "\n"
                + "Agencia: " + getAgencia() + "\n"
                + "Conta: " + getNumeroConta() + "\n";
    }

    public void saqueCorrente(double valor) {
        if (getSaldo() >= -1000 && getLimiteEspecial() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("");
            System.out.println("Você sacou " + valor + " e seu saldo é " + " R$ " + getSaldo() + ".");
        } else {
            System.out.println("Não foi possível processar seu pedido!");
            System.out.println("Seu saldo é " + getSaldo() + " Você precisa fazer um depósito primeiro!");
        }

    }

    @Override
    public void saquecorrente(double valor) {
        if (getSaldo() >= 0 && getLimiteEspecial() <= 1000.0) {
            setSaldo(getSaldo() - valor);
            System.out.println("");
            System.out.println("Você sacou " + valor + " e seu saldo é " + " R$ " + getSaldo() + ".");
            System.out.println("Sua conta tem " + "R$" + getLimiteEspecial() + " de cheque especial.");
        } else {
            System.out.println("Não foi possível processar seu pedido!");
            System.out.println("Seu saldo é " + getSaldo() + " Você precisa fazer um depósito primeiro!");
        }
    }
}
