package io.github.amdagomes.sd.questao4.node2.dao;

public class MySQLDao extends GenericDao{
    
    private static final String url = "jdbc:mysql://localhost:3306/sd";
    private static final String usuario = "root";
    private static final String senha = "secret";
    
    public MySQLDao(){
        super(url, usuario, senha);
    }
}
