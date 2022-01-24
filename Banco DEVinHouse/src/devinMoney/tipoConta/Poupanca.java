package devinMoney.tipoConta;

import java.time.LocalDate;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;

public class Poupanca extends Conta {

    private LocalDate meses;
    private double rentabilidadeAnual;

    public Poupanca(String nome, String cpf, double renda, String conta, Agencia agencia, double saldo, LocalDate meses,
            double rentabilidadeAnual) {
        super(nome, cpf, renda, conta, agencia, saldo);
        this.meses = meses;
        this.rentabilidadeAnual = rentabilidadeAnual;
    }

    public LocalDate getMeses() {
        return meses;
    }

    public void setMeses(LocalDate meses) {
        this.meses = meses;
    }

    public double getRentabilidadeAnual() {
        return rentabilidadeAnual;
    }

    public void setRentabilidadeAnual(double rentabilidadeAnual) {
        this.rentabilidadeAnual = rentabilidadeAnual;
    }

}
