import java.util.Scanner;

public class FormatadorPlaca {

    public static String normalizarPlaca(String placa) {
        return placa.replaceAll("[\\s-]", "").toUpperCase();
    }

    
    public static boolean placaValida(String placa) {
        return placa.matches("[A-Z]{3}[0-9]{4}") ||
               placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String placa;

        while (true) {
            System.out.print("Digite a placa: ");
            placa = sc.nextLine();

            String placaTratada = normalizarPlaca(placa);

            if (placaValida(placaTratada)) {
                System.out.println("Placa salva com sucesso: " + placaTratada);
                break;
            } else {
                System.out.println("O modelo que você digitou não segue os padrões LLLNNNN/LLLNLNN. Repita e corrija.");
            }
        }

        sc.close();
    }
}

// java FormatadorPlaca