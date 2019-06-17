package io.github.amdagomes.sd.questao4.node2.dao;

import io.github.amdagomes.sd.questao4.node2.domain.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDao{
    
    private static String url;
    private static String usuario;
    private static String senha;
    private static Connection connection = null;
    
    public GenericDao(String url, String usuario, String senha){
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public static Connection getConnection()throws SQLException, ClassNotFoundException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, usuario, senha);
        }
        return connection;
    }

    public static void insert(User user) {
        try {
            Connection connection = getConnection();

            String sql = "INSERT INTO tb_user(code, name) VALUES (?,?);";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, user.getCode());
            statement.setString(2, user.getName());

            statement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
