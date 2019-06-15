import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServerSocket serverSocket;
        Integer x;
        Integer y;

        try{
            serverSocket = new ServerSocket(9191);
            System.out.println("node3 iniciado");

            Socket accept = serverSocket.accept();

            ObjectInputStream inputStream = new ObjectInputStream(accept.getInputStream());
            List<Integer> numeros = (List<Integer>) inputStream.readObject();

            x = numeros.get(0);
            y = numeros.get(1);

            Double resultado = Math.pow(y,y) + Math.pow(x,x);
            System.out.println("Resultado da equação f(x,y) = y^y + x^x é " + resultado);

            ObjectOutputStream outputStream = new ObjectOutputStream(accept.getOutputStream());
            outputStream.writeDouble(resultado);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
