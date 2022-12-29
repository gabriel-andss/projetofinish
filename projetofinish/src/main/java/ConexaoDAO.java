import java.sql.*;

public class ConexaoDAO {
    static Connection connection = null;
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "password";

    public ConexaoDAO() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao realizada com sucesso");
        } catch (SQLException e) {
            System.out.println("Problema na conexao: " + e.getMessage());
        }
    }

    public static Connection getConexao() {
        return connection;
    }
}