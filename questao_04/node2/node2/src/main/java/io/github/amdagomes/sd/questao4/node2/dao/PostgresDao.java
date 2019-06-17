package io.github.amdagomes.sd.questao4.node2.dao;

public class PostgresDao extends GenericDao{
    
    private static final String url = "jdbc:postgresql://localhost:5432/sd";
    private static final String usuario = "postgres";
    private static final String senha = "secret";
    
    public PostgresDao(){
        super(url, usuario, senha);
    }
    
}
