package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    static final String IP_SERVEUR = "192.168.0.86"; // adresse IP de la machine serveur
    static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        Scanner scanner =new Scanner(System.in);

        InetAddress adresseIp = InetAddress.getByName(IP_SERVEUR);
        InetSocketAddress adresseServeur = new InetSocketAddress(adresseIp, PORT);
        System.out.println("Je suis un client pas encore connecté…");
        Socket s = new Socket();
        s.connect(adresseServeur, 5000);
        System.out.println("je suis un client connecté à " + IP_SERVEUR + ":" + PORT);

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());
        int number;
        String op;
        do{
            System.out.println("Enter The Operator ");
            op=scanner.next();
            System.out.println("Enter Your Number(0 to stop): ");
            number=scanner.nextInt();
            out.writeInt(number);
            out.writeUTF(op);
            double resultat = in.readDouble();
            System.out.println("Résultat : " + resultat);
        }while (number!=0);
        s.close();
        scanner.close();
    }
}
