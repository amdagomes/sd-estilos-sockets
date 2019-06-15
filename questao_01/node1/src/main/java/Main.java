import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Socket socket = null;
        Integer aux = 0;

        try{
            socket = new Socket("localhost", 9090);
            System.out.println("Node1 iniciado...");

            do{
                System.out.println("Gerando números...");
                List<Integer> numeros = Arrays.asList(random.nextInt(101), random.nextInt(101));

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(numeros);

                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                aux = inputStream.readInt();

                if (aux == 0){
                    System.out.println("Numeros são iguais");
                }

            } while (aux == 0);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
