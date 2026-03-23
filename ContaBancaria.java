import java.util.Scanner;

public class ContaBancaria {

    public static void main(String[] args) {

        class Conta {
            double saldo;
            String titular;
        }

        Conta minhaConta = new Conta();
        minhaConta.saldo = 300;

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o titular da conta: ");
        minhaConta.titular = sc.nextLine();

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n===== BANCO =====");
            System.out.println("Titular: " + minhaConta.titular);
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); 

            if (opcao == 1) {
                System.out.print("Digite quanto deseja depositar: ");
                double valor = sc.nextDouble();
                sc.nextLine(); 
                if (valor <= 0) {
                    System.out.println("Valor inválido para depósito.");
                } else {
                    minhaConta.saldo += valor;
                    System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
                }

            } else if (opcao == 2) {
                System.out.print("Digite quanto deseja sacar: ");
                double valor = sc.nextDouble();
                sc.nextLine(); 
                if (valor <= 0) {
                    System.out.println("Valor inválido para saque.");
                } else if (valor > minhaConta.saldo) {
                    System.out.println("Saldo insuficiente!");
                } else {
                    minhaConta.saldo -= valor;
                    System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
                }

            } else if (opcao == 3) {
                System.out.printf("Saldo atual: R$ %.2f%n", minhaConta.saldo);

            } else if (opcao != 4) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        System.out.println("Obrigado por usar o banco, " + minhaConta.titular + "!");
        sc.close();
    }
}