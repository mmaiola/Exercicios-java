import java.util.Scanner;

public class FormatadorCelular {

    public static String formatarCelular(String celular) {

        celular = celular.replaceAll("\\D", "");

        if (celular.length() != 11) {
            throw new IllegalArgumentException("O número deve ter 11 dígitos, incluindo o DDD.");
        }

        return celular.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String celularFormatado = "";

        while (true) {
            try {
                System.out.print("Digite seu número de celular com DDD: ");
                String celularDigitado = sc.nextLine();

                celularFormatado = formatarCelular(celularDigitado);

                System.out.println("Celular formatado: " + celularFormatado);
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Digite novamente.\n");
            }
        }

        sc.close();
    }
}
// java FormatadorCelular