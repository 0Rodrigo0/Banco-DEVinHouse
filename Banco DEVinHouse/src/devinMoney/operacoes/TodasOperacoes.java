package devinMoney.operacoes;

import java.time.LocalDate;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;

public class TodasOperacoes extends Conta {

    private TipoOp tipoOperacao;
    private double valorOperacao;

    public TodasOperacoes(String tipo, String nome, String cpf, double renda, String numeroConta, Agencia agencia,
            double saldo, TipoOp tipoOperacao, double valorOperacao, LocalDate dataDaOperacao) {
        super(tipo, nome, cpf, renda, numeroConta, agencia, saldo, dataDaOperacao);
        this.tipoOperacao = tipoOperacao;
        this.valorOperacao = valorOperacao;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public TipoOp getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOp tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
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

    @Override
    public String toString() {
        return "Tipo de operação: " + getTipoOperacao() + "\n"
                + "Nome: " + getNome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Renda: " + getRenda() + "\n"
                + "Agencia: " + getAgencia() + "\n"
                + "Conta: " + getNumeroConta() + "\n"
                + "Tipo da Conta: " + getTipo() + "\n"
                + "Saldo: " + getSaldo() + "\n"
                + "Valor da Operação: " + getValorOperacao() + "\n"
                + "Data: " + getDataDaOperacao() + "\n" + "\n";
    }

}
