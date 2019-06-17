import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(9094)) {
            System.out.println("Node4 iniciado port 9094");

            System.out.println("Esperando Requisições");
            Socket accept = server.accept();

            ObjectInputStream inputStream = new ObjectInputStream(accept.getInputStream());
            Map<String, Integer> map = (Map<String, Integer>) inputStream.readObject();

            Integer x = map.get("x");
            Integer y = map.get("y");
            Integer node = map.get("node");
            Integer resultado = 0;

            if (node == 2) resultado = x + y;
            else if (node == 3) resultado = x - y;

            System.out.println("Resultado calculado: " + resultado);

            ObjectOutputStream outputStream = new ObjectOutputStream(accept.getOutputStream());
            outputStream.writeInt(resultado);
            outputStream.flush();

            inputStream.close();
            outputStream.close();

        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }

    }
}
