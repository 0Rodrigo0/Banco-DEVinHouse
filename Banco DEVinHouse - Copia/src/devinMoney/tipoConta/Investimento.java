package devinMoney.tipoConta;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;
import devinMoney.tipoInvestimento.TipoInvestimento;

public class Investimento extends Conta {

    private TipoInvestimento tipoInvestimento;
    private double valorInvestido;

    public Investimento(String tipo, String nome, String cpf, double renda, String conta, Agencia agencia,
            double saldo) {
        super(tipo, nome, cpf, renda, conta, agencia, saldo);

    }

    public TipoInvestimento getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n"
                + "CPF: " + getCpf() + "\n"
                + "Renda: " + getRenda() + "\n"
                + "Agencia: " + getAgencia() + "\n"
                + "Conta: " + getNumeroConta() + "\n";
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

        if (getSaldo() != 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            setValorInvestido(getValorInvestido() + valor);
            System.out.println("");
            System.out.println(
                    "Você investiu " + getValorInvestido() + " e seu saldo é " + " R$ " + getSaldo() + ".");
            return true;
        } else {
            System.out.println("Não foi possível processar seu pedido!");
            System.out.println("Seu saldo é " + getSaldo() + " Você precisa fazer um depósito!");
            System.out.println("Sua conta não possui cheque especial.");
            return false;
        }
    }

}
