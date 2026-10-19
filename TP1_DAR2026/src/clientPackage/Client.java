package clientPackage;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner =new Scanner(System.in);
        Socket s =new Socket("192.168.0.86",1234);
        System.out.println("je suis un client connecté");

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());
        int number;
        do{
            System.out.print("Enter Your Number(0 to stop): ");
            number=scanner.nextInt();

            out.writeInt(number);
            int resultat = in.readInt();
            System.out.println("Résultat : " + resultat);
        }while (number!=0);
        s.close();
        scanner.close();
    }
}
