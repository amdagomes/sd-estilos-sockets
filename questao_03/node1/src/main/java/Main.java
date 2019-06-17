import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 9090)) {

            Map<String, Integer> data = new HashMap<>();

            data.put("x", 5);
            data.put("y", 11);
            data.put("node", 1);

            ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
            outputStream.writeObject(data);

            ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
            Integer resultado = inputStream.readInt();

            System.out.println("Resultado: " + resultado);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
