package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/world";
    private String user = "root";
    private String senha = "root";
    private Connection con;
    
    public Conexao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }

    public Connection getCon() {
        return con;
    }
    
    public void fecharConexao() throws SQLException {
        try {
            con.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
