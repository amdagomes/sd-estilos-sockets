
import domain.User;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        List<String> nomes = Arrays.asList("Rayssa", "Rafaela", "Viviane", "Erivania", "Sarah", "Junior");
        List<String> sobrenomes = Arrays.asList("Nobrega", "Sousa", "Pereira", "Costa", "Saraiva", "Lucena", "Soares");
        int aux = 0;
        try {
            for (int i = 0; i < 1000; i++) {
                int auxNome = random.nextInt(5);
                int auxSobrenome = random.nextInt(6);
                Socket socket = new Socket("localhost", 9090);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(new User(i, nomes.get(auxNome) + ' ' + sobrenomes.get(auxSobrenome)));
                outputStream.flush();
                aux =i;
            }
            System.out.println("Resquisições:" + aux);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
