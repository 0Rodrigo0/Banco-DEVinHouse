package devinMoney.tipoConta;

import java.time.LocalDate;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;

public class Poupanca extends Conta {

    private LocalDate tempo;

    public Poupanca(String tipo, String nome, String cpf, double renda, String conta, Agencia agencia, double saldo) {
        super(tipo, nome, cpf, renda, conta, agencia, saldo);

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
                + "Conta: " + getConta() + "\n";
    }

}
