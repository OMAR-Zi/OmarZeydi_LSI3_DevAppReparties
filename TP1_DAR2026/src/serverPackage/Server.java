package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket sk = new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");

        Socket s = sk.accept();
        System.out.println("un client est connecté");

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        int number;
        do {
            number = in.readInt();
            out.writeInt(number * 5);
        } while (number != 0);

        s.close();
        sk.close();
    }
}
