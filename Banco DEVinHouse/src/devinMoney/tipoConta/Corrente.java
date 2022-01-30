package devinMoney.tipoConta;

import java.time.LocalDate;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;

public class Corrente extends Conta {

    private double especial;
    private double limiteEspecial;

    public Corrente(String tipo, String nome, String cpf, double renda, String conta, Agencia agencia,
            double limiteEspecial, double saldo, LocalDate datadaOperacao) {
        super(tipo, nome, cpf, renda, conta, agencia, saldo, datadaOperacao);
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
                + "Conta: " + getNumeroConta() + "\n"
                + "Tipo da Conta: " + getTipo() + "\n"
                + "Saldo: " + getSaldo() + "\n"
                + "Data: " + getDataDaOperacao() + "\n"
                + "Limite especial: " + Math.abs(getLimiteEspecial()) + "\n"
                + "Data: " + getDataDaOperacao() + "\n" + "\n";
    }

    // saque conta corrente
    @Override
    public void saqueCorrente(double valor) {
        if ((getSaldo() - valor) >= getLimiteEspecial()) {
            setSaldo(getSaldo() - valor);
            System.out.println("");
            System.out.println("O valor " + valor + " foi debitado. Saldo: " + " R$ " + getSaldo() + ".");
            System.out.println("Sua conta tem " + "R$ " + Math.abs(getLimiteEspecial()) + " de cheque especial.");
        } else {
            System.out.println("Você atingiu o limite de sua conta!");
            System.out.println(
                    "Seu saldo é " + getSaldo() + ". Limite " + "R$ " + Math.abs(getLimiteEspecial())
                            + " de cheque especial.");
            System.out.println("Regularize sua conta para voltar a sacar.");
        }
    }

    // saldo conta corrente
    @Override
    public double saldoCorrente() {
        double valor = getSaldo() + Math.abs(getLimiteEspecial());
        return valor;
    }

    // deposito conta corrente
    public void depositoCorrente(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Valor depositado/devolvido " + "R$ " + valor);
            System.out.println("Limite cheque especial " + "R$" + Math.abs(getLimiteEspecial()));

        }

    }

    @Override
    public boolean investe(double valor) {
        return false;
    }

}
