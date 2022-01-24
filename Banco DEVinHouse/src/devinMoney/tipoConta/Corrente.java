package devinMoney.tipoConta;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;

public class Corrente extends Conta {

    private double chequeEspecial;
    private double limiteChequeEspecial;

    public Corrente(String nome, String cpf, double renda, String conta, Agencia agencia, double saldo,
            double chequeEspecial, double limiteChequeEspecial) {
        super(nome, cpf, renda, conta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

}
