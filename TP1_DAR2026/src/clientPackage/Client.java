package clientPackage;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        // La première étape :
        System.out.println("Je suis un client pas encore connecté...");
        Socket s =new Socket("192.168.0.86",1234);
        System.out.println("je suis un client connecté");
        // La dernière étape : Fermer socket
        s.close();
    }
}
