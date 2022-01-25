package devinMoney;

import java.util.ArrayList;
import java.util.Scanner;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;
import devinMoney.tipoConta.Corrente;
import devinMoney.tipoConta.Investimento;
import devinMoney.tipoConta.Poupanca;

public class DevinMoneyApp {

    public void saque(Conta conta) {

        if (conta.getSaldo() == 0) {

        }

    }

    public static void main(String[] args) {

        Scanner opcao = new Scanner(System.in);
        ArrayList<Conta> conta = new ArrayList<>();

        Corrente c1 = new Corrente("Perna Longa", "11111111111", 1000, "0001", Agencia.FLORIANOPOLIS_001, 0, 2000);
        Poupanca p1 = new Poupanca("Patolino", "22222222222", 2000, "0002", Agencia.SAO_JOSE_002, 3000);
        Investimento i1 = new Investimento("Simba", "33333333333", 3000, "0003", Agencia.FLORIANOPOLIS_001, 4000);
        Corrente c2 = new Corrente("Popeye", "11111111111", 1000, "0004", Agencia.FLORIANOPOLIS_001, 0, 1000);
        Poupanca p2 = new Poupanca("Simão", "22222222222", 2000, "0005", Agencia.SAO_JOSE_002, 3500);
        Investimento i2 = new Investimento("Pumba", "33333333333", 3000, "0006", Agencia.FLORIANOPOLIS_001, 5000);

        conta.add(c1);
        conta.add(p1);
        conta.add(i1);
        conta.add(c2);
        conta.add(p2);
        conta.add(i2);

        for (Conta conta2 : conta) {
            System.out.println(conta2);
        }

        opcao.close();
    }

}
