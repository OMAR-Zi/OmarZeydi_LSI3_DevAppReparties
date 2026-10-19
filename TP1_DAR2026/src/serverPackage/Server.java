package serverPackage;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws IOException {
        // La première étape :
        ServerSocket sk = new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");

        // La deuxième étape :
        Socket s = sk.accept();
        System.out.println("un client est connecté");

        // La dernière étape : Fermer socket
        s.close();
        sk.close();
    }
}
