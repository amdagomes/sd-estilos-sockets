package io.github.amdagomes.sd.questao4.node2.handler;


import io.github.amdagomes.sd.questao4.node2.dao.MySQLDao;
import io.github.amdagomes.sd.questao4.node2.dao.PostgresDao;
import io.github.amdagomes.sd.questao4.node2.domain.User;
import java.io.ObjectInputStream;
import java.net.Socket;


public class HandlerThread extends Thread{

    private final Socket socket;

    public HandlerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
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
