import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(9090)) {
            System.out.println("Node3 iniciado port 9090");

            System.out.println("Esperando Requisições");
            Socket accept = server.accept();

            ObjectInputStream inputStreamServer = new ObjectInputStream(accept.getInputStream());
            Map<String, Integer> map = (Map<String, Integer>) inputStreamServer.readObject();

            Integer node = map.get("node");
            Integer resultado = 0;

            Socket client = null;

            map.replace("node", 3);

            if (node == 1) {
                client = new Socket("localhost", 9092);
            }
            else if (node == 2) {
                client = new Socket("localhost", 9094);
            }

            resultado = redirect(client, map);

            ObjectOutputStream outputStreamServer = new ObjectOutputStream(accept.getOutputStream());
            outputStreamServer.writeInt(resultado);
            outputStreamServer.flush();

        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }

    }

    private static Integer redirect(Socket client, Map<String, Integer> data) throws ClassNotFoundException, IOException {

        System.out.println("Redirecionando para: " + client.getPort());

        ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
        outputStream.writeObject(data);

        ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
        Integer resultado = inputStream.readInt();

        outputStream.close();
        inputStream.close();

        return resultado;
    }

}
