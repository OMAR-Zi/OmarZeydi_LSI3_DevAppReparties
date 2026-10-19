package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    static final String IP_SERVEUR = "192.168.0.86"; // adresse IP de la machine serveur
    static final int PORT = 1234;
    public static void main(String[] args) throws IOException {
        InetAddress adresseIp = InetAddress.getByName(IP_SERVEUR);
        InetSocketAddress adresseServeur = new InetSocketAddress(adresseIp, PORT);
        ServerSocket sk = new ServerSocket();
        sk.bind(adresseServeur);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");
        Socket s = sk.accept();
        System.out.println("un client est connecté" + s.getInetAddress());
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        int number;
        do {
            number = in.readInt();
            String op = in.readUTF();
            double resultat;

            switch (op) {
                case "+": resultat = number + 5; break;
                case "-": resultat = number - 5; break;
                case "*": resultat = number * 5; break;
                case "/": resultat = number / 5.0; break;
                default:  resultat = 0;           // unknown operator
            }
            out.writeDouble(resultat);
        } while (number != 0);

        s.close();
        sk.close();
    }
}
