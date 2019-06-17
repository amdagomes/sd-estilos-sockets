import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ServerSocket server = null;

        try {
            server = new ServerSocket(9292);
            System.out.println("Node3 iniciado port 9292");
            process(server);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void process(ServerSocket server) throws IOException, ClassNotFoundException {
        Socket socket = server.accept();

        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Map<String, Integer> map = (Map<String, Integer>) inputStream.readObject();

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        int op = map.get("op");
        Integer resultado = 0;

        if (op == 2) {
            int x = map.get("x");
            int y = map.get("y");
            resultado = (2 * x) / y;
        } else {
            Socket client = null;
            try {
                client = new Socket("localhost", 9090);
                resultado = redirect(client, map);
            } catch (IOException ex1) {
                try {
                    client = new Socket("localhost", 9091);
                    resultado = redirect(client, map);
                } catch (IOException ex2) {
                    System.out.println("Node3 não consiguiu redirecionar para o node1");
                }
            }
        }
        outputStream.writeInt(resultado);
        outputStream.flush();
        outputStream.close();
        //outputStream.close();

    }

    private static Integer redirect(Socket client, Map<String, Integer> map) throws IOException {
        System.out.println("Direcionando para node1...");

        ObjectOutputStream outputStreamClient = new ObjectOutputStream(client.getOutputStream());
        outputStreamClient.writeObject(map);

        ObjectInputStream inputStreamClient = new ObjectInputStream(client.getInputStream());
        Integer result = inputStreamClient.readInt();

        inputStreamClient.close();
        outputStreamClient.close();

        return result;
    }
}
