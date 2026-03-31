import java.sql.*;
import java.util.Scanner;

public class BancoSQL {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);


        Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/C:/Users/mmaiola/Desktop/Env/BancoSQL", "sa", "");

        
        con.createStatement().execute(
            "CREATE TABLE IF NOT EXISTS contas (id INT AUTO_INCREMENT PRIMARY KEY, titular VARCHAR(100), saldo DOUBLE)"
        );

        String titular = "Matheus";
        double saldo = 300.0;

        // Verifica se a conta já existe no banco
        PreparedStatement busca = con.prepareStatement("SELECT * FROM contas WHERE titular = ?");
        busca.setString(1, titular);
        ResultSet rs = busca.executeQuery();

        int id;

        if (rs.next()) {
            // Conta encontrada — carrega os dados
            id    = rs.getInt("id");
            saldo = rs.getDouble("saldo");
            System.out.println("Conta encontrada! Saldo: R$ " + saldo);
        } else {
      
            PreparedStatement insert = con.prepareStatement(
                "INSERT INTO contas (titular, saldo) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            insert.setString(1, titular);
            insert.setDouble(2, saldo);
            insert.executeUpdate();
            ResultSet chave = insert.getGeneratedKeys();
            chave.next();
            id = chave.getInt(1);
            System.out.println("Conta criada com saldo R$ 300,00!");
        }

   
        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n===== BANCO =====");
            System.out.println("Titular: " + titular);
            System.out.printf("Saldo: R$ %.2f%n", saldo);
            System.out.println("-----------------");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            if (opcao == 1) {

                System.out.print("Quanto deseja depositar? R$ ");
                double valor = sc.nextDouble();

                if (valor <= 0) {
                    System.out.println("Valor inválido!");
                } else {
                    saldo = saldo + valor;
                    PreparedStatement update = con.prepareStatement("UPDATE contas SET saldo = ? WHERE id = ?");
                    update.setDouble(1, saldo);
                    update.setInt(2, id);
                    update.executeUpdate();
                    System.out.println("Depósito realizado! Novo saldo: R$ " + saldo);
                }

            } else if (opcao == 2) {

                System.out.print("Quanto deseja sacar? R$ ");
                double valor = sc.nextDouble();

                if (valor <= 0) {
                    System.out.println("Valor inválido!");
                } else if (valor > saldo) {
                    System.out.println("Saldo insuficiente!");
                } else {
                    saldo = saldo - valor;
                    PreparedStatement update = con.prepareStatement("UPDATE contas SET saldo = ? WHERE id = ?");
                    update.setDouble(1, saldo);
                    update.setInt(2, id);
                    update.executeUpdate();
                    System.out.println("Saque realizado! Novo saldo: R$ " + saldo);
                }

            } else if (opcao == 3) {

                System.out.println("Saldo atual: R$ " + saldo);
                System.out.println("Conectado em: " + con.getMetaData().getURL());

            } else if (opcao != 4) {

                System.out.println("Opção inválida!");

            }
        }

        System.out.println("Até logo, " + titular + "!");
        con.close();
        sc.close();
        
    }
}

/*
 COMPILAR:
 javac -cp ".;C:\Users\mmaiola\Downloads\h2-2025-09-22\h2\bin\h2-2.4.240.jar" BancoSQL.java

 RODAR:
 java -cp ".;C:\Users\mmaiola\Downloads\h2-2025-09-22\h2\bin\h2-2.4.240.jar" BancoSQL
*/
