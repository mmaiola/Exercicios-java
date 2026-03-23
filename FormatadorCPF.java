import java.util.Scanner;

public class FormatadorCPF {

    public static String formatarCPF(String cpf) {

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        }

        return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cpfFormatado = "";

        while (true) {
            try {
                System.out.print("Digite seu CPF: ");
                String cpfDigitado = sc.nextLine();

                cpfFormatado = formatarCPF(cpfDigitado);

                System.out.println("CPF formatado: " + cpfFormatado);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Digite novamente.\n");
            }
        }

        sc.close();
    }
}


// java FormatadorCPF