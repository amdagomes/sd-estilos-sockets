package io.github.amdagomes.sd.questao4.node2.handler;


import io.github.amdagomes.sd.questao4.node2.dao.MySQLDao;
import io.github.amdagomes.sd.questao4.node2.dao.PostgresDao;
import io.github.amdagomes.sd.questao4.node2.domain.User;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Handler {
    private final Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    public void save() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) inputStream.readObject();
            System.out.println(user.toString());
            MySQLDao.insert(user);
            PostgresDao.insert(user);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
