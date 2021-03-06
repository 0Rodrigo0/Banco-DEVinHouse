package devinMoney;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import devinMoney.conta.Agencia;
import devinMoney.conta.Conta;
import devinMoney.operacoes.TipoOp;
import devinMoney.operacoes.TodasOperacoes;
import devinMoney.tipoConta.Corrente;
import devinMoney.tipoConta.Investimento;
import devinMoney.tipoConta.Poupanca;

public class DevinMoneyApp {

    public static void main(String[] args) {
        DevinMoneyAp();
    }

    public static void DevinMoneyAp() {
        double totalInvestido = 0;
        Integer opcao = 0;
        Scanner inicio = new Scanner(System.in);
        ArrayList<Conta> conta = new ArrayList<Conta>();
        ArrayList<TodasOperacoes> todasOperacoes = new ArrayList<TodasOperacoes>();

        Corrente c1 = new Corrente("C", "Presuntinho", "11111111111", 1000, "0001", Agencia.FLORIANOPOLIS_001, -1000,
                0, LocalDate.of(1999, 1, 1));
        Poupanca p1 = new Poupanca("P", "Patolino", "22222222222", 2000, "0002", Agencia.SAO_JOSE_002, 0,
                LocalDate.of(1999, 1, 1));
        Investimento i1 = new Investimento("I", "Simba", "33333333333", 3000, "0003", Agencia.FLORIANOPOLIS_001, 0, 0,
                LocalDate.of(1999, 1, 1));
        Corrente c2 = new Corrente("C", "Popeye", "44444444444", 4000, "0004", Agencia.SAO_JOSE_002, -2000, 0,
                LocalDate.of(1999, 1, 1));
        Poupanca p2 = new Poupanca("P", "Simão", "55555555555", 5000, "0005", Agencia.FLORIANOPOLIS_001, 0,
                LocalDate.of(1999, 1, 1));
        Investimento i2 = new Investimento("I", "Pumba", "66666666666", 6000, "0006", Agencia.SAO_JOSE_002, 0, 0,
                LocalDate.of(1999, 1, 1));

        conta.add(c1);
        conta.add(p1);
        conta.add(i1);
        conta.add(c2);
        conta.add(p2);
        conta.add(i2);

        do {
            System.out.println("");
            System.out.println("*************************************************************************");
            System.out.println("***                          Bem vindo                                ***");
            System.out.println("***                         Devin Money                               ***");
            System.out.println("***                                                                   ***");
            System.out.println("***     1 - Sacar  2 - Depositar   3 - Saldo   4 - Tranferência       ***");
            System.out.println("***     5 - Alterar dados   6 - Investimentos  7 - Relatórios/Extrato ***");
            System.out.println("***     9 - para sair                                                 ***");
            System.out.println("*************************************************************************");
            System.out.println("");
            String opcao1 = inicio.next();
            if (opcao1.matches("^[0-9]+")) {
                opcao = Integer.valueOf(opcao1);
                Conta c = null;
                // saque
                if (opcao == 1) {
                    System.out.println("Digite sua conta");
                    String num = inicio.next();
                    if (num.matches("^[0-9]+")) {
                        for (Conta conta2 : conta) {
                            if (conta2.validaConta(num) == true) {
                                System.out.println("");
                                System.out.println("Ola " + conta2.getNome());
                                inicio.nextLine();
                                System.out.println("Digite o valor do Saque");
                                String valorSaque = inicio.next();
                                if (valorSaque.matches("^[0-9]+")) {
                                    double valorSaqueNovo = Double.valueOf(valorSaque);
                                    conta2.saque(valorSaqueNovo);
                                    TodasOperacoes o = new TodasOperacoes(conta2.getTipo(), conta2.getNome(),
                                            conta2.getCpf(),
                                            conta2.getRenda(), conta2.getNumeroConta(), conta2.getAgencia(),
                                            conta2.getSaldo(),
                                            TipoOp.SAQUE, valorSaqueNovo, LocalDate.now());
                                    todasOperacoes.add(o);
                                    c = conta2;
                                } else {
                                    System.out.println("");
                                    System.out.println("Digite somente numeros!");
                                    c = conta2;
                                }
                            }
                        }
                        if (c == null) {
                            System.out.println("");
                            System.out.println("Conta não existe, digite uma conta válida!");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Digite somente numeros!");
                    }
                }
                // deposito
                if (opcao == 2) {
                    System.out.println("Digite sua conta");
                    String num = inicio.next();
                    if (num.matches("^[0-9]+")) {
                        for (Conta conta2 : conta) {
                            if (conta2.validaConta(num) == true) {
                                System.out.println("");
                                System.out.println("Ola " + conta2.getNome());
                                inicio.nextLine();
                                System.out.println("Digite o valor do Deposito");
                                String valorDep = inicio.next();
                                if (valorDep.matches("^[0-9]+")) {
                                    double valorDepNovo = Double.valueOf(valorDep);
                                    conta2.deposito(valorDepNovo);
                                    c = conta2;
                                    TodasOperacoes o = new TodasOperacoes(conta2.getTipo(), conta2.getNome(),
                                            conta2.getCpf(),
                                            conta2.getRenda(), conta2.getNumeroConta(), conta2.getAgencia(),
                                            conta2.getSaldo(),
                                            TipoOp.DEPOSITO, valorDepNovo, LocalDate.now());
                                    todasOperacoes.add(o);

                                } else {
                                    System.out.println("");
                                    System.out.println("Digite somente numeros!");
                                    c = conta2;
                                }

                            }
                        }
                        if (c == null) {
                            System.out.println("");
                            System.out.println("Conta não existe, digite uma conta válida!");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Digite somente numeros!");
                    }
                }
                // saldo
                if (opcao == 3) {
                    System.out.println("Digite sua conta");
                    String num = inicio.next();
                    if (num.matches("^[0-9]+")) {
                        for (Conta conta2 : conta) {
                            if (conta2.validaConta(num) == true) {
                                conta2.saldo(num);
                                c = conta2;
                                TodasOperacoes o = new TodasOperacoes(conta2.getTipo(), conta2.getNome(),
                                        conta2.getCpf(),
                                        conta2.getRenda(), conta2.getNumeroConta(), conta2.getAgencia(),
                                        conta2.getSaldo(),
                                        TipoOp.SALDO, 0, LocalDate.now());
                                todasOperacoes.add(o);
                                c = conta2;
                            }
                        }
                        if (c == null) {
                            System.out.println("");
                            System.out.println("Conta não existe, digite uma conta válida!");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Digite somente numeros!");
                    }
                }
                // transferência
                if (opcao == 4) {
                    System.out.println("Digite sua conta");
                    String num = inicio.next();
                    if (num.matches("^[0-9]+")) {
                        for (Conta conta2 : conta) {
                            if (conta2.validaConta(num) == true) {
                                System.out.println("");
                                System.out.println("Ola " + conta2.getNome());
                                System.out.println("Digite o valor do Saque");
                                double valorSaque = inicio.nextDouble();
                                if (conta2.getTipo() != "C") {
                                    if (conta2.getSaldo() >= valorSaque) {
                                        if (valorSaque > 0) {
                                            conta2.saque(valorSaque);
                                            System.out.println("Digite a conta destino");
                                            String num1 = inicio.next();
                                            for (Conta conta3 : conta) {
                                                if (conta2.getNumeroConta().equals(conta3.getNumeroConta())) {

                                                } else {
                                                    if (conta3.validaConta(num1) == true) {
                                                        conta3.transferir(valorSaque);
                                                        TodasOperacoes o = new TodasOperacoes(conta2.getTipo(),
                                                                conta2.getNome(),
                                                                conta2.getCpf(),
                                                                conta2.getRenda(), conta2.getNumeroConta(),
                                                                conta2.getAgencia(),
                                                                conta2.getSaldo(),
                                                                TipoOp.TRASNFERENCIA, valorSaque, LocalDate.now());
                                                        todasOperacoes.add(o);
                                                        c = conta2;
                                                    }
                                                }
                                            }
                                            if (c == null) {
                                                System.out.println("");
                                                System.out.println("Conta incorreta, digite uma conta válida!");
                                                System.out.println("Saque cancelado!");
                                                conta2.deposito(valorSaque);
                                            }
                                        }
                                    } else {
                                        System.out.println("Não foi possível processar seu pedido!");
                                        System.out.println(
                                                "Seu saldo é " + conta2.getSaldo()
                                                        + " Você precisa fazer um depósito primeiro!");
                                    }
                                } else {
                                    if (conta2.saldoCorrente() >= valorSaque) {
                                        if (valorSaque > 0) {
                                            conta2.saque(valorSaque);
                                            System.out.println("Digite a conta destino");
                                            inicio.nextLine();
                                            String num1 = inicio.next();
                                            for (Conta conta3 : conta) {
                                                if (conta2.getNumeroConta().equals(conta3.getNumeroConta())) {

                                                } else {
                                                    if (conta3.validaConta(num1) == true) {
                                                        conta3.transferir(valorSaque);
                                                        TodasOperacoes o = new TodasOperacoes(conta2.getTipo(),
                                                                conta2.getNome(),
                                                                conta2.getCpf(),
                                                                conta2.getRenda(),
                                                                conta2.getNumeroConta(), conta2.getAgencia(),
                                                                conta2.getSaldo(),
                                                                TipoOp.TRASNFERENCIA, valorSaque, LocalDate.now());
                                                        todasOperacoes.add(o);
                                                        c = conta2;
                                                    }

                                                }
                                            }
                                            if (c == null) {
                                                System.out.println("");
                                                System.out.println("Conta incorreta, digite uma conta válidaAA!");
                                                System.out.println("Saque cancelado!");
                                                conta2.deposito(valorSaque);
                                            }
                                        }
                                    } else {
                                        System.out.println(conta2.saldoCorrente());
                                        System.out.println("Não foi possível processar seu pedido!");
                                        System.out.println(
                                                "Seu saldo é " + conta2.getSaldo()
                                                        + " Você precisa fazer um depósito primeiro!");
                                    }
                                }
                                c = conta2;
                            }
                        }
                        if (c == null) {
                            System.out.println("");
                            System.out.println("Conta não existe, digite uma conta válida!");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Digite somente numeros!");
                    }
                }
                // altera dados, somente o nome pode ser alterado, os outros campos não pois são
                // dados da conta
                if (opcao == 5) {
                    System.out.println("");
                    System.out.println("Alterar dados cadastrais");
                    System.out.println("Digite sua conta");
                    String num = inicio.next();
                    if (num.matches("^[0-9]+")) {
                        for (Conta conta1 : conta) {
                            if (conta1.validaConta(num) == true) {
                                System.out.println("Nome da conta atual: " + conta1.getNome());
                                System.out.println("Deseja alterar?");
                                System.out.println("1 - sim    2 - não");
                                String escolha = inicio.next();
                                if (escolha.equals("1")) {
                                    System.out.println("Digite seu nome");
                                    inicio.nextLine();
                                    String novo = inicio.nextLine();
                                    conta1.setNome(novo);
                                    System.out.println("Seu nome foi alterado para " + conta1.getNome());
                                    System.out.println("");
                                    TodasOperacoes o = new TodasOperacoes(conta1.getTipo(), conta1.getNome(),
                                            conta1.getCpf(),
                                            conta1.getRenda(), conta1.getNumeroConta(), conta1.getAgencia(),
                                            conta1.getSaldo(),
                                            TipoOp.ALTERA_DADOS, 0, LocalDate.now());
                                    todasOperacoes.add(o);

                                }
                                c = conta1;
                            }
                        }
                        if (c == null) {
                            System.out.println("");
                            System.out.println("Conta não existe, digite uma conta válida!");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Digite somente numeros!");
                    }
                }
                // Investimentos
                if (opcao == 6) {
                    System.out.println("*************************************************************************");
                    System.out.println("******************************      *    ********************************");
                    System.out.println("*****************************      **      ******************************");
                    System.out.println("****************************     *  *       *****************************");
                    System.out.println("***************************         *        ****************************");
                    System.out.println("****************************        *       *****************************");
                    System.out.println("*****************************       *      ******************************");
                    System.out.println("*******************************   * * *   *******************************");
                    System.out.println("*************************************************************************");
                    System.out.println("             Bem vindo a área de investimentos do DevinMoney             ");
                    System.out.println("       Sua conta deve ser de Investimento para acessar nossos produtos   ");
                    System.out.println("");
                    System.out.println("Digite sua conta");
                    String num = inicio.next();
                    if (num.matches("^[0-9]+")) {
                        for (Conta conta1 : conta) {
                            if (conta1.validaConta(num) == true) {
                                System.out.println("");
                                System.out.println("Ola " + conta1.getNome() + ".");
                                c = conta1;
                            }
                        }
                        if (c == null) {
                            System.out.println("");
                            System.out.println("Conta não existe, digite uma conta válida!");
                        } else {
                            if (c.getTipo().equals("I")) {
                                System.out.println("Bem vindo a área de Investimentos");
                                System.out.println("");
                                System.out.println("Vou te apresentar as opções:");
                                System.out.println("1 - Cripto Moedas");
                                System.out.println("2 - CDB - Certificado de Depósito Bancário");
                                System.out.println("3 - Fundo de Investimento DevinMoney");
                                System.out.println("");
                                System.out.println("Escolha uma das opções...");
                                switch (inicio.next()) {

                                    case "1": // Cripto
                                        System.out.println("                      Cripto Moedas");
                                        System.out.println("");
                                        System.out
                                                .println(
                                                        "Um tipo de dinheiro como outras moedas com as quais convivemos");
                                        System.out.println("cotidianamente com a diferença de ser totalmente digital.");
                                        System.out.println("Este investimento rene 10% ao ano.");
                                        System.out.println("Faça uma simulação em Simular, ou Investir para investir.");
                                        System.out.println("");
                                        System.out.println("              1 - Investir      2 - Simular");
                                        inicio.nextLine();
                                        num = inicio.next();
                                        if (num.equals("1")) {
                                            System.out.println("Seu saldo é " + "R$ " + c.getSaldo());
                                            System.out.println("Qual valor do Investimento?");
                                            double valorI = inicio.nextDouble();
                                            c.investe(valorI);
                                            totalInvestido = totalInvestido + valorI;
                                            TodasOperacoes o = new TodasOperacoes(c.getTipo(), c.getNome(),
                                                    c.getCpf(),
                                                    c.getRenda(), c.getNumeroConta(), c.getAgencia(),
                                                    c.getSaldo(),
                                                    TipoOp.INVESTIMENTO, valorI, LocalDate.now());
                                            todasOperacoes.add(o);
                                        }
                                        if (num.equals("2")) {
                                            System.out.println("Digite o valor que deseja simular");
                                            double valorI = inicio.nextDouble();
                                            System.out.println("Digite o tempo desejado em meses");
                                            System.out.println("Ex: 1 ou 2 ou 12 ...");
                                            double tempo = inicio.nextDouble();
                                            double rendimento = valorI * (0.009 * tempo);
                                            System.out.println(
                                                    "Valor: " + valorI + " Tempo: " + tempo + " Taxa: 10% a.a");
                                            System.out.println("Rendimento: " + "R$ " + rendimento);
                                        }
                                        break;

                                    case "2": // CDB
                                        System.out.println("            CDB - Certificado de Depósito Bancário");
                                        System.out.println("Um dos investimentos mais simples e populares do mercado");
                                        System.out.println("e possui uma rentabilidade maior comparada a da poupança.");
                                        System.out.println("Este investimento rene 15% ao ano.");
                                        System.out.println("Faça uma simulação em Simular, ou Investir para investir.");
                                        System.out.println("");
                                        System.out.println("              1 - Investir      2 - Simular");
                                        inicio.nextLine();
                                        num = inicio.next();
                                        if (num.equals("1")) {
                                            System.out.println("Seu saldo é " + "R$ " + c.getSaldo());
                                            System.out.println("Qual valor do Investimento?");
                                            double valorI = inicio.nextDouble();
                                            c.investe(valorI);
                                            totalInvestido = totalInvestido + valorI;
                                            TodasOperacoes o = new TodasOperacoes(c.getTipo(), c.getNome(),
                                                    c.getCpf(),
                                                    c.getRenda(), c.getNumeroConta(), c.getAgencia(),
                                                    c.getSaldo(),
                                                    TipoOp.INVESTIMENTO, valorI, LocalDate.now());
                                            todasOperacoes.add(o);
                                        }
                                        if (num.equals("2")) {
                                            System.out.println("Digite o valor que deseja simular");
                                            double valorI = inicio.nextDouble();
                                            System.out.println("Digite o tempo desejado em meses");
                                            System.out.println("Ex: 1 ou 2 ou 12 ...");
                                            double tempo = inicio.nextDouble();
                                            double rendimento = valorI * (0.013 * tempo);
                                            System.out.println(
                                                    "Valor: " + valorI + " Tempo: " + tempo + " Taxa: 15% a.a");
                                            System.out.println("Rendimento: " + "R$ " + rendimento);
                                        }
                                        break;

                                    case "3": // FI
                                        System.out.println("                       Fundo de Investimento DevinMoney");
                                        System.out.println(
                                                "Procura novas opções para diversificar a sua carteira e aumentar o seu patrimônio?");
                                        System.out.println("Então você precisa dos Fundos de Investimentos");
                                        System.out.println("Este investimento rene 18% ao ano.");
                                        System.out.println("Faça uma simulação em Simular, ou Investir para investir.");
                                        System.out.println("");
                                        System.out.println("              1 - Investir      2 - Simular");
                                        inicio.nextLine();
                                        num = inicio.next();
                                        if (num.equals("1")) {
                                            System.out.println("Seu saldo é " + "R$ " + c.getSaldo());
                                            System.out.println("Qual valor do Investimento?");
                                            double valorI = inicio.nextDouble();
                                            c.investe(valorI);
                                            totalInvestido = totalInvestido + valorI;
                                            TodasOperacoes o = new TodasOperacoes(c.getTipo(), c.getNome(),
                                                    c.getCpf(),
                                                    c.getRenda(), c.getNumeroConta(), c.getAgencia(),
                                                    c.getSaldo(),
                                                    TipoOp.INVESTIMENTO, valorI, LocalDate.now());
                                            todasOperacoes.add(o);
                                        }
                                        if (num.equals("2")) {
                                            System.out.println("Digite o valor que deseja simular");
                                            double valorI = inicio.nextDouble();
                                            System.out.println("Digite o tempo desejado em meses");
                                            System.out.println("Ex: 1 ou 2 ou 12 ...");
                                            double tempo = inicio.nextDouble();
                                            double rendimento = valorI * (0.015 * tempo);
                                            System.out.println(
                                                    "Valor: " + valorI + " Tempo: " + tempo + " Taxa: 18% a.a");
                                            System.out.println("Rendimento: " + "R$ " + rendimento);
                                        }
                                        break;
                                }

                            } else {
                                System.out.println("");
                                System.out.println("Seu tipo de conta não dispõe dos produtos.");
                                System.out.println("Contate o Gerente de sua conta.");
                                System.out.println("");
                            }

                        }

                    } else {
                        System.out.println("");
                        System.out.println("Digite somente numeros!");
                    }
                }
                // Relatórios
                if (opcao == 7) {
                    System.out.println("");
                    System.out.println("Área de relatórios");
                    System.out.println("1 - Contas cadastradas   2 - Contas negativas   3 - Total Investido");
                    System.out
                            .println("4 - Transações/Extrato por Cliente   5 - Histórico de todas transações do banco");
                    System.out.println("");
                    System.out.println("Escolha a opção");
                    String entrada = inicio.next();
                    if (entrada.matches("^[0-9]+")) {

                        // Contas cadastradas
                        if (entrada.equals("1")) {
                            System.out.println("");
                            conta.forEach(System.out::print);
                        }

                        // Contas negativas
                        if (entrada.equals("2")) {
                            System.out.println("");
                            for (Conta conta2 : conta) {
                                if (conta2.getSaldo() < 0) {
                                    System.out.println(conta2);
                                    c = conta2;
                                }
                            }
                            if (c == null) {
                                System.out.println("Nenhuma conta negativa! ");
                            }
                        }

                        // Total Investido
                        if (entrada.equals("3")) {
                            System.out.println("");
                            System.out.println("O banco tem um total investido de R$ " + totalInvestido);
                        }

                        // Transações por Cliente
                        if (entrada.equals("4")) {
                            System.out.println("Digite a conta que deseja ver as operações");
                            String num = inicio.next();
                            if (num.matches("^[0-9]+")) {
                                for (TodasOperacoes todasOperacoes2 : todasOperacoes) {
                                    if (todasOperacoes2.getNumeroConta().equals(num)) {
                                        System.out.println("");
                                        System.out.println(todasOperacoes2);
                                    }
                                }
                            } else {
                                System.out.println("");
                                System.out.println("Digite somente numeros!");
                            }
                        }

                        // Histórico de todas transações do banco
                        if (entrada.equals("5")) {
                            todasOperacoes.forEach(System.out::print);
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Digite somente numeros!");
                    }
                }
            } else {
                System.out.println("");
                System.out.println("Digite somente numeros!");
            }
        } while (opcao != 9);
        inicio.close();
    }
}
