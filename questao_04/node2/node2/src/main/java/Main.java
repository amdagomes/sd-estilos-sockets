
import io.github.amdagomes.sd.questao4.node2.handler.HandlerThread;
import java.net.ServerSocket;
import java.util.logging.SocketHandler;


public class Main {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(9090);
        System.out.println("Node iniciado port 9090");

        long initialInstant = 0;
        long finalInstant = 0;
        int cont = 0;
        
//        for (int i = 0 ; i < 100; i++) {
//            Handler socketHander = new Handler(server.accept());
//            if (i == 0) {
//                initialInstant = System.currentTimeMillis();
//            } else if (i == 99) {
//                finalInstant = System.currentTimeMillis();
//            }
//            cont++;
//        }

        //executando com thread
        for (int i = 0 ; i < 1000; i++) {
            HandlerThread socketHander = new HandlerThread(server.accept());

            if (i == 0) {
                initialInstant = System.currentTimeMillis();
            } else if (i == 999) {
                finalInstant = System.currentTimeMillis();
            }

            cont++;
        }
        System.out.println(cont + " requisições");
        System.out.println("Tempo: " + (finalInstant - initialInstant) + " segundos");

    }

}
