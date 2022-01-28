package devinMoney;

import java.util.ArrayList;
import java.util.Scanner;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;
import devinMoney.tipoConta.Corrente;
import devinMoney.tipoConta.Investimento;
import devinMoney.tipoConta.Poupanca;

public class DevinMoneyApp {

    public static void main(String[] args) {
        DevinMoneyAp();
    }

    public static void DevinMoneyAp() {
        Integer opcao = 0;
        Scanner inicio = new Scanner(System.in);
        ArrayList<Conta> conta = new ArrayList<Conta>();

        Corrente c1 = new Corrente("C", "Perna Longa", "11111111111", 1000, "0001", Agencia.FLORIANOPOLIS_001, 0, 0);
        Poupanca p1 = new Poupanca("P", "Patolino", "22222222222", 2000, "0002", Agencia.SAO_JOSE_002, 0);
        Investimento i1 = new Investimento("I", "Simba", "33333333333", 3000, "0003", Agencia.FLORIANOPOLIS_001, 0);
        Corrente c2 = new Corrente("C", "Popeye", "44444444444", 4000, "0004", Agencia.SAO_JOSE_002, 0, 0);
        Poupanca p2 = new Poupanca("P", "Simão", "55555555555", 5000, "0005", Agencia.FLORIANOPOLIS_001, 0);
        Investimento i2 = new Investimento("I", "Pumba", "66666666666", 6000, "0006", Agencia.SAO_JOSE_002, 0);

        conta.add(c1);
        conta.add(p1);
        conta.add(i1);
        conta.add(c2);
        conta.add(p2);
        conta.add(i2);

        // for (Conta conta2 : conta) {
        // if (conta2.getTipo().equals("I"))
        // System.out.println(conta2);
        // }

        do {
            System.out.println(" ");
            System.out.println("Bem vindo");
            System.out.println("1 - Sacar  2 - Depositar   3 - Saldo");
            System.out.println("9 para sair");
            System.out.println(" ");
            opcao = inicio.nextInt();
            if (opcao == 1) {
                System.out.println("Digite sua conta");
                String num = inicio.next();
                Conta c = null;
                for (Conta conta2 : conta) {
                    if (conta2.validaConta(num) == true) {
                        System.out.println("");
                        System.out.println("Ola " + conta2.getNome());
                        System.out.println("Digite o valor do Saque");
                        double valorSaque = inicio.nextDouble();
                        conta2.saque(valorSaque);
                        c = conta2;
                    }
                }
                if (c == null) {
                    System.out.println("");
                    System.out.println("Conta não existe, digite uma conta válida!");
                }

            }
            if (opcao == 2) {
                System.out.println("Digite sua conta");
                String num = inicio.next();
                Conta c = null;
                for (Conta conta2 : conta) {
                    if (conta2.validaConta(num) == true) {
                        System.out.println("");
                        System.out.println("Ola " + conta2.getNome());
                        System.out.println("Digite o valor do Deposito");
                        double valorDep = inicio.nextDouble();
                        conta2.deposito(valorDep);
                        c = conta2;
                    }
                }
                if (c == null) {
                    System.out.println("");
                    System.out.println("Conta não existe, digite uma conta válida!");
                }

            }

            if (opcao == 3) {
                System.out.println("Digite sua conta");
                String num = inicio.next();
                Conta c = null;
                for (Conta conta2 : conta) {
                    if (conta2.validaConta(num) == true) {
                        conta2.saldo(num);
                        c = conta2;
                    }
                }
                if (c == null) {
                    System.out.println("");
                    System.out.println("Conta não existe, digite uma conta válida!");
                }

            }

        } while (opcao != 9);

        inicio.close();
    }

}
