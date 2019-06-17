import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Socket socket = null;
        Map<String, Integer> map = new HashMap<>();

        map.put("x", 11);
        map.put("y", 11);
        map.put("op",2);

        try{
            System.out.println("Iniciando client port 9090");
            socket = new Socket("localhost", 9090);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(map);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Integer resultado = inputStream.readInt();

            System.out.println("Resultado: " + resultado);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
