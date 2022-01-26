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
        return "Nome: " + getNome() + ". CPF: " + getCpf() + ". Renda: " + getRenda() + "\n"
                + "Agencia: " + getAgencia() + ". Conta: " + getConta() + "\n";
    }

}
