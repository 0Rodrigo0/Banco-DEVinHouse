package devinMoney.tipoConta;

import java.time.LocalDate;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;

public class Poupanca extends Conta {

    private LocalDate tempo;

    public Poupanca(String tipo, String nome, String cpf, double renda, String conta, Agencia agencia, double saldo,
            LocalDate dataDaOperacao) {
        super(tipo, nome, cpf, renda, conta, agencia, saldo, dataDaOperacao);

    }

    public LocalDate getTempo() {
        return tempo;
    }

    public void setTempo(LocalDate tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Renda: " + getRenda() + "\n"
                + "Agencia: " + getAgencia() + "\n"
                + "Conta: " + getNumeroConta() + "\n"
                + "Tipo Conta: " + getTipo() + "\n"
                + "Saldo: " + getSaldo() + "\n"
                + "Data: " + getDataDaOperacao() + "\n" + "\n";
    }

    @Override
    public void saqueCorrente(double valor) {
    }

    @Override
    public void depositoCorrente(double valor) {
    }

    @Override
    public double saldoCorrente() {
        return 0;
    }

    @Override
    public boolean investe(double valor) {
        return false;
    }

}
