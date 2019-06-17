import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ServerSocket server = null;
        int port = 9090;

        try{
            server = new ServerSocket(port);
            System.out.println("Node1 iniciado port " + port);

            process(server);

        } catch (BindException e){
            try{
                port = 9091;
                server = new ServerSocket(port);
                System.out.println("Node1 iniciado port " + port);
                process(server);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        catch (IOException | ClassNotFoundException e) {
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

        if(op == 1){
            int x = map.get("x");
            int y = map.get("y");
            resultado = 2*y*x;
        } else {
            Socket client = new Socket("localhost", 9292);
            System.out.println("Direcionando para node3...");

            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(map);

            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            resultado = input.readInt();

            input.close();
            output.close();
            client.close();
        }

        outputStream.writeInt(resultado);
        outputStream.flush();
        outputStream.close();

    }
}
