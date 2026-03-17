import java.util.ArrayList;
import java.util.Scanner;

public class Garagem {

    static class Carro {

        String marca;
        String modelo;
        int ano;
        double velocidade;

        public void mostrarInfo() {
            System.out.println(
                    marca + " " + modelo +
                            " | Ano: " + ano +
                            " | Velocidade: " + velocidade + " km/h");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Carro> carros = new ArrayList<>();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n===== GARAGEM =====");
            System.out.println("1 - Adicionar carro");
            System.out.println("2 - Listar carros");
            System.out.println("3 - Remover carro");
            System.out.println("4 - Carro mais rápido");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {

                Carro novoCarro = new Carro();

                System.out.print("Marca: ");
                novoCarro.marca = scanner.nextLine();

                System.out.print("Modelo: ");
                novoCarro.modelo = scanner.nextLine();

                System.out.print("Ano: ");
                novoCarro.ano = scanner.nextInt();

                System.out.print("TopSpeed: ");
                novoCarro.velocidade = scanner.nextDouble();
                scanner.nextLine();

                carros.add(novoCarro);
                // System.out.println("DEBUG tamanho lista: " + carros.size());
                System.out.println("Quantidade de carros: " + carros.size());

                System.out.println("Carro adicionado!");
            }

            else if (opcao == 2) {

                
                if (carros.isEmpty()) {
                    System.out.println("Nenhum carro na garagem.");
                } else {

                    for (int i = 0; i < carros.size(); i++) {
                        System.out.print(i + " - ");
                        carros.get(i).mostrarInfo();
                    }

                }
            }

            else if (opcao == 3) {

                if (carros.isEmpty()) {
                    System.out.println("Nenhum carro na garagem.");
                }

                 for (int i = 0; i < carros.size(); i++) {
                        System.out.print(i + " - ");
                        carros.get(i).mostrarInfo();
                    }

                System.out.print("Digite o índice do carro para remover: ");
                int indice = scanner.nextInt();

                if (indice >= 0 && indice < carros.size()) {
                    carros.remove(indice);
                    System.out.println("Carro removido.");
                } else {
                    System.out.println("Índice inválido.");
                }

            }

            else if (opcao == 4) {

                if (carros.isEmpty()) {
                    System.out.println("Nenhum carro cadastrado.");
                } else {

                    Carro maisRapido = carros.get(0);

                    for (Carro c : carros) {
                        if (c.velocidade > maisRapido.velocidade) {
                            maisRapido = c;
                        }
                    }

                    System.out.println("Carro mais rápido:");
                    maisRapido.mostrarInfo();
                }

            }

        }

        scanner.close();
    }
}