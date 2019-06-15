import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServerSocket server = null;
        Integer num1 = 0;
        Integer num2 = 0;

        try{
            server = new ServerSocket(9090);
            Socket accept = null;
            System.out.println("Node2 iniciado...");

            ObjectInputStream inputStream = null;
            ObjectOutputStream outputStream = null;
            List<Integer> numeros = null;

            System.out.println("Processando...");
            while(num1 == num2){
                if(accept != null){
                    outputStream = new ObjectOutputStream(accept.getOutputStream());
                    outputStream.writeInt(0);
                    outputStream.close();
                }

                accept = server.accept();

                inputStream = new ObjectInputStream(accept.getInputStream());
                numeros = (List<Integer>) inputStream.readObject();

                num1 = numeros.get(0);
                num2 = numeros.get(1);
            }

            outputStream = new ObjectOutputStream(accept.getOutputStream());
            outputStream.writeInt(1);
            outputStream.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Socket socket = null;
        try{
            socket = new Socket("localhost", 9191);
            List<Integer> numeros = Arrays.asList(num1, num2);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(numeros);

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Double resultado = inputStream.readDouble();

            System.out.println("Resultado da equação f(x,y) = y^y + x^x é " + resultado);

            outputStream.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
