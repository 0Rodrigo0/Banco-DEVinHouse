package devinMoney.tipoConta;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;
import devinMoney.tipoInvestimento.TipoInvestimento;

public class Investimento extends Conta {

    private TipoInvestimento tipoInvestimento;

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

    @Override
    public String toString() {
        return "Nome: " + getNome() + ". CPF: " + getCpf() + ". Renda: " + getRenda() + "\n"
                + "Agencia: " + getAgencia() + ". Conta: " + getConta() + "\n";
    }

}
